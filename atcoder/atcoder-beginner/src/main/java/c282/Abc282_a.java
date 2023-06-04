package c282;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc282_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        System.out.println(solve(n));
    }

    private static String solve(int n) {
        char[] cs = new char[n];
        cs[0] = 'A';
        for (int i = 1; i < n; i++) {
            cs[i] = (char) (cs[i - 1] + 1);
        }
        return new String(cs);
    }
}
/*
A - Generalized ABC
https://atcoder.jp/contests/abc282/tasks/abc282_a

题目大意：
给你一个整数 K。
打印一个字符串，该字符串由前 K 个大写英文字母按升序排列，从 a 开始。

模拟。
======

Input 1
3
Output 1
ABC

Input 2
1
Output 2
A
 */