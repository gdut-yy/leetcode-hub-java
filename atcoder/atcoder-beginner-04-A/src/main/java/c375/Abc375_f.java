package c375;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc375_f {
    private static final long INF = (long) 1e18;
    static int n, m, q;
    static long[][] g;

    record edge(int v, int w, int wt) {
    }

    record query(int v, int w) {
    }

    static edge[] es;
    static query[] qs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();

        g = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                g[i][j] = INF;
            }
        }
        es = new edge[m];
        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            int wt = scanner.nextInt();
            es[i] = new edge(v, w, wt);
            g[v][w] = wt;
            g[w][v] = wt;
        }
        qs = new query[q];
        for (int i = 0; i < q; i++) {
            int op = scanner.nextInt();
            int v = scanner.nextInt();
            if (op == 2) {
                int w = scanner.nextInt();
                qs[i] = new query(v, w);
            } else {
                qs[i] = new query(v, 0);
                edge e = es[v - 1];
                g[e.v][e.w] = INF;
                g[e.w][e.v] = INF;
            }
        }
        System.out.println(solve());
    }

    static void addEdge(int v, int w, int wt) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = Math.min(g[i][j], Math.min(g[i][v] + wt + g[w][j], g[i][w] + wt + g[v][j]));
            }
        }
    }

    private static String solve() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }

        List<Long> ans = new ArrayList<>();
        for (int i = q - 1; i >= 0; i--) {
            query q = qs[i];
            if (q.w == 0) {
                edge e = es[q.v - 1];
                addEdge(e.v, e.w, e.wt);
            } else {
                long d = g[q.v - 1][q.w - 1];
                if (d == INF) {
                    d = -1;
                }
                ans.add(d);
            }
        }
//        return ans.reversed().stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
        Collections.reverse(ans);
        return ans.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }
}
/*
F - Road Blocked
https://atcoder.jp/contests/abc375/tasks/abc375_f

灵茶の试炼 2025-01-15
题目大意：
输入 n(2≤n≤300) m(0≤m≤n*(n-1)/2) q(1≤q≤2e5)，表示一个 n 点 m 边的无向图。保证图中无自环和重边。
然后输入 m 条边，每条边输入 x y w(1≤w≤1e9)，表示一条边权为 w 的无向边连接 x 和 y。节点编号从 1 开始。
然后输入 q 个询问，格式如下：
"1 i"：删掉输入的第 i(1≤i≤m) 条边。保证这条边没被删除。
"2 x y"：输出从 x 到 y 的最短距离。如果无法到达，输出 -1。
保证第一种询问不超过 300 个。

倒序处理询问，删边变成加边，做法就和 力扣 2642. 设计可以求最短路径的图类 一样了。
注意力扣那题是有向图，本题是无向图，更新边的时候 v->w 和 w->v 两个方向都要算。
代码 https://atcoder.jp/contests/abc375/submissions/61620017
======

Input 1
3 3 5
1 2 5
1 3 10
2 3 6
2 1 3
1 2
2 1 3
1 1
2 1 3
Output 1
10
11
-1

Input 2
4 6 6
2 3 1
2 4 1
3 4 1
1 2 1
1 3 1
1 4 1
1 4
1 5
1 6
2 1 2
2 1 3
2 1 4
Output 2
-1
-1
-1
 */
