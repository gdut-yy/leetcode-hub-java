package p659;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF659E {
    static int n, m;
    static List<Integer>[] g;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g[v].add(w);
            g[w].add(v);
        }
        System.out.println(solve());
    }

    static boolean[] vis;
    static int cntV, cntE;

    private static String solve() {
        vis = new boolean[n];
        int ans = 0;
        for (int x = 0; x < n; x++) {
            if (!vis[x]) {
                cntV = 0;
                cntE = 0;
                dfs(x);
                if (cntV == cntE / 2 + 1) {
                    ans++;
                }
            }
        }
        return String.valueOf(ans);
    }

    private static void dfs(int v) {
        vis[v] = true;
        cntV++;
        cntE += g[v].size();
        for (int w : g[v]) {
            if (!vis[w]) {
                dfs(w);
            }
        }
    }
}
/*
E. New Reform
https://codeforces.com/contest/659/problem/E

灵茶の试炼 2024-02-14
题目大意：
输入 n(2≤n≤1e5) m(1≤m≤1e5) 表示一个 n 点 m 边的无向图（节点编号从 1 开始）。
然后输入 m 条无向边。
保证图中无自环和重边。
图不一定连通。
你需要把每条边都变成有向边（定向）。
定向后，入度为 0 的点最少有多少个？

rating 1600
如果一个连通块没有环，即一棵树，随便选一个点出发 DFS，按照递归的顺序定向，那么除了起点以外，其余点的入度都大于 0。
如果一个连通块有环，那么从环上的点出发 DFS，按照递归的顺序定向，所有的点的入度都可以大于 0。
所以答案就是无环连通块的个数。可以用【点数 = 边数 + 1】判断。
https://codeforces.com/contest/659/submission/246057256
======

input
4 3
2 1
1 3
4 3
output
1

input
5 5
2 1
1 3
2 3
2 5
4 3
output
0

input
6 5
1 2
2 3
4 5
4 6
5 6
output
1
 */
