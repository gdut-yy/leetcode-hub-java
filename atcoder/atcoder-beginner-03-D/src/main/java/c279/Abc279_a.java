package c279;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc279_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.next();
        System.out.println(solve(s));
    }

    private static String solve(String s) {
        int ans = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'w') {
                ans += 2;
            } else {
                ans += 1;
            }
        }
        return String.valueOf(ans);
    }
}
/*
A - wwwvvvvvv
https://atcoder.jp/contests/abc279/tasks/abc279_a

题目大意：
给你一个由 v 和 w 组成的字符串 S。
打印字符串 S 中“底部”的数量(参见示例输入/输出中的图)。

v 算 1，w 算 2
======

Input 1
vvwvw
Output 1
7

Input 2
v
Output 2
1

Input 3
wwwvvvvvv
Output 3
12
 */