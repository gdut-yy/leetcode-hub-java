package p1790;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1790E {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int x = scanner.nextInt();
            System.out.println(solve(x));
        }
    }

    private static String solve(int x) {
        // a-b = x
        // a+b = 2x
        // a = 3x / 2
        long x3 = x * 3L;
        if (x3 % 2 != 0) {
            return "-1";
        } else {
            long a = x3 / 2;
            long b = a - x;
            if ((a ^ b) != x) {
                return "-1";
            }
            return a + " " + b;
        }
    }
}
/*
E. Vlad and a Pair of Numbers
https://codeforces.com/contest/1790/problem/E

题目大意：
给定整数 x。x = a ^ b = (a+b)/2

位运算性质。a ^ b 可以看作 a - b。解方程再判断即可。
======

input
6
2
5
10
6
18
36

output
3 1
-1
13 7
-1
25 11
50 22
 */