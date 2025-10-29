package c428;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Abc428_e {
    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static ArrayList<Integer>[] g;

    static void solve() {
        int n = scanner.nextInt();
        g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            g[u].add(v);
            g[v].add(u);
        }

        int[] dist1 = bfs(1, n);
        int S = 1;
        for (int i = 2; i <= n; i++) {
            if (dist1[i] > dist1[S]) {
                S = i;
            } else if (dist1[i] == dist1[S] && i > S) {
                S = i;
            }
        }

        int[] distS = bfs(S, n);
        int T = S;
        for (int i = 1; i <= n; i++) {
            if (distS[i] > distS[T]) {
                T = i;
            } else if (distS[i] == distS[T] && i > T) {
                T = i;
            }
        }

        distS = bfs(S, n);
        int[] distT = bfs(T, n);

        for (int i = 1; i <= n; i++) {
            if (distS[i] > distT[i]) {
                out.println(S);
            } else if (distT[i] > distS[i]) {
                out.println(T);
            } else {
                out.println(Math.max(S, T));
            }
        }
    }

    private static int[] bfs(int start, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Deque<Integer> q = new ArrayDeque<>();
        dist[start] = 0;
        q.add(start);

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int neighbor : g[u]) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[u] + 1;
                    q.add(neighbor);
                }
            }
        }
        return dist;
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
E - Farthest Vertex
https://atcoder.jp/contests/abc428/tasks/abc428_e

题目大意：
有一棵树，树上有 N(5e5) 个顶点，编号为 1 至 N 。 i-th 边连接顶点 Ai 和 Bi 。
定义顶点 u 和 v 之间的距离为路径中端点位于顶点 u 和 v 的边的数量。(这条路径是唯一确定的）。
- 在顶点 1,2,...,N 中，输出与顶点 v 距离最大的顶点的编号。如果有多个顶点满足条件，则输出数字最大的顶点。

https://chat.deepseek.com/a/chat/s/312d63cf-6eab-4a39-a9bd-77bba9bd5c8b
======

Input 1
3
1 2
2 3
Output 1
3
3
1

Input 2
5
1 2
2 3
2 4
1 5
Output 2
4
5
5
5
4
 */
