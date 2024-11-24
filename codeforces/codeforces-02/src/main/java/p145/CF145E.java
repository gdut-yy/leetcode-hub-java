package p145;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class CF145E {
    // Time limit exceeded on test 58
//    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static int n, m;
    static char[] s;

    public static void main(String[] args) {
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.next().toCharArray();
        System.out.println(solve1());
    }

//    private static String solve() {
//        t = new Seg[4 * n];
//        Arrays.setAll(t, e -> new Seg());
//        build(1, 1, n);
//
//        List<String> output = new ArrayList<>();
//        for (; m > 0; m--) {
//            s = scanner.next().toCharArray();
//            if (s[0] == 's') {
//                int l = scanner.nextInt();
//                int r = scanner.nextInt();
//                update(1, l, r);
//            } else {
//                output.add("" + t[1].d.c01);
//            }
//        }
//        return String.join(System.lineSeparator(), output);
//    }

    private static String solve1() {
        SegmentTree seg = new SegmentTree(n);
        seg.build(1, 1, n);

        List<String> output = new ArrayList<>();
        for (; m > 0; m--) {
            s = scanner.next().toCharArray();
            if (s[0] == 's') {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                seg.update(1, l, r);
            } else {
                output.add("" + seg.tr_c01[1]);
            }
        }
        return String.join(System.lineSeparator(), output);
    }

    static class SegmentTree {
        int n;
        int[] tr_c0, tr_c1, tr_c01, tr_c10;
        boolean[] tr_flip;

        public SegmentTree(int n) {
            this.n = n;
            tr_c0 = new int[4 * n];
            tr_c1 = new int[4 * n];
            tr_c01 = new int[4 * n];
            tr_c10 = new int[4 * n];
            tr_flip = new boolean[4 * n];
        }

        void build(int p, int l, int r) {
            if (l == r) {
                int c1 = s[l - 1] & 1;
//                t[o].d = new Data(c1 ^ 1, c1, 1, 1);
                tr_c0[p] = c1 ^ 1;
                tr_c1[p] = c1;
                tr_c01[p] = 1;
                tr_c10[p] = 1;
                return;
            }
            int m = (l + r) >> 1;
            build(p << 1, l, m);
            build(p << 1 | 1, m + 1, r);
            maintain(p);
        }

        void update(int o, int ql, int qr) {
            update(1, 1, n, ql, qr);
        }

        void update(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                _do(p);
                return;
            }
            spread(p);
            int m = (l + r) >> 1;
            if (ql <= m) update(p << 1, l, m, ql, qr);
            if (qr > m) update(p << 1 | 1, m + 1, r, ql, qr);
            maintain(p);
        }

        void _do(int p) {
            int c0 = tr_c0[p];
            int c1 = tr_c1[p];
            int c01 = tr_c01[p];
            int c10 = tr_c10[p];

            tr_c0[p] = c1;
            tr_c1[p] = c0;
            tr_c01[p] = c10;
            tr_c10[p] = c01;
            tr_flip[p] = !tr_flip[p];
        }

        void spread(int p) {
            if (tr_flip[p]) {
                _do(p << 1);
                _do(p << 1 | 1);
                tr_flip[p] = false;
            }
        }

        void maintain(int p) {
            int a = p << 1, b = p << 1 | 1;
            tr_c0[p] = tr_c0[a] + tr_c0[b];
            tr_c1[p] = tr_c1[a] + tr_c1[b];
            tr_c01[p] = Math.max(tr_c01[a] + tr_c1[b], tr_c0[a] + tr_c01[b]);
            tr_c10[p] = Math.max(tr_c10[a] + tr_c0[b], tr_c1[a] + tr_c10[b]);
        }
    }

//    // 线段树模板，只需要实现 mergeInfo 和 do，其余都是固定的
//    static Seg[] t;
//
//    static class Data {
//        int c0, c1, c01, c10;
//
//        public Data() {
//        }
//
//        public Data(int c0, int c1, int c01, int c10) {
//            this.c0 = c0;
//            this.c1 = c1;
//            this.c01 = c01;
//            this.c10 = c10;
//        }
//    }
//
//    static class Seg {
//        int l, r;
//        Data d;
//        boolean flip;
//    }
//
//    static void build(int o, int l, int r) {
//        t[o].l = l;
//        t[o].r = r;
//        if (l == r) {
//            int c1 = s[l - 1] & 1;
//            t[o].d = new Data(c1 ^ 1, c1, 1, 1);
//            return;
//        }
//        int m = (l + r) >> 1;
//        build(o << 1, l, m);
//        build(o << 1 | 1, m + 1, r);
//        maintain(o);
//    }
//
//    static void _do(int O) {
//        Seg o = t[O];
//        Data d = o.d;
//        o.d = new Data(d.c1, d.c0, d.c10, d.c01);
//        o.flip = !o.flip;
//    }
//
//    static Data mergeInfo(Data a, Data b) {
//        return new Data(a.c0 + b.c0, a.c1 + b.c1,
//                Math.max(a.c01 + b.c1, a.c0 + b.c01),
//                Math.max(a.c10 + b.c0, a.c1 + b.c10));
//    }
//
//    static void spread(int o) {
//        if (t[o].flip) {
//            _do(o << 1);
//            _do(o << 1 | 1);
//            t[o].flip = false;
//        }
//    }
//
//    static void maintain(int o) {
//        t[o].d = mergeInfo(t[o << 1].d, t[o << 1 | 1].d);
//    }
//
//    static void update(int o, int l, int r) {
//        if (l <= t[o].l && t[o].r <= r) {
//            _do(o);
//            return;
//        }
//        spread(o);
//        int m = (t[o].l + t[o].r) >> 1;
//        if (l <= m) update(o << 1, l, r);
//        if (r > m) update(o << 1 | 1, l, r);
//        maintain(o);
//    }
//
//    static Data query(int o, int l, int r) {
//        if (l <= t[o].l && t[o].r <= r) {
//            return t[o].d;
//        }
//        spread(o);
//        int m = (t[o].l + t[o].r) >> 1;
//        if (r <= m) return query(o << 1, l, r);
//        if (l > m) return query(o << 1 | 1, l, r);
//        return mergeInfo(query(o << 1, l, r), query(o << 1 | 1, l, r));
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
E. Lucky Queries
https://codeforces.com/contest/145/problem/E

灵茶の试炼 2024-03-22
题目大意：
输入 n(1≤n≤1e6) m(1≤m≤3e5) 和长为 n 的字符串 s，只包含 4 和 7，下标从 1 开始。
然后输入 m 个操作，有两种：
"switch l r"：翻转 s[l] 到 s[r]，也就是把这段子串的 4 变成 7，7 变成 4。
"count"：输出 s 的最长非降子序列的长度。

rating 2400
lazy 线段树。
每个线段树节点维护区间的：
4 的个数，记作 c0。
7 的个数，记作 c1。
最长非降子序列的长度，记作 c01。
最长非增子序列的长度，记作 c10。
合并：
c01 = max(left.c0 + right.c01, left.c01 + right.c1)
c10 = max(left.c1 + right.c10, left.c10 + right.c0)
翻转：
c0 和 c1 交换，c01 和 c10 交换。
https://codeforces.com/problemset/submission/145/249599878
======

Input
2 3
47
count
switch 1 2
count
Output
2
1

Input
3 5
747
count
switch 1 1
count
switch 1 3
count
Output
2
3
2
 */
