package p1674;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1674A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(solve(x, y));
        }
    }

    private static String solve(int x, int y) {
        // y = x * b^a
        for (int a = 1; a <= 100; a++) {
            for (int b = 1; b <= 100; b++) {
                int pow = (int) (x * Math.pow(b, a));
                if (pow == y) {
                    return a + " " + b;
                } else if (pow > y) {
                    break;
                }
            }
        }
        return "0 0";
    }
}
/*
Codeforces Round #786 (Div. 3)
A. Number Transformation
https://codeforces.com/contest/1674/problem/A

题目大意：
给定正整数 x 和 y，求是否存在 a,b 使得 y = x * b^a，若存在，输出任意 a,b，若不存在，输出两次整数 0。

(1≤x,y≤100) 直接暴力枚举即可。
======

input
3
3 75
100 100
42 13

output
2 5
3 1
0 0
 */