package c332;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Abc332_f {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        solve();
        out.close();
    }

    private static void solve() {
        LazyInfoSegmentTree seg = new LazyInfoSegmentTree(n);
        seg.build(a, 1, 1, n);

        while (m-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int x = scanner.nextInt();
            long p = quickPow(r - l + 1, MOD - 2);
            seg.rangeApply(1, 1, n, l, r, new LazyInfoSegmentTree.Tag(p * x % MOD, 1 - p));
        }
        seg.spreadAll(1, 1, n);
    }

    // 快速幂 res = a^b % mod
    static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    static final int MOD = 998244353;

    // 线段树模板，只需要实现 mergeInfo 和 _do，其余都是固定的
    static class LazyInfoSegmentTree {
        static class Info {
            long sm;

            public Info(long sm) {
                this.sm = sm;
            }

            void apply(int l, int r, Tag t) {
                long sz = r - l + 1;
                // 先乘后加
                if (t.mul != 1) {
                    sm = (sm * t.mul) % MOD;
                }
                if (t.add != 0) {
                    sm = (sm + sz * t.add) % MOD;
                }
            }
        }

        static class Tag {
            long add = 0, mul = 1;

            public Tag() {
            }

            public Tag(long add, long mul) {
                this.add = add;
                this.mul = mul;
            }

            void apply(Tag t) {
                if (t.mul != 1) {
                    add = (add * t.mul) % MOD;
                    mul = (mul * t.mul) % MOD;
                }
                if (t.add != 0) {
                    add = (add + t.add) % MOD;
                }
            }
        }

        Info mergeInfo(Info a, Info b) {
            long sm = (a.sm + b.sm) % MOD;
            return new Info(sm);
        }

        void _do(int p, int l, int r, Tag t) {
            info[p].apply(l, r, t);
            tag[p].apply(t);
        }

        int n;
        Info[] info;
        Tag[] tag;

        public LazyInfoSegmentTree(int n) {
            this.n = n;
            info = new Info[4 * n];
            tag = new Tag[4 * n];
            Arrays.setAll(tag, e -> new Tag());
        }

        void build(int[] A, int p, int l, int r) {
            if (l == r) {
                info[p] = new Info(A[l - 1]);
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
            if (tag[p].add == 0 && tag[p].mul == 1) return;
            int m = (l + r) >> 1;
            _do(p << 1, l, m, tag[p]);
            _do(p << 1 | 1, m + 1, r, tag[p]);
            tag[p] = new Tag();
        }

        void rangeApply(int p, int l, int r, int ql, int qr, Tag t) {
            if (ql <= l && r <= qr) {
                _do(p, l, r, t);
                return;
            }
            spread(p, l, r);
            int m = (l + r) >> 1;
            if (ql <= m) rangeApply(p << 1, l, m, ql, qr, t);
            if (qr > m) rangeApply(p << 1 | 1, m + 1, r, ql, qr, t);
            maintain(p);
        }

        Info rangeQuery(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return info[p];
            }
            spread(p, l, r);
            int m = (l + r) >> 1;
            if (qr <= m) return rangeQuery(p << 1, l, m, ql, qr);
            if (ql > m) return rangeQuery(p << 1 | 1, m + 1, r, ql, qr);
            return mergeInfo(rangeQuery(p << 1, l, m, ql, qr), rangeQuery(p << 1 | 1, m + 1, r, ql, qr));
        }

        void spreadAll(int p, int l, int r) {
            if (l == r) {
                out.print((info[p].sm + MOD) % MOD);
                out.print(" ");
                return;
            }
            spread(p, l, r);
            int m = (l + r) >> 1;
            spreadAll(p << 1, l, m);
            spreadAll(p << 1 | 1, m + 1, r);
        }
    }
}
/*
F - Random Update Query
https://atcoder.jp/contests/abc332/tasks/abc332_f

灵茶の试炼 2025-04-24
题目大意：
输入 n(1≤n≤2e5) m(1≤m≤2e5) 和长为 n 的数组 a(0≤a[i]≤1e9)。下标从 1 开始。
输入 m 个操作，每次操作输入 L R x(0≤x≤1e9)，表示在 [L,R] 中等概率地选一个整数 i，然后把 a[i] 替换成 x。
输出最终 a[1],a[2],...,a[n] 的期望值，模 M=998244353。
注：如果期望值是一个分数 p/q，你需要输出 p*pow(q,M-2)%M。

前置题目：P3373 【模板】线段树 2 https://www.luogu.com.cn/problem/P3373
P3373 代码 https://www.luogu.com.cn/paste/o0r8x5yr
设 p = 1 / (R-L+1)。
如果 i 在 [L,R] 中：
- 有 1-p 的概率 a[i] 不变，仍然为 a[i]。
- 有 p 的概率 a[i] 变成 x。
所以操作后，a[i] 的期望值为 (1-p)*a[i] + p*x。
注：可以直接把期望值作为 a[i] 的值，参与上面的运算。
所以操作本质上，是把区间内的所有数都乘以 1-p，再加上 p*x。
这可以直接用前置题目的代码。
注意取模。
注意 1-p 可能是负数。
代码 https://atcoder.jp/contests/abc332/submissions/65086142
======

Input 1
5 2
3 1 4 1 5
1 2 2
2 4 0
Output 1
499122179 1 665496238 665496236 5

Input 2
2 4
1 2
1 1 3
2 2 4
1 1 5
2 2 6
Output 2
5 6

Input 3
20 20
998769066 273215338 827984962 78974225 994243956 791478211 891861897 680427073 993663022 219733184 570206440 43712322 66791680 164318676 209536492 137458233 289158777 461179891 612373851 330908158
12 18 769877494
9 13 689822685
6 13 180913148
2 16 525285434
2 14 98115570
14 17 622616620
8 12 476462455
13 17 872412050
14 15 564176146
7 13 143650548
2 5 180435257
4 10 82903366
1 2 643996562
8 10 262860196
10 14 624081934
11 13 581257775
9 19 381806138
3 12 427930466
6 19 18249485
14 19 682428942
Output 3
821382814 987210378 819486592 142238362 447960587 678128197 687469071 405316549 318941070 457450677 426617745 712263899 939619994 228431878 307695685 196179692 241456697 12668393 685902422 330908158
 */
