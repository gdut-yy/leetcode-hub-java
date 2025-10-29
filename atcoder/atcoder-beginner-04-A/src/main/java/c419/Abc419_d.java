package c419;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Abc419_d {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String s = scanner.next();
        String t = scanner.next();

        LazyInfoSegmentTree seg = new LazyInfoSegmentTree(n + 1);
        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            seg.modify(1, 1, n, l, r, 1);
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            int xor = seg.query(1, 1, n, i, i).xor;
            if (xor == 0) ans.append(s.charAt(i - 1));
            else ans.append(t.charAt(i - 1));
        }
        out.println(ans);
    }

    // 线段树模板，只需要实现 mergeInfo 和 _do，其余都是固定的
    static class LazyInfoSegmentTree {
        static class Info {
            int xor, lazy;

            public Info(int xor, int lazy) {
                this.xor = xor;
                this.lazy = lazy;
            }
        }

        Info mergeInfo(Info a, Info b) {
            int xor = a.xor ^ b.xor;
            return new Info(xor, 0);
        }

        void _do(int p, int qv) {
            info[p].xor ^= qv;
            info[p].lazy ^= qv;
        }

        int n;
        Info[] info;

        public LazyInfoSegmentTree(int n) {
            this.n = n;
            info = new Info[4 * n];
            Arrays.setAll(info, e -> new Info(0, 0));
        }

        void build(int[] A, int p, int l, int r) {
            if (l == r) {
                info[p] = new Info(0, 0);
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

        void spread(int p) {
            if (info[p].lazy == 0) return;
            _do(p << 1, info[p].lazy);
            _do(p << 1 | 1, info[p].lazy);
            info[p].lazy = 0;
        }

        void modify(int p, int l, int r, int ql, int qr, int qv) {
            if (ql <= l && r <= qr) {
                _do(p, qv);
                return;
            }
            spread(p);
            int m = (l + r) >> 1;
            if (ql <= m) modify(p << 1, l, m, ql, qr, qv);
            if (qr > m) modify(p << 1 | 1, m + 1, r, ql, qr, qv);
            maintain(p);
        }

        Info query(int p, int l, int r, int ql, int qr) {
            if (ql <= l && r <= qr) {
                return info[p];
            }
            spread(p);
            int m = (l + r) >> 1;
            if (qr <= m) return query(p << 1, l, m, ql, qr);
            if (ql > m) return query(p << 1 | 1, m + 1, r, ql, qr);
            return mergeInfo(query(p << 1, l, m, ql, qr), query(p << 1 | 1, m + 1, r, ql, qr));
        }
    }
}
/*
D - Substr Swap
https://atcoder.jp/contests/abc419/tasks/abc419_d

题目大意：
给你长度为 N 的小写英文字符串 S 和 T ，以及 M 对整数 (L1,R1),(L2,R2),...,(LM,RM) 。
依次对 i=1,2,...,M 执行以下操作：
- 交换 S 的 Li-th 到 Ri-th 字符和 T 的 Li-th 到 Ri-th 字符。
    - 例如，如果 S 是 "abcdef"， T 是 "ghijkl"， (Li,Ri)=(3,5) ，那么 S 和 T 就分别变成了 "abijkf "和 "ghcdel"。
求出进行 M 操作后的字符串 S 。

线段树 维护区间 xor
======

Input 1
5 3
apple
lemon
2 4
1 5
5 5
Output 1
lpple

Input 2
10 5
lemwrbogje
omsjbfggme
5 8
4 8
1 3
6 6
1 4
Output 2
lemwrfogje
 */
