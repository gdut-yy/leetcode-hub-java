package p1363;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1363B {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        String s = scanner.next();
        int n = s.length();
        int suf1 = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') suf1++;
        }
        int pre1 = 0;
        int ans = n;
        for (int i = 0; i < n; i++) {
            int b = s.charAt(i) - '0';
            suf1 -= b;
            pre1 += b;
            ans = Math.min(ans, Math.min(i + 1 - pre1 + suf1, pre1 + n - i - 1 - suf1));
        }
        out.println(ans);
    }
}
/*
B. Subsequence Hate
https://codeforces.com/contest/1363/problem/B

灵茶の试炼 2026-05-19
题目大意：
输入 T(≤100) 表示 T 组数据。
每组数据输入长度 ≤1e3 的 0-1 字符串 s。
每次操作，你可以翻转一个 s[i]，即 s[i] ^= 1。
把 s 变成不含子序列 010 或 101 的字符串，至少要操作多少次？
注：子序列不一定连续。

rating 1400
没有 010 或 101 子序列，意味着连续相同子段个数必须 <= 2，即 s 要变成 00..011..1 或者 11..100..0。
前后缀分解。
枚举分段位置，统计前缀后缀中的 0 的个数，1 的个数。
可以做到 O(1) 额外空间。
代码 https://codeforces.com/problemset/submission/1363/374943247
代码备份（上面打不开的同学看这个）
======

Input
7
001
100
101
010
0
1
001100
Output
0
0
1
1
0
0
2
 */
