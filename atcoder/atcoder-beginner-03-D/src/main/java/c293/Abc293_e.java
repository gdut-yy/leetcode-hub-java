package c293;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc293_e {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int A = scanner.nextInt();
        long X = scanner.nextLong();
        int M = scanner.nextInt();
        System.out.println(solve(A, X, M));
    }

    private static String solve(int A, long X, int M) {
        if (A == 1) {
            return String.valueOf(X % M);
        }
        long mod = M * (A - 1L);
        long x = quickPow(A, X, mod) - 1;
        x /= (A - 1);
        x = (x + M) % M;
        return String.valueOf(x);
    }

    private static long quickPow(long a, long b, long m) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = multi(res, a, m);
            }
            a = multi(a, a, m);
            b >>= 1;
        }
        return res;
    }

    // a * b % m
    // 快速幂取模（当数很大时，相乘 long long 也会超出的解决办法）
    private static long multi(long a, long b, long m) {
        long res = 0L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res + a) % m;
            }
            a = (a + a) % m;
            b >>= 1;
        }
        return res;
    }
}
/*
E - Geometric Progression
https://atcoder.jp/contests/abc293/tasks/abc293_e

题目大意：
给定整数 A, X, M，求出 ai 模 M 的和（0<=i<=x-1）。
1≤A,M≤10e9
1≤X≤10e12

https://atcoder.jp/contests/abc293/submissions/39612056
(A^(X+1)-1) / (A-1) % M
---
a/b % p = a%(bp) / b
证明：设 a/b % p = d
a/b = kp + d
a = bkp + bd
a = (bp)k + bd
a % (bp) = bd
a%(bp) / b = d
---
快速幂取模（当数很大时，相乘 long long 也会超出的解决办法）
======

Input 1
3 4 7
Output 1
5

Input 2
8 10 9
Output 2
0

Input 3
1000000000 1000000000000 998244353
Output 3
919667211
 */