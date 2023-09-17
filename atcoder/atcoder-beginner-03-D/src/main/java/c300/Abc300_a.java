package c300;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc300_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(solve(n, a, b, c));
    }

    private static String solve(int n, int a, int b, int[] c) {
        for (int i = 0; i < n; i++) {
            if (c[i] == a + b) {
                return String.valueOf(i + 1);
            }
        }
        return "-1";
    }
}
/*
A - N-choice question
https://atcoder.jp/contests/abc300/tasks/abc300_a

题目大意：
给定整数 A 和 B，求出 A+B。
这是一个 n 选项问题;第 i 个选项是 ci。
打印正确选项的索引。
C i 是两两不同的。换句话说，没有两个选择具有相同的值。
只有一个 i 满足 A+B=C i。换句话说，总是有一个唯一的正确选择。

注意 C 并没有单调性，不能用二分偷懒。。
======

Input
3 125 175
200 300 400
Output
2

Input
1 1 1
2
Output
1

Input
5 123 456
135 246 357 468 579
Output
5
 */