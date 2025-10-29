package c423;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc423_a {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        long x = scanner.nextLong();
        long c = scanner.nextLong();
        long ans = x / (1000 + c) * 1000;
        out.println(ans);
    }
}
/*
A - Scary Fee
https://atcoder.jp/contests/abc423/tasks/abc423_a

题目大意：
你有一张恐怖银行的存折。该银行的存折有一个可怕的特性，即手续费会根据取款金额的变化而变化。
要从存折中取款，您需要指定取款金额，单位为 1000 日元，并从余额中按每 1000 日元取款金额支付 C(999) 日元的手续费。如果取款余额低于 0 日元，则不允许取款。
当您的银行存折余额为 X(1e7) 日元时，您最多可以提取多少钱？

模拟。
======

Input 1
650000 8
Output 1
644000

Input 2
1003 4
Output 2
0

Input 3
10000000 24
Output 3
9765000
 */
