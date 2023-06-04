package c288;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc288_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        while (n-- > 0) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            System.out.println(a + b);
        }
    }
}
/*
A - Many A+B Problems
https://atcoder.jp/contests/abc288/tasks/abc288_a

题目大意：
给你 N 对整数:(a1, b1), (a2, b2),...,(a1, b2)。对于每个 i=1,2,...,N，打印 Ai + Bi

模拟。
======

Input 1
4
3 5
2 -6
-5 0
314159265 123456789
Output 1
8
-4
-5
437616054
 */