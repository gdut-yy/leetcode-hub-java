package p1692;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1692A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();
            System.out.println(solve(a, b, c, d));
        }
    }

    private static String solve(int a, int b, int c, int d) {
        int cnt = 0;
        if (b > a) {
            cnt++;
        }
        if (c > a) {
            cnt++;
        }
        if (d > a) {
            cnt++;
        }
        return String.valueOf(cnt);
    }
}
/*
Codeforces Round #799 (Div. 4)
A. Marathon
https://codeforces.com/contest/1692/problem/A

题目大意：
给定 4 个整数 a,b,c,d，代表马拉松比赛 4 人 跑过的距离，求在 a 前面的人数。

模拟。
======

input
4
2 3 4 1
10000 0 1 2
500 600 400 300
0 9999 10000 9998

output
2
0
1
3
 */