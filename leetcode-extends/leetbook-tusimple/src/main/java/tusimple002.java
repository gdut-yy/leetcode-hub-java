import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class tusimple002 {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        // t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int q = scanner.nextInt();
        int k = scanner.nextInt();

        int[] sources = new int[q];
        for (int i = 0; i < q; i++) {
            sources[i] = scanner.nextInt();
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        // 多源 BFS 求每个点到最近源点的最短距离
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> queue = new ArrayDeque<>();

        for (int s : sources) {
            dist[s] = 0;
            queue.offer(s);
        }

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int v : adj.get(u)) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    queue.offer(v);
                }
            }
        }

        // 输出每个员工知道秘密的天数
        for (int i = 1; i <= n; i++) {
            if (i > 1) out.print(" ");

            if (dist[i] == 0) {
                out.print(0);
            } else {
                // 需要的“单位距离”数：向上取整(dist[i] / k)
                int need = (dist[i] + k - 1) / k;

                // 二分查找最小的 t，使得 t*(t+1)/2 >= need
                int lo = 0, hi = 1000000;
                while (lo < hi) {
                    int mid = (lo + hi) / 2;
                    if ((long) mid * (mid + 1) / 2 >= need) {
                        hi = mid;
                    } else {
                        lo = mid + 1;
                    }
                }
                out.print(lo);
            }
        }
        out.println();
    }
}
/*
tusimple-002. 商业机密
https://leetcode.cn/problems/nQ3bZq/description/

我们可以认为图森未来的所有员工之间的关系构成一张关系图，两个员工的关系密切，则两个员工之间会有一条边相连（我们认为关系是双向的），员工的索引是从 1 到 N 递增的整数，假设每条边的长度都是 1 。
现在，图森未来即将召开新的一次发布会了，在发布会前，高层将会有一次秘密会议，讨论决定发布会的具体内容，显然，秘密会议的内容是绝对的商业机密。
可惜的是，参与会议的人都是些藏不住秘密的人。从会议结束后的第一天开始，所有知道秘密的人都会和距离（在上述关系图中的距离）自己不超过 k 的所有人共享这个秘密，而第二天，所有知道秘密的人都会和距离自己不超过 2k 的所有人共享这个秘密。也就是说，在会议结束后的第 x 天，所有知道秘密的人都开始与距自己最多 xk 的所有人共享该秘密。
现在 TuTu 被委托计算每个人都会在什么时候知道这个秘密。
输入描述:
第一行包含四个整数 n, m, q 和 k (1 <= n,q,k <= 10^5, q <= n, 1 <= m <= 2*10^5) ，分别表示员工数量，关系数量，参加秘密会议的人数，以及任务描述中的 k。
接下来的一行包含 q 个整数，其中第 i 个整数表示秘密会议中第 i 个员工的索引。
接下来的 m 行，每行包含两个整数 a[i] 和 b[i] (1 <= a[i],b[i] <= n, a[i]!=b[i])，表示第 i 个关系为索引为 a[i] 和 b[i] 的员工。
题目保证给定的图是一张联通图，即任意两个员工之间，一定存在间接的关系相连。
输出描述:
输出 n 个数字，第 i 个数字代表会议后的哪一天索引为 i 的员工将知道秘密。如果该员工参加了会议，则输出 0 。
样例1
输入
6 8 1 1
6
1 3
1 5
1 6
2 5
2 6
3 4
3 5
5 6
输出 1 1 2 2 1 0
备注:
对于其中 40% 的数据，保证 k=1, 1 <= n,q <= 100, 1 <= m <= 200。 对于其中另外 30% 的数据，保证 1 <= n,q <= 100, 1 <= m <= 200 。
 */