package p733;

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

public class CF733F {
    static int n, m;
    static Edge[] es;
    static int money;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();
        es = new Edge[m];
        for (int i = 0; i < m; i++) {
            es[i] = new Edge();
            es[i].wt = scanner.nextInt();
            es[i].id = i;
        }
        for (int i = 0; i < m; i++) {
            es[i].c = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            es[i].x = scanner.nextInt() - 1;
            es[i].y = scanner.nextInt() - 1;
        }
        money = scanner.nextInt();
        System.out.println(solve());
    }

    // 2^18 = 262144 > 2e5
    private static final int mx = 18;
    private static Map<Integer, List<int[]>> adj;
    private static int[][] pa;
    private static int[][] pamax;
    private static int[][] paeid;
    private static int[] depth;

    private static String solve() {
        Arrays.sort(es, Comparator.comparingInt(o -> o.wt));

        long s = 0;
        adj = new HashMap<>();
        DSU dsu = new DSU(n);
        for (Edge e : es) {
            int x = e.x, y = e.y, wt = e.wt, eid = e.id;
            if (!dsu.union(x, y)) {
                s += wt;
                adj.computeIfAbsent(x, key -> new ArrayList<>()).add(new int[]{y, wt, eid});
                adj.computeIfAbsent(y, key -> new ArrayList<>()).add(new int[]{x, wt, eid});
                e.wt = -e.wt;
            }
        }

        pa = new int[n][mx];
        pamax = new int[n][mx];
        paeid = new int[n][mx];
        depth = new int[n];
        dfs(0, -1, 0);

        for (int i = 0; i + 1 < mx; i++) {
            for (int v = 0; v < n; v++) {
                int p = pa[v][i];
                if (p != -1) {
                    pa[v][i + 1] = pa[p][i];
                    if (pamax[v][i] > pamax[p][i]) {
                        pamax[v][i + 1] = pamax[v][i];
                        paeid[v][i + 1] = paeid[v][i];
                    } else {
                        pamax[v][i + 1] = pamax[p][i];
                        paeid[v][i + 1] = paeid[p][i];
                    }
                } else {
                    pa[v][i + 1] = -1;
                }
            }
        }

        int mxDec = -1, ori = -1, cur = 0;
        for (Edge e : es) {
            int dec = money / e.c;
            if (e.wt > 0) {
                int[] tuple = maxWt(e.x, e.y);
                int mxWt = tuple[0], eid = tuple[1];
                dec = mxWt - (e.wt - dec);
                if (mxDec < dec) {
                    mxDec = dec;
                    ori = eid;
                    cur = e.id;
                }
            } else {
                if (mxDec < dec) {
                    mxDec = dec;
                    ori = -1;
                    cur = e.id;
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        ans.append(s - mxDec).append(System.lineSeparator());
        for (Edge e : es) {
            if (e.id == ori || e.id != cur && e.wt > 0) {
                continue;
            }
            int wt = e.wt;
            if (wt < 0) {
                wt = -wt;
            }
            if (e.id == cur) {
                wt -= money / e.c;
            }
            ans.append(e.id + 1).append(" ").append(wt).append(System.lineSeparator());
        }
        return ans.toString();
    }

    private static int[] maxWt(int v, int w) {
        int mxWt = 0, eid = 0;
        if (depth[v] > depth[w]) {
            int tmp = v;
            v = w;
            w = tmp;
        }
        for (int i = 0; i < mx; i++) {
            if (((depth[w] - depth[v]) >> i & 1) == 1) {
                if (mxWt < pamax[w][i]) {
                    mxWt = pamax[w][i];
                    eid = paeid[w][i];
                }
                w = pa[w][i];
            }
        }
        if (v == w) {
            return new int[]{mxWt, eid};
        }
        for (int i = mx - 1; i >= 0; i--) {
            if (pa[v][i] != pa[w][i]) {
                if (mxWt < pamax[v][i]) {
                    mxWt = pamax[v][i];
                    eid = paeid[v][i];
                }
                if (mxWt < pamax[w][i]) {
                    mxWt = pamax[w][i];
                    eid = paeid[w][i];
                }
                v = pa[v][i];
                w = pa[w][i];
            }
        }
        if (mxWt < pamax[v][0]) {
            mxWt = pamax[v][0];
            eid = paeid[v][0];
        }
        if (mxWt < pamax[w][0]) {
            mxWt = pamax[w][0];
            eid = paeid[w][0];
        }
        return new int[]{mxWt, eid};
    }

    private static void dfs(int x, int fa, int d) {
        pa[x][0] = fa;
        depth[x] = d;
        for (int[] tuple : adj.getOrDefault(x, new ArrayList<>())) {
            int y = tuple[0], wt = tuple[1], eid = tuple[2];
            if (y == fa) continue;
            pamax[y][0] = wt;
            paeid[y][0] = eid;
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
        int x, y, wt, c, id;
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
F. Drivers Dissatisfaction
https://codeforces.com/contest/733/problem/F

题目大意：
一个王国有 n 座城市和 m 条双向道路。每条道路连接两个城市，对于每条道路，我们知道司机的不满程度-值 wi。
对于每条路，我们知道值 ci——我们应该花多少 lamziks 来减少对这条路的不满程度。因此，为了减少 k 对第 i 条道路的不满，我们应该花费 k·ci lamziks。它允许不满意变为零甚至为负。
按照国王的命令，我们需要选择 n - 1 条道路，并使它们成为主要道路。必须有一个重要的条件:从一个城市到另一个城市应该可以通过主干道通行。
道路部为这项改革编列了 500 万美元的预算。交通部打算将这笔预算用于修复一些道路(以减少对它们的不满)，然后选择 n - 1 条主要道路。
帮助以这种方式花费预算，然后选择主要道路，这样对主要道路的总不满将尽可能小。对一些道路的不满可能会变得消极。没有必要花光全部预算。
这是可以保证的，从任何城市旅行到任何其他使用现有的道路。天国里的每条路都是双向的。

rating 2200
树上倍增
https://codeforces.com/contest/733/submission/120955685
======

input
6 9
1 3 1 1 3 1 2 2 2
4 1 4 2 2 5 3 1 6
1 2
1 3
2 3
2 4
2 5
3 5
3 6
4 5
5 6
7
output
0
1 1
3 1
6 1
7 2
8 -5
input
3 3
9 5 1
7 7 2
2 1
3 1
3 2
2
output
5
3 0
2 5
 */
