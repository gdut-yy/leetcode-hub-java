package p455;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class CF455C {
    // Time limit exceeded on test 42
//    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static int n, m, q;
//    static List<Integer>[] g;

    // 链式前向星
    static int N = (int) (3e5 + 5), M = N * 2;
    static int[] he = new int[N], ne = new int[M], ed = new int[M]/*, we = new int[M]*/;
    static int idx = 0;

    static void add(int u, int v/*, int w*/) {
        ed[idx] = v;
        ne[idx] = he[u];
        he[u] = idx;
//        we[idx] = w;
        idx++;
    }

    public static void main(String[] args) {
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();
//        g = new ArrayList[n + 1];
//        Arrays.setAll(g, e -> new ArrayList<>());
        Arrays.fill(he, -1);
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
//            g[x].add(y);
//            g[y].add(x);
            add(x, y);
            add(y, x);
        }
        System.out.println(solve());
    }

    static DSU dsu;
    static int global_i;
    static int[] d;

    private static String solve() {
        dsu = new DSU(n + 1);
        d = new int[n + 1];
        for (global_i = 1; global_i <= n; global_i++) {
            if (dsu.fa[global_i] != global_i) continue;
            dfs(global_i, 0);
        }

        List<String> output = new ArrayList<>();
        for (int j = 0; j < q; j++) {
            int op = scanner.nextInt();
            int x = scanner.nextInt();
            if (op == 1) {
                output.add(String.valueOf(d[dsu.find(x)]));
                continue;
            }
            int y = scanner.nextInt();
            x = dsu.find(x);
            y = dsu.find(y);
            if (x != y) {
                d[x] = Math.max(d[x], Math.max(d[y], (d[x] + 1) / 2 + (d[y] + 1) / 2 + 1));
                dsu.fa[y] = x;
            }
        }
        return String.join(System.lineSeparator(), output);
    }

    static int dfs(int x, int from) {
        dsu.fa[x] = global_i;
        int maxL = 0;
//        for (Integer y : g[x]) {
        for (int i = he[x]; i != -1; i = ne[i]) {
            int y = ed[i];

            if (y != from) {
                int subL = dfs(y, x) + 1;
                d[global_i] = Math.max(d[global_i], maxL + subL);
                maxL = Math.max(maxL, subL);
            }
        }
        return maxL;
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
C. Civilization
https://codeforces.com/contest/455/problem/C

灵茶の试炼 2024-07-04
题目大意：
输入 n m(0≤m<n≤3e5) 和 q(1≤q≤3e5)。
然后输入一个森林的 m 条边。注：森林由多棵树组成。
然后输入 q 个询问，格式如下：
"1 x"：输出节点 x 所在的树的直径。
"2 x y"：如果节点 x 和节点 y 在同一棵树，什么也不做；否则在这两棵树上各选一个点，连一条边，要求连边后，得到的新树的直径最小。
所有输入的节点编号均从 1 开始。

rating 2100
在 周赛第四题 的基础上，套一个带权并查集。
初始化：跑树形 DP 的同时，把树上的每个节点 x 和根节点 i 合并。在根节点 i 处记录直径信息 d[i]。
合并：按照周赛第四题的做法更新直径，如果要把 y 合并到 x 上，那么更新
d[x] = max(d[x], d[y], (d[x]+1)/2+(d[y]+1)/2+1)
代码 https://codeforces.com/contest/455/submission/268332913
相似题目: 3203. 合并两棵树后的最小直径
https://leetcode.cn/problems/find-minimum-diameter-after-merging-two-trees/description/
======

Input
6 0 6
2 1 2
2 3 4
2 5 6
2 3 2
2 5 3
1 1
Output
4
 */