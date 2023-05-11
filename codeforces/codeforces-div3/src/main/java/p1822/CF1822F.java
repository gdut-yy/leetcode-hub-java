package p1822;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CF1822F {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int c = scanner.nextInt();
            int[][] edges = new int[n - 1][2];
            for (int i = 0; i < n - 1; i++) {
                edges[i][0] = scanner.nextInt();
                edges[i][1] = scanner.nextInt();
            }
            System.out.println(solve(n, k, c, edges));
        }
    }

    private static Map<Integer, List<Integer>> adj;
    private static int[] f1, f2, g, p;
    private static long[] dist;

    private static String solve(int n, int k, int c, int[][] edges) {
        adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }
        // f[u] 代表在以 0 号点为根节点的树中，以 u 节点为子树根节点时，往下的最大高度
        // g[u] 代表在以 0 号点为根节点的树中，以 u 节点为子节点时，往上的最大高度
        // f1 最大值，f2 次大值
        f1 = new int[n + 1];
        f2 = new int[n + 1];
        g = new int[n + 1];
        // p 数组记录下取得 f1[u] 时 u 的子节点 j 为何值。
        p = new int[n + 1];
        dist = new long[n + 1];
        dist[0] = -1;
        dfs1(1, 0);
        dfs2(1, 0);

        long max = 0L;
        for (int x = 1; x <= n; x++) {
            long maxD = Math.max(f1[x], g[x]);
            max = Math.max(max, maxD * k - dist[x] * c);
        }
        return String.valueOf(max);
    }

    private static int dfs1(int x, int fa) {
        dist[x] = dist[fa] + 1;
        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa) continue;
            int sub = dfs1(y, x) + 1;
            if (sub > f1[x]) {
                f2[x] = f1[x];
                f1[x] = sub;
                p[x] = y;
            } else if (sub > f2[x]) {
                f2[x] = sub;
            }
        }
        return f1[x];
    }

    private static void dfs2(int x, int fa) {
        for (int y : adj.getOrDefault(x, new ArrayList<>())) {
            if (y == fa) continue;
            if (p[x] != y) {
                g[y] = Math.max(g[y], f1[x] + 1);
            } else {
                g[y] = Math.max(g[y], f2[x] + 1);
            }
            g[y] = Math.max(g[y], g[x] + 1);
            dfs2(y, x);
        }
    }
}
/*
F. Gardening Friends
https://codeforces.com/contest/1822/problem/F

题目大意：
两个朋友，Alisa 和 Yuki，在他们的花园里种了一棵有 n 个顶点的树。树是一种无向图，没有环、环或多条边。这棵树的每条边的长度都是 k。最初，顶点 1 是树的根。
艾丽莎和尤奇种植这棵树不仅仅是为了好玩，他们还想卖掉它。树的代价被定义为在树的所有顶点中从根到顶点的最大距离。两个顶点 u 和 v 之间的距离等于从 u 到 v 的路径上所有边的长度之和。
女孩们参加了园艺课程，所以她们知道如何修饰这棵树。Alisa 和 Yuki 可以花费 c 个硬币将树的根移动到当前根的一个邻居。此操作可以执行任意次数(可能为零)。注意，树的结构保持不变;唯一改变的是哪个顶点是根结点。
朋友们想以最大的利润卖掉这棵树。利润被定义为采油树的成本和总运营成本之间的差额。利润是树的成本减去操作的总成本。
帮助女孩们，通过对树进行任意次数的操作(可能为零)，找到她们能获得的最大利润。

树形 DP（换根 DP）
求以 x 为根的最长路，记为 ans[x]；求以节点 x 到 1 的距离，记为 dist[x]。
则答案为 max{ans[x] * k - dist[x] * c}
相似题目: 310. 最小高度树
https://leetcode.cn/problems/minimum-height-trees/
======

input
4
3 2 3
2 1
3 1
5 4 1
2 1
4 2
5 4
3 4
6 5 3
4 1
6 1
2 6
5 1
3 2
10 6 4
1 3
1 9
9 7
7 6
6 4
9 2
2 8
8 5
5 10
output
2
12
17
32
 */
