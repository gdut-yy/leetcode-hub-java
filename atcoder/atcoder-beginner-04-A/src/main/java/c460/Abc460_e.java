package c460;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Abc460_e {
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

    static final long MOD = 998244353;

    private static void wa() {
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        long ans = 0;
        for (long p10 = 1; p10 <= n; p10 *= 10) {
            long m2 = m / gcd(p10 * 10 - 1, m);
            long mx = Math.min(p10 * 10 - 1, n);
            ans = (ans + n / m2 % MOD * ((mx - p10 + 1) % MOD)) % MOD;
        }
        out.println(ans);
    }

    private static void solve() {
        long n = scanner.nextLong(), m = scanner.nextLong();
        long ans = 0;
        for (long p10 = 1; p10 <= n; ) {
            BigInteger v = BigInteger.valueOf(p10).multiply(BigInteger.TEN).subtract(BigInteger.ONE);
            long m2 = m / v.gcd(BigInteger.valueOf(m)).longValue();
            long mx = v.compareTo(BigInteger.valueOf(n)) <= 0 ? v.longValue() : n;
            ans = (ans + n / m2 % MOD * ((mx - p10 + 1) % MOD)) % MOD;
            if (p10 > n / 10) break;
            p10 *= 10;
        }
        out.println(ans);
    }

    static long gcd(long a, long b) {
        while (a != 0) {
            long t = b % a;
            b = a;
            a = t;
        }
        return b;
    }
}
/*
E - x + y ≡ x + y
https://atcoder.jp/contests/abc460/tasks/abc460_e

灵茶の试炼 2026-06-17
题目大意：
输入 T(≤1e4) 表示 T 组数据。
每组数据输入 n(1≤n≤1e18) 和 m(2≤m≤1e9)。
定义 f(x, y) 表示把整数 x 和整数 y 按照十进制字符串拼起来，得到的整数。
例如 f(12, 345) = 12345。
输出整数对 (x, y) 的个数，满足 1≤x≤n 且 1≤y≤n 且 f(x, y) ≡ x + y (mod m)。
答案模 998244353。

rating
枚举 y 的十进制长度。
例如 y 的十进制长度为 3，那么有 x*1000+y ≡ x+y (mod m)，即 x*999 是 m 的倍数。
去掉 m 与 999 的公因子，设 m' = m / gcd(m, 999)，问题变成计算 [1, n] 中的 m' 的倍数个数，即 n / m'，从而得到 x 的个数。
对于 y 的个数，即三位数的个数，900。
对于其他十进制长度，计算方式类似。
注意特殊处理 y 的十进制长度等于 n 的十进制长度的情况，此时 y 的最大值为 n，而不是 99..9。
由于计算过程可能会得到 1e19，要用 unsigned long long。
代码 https://atcoder.jp/contests/abc460/submissions/76604946
======

Input 1
4
3 2
123 456
20260530 460
123456789123456789 998244353
Output 1
3
0
922576091
422081792
 */
