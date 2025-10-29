package c417;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc417_f {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static final int MOD = 998244353;
    static int MAXN = 200000;
    static long[] inv;

    private static void solve() {
        inv = new long[MAXN + 1];
        inv[1] = 1;
        for (int i = 2; i <= MAXN; i++) {
            inv[i] = (MOD - MOD / i) * inv[MOD % i] % MOD;
        }

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        LazyInfoSegmentTree seg = new LazyInfoSegmentTree(n);
        seg.build(a, 1, 1, n);

        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();

            long S = seg.query(1, 1, n, l, r).sm;
            int len = r - l + 1;
            long T = S % MOD * inv[len] % MOD;

            seg.modify(1, 1, n, l, r, (int) T);
        }

        long[] ans = new long[n];
        seg.get_ans(ans, 1, 1, n);

        for (int i = 0; i < n; i++) {
            if (i != 0) out.print(" ");
            out.print(ans[i]);
        }
    }

    // 线段树模板，只需要实现 mergeInfo 和 _do，其余都是固定的
    static class LazyInfoSegmentTree {
        static class Info {
            long sm, lazy;

            public Info(long sm, long lazy) {
                this.sm = sm;
                this.lazy = lazy;
            }
        }

        Info mergeInfo(Info a, Info b) {
            long sm = (a.sm + b.sm) % MOD;
            return new Info(sm, -1);
        }

        void _do(int p, int l, int r, long qv) {
            info[p].sm = (r - l + 1L) * qv % MOD;
            info[p].lazy = qv;
        }

        int n;
        Info[] info;

        public LazyInfoSegmentTree(int n) {
            this.n = n;
            info = new Info[4 * n];
        }

        void build(int[] A, int p, int l, int r) {
            if (l == r) {
                info[p] = new Info(A[l - 1], -1);
                return;
            }
            int m = (l + r) >> 1;
            build(A, p << 1, l, m);
            build(A, p << 1 | 1, m + 1, r);
            maintain(p);
        }

        void maintain(int p) {
            info[p] = mergeInfo(info[p << 1], info[p << 1 | 1]);
        }

        void spread(int p, int l, int r) {
            if (info[p].lazy == -1) return;
            if (l != r) {
                int m = (l + r) >> 1;
                _do(p << 1, l, m, info[p].lazy);
                _do(p << 1 | 1, m + 1, r, info[p].lazy);
            }
            info[p].lazy = -1;
        }

        void modify(int p, int l, int r, int ql, int qr, int qv) {
            if (ql <= l && r <= qr) {
                _do(p, l, r, qv);
                return;
            }
            spread(p, l, r);
            int m = (l + r) >> 1;
            if (ql <= m) modify(p << 1, l, m, ql, qr, qv);
            if (qr > m) modify(p << 1 | 1, m + 1, r, ql, qr, qv);
            maintain(p);
        }

        Info query(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return info[p];
            }
            spread(p, l, r);
            int m = (l + r) >> 1;
            if (qr <= m) return query(p << 1, l, m, ql, qr);
            if (ql > m) return query(p << 1 | 1, m + 1, r, ql, qr);
            return mergeInfo(query(p << 1, l, m, ql, qr), query(p << 1 | 1, m + 1, r, ql, qr));
        }

        void get_ans(long[] ans, int p, int l, int r) {
            if (l == r) {
                ans[l - 1] = info[p].sm;
                return;
            }
            spread(p, l, r);
            int m = (l + r) >> 1;
            get_ans(ans, p << 1, l, m);
            get_ans(ans, p << 1 | 1, m + 1, r);
        }
    }
}
/*
F - Random Gathering
https://atcoder.jp/contests/abc417/tasks/abc417_f

题目大意：
有 N 个盘子，从左到右排列为盘子 1, 盘子 2,..., 盘子 N 。最初，板块 i (1 <= i <= N) 包含 Ai 块石头。
你将在这些盘子上进行 M 次操作。在 i-th 运算 (1 <= i <= M) 中，给出了两个整数 Li 和 Ri ，并依次进行了以下运算：
- 移除 Ri-Li+1 盘中的所有石子：盘子 Li, 盘子 Li+1,..., 盘子 Ri 。
- 在 Li 和 Ri （含）之间均匀随机地选择一个整数，让它成为 x 。
- 将所有取出的棋子放入棋盘 x 。
对于 i=1,2,...,N，求当所有 M 运算完成后，放置在 i 盘子上的石子的预期个数（模为 998244353）。

https://yuanbao.tencent.com/chat/naQivTmsDa/38e7bd50-bd95-43fc-bafa-0feede90c540
======

Input 1
7 4
30 10 40 10 50 90 20
4 6
5 7
1 6
3 7
Output 1
35 35 36 36 36 36 36

Input 2
2 1
0 1
1 2
Output 2
499122177 499122177

Input 3
15 10
61477244 450343304 812961384 836482955 280670539 405068748 318805088 304825858 518212597 316347783 589272551 505875419 944071276 364842194 5376942
2 11
5 9
8 15
6 7
6 8
1 2
1 10
4 9
12 15
6 11
Output 3
449356308 449356308 449356308 449356308 449356308 648148154 648148154 648148154 648148154 648148154 648148154 643863031 643863031 643863031 643863031
 */
