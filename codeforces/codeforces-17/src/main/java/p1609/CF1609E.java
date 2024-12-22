package p1609;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1609E {
    static Scanner scanner = new Scanner(System.in);
    static int n, q;
    static char[] s;

    public static void main(String[] args) {
        n = scanner.nextInt();
        q = scanner.nextInt();
        s = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static String solve() {
        int[] ans = new int[q];

        SegmentTree seg = new SegmentTree(n);
        seg.build(1, 0, n - 1);
        for (int qi = 0; qi < q; qi++) {
            int i = scanner.nextInt();
            s = scanner.next().toCharArray();
            seg.update(1, i - 1, s[0]);
            ans[qi] = seg.tr_abc[1];
        }
        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

//    private static String solve1() {
//        int[] ans = new int[q];
//
//        t = new Seg[4 * n];
//        Arrays.setAll(t, e -> new Seg());
//        build(1, 0, n - 1);
//        for (int qi = 0; qi < q; qi++) {
//            int i = scanner.nextInt();
//            s = scanner.next().toCharArray();
//            update(1, i - 1, s[0]);
//            ans[qi] = t[1].d.abc;
//        }
//        return Arrays.stream(ans).mapToObj(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
//    }

    static class SegmentTree {
        int n;
        int[] tr_a, tr_b, tr_c, tr_ab, tr_bc, tr_abc;

        public SegmentTree(int n) {
            this.n = n;
            tr_a = new int[4 * n];
            tr_b = new int[4 * n];
            tr_c = new int[4 * n];
            tr_ab = new int[4 * n];
            tr_bc = new int[4 * n];
            tr_abc = new int[4 * n];
        }

        void build(int p, int l, int r) {
            if (l == r) {
                newData(p, s[l]);
                return;
            }
            int m = (l + r) >> 1;
            build(p << 1, l, m);
            build(p << 1 | 1, m + 1, r);
            maintain(p);
        }

        void newData(int p, char c) {
            tr_a[p] = 0;
            tr_b[p] = 0;
            tr_c[p] = 0;
            tr_ab[p] = 0;
            tr_bc[p] = 0;
            tr_abc[p] = 0;

            if (c == 'a') tr_a[p] = 1;
            else if (c == 'b') tr_b[p] = 1;
            else tr_c[p] = 1;
        }

        void update(int p, int i, char c) {
            update(p, 0, n - 1, i, c);
        }

        void update(int p, int l, int r, int i, char c) {
            if (l == r) {
                newData(p, c);
                return;
            }
            int m = (l + r) >> 1;
            if (i <= m) update(p << 1, l, m, i, c);
            else update(p << 1 | 1, m + 1, r, i, c);
            maintain(p);
        }

        void maintain(int p) {
            int l = p << 1, r = p << 1 | 1;

            int a = tr_a[l] + tr_a[r];
            int b = tr_b[l] + tr_b[r];
            int c = tr_c[l] + tr_c[r];
            int ab = Math.min(tr_a[l] + tr_ab[r], tr_ab[l] + tr_b[r]);
            int bc = Math.min(tr_b[l] + tr_bc[r], tr_bc[l] + tr_c[r]);
            int abc = Math.min(tr_a[l] + tr_abc[r], Math.min(tr_ab[l] + tr_bc[r], tr_abc[l] + tr_c[r]));

            tr_a[p] = a;
            tr_b[p] = b;
            tr_c[p] = c;
            tr_ab[p] = ab;
            tr_bc[p] = bc;
            tr_abc[p] = abc;
        }
    }

    // 线段树模板，只需要实现 mergeInfo 和 do，其余都是固定的
//    static Seg[] t;
//
//    static class Data {
//        int a, b, c, ab, bc, abc;
//
//        public Data() {
//        }
//
//        public Data(int a, int b, int c, int ab, int bc, int abc) {
//            this.a = a;
//            this.b = b;
//            this.c = c;
//            this.ab = ab;
//            this.bc = bc;
//            this.abc = abc;
//        }
//    }
//
//    static class Seg {
//        int l, r;
//        Data d;
//    }
//
//    static void build(int o, int l, int r) {
//        t[o].l = l;
//        t[o].r = r;
//        if (l == r) {
//            t[o].d = newData(s[l]);
//            return;
//        }
//        int m = (l + r) >> 1;
//        build(o << 1, l, m);
//        build(o << 1 | 1, m + 1, r);
//        maintain(o);
//    }
//
//    static Data newData(char c) {
//        Data d = new Data();
//        if (c == 'a') d.a = 1;
//        else if (c == 'b') d.b = 1;
//        else d.c = 1;
//        return d;
//    }
//
//    static Data mergeInfo(Data l, Data r) {
//        return new Data(
//                l.a + r.a,
//                l.b + r.b,
//                l.c + r.c,
//                Math.min(l.a + r.ab, l.ab + r.b),
//                Math.min(l.b + r.bc, l.bc + r.c),
//                Math.min(l.a + r.abc, Math.min(l.ab + r.bc, l.abc + r.c))
//        );
//    }
//
//    static void maintain(int o) {
//        t[o].d = mergeInfo(t[o << 1].d, t[o << 1 | 1].d);
//    }
//
//    static void update(int o, int i, char c) {
//        if (t[o].l == t[o].r) {
//            t[o].d = newData(c);
//            return;
//        }
//        int m = (t[o].l + t[o].r) >> 1;
//        if (i <= m) update(o << 1, i, c);
//        else update(o << 1 | 1, i, c);
//        maintain(o);
//    }
}
/*
E. William The Oblivious
https://codeforces.com/contest/1609/problem/E

灵茶の试炼 2024-11-01
题目大意：
输入 n(1≤n≤1e5) q(1≤q≤1e5) 和长为 n 的字符串 s，只包含 'a','b','c'。
然后输入 q 个操作，每个操作输入 i(1≤i≤n) 和 c (c 是 'a' 或者 'b' 或者 'c')。
每个操作会把 s[i] 改成 c。
每次操作后，要使 s 不包含子序列 abc，至少要删除多少个字母？
注：子序列不一定连续。

rating 2400
考虑分治，用单点更新的线段树解决。（和昨天力扣每日一题一样）
线段树的每个节点维护：
a：区间有多少个 a。
b：区间有多少个 b。
c：区间有多少个 c。
ab：要使区间没有子序列 ab，至少要操作多少次。
bc：要使区间没有子序列 bc，至少要操作多少次。
abc：要使区间没有子序列 abc，至少要操作多少次。
合并：
a = l.a + r.a。
b = l.b + r.b。
c = l.c + r.c。
ab：如果右边没有 ab（但可能有 b），那么左边不能有 a；如果左边没有 ab（但可能有 a），那么右边不能有 b。
所以 ab = min(l.a+r.ab, l.ab+r.b)。
bc：如果右边没有 bc（但可能有 c），那么左边不能有 b；如果左边没有 bc（但可能有 b），那么右边不能有 c。
所以 bc = min(l.b+r.bc, l.bc+r.c)。
abc：如果右边没有 abc（但可能有 bc），那么左边不能有 a；如果左边没有 abc（但可能有 ab），那么右边不能有 c；如果左边没有 ab（但可能有 a），那么右边不能有 bc；如果右边没有 bc（但可能有 c），那么右边不能有 ab。
所以 abc = min(l.a+r.abc, l.ab+r.bc, l.abc+r.c)。
答案为根节点的 abc。
代码 https://codeforces.com/contest/1609/submission/288652113
代码备份（洛谷）
======

Input
9 12
aaabccccc
4 a
4 b
2 b
5 a
1 b
6 b
5 c
2 a
1 a
5 a
6 b
7 b
Output
0
1
2
2
1
2
1
2
2
2
2
2
 */
