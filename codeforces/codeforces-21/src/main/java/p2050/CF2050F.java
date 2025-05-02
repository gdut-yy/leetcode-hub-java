package p2050;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF2050F {
    static Scanner scanner = new Scanner(System.in);
    static int n, q;
    static int[] a;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            q = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                a[i - 1] = Math.abs(a[i - 1] - a[i]);
            }
        }

        InfoSegmentTree seg = new InfoSegmentTree(n);
        seg.build(a, 1, 0, n - 1);

        List<Integer> ans = new ArrayList<>();
        while (q-- > 0) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            if (l == r) {
                ans.add(0);
            } else {
                ans.add(seg.query(1, 0, n - 1, l - 1, r - 2).g);
            }
        }
        return ans.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

    static long getGCD(long num1, long num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }

    // 线段树模板，只需要实现 mergeInfo 和 _do，其余都是固定的
    static class InfoSegmentTree {
        static class Info {
            int g;

            public Info(int g) {
                this.g = g;
            }
        }

        Info mergeInfo(Info a, Info b) {
            return new Info((int) getGCD(a.g, b.g));
        }

        int n;
        Info[] info;

        public InfoSegmentTree(int n) {
            this.n = n;
            info = new Info[4 * n];
        }

        void build(int[] A, int p, int l, int r) {
            if (l == r) {
                info[p] = new Info(A[l]);
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
}
/*
F. Maximum modulo equality
https://codeforces.com/contest/2050/problem/F

灵茶の试炼 2024-12-18
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5，q 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) q(1≤q≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e9)。数组下标从 1 开始。
然后输入 q 个询问，每个询问输入两个数 L R(1≤L≤R≤n)。
对于每个询问，输出最大的 m，满足 a[L],a[L+1],...,a[R] 关于模 m 同余（这些数模 m 的结果都相等）。
如果 m 可以无限大，输出 0。

rating 1700
如果 x 和 y 关于模 m 同余，那么 x%m = y%m，所以 (x-y)%m = 0。也就是说，m 是 x-y 的因子。所以 m 最大是 |x-y|。
如果 x y z 关于模 m 同余，那么同理，m 是 x-y 的因子且 m 是 y-z 的因子。所以 m 是 x-y 和 y-z 的公因子。所以 m 最大是 GCD(|x-y|,|y-z|)。
一般地，如果多个数同余，那么 m 最大是相邻元素之差的 GCD。
根据 a 数组，生成长为 n-1 的邻项差值（取绝对值）数组 b，用来构建 GCD 线段树（或者 ST 表）。
然后回答询问：
如果 L=R，输出 0。
如果 L<R，输出 b[L] 到 b[R-1] 的 GCD。
注意当差值都是 0 的时候，m 可以无限大。但由于 0 和 0 的 GCD 仍然是 0，这正好符合题目要输出的 0。
（如果题目要输出的是 -1 或者别的，需要特判答案是 0 的情况。）
代码 https://codeforces.com/contest/2050/submission/296913688
代码备份（洛谷）
======

Input
3
5 5
5 14 2 6 3
4 5
1 4
2 4
3 5
1 1
1 1
7
1 1
3 2
1 7 8
2 3
1 2
Output
3 1 4 1 0
0
1 6
 */
