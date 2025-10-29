package p803;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF803F {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static final int MOD = (int) (1e9 + 7);
    static final int mx = (int) 1e5;

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int[] cnt = new int[mx + 1];
        long[] f = new long[mx + 1];
        long[] pow2 = new long[n + 1];
        pow2[0] = 1;
        for (int i = 0; i < n; i++) {
            cnt[a[i]]++;
            pow2[i + 1] = pow2[i] * 2 % MOD;
        }

        for (int i = mx; i > 0; i--) {
            int c = 0;
            for (int j = i; j <= mx; j += i) {
                c += cnt[j];
                f[i] -= f[j];
            }
            f[i] = (f[i] + pow2[c] - 1) % MOD;
        }
        long ans = (f[1] + MOD) % MOD;
        out.println(ans);
    }
}
/*
F. Coprime Subsequences
https://codeforces.com/contest/803/problem/F

灵茶の试炼 2025-07-24
题目大意：
输入 n(1≤n≤1e5) 和长为 n 的数组 a(1≤a[i]≤1e5)。
输出 a 有多少个非空子序列 b，满足 gcd(b) = 1。（注：子序列不一定连续）
答案模 1e9+7。
变形：改成子数组怎么做？

rating 2000
本题和 LC3312. 查询排序后的最大公约数 的思路是一样的，读完我的题解你就会做了。
把题解代码中的 c*(c-1)/2 改成 c 个数的非空子序列个数 pow(2,c) - 1。
代码 https://codeforces.com/contest/803/submission/328973343
代码备份（Ubuntu Pastebin）
改成子数组用 logTrick。
======

Input
3
1 2 3
Output
5

Input
4
1 1 1 1
Output
15

Input
7
1 3 5 15 3 105 35
Output
100
 */
