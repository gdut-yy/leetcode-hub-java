package p1725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CF1725M {
    static int n, m;
//    static List<int[]>[] g; // to, wt, inv

    // 链式前向星
    static int N = (int) (1e5 + 5), M = N * 4;
    static int[] he = new int[N], ne = new int[M], ed = new int[M], we = new int[M], we2 = new int[M];
    static int idx = 0;

    static void add(int u, int v, int w, int w2) {
        ed[idx] = v;
        ne[idx] = he[u];
        he[u] = idx;
        we[idx] = w;
        we2[idx] = w2;
        idx++;
    }

    public static void main(String[] args) {
        // Time limit exceeded on test 2
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();
//        g = new ArrayList[n];
//        Arrays.setAll(g, e -> new ArrayList<>());
        Arrays.fill(he, -1);
        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            int wt = scanner.nextInt();
//            g[v].add(new int[]{w, wt, 0});
//            g[w].add(new int[]{v, wt, 1});
            add(v, w, wt, 0);
            add(w, v, wt, 1);
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[][] dis = new long[n][2];
        for (int i = 1; i < n; i++) {
            dis[i] = new long[]{Long.MAX_VALUE, Long.MAX_VALUE};
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[0])); // dis, v, inv
        pq.add(new long[3]);
        pq.add(new long[]{0, 0, 1});
        while (!pq.isEmpty()) {
            long[] p = pq.remove();
            long p_dis = p[0];
            int p_v = (int) p[1], p_inv = (int) p[2];
            if (p_dis > dis[p_v][p_inv]) continue;
//            for (int[] e : g[p_v]) {
//                int w = e[0], eInv = e[2];
//                long newD = p_dis + e[1];

            for (int i = he[p_v]; i != -1; i = ne[i]) {
                int w = ed[i], eInv = we2[i];
                long newD = p_dis + we[i];

                if ((eInv == 1 || p_inv == 0) && newD < dis[w][eInv]) {
                    dis[w][eInv] = newD;
                    pq.add(new long[]{newD, w, eInv});
                }
            }
        }

        List<Long> output = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            long res = Math.min(dis[i][0], dis[i][1]);
            if (res == Long.MAX_VALUE) {
                res = -1;
            }
            output.add(res);
        }
        return output.stream().map(String::valueOf).collect(Collectors.joining(" "));
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
M. Moving Both Hands
https://codeforces.com/contest/1725/problem/M

灵茶の试炼 2024-07-10
题目大意：
输入 n(2≤n≤1e5) m(0≤m≤2e5)，表示一个 n 点 m 边的有向图。节点编号从 1 开始。保证图中无自环和重边。
然后输入 m 条边，每条边输入 x y w(1≤w≤1e9)，表示一条从 x 到 y 的边权为 w 的有向边。
定义 f(i) 为：有甲乙两人，分别从 1 和 i 出发，到达同一个点，两人用时之和的最小值。
如果两人无法到达同一个点，则 f(i) = -1。
输出 f(2), f(3), ..., f(n)。

rating 1800
分层图最短路。
建图：把每条有向边及其反向边加到图中，用一个额外变量 inv 表示这条边是否为反向边。
从 1 到 i 的路径分成两段：
从 1 到 x，走原图上的边。（记作状态 0）
从 x 到 i，走反向边。（记作状态 1）
由于到达每个节点时，都有两个状态，所以相当于在有 2n 个节点的图上跑 Dijkstra 算法。Dijkstra 算法介绍
类似状态机 DP，在 Dijkstra 的优先队列中，额外记录一个状态 inv，如果 inv=0 表示当前在走原图上的边，如果 inv=1 表示当前在走反向边。
如果当前状态是 0，那么可以转移到 0 或者 1。
如果当前状态是 1，那么只能转移到 1。
代码 https://codeforces.com/problemset/submission/1725/268999639
======

Input
5 7
1 2 2
2 4 1
4 1 4
2 5 3
5 4 1
5 2 4
2 1 1
Output
1 -1 3 4
 */