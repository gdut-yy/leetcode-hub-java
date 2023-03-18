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
        long inv = inv(100, MOD);
        long x = 1, ans = 1;
        for (int i = 0; i < n - 1; i++) {
            x = (1 - x * p % MOD * inv % MOD + MOD) % MOD;
            ans = (ans + x) % MOD;
        }
        return String.valueOf(ans);
    }

    static long inv(long a, long b) {
        x = 0;
        y = 0;
        exgcd(a, b);
        return (x + b) % b;
    }

    static long x, y;

    static long exgcd(long a, long b) {
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

exgcd 求逆元
 */