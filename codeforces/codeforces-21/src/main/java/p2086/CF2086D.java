package p2086;

import java.util.Scanner;

public class CF2086D {
    static int[] a = new int[26];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            for (int i = 0; i < a.length; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static final int MOD = 998244353;

    private static String solve() {
        int n = 0;
        long ans = 1;
        for (int v : a) {
            n += v;
            ans = ans * fac(v) % MOD;
        }

        int m = n / 2;
        ans = quickPow(ans, MOD - 2) * fac(m) % MOD * fac(n - m) % MOD;

        long[] f = new long[m + 1];
        f[0] = 1;
        for (int v : a) {
            if (v == 0) {
                continue;
            }
            for (int j = m; j >= v; j--) {
                f[j] = (f[j] + f[j - v]) % MOD;
            }
        }
        ans = ans * f[m] % MOD;
        return String.valueOf(ans);
    }

    // res = a^b % mod
    static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    static long fac(long n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res = res * i % MOD;
        }
        return res;
    }
}
/*
D. Even String
https://codeforces.com/contest/2086/problem/D

灵茶の试炼 2025-05-28
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 c[i] 之和 ≤5e5。
每组数据输入长为 26 的数组 c(0≤c[i]≤5e5)，保证 sum(c)>0。
计算满足如下全部要求的字符串 s 的数量：
1. 长为 sum(c)。
2. 第 i 种小写字母出现 c[i] 次。
3. 对于满足 s[i]=s[j] 的 i 和 j，下标之差 |i-j| 必须是偶数。
答案模 998244353。

rating 1700
把偶数下标记作集合 A，奇数下标记作集合 B。
相同字母的下标必须在同一个集合。
也就是说，我们要把 26 种字母分配到这两个集合中。
先算排列：
对于一个固定的分配方案，我们计算的是可重集合的排列数。
集合 A 是 |A|! / (c[i1]!c[i2]!...)。
集合 A 是 |B|! / (c[j1]!c[j2]!...)。
二者相乘就是 |A|!|B|! / (c[0]!*c[1]!*...*c[25]!)。
设 n = sum(c)。其中 |A| = floor(n/2)，|B| = ceil(n/2)。
然后算组合：
这是【恰好装满型 0-1 背包】。
有 26 个物品，物品大小为 c[i]。选择 c 的一个子集装入集合 A（恰好装满），其余装入集合 B。
做法同 494. 目标和。
最后，排列方案数 * 组合方案数 = 答案。
代码 https://codeforces.com/problemset/submission/2086/320729716
代码备份（洛谷）
======

Input
5
2 1 0 0 0 0 0 0 0 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
3 1 1 0 0 0 0 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 0 0 1 0
0 0 0 0 0 0 0 0 0 0 0 0 1 0 3 0 0 0 0 0 0 0 0 0 0 0
1 2 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 233527 233827
Output
4
960
0
1
789493841
 */