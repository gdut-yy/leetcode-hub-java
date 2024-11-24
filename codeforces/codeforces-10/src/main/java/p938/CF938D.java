package p938;

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

public class CF938D {
    static int n, m;
    static List<long[]>[] g; // to, wt

    public static void main(String[] args) {
        // Time limit exceeded on test 3
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();
        g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            long wt = scanner.nextLong();
            g[v].add(new long[]{w, wt * 2});
            g[w].add(new long[]{v, wt * 2});
        }
        for (int i = 1; i <= n; i++) {
            long wt = scanner.nextLong();
            g[0].add(new long[]{i, wt});
        }
        System.out.println(solve());
    }

    static final long INF = (long) 1e18;
    static long[] dis;

    private static String solve() {
        dis = new long[n + 1];
        Arrays.fill(dis, INF);
        dis[0] = 0;

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(o -> o[0])); // dis, v
        pq.add(new long[]{0, 0});
        while (!pq.isEmpty()) {
            long[] p = pq.remove();
            int v = (int) p[1];
            if (p[0] > dis[v]) continue;
            for (long[] e : g[v]) {
                int w = (int) e[0];
                long newD = p[0] + e[1];
                if (newD < dis[w]) {
                    dis[w] = newD;
                    pq.add(new long[]{newD, w});
                }
            }
        }
        // for _, v := range dis[1:] {
        //		Fprint(out, v, " ")
        //	}
        return Arrays.stream(dis).skip(1).mapToObj(String::valueOf).collect(Collectors.joining(" "));
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
D. Buy a Ticket
https://codeforces.com/contest/938/problem/D

灵茶の试炼 2024-05-09
题目大意：
输入 n(2≤n≤2e5) m(1≤m≤2e5) 表示一个 n 点 m 边的无向图。节点编号从 1 开始。保证图中无自环和重边。
然后输入 m 条边，每条边输入 x y w(1≤w≤1e12)，表示有一条边权为 w 的无向边连接 x 和 y。
然后输入一个长为 n 的数组 a(1≤a[i]≤1e12)。
定义 d(i,j) 为 i 到 j 的最短路长度。
对于每个点 i，输出 min(2*d(i,j)+a[j])，其中 1≤j≤n。

rating 2000
逆向思维。用 a[i] 去更新答案。
被确定的答案是谁？第二个被确定的答案是谁？动手算一算，是不是和 Dijkstra 很像？
更多的点怎么办？怎么和边权结合起来？
为了能够使用 Dijkstra 算法，我们需要把 a[i] 转换成边权。
建立一个超级源点 S，向每个点 i 连边，边权为 a[i]。
跑从 S 出发的最短路即为答案。
注意原图的边权要乘 2。
https://codeforces.com/contest/938/submission/259488718
======

Input
4 2
1 2 4
2 3 7
6 20 1 25
Output
6 14 1 25

Input
3 3
1 2 1
2 3 1
1 3 1
30 10 20
Output
12 10 12
 */
