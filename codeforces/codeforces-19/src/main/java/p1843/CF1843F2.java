package p1843;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1843F2 {
    static List<int[]> vxList, uvkList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            vxList = new ArrayList<>();
            uvkList = new ArrayList<>();
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                String symbol = scanner.next();
                if (symbol.equals("+")) {
                    int v = scanner.nextInt();
                    int x = scanner.nextInt();
                    vxList.add(new int[]{v, x});
                } else {
                    int u = scanner.nextInt();
                    int v = scanner.nextInt();
                    int k = scanner.nextInt();
                    uvkList.add(new int[]{u, v, k});
                }
            }
            System.out.println(solve());
        }
    }

    // 2^18 = 262,144 > 2e5
    private static final int K = 19;

    // 树上倍增
    // https://codeforces.com/contest/1843/submission/210486795
    private static String solve() {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        List<Integer> dep = new ArrayList<>();
        dep.add(0);
        List<int[]> pa = new ArrayList<>();
        pa.add(new int[K]);
        List<Info[]> lifts = new ArrayList<>();
        Info[] info0 = new Info[K];
        Arrays.fill(info0, new Info(0));
        lifts.add(info0);

        for (int[] p : vxList) {
            int v = p[0] - 1, x = p[1];

            int[] paArr = new int[K];
            paArr[0] = v;
            pa.add(paArr);

            a.add(x);
            dep.add(dep.get(v) + 1);

            Info[] infos = new Info[K];
            infos[0] = new Info(x);
            lifts.add(infos);

            for (int i = 1; i < K; i++) {
                int[] paBack = pa.get(pa.size() - 1);
                paBack[i] = pa.get(paBack[i - 1])[i - 1];

                Info[] liftsBack = lifts.get(lifts.size() - 1);
                liftsBack[i] = Info.merge(lifts.get(paBack[i - 1])[i - 1], liftsBack[i - 1]);
            }
        }

        List<String> resList = new ArrayList<>();
        for (int[] p : uvkList) {
            int u = p[0] - 1, v = p[1] - 1, k = p[2];

            Info L = new Info(0);
            Info R = new Info(0);
            // 假设 depth[x]≤depth[y]（否则交换两点）
            if (dep.get(u) > dep.get(v)) {
                int tmp = u;
                u = v;
                v = tmp;
            }
            // 我们可以先把更靠下的 y 更新为 y 的第 depth[y]-depth[x] 个祖先节点，这样 x 和 y 就处在同一深度了。
            for (int i = K - 1; i >= 0; i--) {
                if (dep.get(v) - dep.get(u) >= 1 << i) {
                    R = Info.merge(lifts.get(v)[i], R);
                    v = pa.get(v)[i];
                }
            }
            // 把 x 和 y 一起往上跳。先尝试大步跳，再尝试小步跳。
            for (int i = K - 1; i >= 0; i--) {
                if (pa.get(u)[i] != pa.get(v)[i]) {
                    L = Info.merge(lifts.get(u)[i], L);
                    R = Info.merge(lifts.get(v)[i], R);
                    u = pa.get(u)[i];
                    v = pa.get(v)[i];
                }
            }
            // 循环结束时，x 与 lca 只有一步之遥，即 lca=pa[x][0]。
            if (u != v) {
                L = Info.merge(lifts.get(u)[0], L);
                R = Info.merge(lifts.get(v)[0], R);
                u = pa.get(u)[0];
                v = pa.get(v)[0];
            }

            // 注意合并顺序
            Info tot = Info.merge(Info.rev(L), new Info(a.get(u)));
            tot = Info.merge(tot, R);

            int min = tot.minsegsum, max = tot.maxsegsum;
            resList.add(min <= k && k <= max ? "YES" : "NO");
        }
        return String.join(System.lineSeparator(), resList);
    }

    private static class Info {
        int sum, maxpref, maxsuff, maxsegsum, minpref, minsuff, minsegsum;

        public Info(int x) {
            this.sum = x;
            this.maxpref = Math.max(0, x);
            this.maxsuff = Math.max(0, x);
            this.maxsegsum = Math.max(0, x);
            this.minpref = Math.min(0, x);
            this.minsuff = Math.min(0, x);
            this.minsegsum = Math.min(0, x);
        }

        public Info(int sum, int maxpref, int maxsuff, int maxsegsum, int minpref, int minsuff, int minsegsum) {
            this.sum = sum;
            this.maxpref = maxpref;
            this.maxsuff = maxsuff;
            this.maxsegsum = maxsegsum;
            this.minpref = minpref;
            this.minsuff = minsuff;
            this.minsegsum = minsegsum;
        }

        public static Info merge(Info a, Info b) {
            if (a == null) return b;
            return new Info(
                    a.sum + b.sum,
                    Math.max(a.maxpref, a.sum + b.maxpref),
                    Math.max(b.maxsuff, a.maxsuff + b.sum),
                    Math.max(Math.max(a.maxsegsum, b.maxsegsum), a.maxsuff + b.maxpref),
                    Math.min(a.minpref, a.sum + b.minpref),
                    Math.min(b.minsuff, a.minsuff + b.sum),
                    Math.min(Math.min(a.minsegsum, b.minsegsum), a.minsuff + b.minpref)
            );
        }

        public static Info rev(Info a) {
            return new Info(
                    a.sum, a.maxsuff, a.maxpref, a.maxsegsum, a.minsuff, a.minpref, a.minsegsum
            );
        }
    }
}
/*
F2. Omsk Metro (hard version)
https://codeforces.com/contest/1843/problem/F2

题目大意：
这是这个问题的难点。简单版本和硬版本之间的唯一区别是，在这个版本中，u 可以取任何可能的值。
众所周知，鄂木斯克是柏林的首府。和其他首都一样，鄂木斯克拥有发达的地铁系统。鄂木斯克地铁由一定数量的通过隧道连接的车站组成，并且在任何两个车站之间都有一条路径穿过每个隧道不超过一次。换句话说，地铁是一棵树。
为了发展地铁和吸引居民，鄂木斯克使用了以下系统。每个站都有自己的权值 x∈{−1,1}。如果车站的重量为 -1，那么当鄂木斯克居民访问车站时，将收取 1 burle 的费用。如果车站的重量为 1，那么鄂木斯克居民将获得 1 个 burle 奖励。
鄂木斯克地铁目前只有一个 1 号、重量 x=1 的车站。每天都会发生以下事件之一:
- 将权重为 x 的新站点添加到编号为 vi 的站点中，并为其分配一个比现有站点数量大 1 的数字。
- 住在鄂木斯克的亚历克斯想知道:在顶点 u 和 v 之间的路径上是否有一个子段(可能是空的)，使得沿着它旅行，正好可以获得 k 个洞(如果 k<0，这意味着必须在旅行中花费 k 个洞)。换句话说，Alex 感兴趣的是，路径中是否存在这样一个子段，使得其中所有顶点的权值之和等于 k。注意子段可以为空，然后求和等于 0。
你是 Alex 的朋友，所以你的任务是回答 Alex 的问题。

连续子段 最小和 最大和。倍增，树上合并。
【树上倍增 LCA 模板】https://leetcode.cn/problems/kth-ancestor-of-a-tree-node/solution/mo-ban-jiang-jie-shu-shang-bei-zeng-suan-v3rw/
【洛谷 P4513 小白逛公园】https://www.luogu.com.cn/problem/P4513
【树上倍增题单】
https://codeforces.com/problemset/problem/587/C
https://codeforces.com/problemset/problem/609/E
https://codeforces.com/problemset/problem/733/F
https://codeforces.com/problemset/problem/980/E
======

input
1
8
+ 1 -1
? 1 1 2
? 1 2 1
+ 1 1
? 1 3 -1
? 1 1 1
? 1 3 2
? 1 1 0
output
NO
YES
NO
YES
YES
YES

input
1
7
+ 1 -1
+ 2 -1
+ 2 1
+ 3 -1
? 5 2 2
? 3 1 -1
? 5 4 -3
output
NO
YES
YES
 */