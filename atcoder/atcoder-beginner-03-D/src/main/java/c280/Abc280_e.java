package c280;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc280_e {
    private static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        System.out.println(solve(n, p));
    }

    private static String solve(int n, int p) {
        // x = 1 - x*p/100
        // ans += x
        long inv = inv(100, MOD);
        long x = 1, ans = 1;
        for (int i = 0; i < n - 1; i++) {
            x = (1 - x * p % MOD * inv % MOD + MOD) % MOD;
            ans = (ans + x) % MOD;
        }
        return String.valueOf(ans);
    }

    private static long inv(long a, long b) {
        x = 0;
        y = 0;
        exgcd(a, b);
        return (x + b) % b;
    }

    private static long x, y;

    private static long exgcd(long a, long b) {
        if (b == 0) {
            x = 1;
            y = 0;
            return a;
        }
        long d = exgcd(b, a % b);
        long tmp = x;
        x = y;
        y = tmp - a / b * y;
        return d;
    }
}
/*
E - Critical Hit
https://atcoder.jp/contests/abc280/tasks/abc280_e

灵茶の试炼 2023-08-07
题目大意：
有一个初始耐力为 N 的怪物。
高桥反复攻击怪物，而怪物的耐力保持 1 或更高。
高桥的攻击使怪物的耐力减少 2(概率为 P/100)和 1(概率为 1 - P/100)。
在怪物的耐力变为 0 或更少之前，求出攻击次数的模 998244353 的期望值。

概率 DP。
exgcd 求逆元
======

Input
3 10
Output
229596204

Input
5 100
Output
3

Input
280 59
Output
567484387
 */