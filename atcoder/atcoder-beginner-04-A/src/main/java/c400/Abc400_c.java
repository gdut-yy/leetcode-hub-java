package c400;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc400_c {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static long isqrt(long x) {
        long rt = (long) Math.sqrt(x);
        if (rt * rt > x) rt--;
        return rt;
    }

    private static void solve() {
        long n = scanner.nextLong();
        out.println(isqrt(n / 2) + isqrt(n / 4));
    }
}
/*
C - 2^a b^2
https://atcoder.jp/contests/abc400/tasks/abc400_c

灵茶の试炼 2026-06-22
题目大意：
输入 n(1≤n≤1e18)。
如果正整数 x 可以表示为 pow(2, a) * b * b，其中 a 和 b 均为正整数，则称 x 为好整数。
输出 [1, n] 中的好整数个数。

rating
x 本质只有两类：2 * b^2 或者 4 * b^2，这两类无交集。
对于 8 * b^2，等价于 2 * (2b)^2，其余类似。
所以问题变成，计算满足 2 * b^2 <= n 的正整数 b 的个数，加上满足 4 * b^2 <= n 的正整数 b 的个数。
即 isqrt(n/2) + isqrt(n/4)。
本题 n 很大，用浮点计算 sqrt 需要微调，具体见代码。
代码 https://atcoder.jp/contests/abc400/submissions/76676086
======

Input 1
20
Output 1
5

Input 2
400
Output 2
24

Input 3
1234567890
Output 3
42413
 */
