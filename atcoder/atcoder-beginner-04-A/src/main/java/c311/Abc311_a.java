package c311;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc311_a {
    static int n;
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        s = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        int FULL = (1 << 3) - 1;
        int mask = 0;
        for (int i = 0; i < n; i++) {
            mask |= 1 << (s.charAt(i) - 'a');
            if (mask == FULL) {
                return String.valueOf(i + 1);
            }
        }
        return String.valueOf(n);
    }
}
/*
A - First ABC
https://atcoder.jp/contests/abc311/tasks/abc311_a

题目大意：
给定一个由 a, B 和 C 组成的字符串 S, S 保证包含所有 a, B 和 C。
如果从左边依次检查 S 的字符，当第一次满足以下条件时，检查了多少个字符?
A、B 和 C 都至少出现过一次。

枚举
======

Input 1
5
ACABB
Output 1
4

Input 2
4
CABC
Output 2
3

Input 3
30
AABABBBABABBABABCABACAABCBACCA
Output 3
17
 */