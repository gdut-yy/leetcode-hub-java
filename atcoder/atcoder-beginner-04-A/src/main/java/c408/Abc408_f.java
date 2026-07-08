package c408;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Abc408_f {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static final int INF = (int) 1e9;
    static int[] seg;

    static void update(int o, int l, int r, int i, int v) {
        if (l == r) {
            seg[o] = v;
            return;
        }
        int m = (l + r) >> 1;
        if (i <= m) {
            update(o << 1, l, m, i, v);
        } else {
            update(o << 1 | 1, m + 1, r, i, v);
        }
        seg[o] = Math.max(seg[o << 1], seg[o << 1 | 1]);
    }

    static int query(int o, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            return seg[o];
        }
        int m = (l + r) >> 1;
        if (qr <= m) {
            return query(o << 1, l, m, ql, qr);
        }
        if (ql > m) {
            return query(o << 1 | 1, m + 1, r, ql, qr);
        }
        return Math.max(query(o << 1, l, m, ql, qr), query(o << 1 | 1, m + 1, r, ql, qr));
    }

    private static void solve() {
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        int r = scanner.nextInt();
        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            pos[v] = i;
        }
        int size = 2 << (32 - Integer.numberOfLeadingZeros(n - 1));
        seg = new int[size];
        Arrays.fill(seg, -INF);
        int[] f = new int[n];
        int ans = 0;
        for (int x = d + 1; x <= n; x++) {
            update(1, 0, n - 1, pos[x - d], f[pos[x - d]]);
            int i = pos[x];
            f[i] = Math.max(query(1, 0, n - 1, Math.max(i - r, 0), Math.min(i + r, n - 1)) + 1, 0);
            ans = Math.max(ans, f[i]);
        }
        out.println(ans);
    }
}
/*
F - Athletic
https://atcoder.jp/contests/abc408/tasks/abc408_f

灵茶の试炼 2026-06-11
题目大意：
输入 n(1≤n≤5e5) d(1≤d≤n) r(1≤r≤n) 和一个 1~n 的排列 a。下标从 1 开始。
选择一个 1~n 中的下标，作为起点。
每次跳跃，选择一个下标 j，满足 a[j] <= a[i] - d 且 1 <= |i - j| <= r。
重复直到无法跳跃为止。
输出最大跳跃次数。

rating
按照值域从小到大计算。
用“枚举大，维护小”的思路做。
定义 f[i] 表示从 i 开始的最大跳跃次数。
用线段树维护满足 a[j] <= a[i] - d 的 f[j]，查询区间 [i-r, i+r] 内的最大 f 值，加一，和 0 取最大值，作为转移来源。
线段树初始值为 -∞。
答案为 max(f)。
代码 https://atcoder.jp/contests/abc408/submissions/76295753
======

Input 1
5 2 1
5 3 1 4 2
Output 1
2

Input 2
13 3 2
13 7 10 1 9 5 4 11 12 2 8 6 3
Output 2
3
 */
