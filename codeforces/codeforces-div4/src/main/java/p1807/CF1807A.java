package p1807;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1807A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            if (a + b == c) {
                System.out.println("+");
            } else {
                System.out.println("-");
            }
        }
    }
}
/*
Codeforces Round 859 (Div. 4)
A. Plus or Minus
https://codeforces.com/contest/1807/problem/A

题目大意：
给定三个整数 a, b 和 c，使得这两个方程中的一个是正确的。正确打印 + 否则打印 -
a+b=c
a−b=c
======

input
11
1 2 3
3 2 1
2 9 -7
3 4 7
1 1 2
1 1 0
3 3 6
9 9 18
9 9 0
1 9 -8
1 9 10
output
+
-
-
+
+
-
+
+
-
-
+
 */
