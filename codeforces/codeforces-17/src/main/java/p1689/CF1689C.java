package p1689;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1689C {
    static int n;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            g = new ArrayList[n + 1];
            Arrays.setAll(g, e -> new ArrayList<>());
            g[1].add(0);
            for (int i = 1; i < n; i++) {
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                g[v].add(w);
                g[w].add(v);
            }
            System.out.println(solve());
        }
    }

    static final int INF = (int) 1e9;

    private static String solve() {
        int ans = n - dfs(1, 0);
        return String.valueOf(ans);
    }

    static int dfs(int v, int fa) {
        if (g[v].size() <= 2) {
            return g[v].size();
        }
        int mn = INF;
        for (Integer w : g[v]) {
            if (w != fa) {
                mn = Math.min(mn, dfs(w, v) + 2);
            }
        }
        return mn;
    }
}
/*
C. Infected Tree
https://codeforces.com/contest/1689/problem/C

灵茶の试炼 2024-05-22
题目大意：
输入 T(≤5000) 表示 T 组数据。所有数据的 n 之和 ≤3e5。
每组数据输入 n(2≤n≤3e5) 和一棵 n 个节点的二叉树的 n-1 条双向边。节点编号从 1 开始。
二叉树的根节点是 1。
一开始，根节点被感染。
然后执行如下过程 n 次：
- 首先，选择一个未被感染也未被删除的点，将其删除（相连的边也删除）；或者什么也不做。
- 然后，任何与被感染节点相邻的节点，都被感染。
输出最多可以让多少个节点不被感染也不被删除。
改成多叉树：https://www.luogu.com.cn/problem/P1041

rating 1600
贪心 + 树形 DP。
当某棵子树的根节点被感染时，删除左儿子或右儿子，可以尽最大可能地减少感染。
那么应该删左儿子还是右儿子呢？用 DP 判断最优解。
为方便计算，考虑感染和删除最少多少个点。
对于以 v 为根的子树而言，在 v 被感染的情况下：
1. 如果 v 是叶子，返回 1，表示 v 被感染。
2. 如果 v 只有一个儿子，删除儿子，返回 2，表示 v 被感染，v 的儿子被删除。
3. 如果 v 有两个儿子，枚举删除哪个儿子，递归另一棵子树 w，返回 dfs(w, v) + 2 的最小值。第二个参数是父节点。
答案为 n - dfs(1, 0)。
为方便判断，可以给根节点 1 加个 0 号邻居。
https://codeforces.com/contest/1689/submission/261590342
======

Input
4
2
1 2
4
1 2
2 3
2 4
7
1 2
1 5
2 3
2 4
5 6
5 7
15
1 2
2 3
3 4
4 5
4 6
3 7
2 8
1 9
9 10
9 11
10 12
10 13
11 14
11 15
Output
0
2
2
10
 */
