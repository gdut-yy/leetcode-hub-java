package p1209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CF1209F {
    static int n, m;
    static int n0;

    //    record nb(int to, int wt) {
    //    }
    //    static final int mx = (int) 1e6;
    //    static List<nb>[] g;
    static int N = (int) (1e6 + 5), M = N * 2;
    // 链式前向星
    static int[] he = new int[N], ne = new int[M], ed = new int[M], we = new int[M];
    static int idx = 0;

    static void add(int u, int v, int w) {
        ed[idx] = v;
        ne[idx] = he[u];
        he[u] = idx;
        we[idx] = w;
        idx++;
    }

    public static void main(String[] args) {
        // Time limit exceeded on test 8
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        n0 = n;
        m = scanner.nextInt();
//        g = new ArrayList[mx];
//        Arrays.setAll(g, e -> new ArrayList<>());
        Arrays.fill(he, -1);
        for (int i = 1; i <= m; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            add1(v, w, i);
            add1(w, v, i);
        }
        System.out.println(solve());
    }

    static void add1(int v, int w, int x) {
        for (; x > 9; x /= 10) {
//            g[n].add(new nb(w, x % 10));
            add(n, w, x % 10);
            w = n;
            n++;
        }
//        g[v].add(new nb(w, x));
        add(v, w, x);
    }

    static final int MOD = (int) (1e9 + 7);

    record edge(int from, int to) {
    }

    private static String solve() {
        long[] dis = new long[n];
        boolean[] vis = new boolean[n];
        vis[0] = true;
        Queue<List<Integer>> q = new ArrayDeque<>();
        q.add(List.of(0));
        while (!q.isEmpty()) {
            List<Integer> vs = q.remove();
            List<edge>[] nxt = new ArrayList[10];
            Arrays.setAll(nxt, e -> new ArrayList<>());
            for (Integer v : vs) {
//                for (nb e : g[v]) {
//                    nxt[e.wt].add(new edge(v, e.to));
                for (int i = he[v]; i != -1; i = ne[i]) {
                    int to = ed[i], wt = we[i];
                    nxt[wt].add(new edge(v, to));
                }
            }
            for (int wt = 0; wt < nxt.length; wt++) {
                List<edge> es = nxt[wt];
                vs = new ArrayList<>();
                for (edge e : es) {
                    int w = e.to;
                    if (!vis[w]) {
                        vis[w] = true;
                        dis[w] = (dis[e.from] * 10 + wt) % MOD;
                        vs.add(w);
                    }
                }
                if (!vs.isEmpty()) {
                    q.add(vs);
                }
            }
        }

        // for _, v := range dis[1:n0] {
        return Arrays.stream(dis).limit(n0).skip(1).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
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
F. Koala and Notebook
https://codeforces.com/contest/1209/problem/F

灵茶の试炼 2024-05-10
题目大意：
输入 n(2≤n≤1e5) m(n-1≤m≤1e5) 表示一个 n 点 m 边的无向图。节点编号从 1 开始。保证图是连通的。保证图中无自环和重边。
然后输入 m 条边，按照输入的顺序，第 1 条边的边权等于 1，第 2 条边的边权等于 2，……，第 m 条边的边权等于 m。
定义 x 到 y 的路径长度，等于依次拼接路径上的边权的结果。
例如 x-a-b-y 路径上的边权从左到右依次为 31,41,59，那么这条路径的长度等于 314159。
输出 1 到 2,3,4,...,n 的最短路长度，模 1e9+7。
注意你要最小化的是最短路长度，然后再取模，不是最小化取模后的值。

rating 2600
拆点。
比如 v 到 w 的一条边权为 123 的边，拆分成 v-a-b-w，其中 v-a 的边权为 1，a-b 的边权为 2，b-w 的边权为 3。
注意拆点后，v 到 w 和 w 到 v 的边权是不同的，一个是 v-a-b-w 边权依次为 1,2,3，另一个是 w-b-a-v 边权依次为 1,2,3。
拆点后，经过的边数越少，最短路就越小。这可以 BFS。
边数相同时，要计算的是一个经典问题：字典序最小最短路。
这仍然可以用 BFS 解决。
比如从节点 5 出发可以走边权为 0,1,2,... 的边，访问某些点；从节点 7 出发走边权为 0,1,2,... 的边，访问某些点。
这些接下来要访问的点，必须优先访问从节点 5 7 出发走边权为 0 的边所到达的点，然后再访问从节点 5 7 出发走边权为 1 的边所到达的点，依此类推。这可以保证首次访问到一个点时，我们是通过字典序最小最短路到达的。
所以队列中保存的不是节点，而是节点列表。这个列表中的节点都是走相同的边权到达的。
在 BFS 的同时用 dis[to] = (dis[from] * 10 + weight) % MOD 计算最短路。
注：字典序最小最短路在刘汝佳的紫书 p.173 有提到。
https://codeforces.com/contest/1209/submission/259463472
======

Input
11 10
1 2
2 3
3 4
4 5
5 6
6 7
7 8
8 9
9 10
10 11
Output
1
12
123
1234
12345
123456
1234567
12345678
123456789
345678826

Input
12 19
1 2
2 3
2 4
2 5
2 6
2 7
2 8
2 9
2 10
3 11
11 12
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10
Output
1
12
13
14
15
16
17
18
19
1210
121011

Input
12 14
1 2
2 3
3 4
4 5
5 6
6 7
7 8
8 9
9 10
10 11
11 12
1 3
1 4
1 10
Output
1
12
13
134
1345
13456
1498
149
14
1410
141011
 */
