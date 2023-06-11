package p1742;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1742A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            System.out.println(solve(a, b, c));
        }
    }

    private static String solve(int a, int b, int c) {
        if (a + b == c || a + c == b || b + c == a) {
            return "YES";
        }
        return "NO";
    }
}
/*
Codeforces Round #827 (Div. 4)
A. Sum
https://codeforces.com/contest/1742/problem/A

题目大意：
给定三个整数a、b和c，判断其中一个是否为其他两个的和。

模拟。
======

input
7
1 4 3
2 5 8
9 11 20
0 0 0
20 20 20
4 12 3
15 7 8

output
YES
NO
YES
YES
NO
NO
YES
 */