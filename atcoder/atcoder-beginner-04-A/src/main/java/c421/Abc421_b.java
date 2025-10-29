package c421;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Abc421_b {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        String x = scanner.next();
        String y = scanner.next();

        BigInteger[] a = new BigInteger[11];
        a[1] = new BigInteger(x);
        a[2] = new BigInteger(y);
        for (int i = 3; i <= 10; i++) {
            a[i] = new BigInteger(new StringBuilder(a[i - 1].add(a[i - 2]).toString()).reverse().toString());
        }
        out.println(a[10]);
    }
}
/*
B - Fibonacci Reversed
https://atcoder.jp/contests/abc421/tasks/abc421_b

题目大意：
对于正整数 x ，定义 f(x) 如下：
- 设 sx 是用十进制符号表示 x 所得到的字符串（不含前导零），而 rev(sx) 是反转 sx 所得到的字符串。 f(x) 的值是将 rev(sx) 解释为整数的十进制表示所得到的整数。
例如，当 x=13 时，我们有 rev(sx)=31，所以是 f(x)=31；当 x=10 时，我们得到 rev(sx)=01，所以是 f(x)=1。特别是，对于任何正整数 x，f(x) 的值都是正整数。
给你正整数 X 和 Y 。定义一个正整数序列 A=(a1,a2,...,a10) 如下：
- a1 = X
- a2 = Y
- ai = f(a_{i-1} + a_{i-2}) (i >= 3)
求 a10 的值。

BigInteger 模拟。
======

Input 1
1 1
Output 1
415

Input 2
3 7
Output 2
895

Input 3
90701 90204
Output 3
9560800101
 */
