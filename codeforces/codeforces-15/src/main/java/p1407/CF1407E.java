package p1407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF1407E {
    // Time limit exceeded on test 17
//    static Scanner scanner;
    static FastReader scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new FastReader();
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<int[]>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            int tp = scanner.nextInt();
            g[w].add(new int[]{v, tp});
        }
        int[] dis = new int[n];
        int[] ans = new int[n];
        Arrays.fill(dis, -1);
        Arrays.fill(ans, -1);
        dis[n - 1] = 0;
        Deque<Integer> q = new ArrayDeque<>();
        q.add(n - 1);
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int[] e : g[v]) {
                int w = e[0], tp = e[1];
                if (ans[w] != tp) {
                    ans[w] = tp ^ 1;
                } else if (dis[w] < 0) {
                    dis[w] = dis[v] + 1;
                    q.add(w);
                }
            }
        }
        out.println(dis[0]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(Math.max(ans[i], 0));
        out.println(sb);
    }

    static class FastReader {
        private final BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                if (stringTokenizer.hasMoreTokens()) {
                    str = stringTokenizer.nextToken("\n");
                } else {
                    str = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
/*
E. Egor in the Republic of Dagestan
https://codeforces.com/contest/1407/problem/E

灵茶の试炼 2026-01-23
题目大意：
输入 n(1≤n≤5e5) 和 m(0≤m≤5e5)，表示一个 n 点 m 边的有向图。可能有重边和自环。
然后输入 m 条边，每条边输入 x y w(0≤w≤1)，表示一条从 x 到 y 的边权为 w 的有向边。节点编号从 1 到 n。
一开始，每个节点未被染色。请你把每个节点染成颜色 0 或 1。
对于有向边 x -> y，如果其边权等于点 x 的颜色，才能通行，否则无法通行。
你需要找到一种染色方案，使得从 1 到 n 的最短路长度尽量长。
注：最短路长度等于路径上的边的个数。
输出两行：
第一行输出最短路长度的最大值。如果存在染色方案，无法从 1 到达 n，输出 -1。
第二行输出一个长为 n 的 01 字符串，表示节点 1 到 n 的颜色。

rating 2500
正难则反，从终点倒推。
从终点开始，在反图上 BFS。
考虑如下场景：
在 BFS 的过程中，如果我们先搜索到一条 x1 -> y 的边，边权为 0，再搜索到一条 x2 -> y 的边，边权为 1，那么点 y 染成什么颜色比较好？
这说明在原图上，点 x1 离终点更近，所以点 y 要染成颜色 1。把更近的路堵住，从而让最短路尽量长。
具体地，初始化每个节点的颜色为 -1，表示未染色。
从反图的点 n 开始 BFS。
如果访问到的节点颜色不等于边权，那么节点颜色染成 边权 XOR 1，即与边权相反，把路堵住。
如果访问到的节点颜色等于边权，说明我们不是第一次到达该节点，也说明之前把更短的路堵住了，那么就把访问到的节点入队，更新最短路。
注：本题输入量大，可以用快读加速。（下面的代码没写快读）
代码 https://codeforces.com/problemset/submission/1407/359180729
代码备份（上面打不开的同学看这个）
======

Input
3 4
1 2 0
1 3 1
2 3 0
2 3 1
Output
2
011

Input
4 8
1 1 0
1 3 0
1 3 1
3 2 0
2 1 0
3 4 1
2 4 0
2 4 1
Output
3
1101

Input
5 10
1 2 0
1 3 1
1 4 0
2 3 0
2 3 1
2 5 0
3 4 0
3 4 1
4 2 1
4 5 0
Output
-1
11111
 */
