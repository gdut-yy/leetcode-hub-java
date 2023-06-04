package c291;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc291_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.next();
        System.out.println(solve(s));
    }

    private static String solve(String s) {
        for (int i = 1; i <= s.length(); i++) {
            char ch = s.charAt(i - 1);
            if (Character.isUpperCase(ch)) {
                return String.valueOf(i);
            }
        }
        return "-1";
    }
}
/*
A - camel Case
https://atcoder.jp/contests/abc291/tasks/abc291_a

题目大意：
给你一个由大写和小写英文字母组成的字符串 S。
这里，S 中只有一个字符是大写的，其他字符都是小写的。
求整数 x，使 S 的第 x 个字符为大写。
在这里，S 的初始字符被认为是第 1 个字符。

遍历。
======

Input 1
aBc
Output 1
2

Input 2
xxxxxxXxxx
Output 2
7

Input 3
Zz
Output 3
1
 */