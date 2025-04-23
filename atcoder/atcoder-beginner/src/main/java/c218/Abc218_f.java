package c218;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Abc218_f {
    static int n, m;
    static List<edge>[] g;

    record edge(int to, int i) {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g[v].add(new edge(w, i));
        }
        System.out.println(solve());
    }

    static edge[] from;
    static int[] dis;

    private static String solve() {
        from = new edge[n];
        dis = new int[n];

        int res = bfs(-1);
        int[] ans = new int[m];
        Arrays.fill(ans, res);
        if (res != -1) {
            for (int v = n - 1; v != 0; v = from[v].to) {
                ans[from[v].i] = bfs(from[v].i);
            }
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    static int bfs(int ban) {
        Arrays.fill(dis, -1);
        dis[0] = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        while (!q.isEmpty()) {
            int v = q.remove();
            for (edge e : g[v]) {
                int w = e.to;
                if (e.i != ban && dis[w] < 0) {
                    dis[w] = dis[v] + 1;
                    if (ban < 0) {
                        from[w] = new edge(v, e.i);
                    }
                    q.add(w);
                }
            }
        }
        return dis[n - 1];
    }
}
/*
F - Blocked Roads
https://atcoder.jp/contests/abc218/tasks/abc218_f

灵茶の试炼 2025-02-20
题目大意：
输入 n(2≤n≤400) m(1≤m≤n*(n-1))，表示一个 n 点 m 边的有向图。保证图中无自环和重边。
然后输入 m 条边，每条边输入 x y，表示一条 x 到 y 的有向边，边权为 1。节点编号从 1 开始。
输出 m 个数，其中第 i 个数表示删除输入的第 i 条边后，从 1 到 n 的最短路长度。如果无法从 1 到达 n，输出 -1。

首先找到任意一条从 1 到 n 的最短路。
分类讨论：
如果删除的边不在这条最短路上，那么最短路长度不变。
如果删除的边在这条最短路上，直接重新算一遍最短路长度。由于最短路至多有 n-1 条边，所以至多重新算 n-1 次。
时间复杂度 O(nm)。
怎么求任意一条最短路？由于图中边权都是 1，这可以通过一次 BFS 完成。
BFS 更新 dis 的时候记录转移来源 from。最后从终点 n 出发，根据 from 倒着走到起点 1，就知道路径上有哪些边了。
代码 https://atcoder.jp/contests/abc218/submissions/62188187
======

Input 1
3 3
1 2
1 3
2 3
Output 1
1
2
1

Input 2
4 4
1 2
2 3
2 4
3 4
Output 2
-1
2
3
2

Input 3
5 10
1 2
1 4
1 5
2 1
2 3
3 1
3 2
3 5
4 2
4 3
Output 3
1
1
3
1
1
1
1
1
1
1

Input 4
4 1
1 2
Output 4
-1
 */
