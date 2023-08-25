package c300;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Abc300_e {
    private static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        long n = scanner.nextLong();
        System.out.println(solve(n));
    }

    private static Map<Long, Long> memo;
    private static final long INV5 = quickPow(5, MOD - 2);

    private static String solve(long n) {
        memo = new HashMap<>();
        long res = dp(1, n);
        return String.valueOf(res);
    }

    private static long dp(long x, long n) {
        if (x >= n) {
            return x == n ? 1 : 0;
        }
        if (memo.containsKey(x)) {
            return memo.get(x);
        }
        long res = 0L;
        for (int i = 2; i <= 6; i++) {
            res = (res + dp(x * i, n)) % MOD;
        }
        res = res * INV5 % MOD;
        memo.put(x, res);
        return res;
    }

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
E - Dice Product 3
https://atcoder.jp/contests/abc300/tasks/abc300_e

灵茶の试炼 2023-08-23
题目大意：
你有一个整数 1 和一个骰子，显示 1 到 6(包括 6)之间的整数的概率相等。
当整数严格小于 N 时，重复以下操作:
掷骰子。如果是 x，把整数乘以 x。
求出对 998244353 取模的概率，这个整数最终等于 N。

概率 DP。
f(n) = 1/6 (f(n) + f(2n) + f(3n) + f(4n) + f(5n) + f(6n))
5/6 f(n) = 1/6 (f(2n) + f(3n) + f(4n) + f(5n) + f(6n))
f(n) = 1/5 (f(2n) + f(3n) + f(4n) + f(5n) + f(6n))
======

Input
6
Output
239578645

Input
7
Output
0

Input
300
Output
183676961

Input
979552051200000000
Output
812376310
 */