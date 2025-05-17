package c343;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Abc343_f {
    static Scanner scanner = new Scanner(System.in);
    static int n, q;
    static int[] a;

    public static void main(String[] args) {
        n = scanner.nextInt();
        q = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        InfoSegmentTree seg = new InfoSegmentTree(n);
        seg.build(a, 1, 0, n - 1);

        List<String> output = new ArrayList<>();
        while (q-- > 0) {
            int op = scanner.nextInt();
            int l = scanner.nextInt();
            int r = scanner.nextInt();

            if (op == 1) {
                seg.update(1, l - 1, r);
            } else {
                long res = seg.query(1, l - 1, r - 1).c2;
                output.add(String.valueOf(res));
            }
        }
        return String.join(System.lineSeparator(), output);
    }

    // 线段树模板，只需要实现 mergeInfo 和 _do，其余都是固定的
    static class InfoSegmentTree {
        static class Data {
            long mx1, mx2, c1, c2;

            public Data(long mx1, long mx2, long c1, long c2) {
                this.mx1 = mx1;
                this.mx2 = mx2;
                this.c1 = c1;
                this.c2 = c2;
            }
        }

        static class Info {
            int l, r;
            Data val;

            public Info(int l, int r, Data val) {
                this.l = l;
                this.r = r;
                this.val = val;
            }
        }

        Data mergeInfo(Data _a, Data _b) {
            Data a = new Data(_a.mx1, _a.mx2, _a.c1, _a.c2);
            Data b = new Data(_b.mx1, _b.mx2, _b.c1, _b.c2);
            if (a.mx1 < b.mx1) {
                // a, b = b, a;
                a = new Data(_b.mx1, _b.mx2, _b.c1, _b.c2);
                b = new Data(_a.mx1, _a.mx2, _a.c1, _a.c2);
            }
            if (a.mx1 > b.mx1) {
                if (b.mx1 > a.mx2) {
                    a.mx2 = b.mx1;
                    a.c2 = b.c1;
                } else if (b.mx1 == a.mx2) {
                    a.c2 += b.c1;
                }
            } else {
                a.c1 += b.c1;
                if (b.mx2 > a.mx2) {
                    a.mx2 = b.mx2;
                    a.c2 = b.c2;
                } else if (b.mx2 == a.mx2) {
                    a.c2 += b.c2;
                }
            }
            return a;
        }

        int n;
        Info[] t;

        public InfoSegmentTree(int n) {
            this.n = n;
            t = new Info[4 * n];
        }

        void build(int[] A, int o, int l, int r) {
            t[o] = new Info(l, r, new Data(0, 0, 0, 0));
            if (l == r) {
                t[o].val.mx1 = A[l];
                t[o].val.c1 = 1;
                return;
            }
            int m = (l + r) >> 1;
            build(A, o << 1, l, m);
            build(A, o << 1 | 1, m + 1, r);
            maintain(o);
        }

        void maintain(int o) {
            t[o].val = mergeInfo(t[o << 1].val, t[o << 1 | 1].val);
        }

        void update(int o, int i, int val) {
            if (t[o].l == t[o].r) {
                t[o].val.mx1 = val;
                return;
            }
            int m = (t[o].l + t[o].r) >> 1;
            if (i <= m) update(o << 1, i, val);
            else update(o << 1 | 1, i, val);
            maintain(o);
        }

        Data query(int o, int ql, int qr) {
            if (ql <= t[o].l && t[o].r <= qr) {
                return t[o].val;
            }
            int m = (t[o].l + t[o].r) >> 1;
            if (qr <= m) return query(o << 1, ql, qr);
            if (m < ql) return query(o << 1 | 1, ql, qr);
            return mergeInfo(query(o << 1, ql, qr), query(o << 1 | 1, ql, qr));
        }
    }
}
/*
F - Second Largest Query
https://atcoder.jp/contests/abc343/tasks/abc343_f

灵茶の试炼 2025-04-02
题目大意：
输入 n(1≤n≤2e5) q(1≤q≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。下标从 1 开始。
然后输入 q 个询问，格式如下：
"1 p x"：把 a[p] 改成 x(1≤x≤1e9)。
"2 l r"：输出 a 的子数组 [l,r] 中的严格次大值的个数。
注：严格次大值指不等于最大值的数中的最大值。

单点修改线段树。
维护区间最大值 mx1、次大值 mx2、最大值个数 c1、次大值个数 c2。
合并的时候，分类讨论即可，具体见代码。
代码 https://atcoder.jp/contests/abc343/submissions/64180700
======

Input 1
5 4
3 3 1 4 5
2 1 3
2 5 5
1 3 3
2 2 4
Output 1
1
0
2

Input 2
1 1
1000000000
2 1 1
Output 2
0

Input 3
8 9
2 4 4 3 9 1 1 2
1 5 4
2 7 7
2 2 6
1 4 4
2 2 5
2 2 7
1 1 1
1 8 1
2 1 8
Output 3
0
1
0
2
4
 */
