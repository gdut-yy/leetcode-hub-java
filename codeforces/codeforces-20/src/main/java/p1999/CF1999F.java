package p1999;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1999F {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int c1 = 0;
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            c1 += v;
        }
        long ans = 0;
        for (int i = 0; i < k / 2 + 1; i++) {
            ans = (ans + comb(n - c1, i) * comb(c1, k - i)) % MOD;
        }

        out.println(ans);
    }

    static int MOD = (int) 1e9 + 7, MX = (int) 2e5;
    static long[] F = new long[MX + 1], invF = new long[MX + 1];

    static {
        F[0] = F[1] = invF[0] = invF[1] = 1;
        for (int i = 2; i <= MX; i++) F[i] = F[i - 1] * i % MOD;
        invF[MX] = quickPow(F[MX], MOD - 2);
        for (int i = MX - 1; i >= 2; i--) invF[i] = invF[i + 1] * (i + 1) % MOD;
    }

    static long comb(int n, int m) {
        if (n < m || m < 0) return 0;
        return F[n] * invF[n - m] % MOD * invF[m] % MOD;
    }

    static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
F. Expected Median
https://codeforces.com/contest/1999/problem/F

灵茶の试炼 2025-10-07
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n k(1≤k≤n≤2e5) 和长为 n 的只包含 0 和 1 的数组 a。
保证 k 是奇数。
对于 a 的每个长为 k 的子序列 b，计算 b 的中位数。
所有中位数的和是多少？
答案模 1e9+7。
注：子序列不一定连续。

rating 1500
注意是子序列，不是子数组。
设 a 中有 count1 个 1。
枚举子序列中有 i = 0,1,2,...,floor(k/2) 个 0，有 count1 - i 个 1。
对应的方案数为 C(n-count1, i) * C(cnt1, k-i)。
累加即为答案。
代码 https://codeforces.com/contest/1999/submission/339447126
代码备份（上面打不开的同学看这个）
======

Input
8
4 3
1 0 0 1
5 1
1 1 1 1 1
5 5
0 1 0 1 0
6 3
1 0 1 0 1 1
4 3
1 0 1 1
5 3
1 0 1 1 0
2 1
0 0
34 17
1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1
Output
2
5
0
16
4
7
0
333606206
 */
