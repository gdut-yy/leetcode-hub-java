package p1579;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1579A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String s = scanner.next();
            System.out.println(solve(s));
        }
    }

    private static String solve(String s) {
        int len = s.length();
        if (len % 2 != 0) {
            return "NO";
        }
        int cntB = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'B') {
                cntB++;
            }
        }
        return (cntB == len / 2) ? "YES" : "NO";
    }
}
/*
Codeforces Round #744 (Div. 3)
A - Casimir's String Solitaire
https://codeforces.com/contest/1579/problem/A

题目大意：
给出字符串 s。s 只包含 'A','B','C' 三种字符，每次操作可去除 1个'A'和 1个'B'，或去除 1个'B'和 1个'C'，问最后能否成为空串。

统计字符频次，判断 'B'的频次是否等于 'A','C'频次之和即可。
======

input
6
ABACAB
ABBA
AC
ABC
CABCBB
BCBCBCBCBCBCBCBC

output
NO
YES
NO
NO
YES
YES
 */