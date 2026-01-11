package p593;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF593D {
    // Stuck in sleigh traffic on flight 13
//    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static class Edge {
        int v, w;
        long wt;

        Edge(int v, int w, long wt) {
            this.v = v;
            this.w = w;
            this.wt = wt;
        }
    }

    record Nb(int to, int i) {
    }

    static int n, m;
    static Edge[] es;
    static List<Nb>[] g;
    //    static int[] fa;
    static DSU dsu;
    static Nb[] paInfo;
    static int[] dep;

    private static void solve() {
        n = scanner.nextInt();
        m = scanner.nextInt();

        es = new Edge[n - 1];
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());

        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            long wt = scanner.nextLong();
            es[i] = new Edge(v, w, wt);
            g[v].add(new Nb(w, i));
            g[w].add(new Nb(v, i));
        }

        dsu = new DSU(n);
        paInfo = new Nb[n];
        dep = new int[n];
        dfs(0, -1);

        for (int i = 0; i < m; i++) {
            int op = scanner.nextInt();
            int v = scanner.nextInt();

            if (op == 1) {
                int w = scanner.nextInt();
                long wt = scanner.nextLong();
                v = dsu.find(v - 1);
                w = dsu.find(w - 1);
                while (wt > 0 && v != w) {
                    if (dep[v] > dep[w]) {
                        int temp = v;
                        v = w;
                        w = temp;
                    }
                    wt /= es[paInfo[w].i].wt;
                    w = dsu.find(paInfo[w].to);
                }
                out.println(wt);
            } else {
                long w = scanner.nextLong();
                Edge e = es[v - 1];
                if (w > 1) {
                    e.wt = w;
                } else {
                    int v1 = e.v, w1 = e.w;
                    if (dep[v1] > dep[w1]) {
                        int temp = v1;
                        v1 = w1;
                        w1 = temp;
                    }
                    dsu.fa[w1] = dsu.find(v1);
                }
            }
        }
    }

    static void dfs(int v, int pa) {
        for (Nb e : g[v]) {
            int w = e.to;
            if (w == pa) continue;
            if (es[e.i].wt == 1) {
                dsu.fa[w] = dsu.find(v);
            }
            paInfo[w] = new Nb(v, e.i);
            dep[w] = dep[v] + 1;
            dfs(w, v);
        }
    }

    static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) fa[i] = i;
        }

        int find(int x) { // 查找
            return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
        }
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
D. Happy Tree Party
https://codeforces.com/contest/593/problem/D

灵茶の试炼 2025-12-26
题目大意：
输入 n(2≤n≤2e5) m(1≤m≤2e5)。
然后输入一棵无向树的 n-1 条边（节点编号从 1 到 n），每条边包含 3 个数 x y z(1≤z≤1e18)，表示有一条边权为 z 的边连接 x 和 y。
然后输入 m 个操作，格式如下：
"1 x y val"：其中 1≤val≤1e18。依次经过从 x 到 y 的最短路上的边，每经过一条边，就把 val 更新为 floor(val / 边权)。你需要输出最终的 val。
"2 i z"：把输入的第 i(1≤i≤n-1) 条边的边权改为（减小为）z(1≤z<旧边权)。

rating 2400
一个数除以 1 不变，而除以大于 1 的数，至多除 O(log U) 次就会变成 0。
考虑暴力。
由于操作只会让边权变小，在边权修改成 1 时（或者一开始就是 1），把这条边下面的点，用并查集指向上面的点。
这样我们可以快速向上跳到边权大于 1 的边。
对于路径的两个点 x 和 y，按照什么顺序跳呢？
万一跳到 LCA 上面，怎么办？
类似计算 LCA 的过程，先跳深度更大的点。
注意并不需要真的计算 LCA，只要 x 和 y 通过并查集跳到了同一个点 z，那么 z 必然是 LCA 的祖先（含 LCA）。没有跳到 z 之前，节点必然在 LCA 下面。
如果中途数字除成 0 了，跳出循环。
代码 https://codeforces.com/problemset/submission/593/354500616
代码备份（上面打不开的同学看这个）
======

Input
6 6
1 2 1
1 3 7
1 4 4
2 5 5
2 6 2
1 4 6 17
2 3 2
1 4 6 17
1 5 5 20
2 4 1
1 5 1 3
Output
2
4
20
3

Input
5 4
1 2 7
1 3 3
3 4 2
3 5 5
1 4 2 100
1 5 4 1
2 2 2
1 1 3 4
Output
2
0
2
 */
