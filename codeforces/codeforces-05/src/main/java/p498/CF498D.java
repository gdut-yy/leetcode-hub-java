package p498;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF498D {
    //    static Scanner scanner = new Scanner(System.in);
    static FastReader scanner = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);
    static int n;
    static int[] a;

    public static void main(String[] args) {
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        solve();
        out.flush();
    }

    private static void solve() {
        InfoSegmentTree seg = new InfoSegmentTree(n);
        seg.build(a, 1, 0, n - 1);

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            char op = scanner.next().charAt(0);
            int l = scanner.nextInt();
            int r = scanner.nextInt();

            if (op == 'A') {
                out.println(seg.query(1, 0, n - 1, l - 1, r - 2).val[0]);
            } else {
                seg.modify(1, 0, n - 1, l - 1, r);
            }
        }
    }

    // 线段树模板，只需要实现 mergeInfo 和 _do，其余都是固定的
    static class InfoSegmentTree {
        static class Info {
            int[] val;

            public Info(int[] val) {
                this.val = val;
            }
        }

        Info mergeInfo(Info a, Info b) {
            int[] c = new int[60];
            for (int i = 0; i < a.val.length; i++) {
                int t = a.val[i];
                c[i] = t + b.val[(i + t) % 60];
            }
            return new Info(c);
        }

        Info set(int v) {
            int[] c = new int[60];
            for (int i = 0; i < c.length; i++) {
                if (i % v == 0) {
                    c[i] = 2;
                } else {
                    c[i] = 1;
                }
            }
            return new Info(c);
        }

        int n;
        Info[] info;

        public InfoSegmentTree(int n) {
            this.n = n;
            info = new Info[4 * n];
        }

        void build(int[] A, int p, int l, int r) {
            if (l == r) {
                info[p] = set(A[l]);
                return;
            }
            int m = (l + r) >> 1;
            build(A, p << 1, l, m);
            build(A, p << 1 | 1, m + 1, r);
            maintain(p, l, r);
        }

        void maintain(int p, int l, int r) {
            info[p] = mergeInfo(info[p << 1], info[p << 1 | 1]);
        }

        void modify(int p, int l, int r, int i, int qv) {
            if (l == r) {
                info[p] = set(qv);
                return;
            }
            int m = (l + r) >> 1;
            if (i <= m) modify(p << 1, l, m, i, qv);
            else modify(p << 1 | 1, m + 1, r, i, qv);
            maintain(p, l, r);
        }

        Info query(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return info[p];
            }
            int m = (l + r) >> 1;
            if (qr <= m) return query(p << 1, l, m, ql, qr);
            if (ql > m) return query(p << 1 | 1, m + 1, r, ql, qr);
            return mergeInfo(query(p << 1, l, m, ql, qr), query(p << 1 | 1, m + 1, r, ql, qr));
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
D. Traffic Jams in the Land
https://codeforces.com/contest/498/problem/D

灵茶の试炼 2025-06-13
题目大意：
输入 n(1≤n≤1e5) 和长为 n 的数组 a(2≤a[i]≤6)。
有一条公路连接 n+1 个城市。从第 i 个城市到第 i+1 个城市需要 1 个单位时间。
但是，如果你从城市 i 出发时，当前时间 t % a[i] = 0，那么必须等待 1 个单位时间才能出发。
然后输入 q(1≤q≤1e5) 和 q 个询问，格式如下：
"A l r"：输出从城市 l 到城市 r 所需的时间。你在城市 l 时，当前时间 t = 0。其中 1≤l<r≤n+1。
"C i v"：把 a[i] 改成 v。其中 1≤i≤n，2≤v≤6。

rating 2400
考虑用线段树维护。
考虑左右两个区间 A 和 B，如何合并？
想象一辆车从左到右，穿过 A，再穿过 B。
我们需要知道穿过 B 的时间增量是多少。
但是，到达 B 之前的时间 t 不同，增量也不同。
好在，a[i] 是很小的，我们可以维护 LCM(2,3,4,5,6)=60 个 t%60 所对应的时间增量，更大的时间一定和 t%60 的时间增量相同。
A 与 B 合并后的时间增量 C[i] = A[i] + B[(i+A[i])%60]。
初始值：如果 i%v=0，则 A[i]=2，否则 A[i]=1。
代码 https://codeforces.com/contest/498/submission/323060399
代码备份（洛谷）
======

Input
10
2 5 3 2 3 5 3 4 2 4
10
C 10 6
A 2 6
A 1 3
C 3 4
A 3 11
A 4 9
A 5 6
C 7 3
A 8 10
A 2 5
Output
5
3
14
6
2
4
4
 */
