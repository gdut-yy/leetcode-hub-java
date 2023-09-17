package c320;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc320_b {
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        s = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        int n = s.length();
        int ans = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (j - i + 1 > ans && isPal(s.substring(i, j + 1))) {
                    ans = j - i + 1;
                }
            }
        }
        return String.valueOf(ans);
    }

    private static boolean isPal(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }
}
/*
B - Longest Palindrome
https://atcoder.jp/contests/abc320/tasks/abc320_b

题目大意：
给定一个字符串 S，求 S 的一个连续子字符串的最大长度，它是一个回文。
请注意，S 总是有一个连续的子字符串，它是一个回文。

暴力
======

Input 1
TOYOTA
Output 1
5

Input 2
ABCDEFG
Output 2
1

Input 3
AAAAAAAAAA
Output 3
10
 */