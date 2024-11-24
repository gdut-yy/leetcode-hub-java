package p620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class CF620E {
    // Time limit exceeded on test 51
//    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static int n, m;
    static int[] a;
    static List<Integer>[] g;

    public static void main(String[] args) {
        n = scanner.nextInt();
        m = scanner.nextInt();
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
        System.out.println(solve1());
    }

    static long[] b;
    static int[][] nodes;
    static int dfn;

//    private static String solve() {
//        b = new long[n];
//        nodes = new int[n][2];
//        dfn = 0;
//        dfs(0, -1);
//
//        t = new Seg[4 * n];
//        Arrays.setAll(t, e -> new Seg());
//        build(1, 1, n);
//
//        List<String> output = new ArrayList<>();
//        for (; m > 0; m--) {
//            int op = scanner.nextInt();
//            int v = scanner.nextInt();
//            int[] o = nodes[v - 1];
//            if (op == 1) {
//                int w = scanner.nextInt();
//                update(1, o[0], o[1], 1L << w);
//            } else {
//                long query = query(1, o[0], o[1]);
//                output.add("" + Long.bitCount(query));
//            }
//        }
//        return String.join(System.lineSeparator(), output);
//    }

    private static String solve1() {
        b = new long[n];
        nodes = new int[n][2];
        dfn = 0;
        dfs(0, -1);

        SegmentTree seg = new SegmentTree(n);
        seg.build(1, 1, n);

        List<String> output = new ArrayList<>();
        for (; m > 0; m--) {
            int op = scanner.nextInt();
            int v = scanner.nextInt();
            int[] o = nodes[v - 1];
            if (op == 1) {
                int w = scanner.nextInt();
                seg.update(1, o[0], o[1], 1L << w);
            } else {
                long query = seg.query(1, o[0], o[1]);
                output.add("" + Long.bitCount(query));
            }
        }
        return String.join(System.lineSeparator(), output);
    }

    static int dfs(int v, int fa) {
        b[dfn] = 1L << a[v];
        dfn++;
        nodes[v][0] = dfn;
        int size = 0;
        for (Integer w : g[v]) {
            if (w != fa) {
                size += dfs(w, v);
            }
        }
        nodes[v][1] = nodes[v][0] + size;
        size++;
        return size;
    }

    static class SegmentTree {
        int n;
        long[] tr_mask, tr_todo;

        public SegmentTree(int n) {
            this.n = n;
            tr_mask = new long[4 * n];
            tr_todo = new long[4 * n];
        }

        void build(int p, int l, int r) {
            if (l == r) {
                tr_mask[p] = b[l - 1];
                return;
            }
            int m = (l + r) >> 1;
            build(p << 1, l, m);
            build(p << 1 | 1, m + 1, r);
            maintain(p);
        }

        void update(int o, int ql, int qr, long v) {
            update(1, 1, n, ql, qr, v);
        }

        void update(int p, int l, int r, int ql, int qr, long v) {
            if (ql <= l && r <= qr) {
                _do(p, v);
                return;
            }
            spread(p);
            int m = (l + r) >> 1;
            if (ql <= m) update(p << 1, l, m, ql, qr, v);
            if (qr > m) update(p << 1 | 1, m + 1, r, ql, qr, v);
            maintain(p);
        }

        void _do(int p, long v) {
            tr_mask[p] = v;
            tr_todo[p] = v;
        }

        void spread(int p) {
            if (tr_todo[p] > 0) {
                _do(p << 1, tr_todo[p]);
                _do(p << 1 | 1, tr_todo[p]);
                tr_todo[p] = 0;
            }
        }

        void maintain(int p) {
            int a = p << 1, b = p << 1 | 1;
            tr_mask[p] = tr_mask[a] | tr_mask[b];
        }

        long query(int o, int ql, int qr) {
            return query(1, 1, n, ql, qr);
        }

        long query(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return tr_mask[p];
            }
            spread(p);
            int m = (l + r) >> 1;
            if (qr <= m) return query(p << 1, l, m, ql, qr);
            if (ql > m) return query(p << 1 | 1, m + 1, r, ql, qr);
            return query(p << 1, l, m, ql, qr) | query(p << 1 | 1, m + 1, r, ql, qr);
        }
    }

//    // 线段树模板，只需要实现 mergeInfo 和 do，其余都是固定的
//    static Seg[] t;
//
//    static class Seg {
//        int l, r;
//        long mask;
//        long todo;
//    }
//
//    static void build(int o, int l, int r) {
//        t[o].l = l;
//        t[o].r = r;
//        if (l == r) {
//            t[o].mask = b[l - 1];
//            return;
//        }
//        int m = (l + r) >> 1;
//        build(o << 1, l, m);
//        build(o << 1 | 1, m + 1, r);
//        maintain(o);
//    }
//
//    static void _do(int O, long v) {
//        Seg o = t[O];
//        o.mask = v;
//        o.todo = v;
//    }
//
//    static void spread(int o) {
//        long v = t[o].todo;
//        if (v > 0) {
//            _do(o << 1, v);
//            _do(o << 1 | 1, v);
//            t[o].todo = 0;
//        }
//    }
//
//    static void maintain(int o) {
//        t[o].mask = t[o << 1].mask | t[o << 1 | 1].mask;
//    }
//
//    static void update(int o, int l, int r, long v) {
//        if (l <= t[o].l && t[o].r <= r) {
//            _do(o, v);
//            return;
//        }
//        spread(o);
//        int m = (t[o].l + t[o].r) >> 1;
//        if (l <= m) update(o << 1, l, r, v);
//        if (r > m) update(o << 1 | 1, l, r, v);
//        maintain(o);
//    }
//
//    static long query(int o, int l, int r) {
//        if (l <= t[o].l && t[o].r <= r) {
//            return t[o].mask;
//        }
//        spread(o);
//        int m = (t[o].l + t[o].r) >> 1;
//        if (r <= m) return query(o << 1, l, r);
//        if (l > m) return query(o << 1 | 1, l, r);
//        return query(o << 1, l, r) | query(o << 1 | 1, l, r);
//    }

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
E. New Year Tree
https://codeforces.com/contest/620/problem/E

灵茶の试炼 2024-03-28
题目大意：
输入 n(1≤n≤4e5) m(1≤m≤4e5) 和长为 n 的数组 a(1≤a[i]≤60)，表示一棵 n 个节点的无向树，以及每个节点的颜色 a[i]。
然后输入这棵树的 n-1 条边（编号从 1 到 n）。根节点的编号是 1。
然后输入 m 个操作：
"1 v c"：把以 v 为根的子树中的所有节点的颜色改成 c(1≤c≤60)。
"2 v"：输出以 v 为根的子树中，有多少种不同的颜色。

rating 2100
DFS 这棵树，每棵子树都可以视作 DFS 序中的一段连续区间。
所以问题变成区间更新区间查询的 lazy 线段树。
由于颜色至多 60 种，可以用 LL 存储区间内是否有相应的颜色。
https://codeforces.com/contest/620/submission/253191247
======

Input
7 10
1 1 1 1 1 1 1
1 2
1 3
1 4
3 5
3 6
3 7
1 3 2
2 1
1 4 3
2 1
1 2 5
2 1
1 6 4
2 1
2 2
2 3
Output
2
3
4
5
1
2

Input
23 30
1 2 2 6 5 3 2 1 1 1 2 4 5 3 4 4 3 3 3 3 3 4 6
1 2
1 3
1 4
2 5
2 6
3 7
3 8
4 9
4 10
4 11
6 12
6 13
7 14
7 15
7 16
8 17
8 18
10 19
10 20
10 21
11 22
11 23
2 1
2 5
2 6
2 7
2 8
2 9
2 10
2 11
2 4
1 12 1
1 13 1
1 14 1
1 15 1
1 16 1
1 17 1
1 18 1
1 19 1
1 20 1
1 21 1
1 22 1
1 23 1
2 1
2 5
2 6
2 7
2 8
2 9
2 10
2 11
2 4
Output
6
1
3
3
2
1
2
3
5
5
1
2
2
1
1
1
2
3
 */
