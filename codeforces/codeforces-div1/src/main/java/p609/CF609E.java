package p609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CF609E {
    static int n, m;
    static Edge[] es;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();
        es = new Edge[m];
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt();
            es[i] = new Edge(u, v, w, i);
        }
        System.out.println(solve());
    }

    // 2^18 = 262144 > 2e5
    private static final int mx = 18;
    private static Map<Integer, List<int[]>> adj;
    private static int[][] pa;
    private static int[][] pamax;
    private static int[] depth;

    private static String solve() {
        Arrays.sort(es, Comparator.comparingInt(o -> o.wt));

        adj = new HashMap<>(n);
        long s = 0;
        DSU dsu = new DSU(n);
        for (Edge e : es) {
            int x = e.x, y = e.y, w = e.wt;
            if (!dsu.union(x, y)) {
                s += w;
                adj.computeIfAbsent(x, key -> new ArrayList<>()).add(new int[]{y, w});
                adj.computeIfAbsent(y, key -> new ArrayList<>()).add(new int[]{x, w});
                e.wt = 0;
            }
        }

        depth = new int[n];
        pa = new int[n][mx];
        pamax = new int[n][mx];
        dfs(0, -1, 0);

        for (int i = 0; i + 1 < mx; i++) {
            for (int v = 0; v < n; v++) {
                int p = pa[v][i];
                if (p != -1) {
                    pa[v][i + 1] = pa[p][i];
                    pamax[v][i + 1] = Math.max(pamax[v][i], pamax[p][i]);
                } else {
                    pa[v][i + 1] = -1;
                    pamax[v][i + 1] = 0;
                }
            }
        }

        long[] ans = new long[m];
        Arrays.fill(ans, s);
        for (Edge e : es) {
            if (e.wt > 0) {
                int maxWt = maxWt(e.x, e.y);
                ans[e.id] += e.wt - maxWt;
            }
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    private static int maxWt(int v, int w) {
        int mxWt = 0;
        if (depth[v] > depth[w]) {
            int tmp = v;
            v = w;
            w = tmp;
        }
        for (int i = 0; i < mx; i++) {
            if (((depth[w] - depth[v]) >> i & 1) == 1) {
                mxWt = Math.max(mxWt, pamax[w][i]);
                w = pa[w][i];
            }
        }
        if (v == w) {
            return mxWt;
        }
        for (int i = mx - 1; i >= 0; i--) {
            if (pa[v][i] != pa[w][i]) {
                mxWt = Math.max(mxWt, Math.max(pamax[v][i], pamax[w][i]));
                v = pa[v][i];
                w = pa[w][i];
            }
        }
        return Math.max(mxWt, Math.max(pamax[v][0], pamax[w][0]));
    }

    private static void dfs(int x, int fa, int d) {
        pa[x][0] = fa;
        depth[x] = d;
        for (int[] tuple : adj.getOrDefault(x, new ArrayList<>())) {
            int y = tuple[0], wt = tuple[1];
            if (y == fa) continue;
            pamax[y][0] = wt;
            dfs(y, x, d + 1);
        }
    }

    private static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) {
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        boolean union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return true;
            }
            fa[rootQ] = rootP;
            return false;
        }
    }

    private static class Edge {
        int x, y, wt, id;

        public Edge(int x, int y, int wt, int id) {
            this.x = x;
            this.y = y;
            this.wt = wt;
            this.id = id;
        }
    }

    private static class FastReader {
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
E. Minimum spanning tree for each edge
https://codeforces.com/contest/609/problem/E

题目大意：
给出了无自环和多条边的连通无向加权图。图包含 n 个顶点和 m 条边。
对于每条边(u, v)找到包含边(u, v)的生成树的最小可能权值。
生成树的权值是生成树中所有边的权值之和。

rating 2100
树上倍增
https://codeforces.com/contest/609/submission/98216641
======

input
5 7
1 2 3
1 3 1
1 4 5
2 3 2
2 5 3
3 4 2
4 5 4
output
9
8
11
8
8
8
9
 */
