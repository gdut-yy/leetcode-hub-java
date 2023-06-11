package p1790;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1790A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            String n = scanner.next();
            System.out.println(solve(n));
        }
    }

    private static String solve(String n) {
        String T = "314159265358979323846264338327";
        int i = 0;
        for (; i < n.length(); i++) {
            if (n.charAt(i) != T.charAt(i)) {
                return String.valueOf(i);
            }
        }
        return String.valueOf(i);
    }
}
/*
Codeforces Round #847 (Div. 3)
A. Polycarp and the Day of Pi
https://codeforces.com/contest/1790/problem/A

题目大意：
给定字符串 n。计算 n 是圆周率的前多少个字母

模拟。
======

input
9
000
3
4141592653
141592653589793238462643383279
31420
31415
314159265358
27182
314159265358979323846264338327

output
0
1
0
0
3
5
12
0
30
 */