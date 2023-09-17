package c295;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc295_e {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, m, k, a));
    }

    private static final int MAX_N = 5010;
    private static final int MOD = 998244353;
    private static final long[][] binom = new long[MAX_N][MAX_N];

    static {
        for (int i = 0; i < MAX_N; i++) {
            binom[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                binom[i][j] = (binom[i - 1][j - 1] + binom[i - 1][j]) % MOD;
            }
        }
    }

    private static String solve(int n, int m, int k, int[] a) {
        long ans = 0L;
        for (int i = 1; i <= m; i++) {
            int rem = n + 1 - k;
            int zero = 0;
            for (int j : a) {
                if (j >= i) rem--;
                if (j == 0) zero++;
            }
            if (rem < 0 || rem > zero) {
                ans += (rem < 0 ? 1 : 0);
                continue;
            }
            // 逆元 long p = (m + 1 - i) / m;
            long p = (m + 1 - i) * quickPow(m, MOD - 2) % MOD;
            long[] pPow = new long[zero + 1];
            long[] qPow = new long[zero + 1];
            Arrays.fill(pPow, 1);
            Arrays.fill(qPow, 1);
            for (int j = 0; j < zero; j++) {
                pPow[j + 1] = (pPow[j] * p % MOD + MOD) % MOD;
                qPow[j + 1] = (qPow[j] * (1 - p) % MOD + MOD) % MOD;
            }
            for (int j = rem; j <= zero; j++) {
                long x = binom[zero][j] * pPow[j] % MOD * qPow[zero - j] % MOD;
                ans = (ans + x) % MOD;
            }
        }
        return String.valueOf(ans);
    }

    // 模下的 a^b
    private static long quickPow(long a, long b) {
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
}
/*
E - Kth Number
https://atcoder.jp/contests/abc295/tasks/abc295_e

题目大意：
我们有一个长度为 N 的序列，由 0 到 M 之间的整数组成，包括:A=(A1, A2,...,AN)。Snuke 将依次执行以下操作 1 和 2。
- 对于每一个 i，使得 A[i] = 0，分别在 1 到 M 之间(含 M)选择一个统一的随机整数，并用该整数替换 A[i]。
- 按升序对 A 排序。
对 998244353 进行模运算后，输出 A[K] 的期望值。

概率 DP。
======

Input
3 5 2
2 0 4
Output
3

Input
2 3 1
0 0
Output
221832080

Input
10 20 7
6 5 0 2 0 0 0 15 0 0
Output
617586310
 */