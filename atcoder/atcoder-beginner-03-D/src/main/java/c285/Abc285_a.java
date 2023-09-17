package c285;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc285_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(solve(a, b));
    }

    private static String solve(int a, int b) {
        if (a / 2 == b || b / 2 == a) {
            return "Yes";
        }
        return "No";
    }
}
/*
A - Edge Checker 2
https://atcoder.jp/contests/abc285/tasks/abc285_a

题目大意：
判断是否存在直接连接下图中 a 和 b 点的线段。
1≤a<b≤15

二叉树 left = i*2, right = i*2+1
======

Input 1
1 2
Output 1
Yes

Input 2
2 8
Output 2
No

Input 3
14 15
Output 3
No
 */