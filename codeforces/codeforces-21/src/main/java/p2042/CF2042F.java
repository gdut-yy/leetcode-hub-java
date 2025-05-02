package p2042;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CF2042F {
    // Time limit exceeded on test 8
//    static Scanner scanner = new Scanner(System.in);
    static Reader scanner = new Reader();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int[][] a;

    public static void main(String[] args) throws IOException {
        n = scanner.nextInt();
        a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            a[i][1] = scanner.nextInt();
        }
        solve();
    }

    private static void solve() throws IOException {
        InfoSegmentTree seg = new InfoSegmentTree(n);
        seg.build(a, 1, 0, n - 1);

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int op = scanner.nextInt();
            int p = scanner.nextInt() - 1;
            int x = scanner.nextInt();

            if (op < 3) {
                a[p][op - 1] = x;
                seg.modify(1, 0, n - 1, p, a[p][0], a[p][1]);
            } else {
                long res = seg.query(1, 0, n - 1, p, x - 1).val[0][4];
                bw.write(res + "\n");
            }
        }
        bw.flush();
    }

    // 线段树模板，只需要实现 mergeInfo 和 _do，其余都是固定的
    static class InfoSegmentTree {
        static final long INF = (long) 1e18;

        static class Info {
            long[][] val;

            public Info(long[][] val) {
                this.val = val;
            }

            public Info(long a, long b) {
                val = new_val(a, b);
            }
        }

        static long[][] new_val(long a, long b) {
            return new long[][]{
                    {0, a + b, a + b * 2, -INF, -INF},
                    {-INF, a, a + b, -INF, -INF},
                    {-INF, -INF, 0, a + b, a + b * 2},
                    {-INF, -INF, -INF, a, a + b},
                    {-INF, -INF, -INF, -INF, 0}
            };
        }

        Info mergeInfo(Info a, Info b) {
            long[][] c = new long[5][5];
            extracted(c, a.val, b.val);
            return new Info(c);
        }

        static long max(long e1, long e2) {
            return Math.max(e1, e2);
        }

        static long max(long e1, long e2, long e3) {
            return max(e1, max(e2, e3));
        }

        static long max(long e1, long e2, long e3, long e4) {
            return max(e1, e2, Math.max(e3, e4));
        }

        static long max(long e1, long e2, long e3, long e4, long e5) {
            return max(e1, e2, e3, Math.max(e4, e5));
        }

        void extracted(long[][] c, long[][] a, long[][] b) {
//            for (int i = 0; i < 5; i++) {
//                for (int j = 0; j < 5; j++) {
//                    c[i][j] = -INF;
//                }
//            }
//            for (int i = 0; i < 5; i++) {
//                for (int k = i; k < 5; k++) {
//                    for (int j = k; j < 5; j++) {
//                        c[i][j] = Math.max(c[i][j], a[i][k] + b[k][j]);
//                    }
//                }
//            }
            // 循环展开：https://www.luogu.com.cn/article/kgo19xai
            c[0][0] = 0;
            c[0][1] = max(b[0][1], a[0][1] + b[1][1]);
            c[0][2] = max(b[0][2], a[0][1] + b[1][2], a[0][2]);
            c[0][3] = max(b[0][3], a[0][1] + b[1][3], a[0][2] + b[2][3], a[0][3] + b[3][3]);
            c[0][4] = max(b[0][4], a[0][1] + b[1][4], a[0][2] + b[2][4], a[0][3] + b[3][4], a[0][4]);
            c[1][1] = a[1][1] + b[1][1];
            c[1][2] = max(a[1][1] + b[1][2], a[1][2]);
            c[1][3] = max(a[1][1] + b[1][3], a[1][2] + b[2][3], a[1][3] + b[3][3]);
            c[1][4] = max(a[1][1] + b[1][4], a[1][2] + b[2][4], a[1][3] + b[3][4], a[1][4]);
            c[2][2] = 0;
            c[2][3] = max(b[2][3], a[2][3] + b[3][3]);
            c[2][4] = max(b[2][4], a[2][3] + b[3][4], a[2][4]);
            c[3][3] = a[3][3] + b[3][3];
            c[3][4] = max(a[3][3] + b[3][4], a[3][4]);
            c[4][4] = 0;
        }

        int n;
        Info[] info;

        public InfoSegmentTree(int n) {
            this.n = n;
//            info = new Info[4 * n];
            info = new Info[1 << (33 - Integer.numberOfLeadingZeros(n - 1))];
        }

        void build(int[][] A, int p, int l, int r) {
            info[p] = new Info(new long[5][5]);
            if (l == r) {
//                info[p] = new Info(A[l][0], A[l][1]);
                info[p].val = new_val(A[l][0], A[l][1]);
                return;
            }
            int m = (l + r) >> 1;
            build(A, p << 1, l, m);
            build(A, p << 1 | 1, m + 1, r);
            maintain(p);
        }

        void maintain(int p) {
//            info[p] = mergeInfo(info[p << 1], info[p << 1 | 1]);
            long[][] c = info[p].val;
            long[][] a = info[p << 1].val;
            long[][] b = info[p << 1 | 1].val;
            extracted(c, a, b);
        }

        void modify(int p, int l, int r, int i, int a, int b) {
            if (l == r) {
//                info[p] = new Info(a, b);
                info[p].val = new_val(a, b);
                return;
            }
            int m = (l + r) >> 1;
            if (i <= m) modify(p << 1, l, m, i, a, b);
            else modify(p << 1 | 1, m + 1, r, i, a, b);
            maintain(p);
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

    static class Reader {
        private final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream dataInputStream;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            dataInputStream = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg) {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg) {
                return -ret;
            }
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = dataInputStream.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }
    }
}
/*
F. Two Subarrays
https://codeforces.com/contest/2042/problem/F

灵茶の试炼 2025-01-03
题目大意：
输入 n(2≤n≤2e5)，长为 n 的数组 a(-1e9≤a[i]≤1e9)，长为 n 的数组 b(-1e9≤b[i]≤1e9)，下标从 1 开始。
定义区间 [i,j] 的 cost = a 的子数组 [i,j] 的元素和 + b[i] + b[j]。
特别地，区间 [i,i] 的 cost = a[i] + 2*b[i]。
然后输入 q(1≤q≤2e5) 和 q 个询问，格式如下：
"1 p x"，把 a[p] 改成 x。其中 1≤p≤n，-1e9≤x≤1e9。
"2 p x"，把 b[p] 改成 x。其中 1≤p≤n，-1e9≤x≤1e9。
"3 L R"，在区间 [L,R] 中选两个不重叠的非空区间，输出这两个区间的 cost 之和的最大值。其中 1≤L<R≤n。

rating 2600
如果 b[i] = 0，那么问题是区间最大两段子数组和。
区间最大（一段）子数组和可以用线段树。
两段也可以，这启发我们用线段树解决。
对于本题来说，相比定义一大堆线段树的前后缀信息，更简单的做法是状态机 DP + 矩阵运算。
详细状态定义 https://www.luogu.com.cn/article/lb4y1dx0
代码 https://codeforces.com/contest/2042/submission/299019122
代码备份（洛谷）
======

Input
7
3 -1 4 -3 2 4 0
0 6 1 0 -3 -2 -1
6
3 1 7
1 2 0
3 3 6
2 5 -3
1 3 2
3 1 5
Output
18
7
16

Input
10
2 -1 -3 -2 0 4 5 6 2 5
2 -4 -5 -1 6 2 5 -6 4 2
10
3 6 7
1 10 -2
3 5 7
3 2 8
2 1 -5
2 7 4
3 1 3
3 3 8
3 2 3
1 4 4
Output
23
28
28
-17
27
-22
 */
