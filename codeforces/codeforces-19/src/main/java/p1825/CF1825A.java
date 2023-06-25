package p1825;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1825A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            String s = scanner.next();
            System.out.println(solve(s));
        }
    }

    private static String solve(String s) {
        int n = s.length();
        if (isPal(s.substring(1))) {
            return "-1";
        }
        return String.valueOf(n - 1);
    }

    private static boolean isPal(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
/*
Codeforces Round 872 (Div. 2) https://www.bilibili.com/video/BV1th4y1b7uw/
A. LuoTianyi and the Palindrome String
https://codeforces.com/contest/1825/problem/A

题目大意：
LuoTianyi 给你一个回文字符串 s，她想让你找出 s 的最长非空子序列‡的长度，它不是回文字符串。如果没有子序列，则输出 −1。
回文是一种向后读和正向读一样的字符串。例如，字符串"z"， "aaa"， "aba"， "abccba"是回文，但字符串"codeforces"， "reality"， "ab"不是回文。
如果可以通过删除 b 中的几个字符(可能为零或全部)从 b 中获得 A，则字符串 A 是字符串 b 的子序列。例如，字符串“a”，“aaa”，“bab”是字符串“abaab”的子序列，但字符串“codeforces”，“bbb”，“h”不是。
---
给定回文串 s
求最长非回文子序列的长度是多少？

脑筋急转弯
======

input
4
abacaba
aaa
codeforcesecrofedoc
lol
output
6
-1
18
2
 */
