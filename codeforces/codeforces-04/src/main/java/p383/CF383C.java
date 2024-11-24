package p383;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class CF383C {
    // Time limit exceeded on test 6
//    Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static int n, q;
    static int[] a;
    static List<Integer>[] g;

    public static void main(String[] args) {
        n = scanner.nextInt();
        q = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g[v].add(w);
            g[w].add(v);
        }

        System.out.println(solve());
    }

    static int[][] nodes; // sgn, l, r
    static int dfn;

    private static String solve() {
        nodes = new int[n][3];
        f(0, -1, -1);

        BIT tr = new BIT(n);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            int op = scanner.nextInt();
            int v = scanner.nextInt() - 1;
            int sgn = nodes[v][0], l = nodes[v][1], r = nodes[v][2];
            if (op == 1) {
                int val = scanner.nextInt();
                tr.add(l, val * sgn);
                tr.add(r, -val * sgn);
            } else {
                int res = a[v] + tr.query(l) * sgn;
                ans.add(res);
            }
        }
        return ans.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    static int f(int v, int fa, int sgn) {
        nodes[v][0] = sgn;
        dfn++;
        nodes[v][1] = dfn;
        int sz = 1;
        for (Integer w : g[v]) {
            if (w != fa) {
                sz += f(w, v, -sgn);
            }
        }
        nodes[v][2] = nodes[v][1] + sz;
        return sz;
    }

    static class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        int lb(int x) {
            return x & -x;
        }

        void add(int pos, int val) {
            for (; pos <= n; pos += lb(pos)) tree[pos] += val;
        }

        int query(int pos) {
            int ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
            return ret;
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
C. Propagating tree
https://codeforces.com/contest/383/problem/C

灵茶の试炼 2024-02-29
题目大意：
输入 n(1≤n≤2e5) m(1≤m≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e3)，表示一棵树每个节点的初始点权。
然后输入一棵树的 n-1 条边，节点编号从 1 到 n，根节点为 1。
然后输入 m 个询问，格式如下：
"1 x val"：对于以 x 为根的子树，把根节点的点权增加 val，根节点儿子的点权增加 -val，根节点儿子的儿子的点权增加 val，依此类推，val 和 -val 交替，直到叶子。其中 1≤val≤1e3。
"2 x"：输出节点 x 的点权。

rating 2000
前置知识：
1. 在 DFS 序中，一棵子树的所有节点是一段连续子数组。
2. 区间更新+单点查询（线段树 / 差分树状数组）。
设操作 2 的节点为 x。如果操作 1 的节点和 x 的深度的奇偶性是一样的，那么操作 1 会把 x 的值增加 val；如果奇偶性不一样，那么 x 的值增加 -val。
我们规定：
偶数深度的更新操作 => 区间增加 val。
奇数深度的更新操作 => 区间增加 -val。
于是：
对于偶数深度的 x，它增加的值正好就是区间更新操作之后的值。
对于奇数深度的 x，它增加的值正好就是区间更新操作之后的值再取反。
https://codeforces.com/problemset/submission/383/247557407
======

input
5 5
1 2 1 1 2
1 2
1 3
2 4
2 5
1 2 3
1 1 2
2 1
2 2
2 4
output
3
3
0
 */
