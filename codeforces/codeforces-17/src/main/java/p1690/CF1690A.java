package p1690;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1690A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            System.out.println(solve(n));
        }
    }

    private static String solve(int n) {
        int h2 = (n + 2) / 3;
        int h1 = h2 + 1;
        int h3 = n - h1 - h2;
        if (h3 == 0) {
            h3++;
            h2--;
        }
        return h2 + " " + h1 + " " + h3;
    }
}
/*
Codeforces Round #797 (Div. 3)
A. Print a Pedestal (Codeforces logo?)
https://codeforces.com/contest/1690/problem/A

题目大意：
给定一个整数 n，代表基座块的总数。输出 3 个数字 h2, h1, h3，要求 h1 > h2 > h3 > 0.

贪心。
======

input
6
11
6
10
100000
7
8

output
4 5 2
2 3 1
4 5 1
33334 33335 33331
2 4 1
3 4 1
 */