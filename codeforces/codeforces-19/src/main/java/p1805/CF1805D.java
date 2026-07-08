package p1805;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF1805D {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static int maxD, u;
    static int[] tmp;

    static void dfs(List<Integer>[] g, int v, int fa, int d) {
        tmp[v] = d;
        if (d > maxD) {
            maxD = d;
            u = v;
        }
        for (int w : g[v]) {
            if (w != fa) {
                dfs(g, w, v, d + 1);
            }
        }
    }

    private static void solve() {
        int n = scanner.nextInt();
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g[v].add(w);
            g[w].add(v);
        }
        tmp = new int[n];
        maxD = -1;
        dfs(g, 0, -1, 0);
        maxD = -1;
        dfs(g, u, -1, 0);
        int[] d1 = tmp.clone();
        maxD = -1;
        dfs(g, u, -1, 0);
        int[] d2 = tmp;
        int[] s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (i != u) {
                s[Math.max(d1[i], d2[i]) + 1]++;
            }
        }
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            sum += s[i];
            out.print(sum + " ");
        }
    }
}
/*
D. A Wide, Wide Graph
https://codeforces.com/contest/1805/problem/D

灵茶の试炼 2026-05-07
题目大意：
输入 n(2≤n≤1e5) 和一棵 n 个节点的无向树的 n-1 条边。节点编号从 1 到 n。
定义 n 个节点的无向图 Gk，当且仅当树中 dis(u,v) >= k 时，Gk 中的 u 和 v 之间才存在一条边。
定义 f(k) 表示 Gk 的连通块的个数。
输出 f(1),f(2),...,f(n)。

rating 1800
对于节点 x，如果 x 到最远点（直径端点）的距离 < k，那么 x 无法与其余任何点相连，是个孤立点。
否则，x 与直径端点相连。由于直径的两个端点是相连的（如果两个端点的距离 >= k），所以所有与直径端点相连的点组成一整个连通块。
注：用反证法可以证明，x 的最远点一定是直径端点。若不然，则直径可以延长，矛盾。
算出任意一条直径，计算从端点出发，到每个节点的距离（算出两个距离数组），即可求出每个节点到最远点的距离。
设 x 到最远点的距离为 d，那么 k=d+1,d+2,...,n 时，孤立点的个数加一。
用差分数组处理区间加一。
代码 https://codeforces.com/problemset/submission/1805/373718514
代码备份（上面打不开的同学看这个）
======

Input
6
1 2
1 3
2 4
2 5
3 6
Output
1 1 2 4 6 6

Input
5
1 2
2 3
3 4
3 5
Output
1 1 3 5 5
 */
