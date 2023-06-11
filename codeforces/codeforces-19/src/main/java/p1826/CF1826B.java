package p1826;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1826B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        long gcd = 0;
        for (int i = 0; i < n / 2; i++) {
            long x = Math.min(a[i], a[n - 1 - i]);
            long y = Math.max(a[i], a[n - 1 - i]);
            gcd = getGCD(y - x, gcd);
        }
        return String.valueOf(gcd);
    }

    private static long getGCD(long num1, long num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
B. Lunatic Never Content
https://codeforces.com/contest/1826/problem/B

题目大意：
你有一个包含 n 个非负整数的数组 a。对于正整数 x，我们定义 f(a,x)=[a1modx,a2modx,...,anmodx]。找出最大的 x，使得 f(a,x) 是一个回文。
这里，a mod x 是 a 除以 x 的整数除法的余数。
如果一个数组的前后读法相同，那么它就是回文。更正式地说，长度为 n 的数组 a 是一个回文，如果对于每一个 i(1≤i≤n)， ai=a[n-i+1]。
---
对于每个测试用例输出最大的 x，使得 f(a,x)是一个回文。如果 x 可以无穷大，输出 0。

a1 mod x == an mod x
移项得 |an-a1| mod x 为定值
GCD
======

input
4
2
1 2
8
3 0 1 2 0 3 2 1
1
0
3
100 1 1000000000
output
1
2
0
999999900
 */
