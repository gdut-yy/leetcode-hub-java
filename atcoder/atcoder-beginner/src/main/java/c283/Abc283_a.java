package c283;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc283_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int res = (int) Math.pow(a, b);
        System.out.println(res);
    }
}
/*
A - Power
https://atcoder.jp/contests/abc283/tasks/abc283_a

题目大意：
给定整数 A 和 B，输出值 A^B。
1≤A,B≤9

模拟。
======

Input 1
4 3
Output 1
64

Input 2
5 5
Output 2
3125

Input 3
8 1
Output 3
8
 */