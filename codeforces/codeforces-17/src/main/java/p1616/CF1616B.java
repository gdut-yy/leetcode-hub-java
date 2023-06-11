package p1616;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1616B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            String s = scanner.next();
            System.out.println(solve(n, s));
        }
    }

    private static String solve(int n, String s) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(s.charAt(0));
        for (int i = 1; i < n; i++) {
            // 特判
            if (s.charAt(0) == s.charAt(1)) {
                break;
            }
            if (s.charAt(i - 1) >= s.charAt(i)) {
                stringBuilder.append(s.charAt(i));
            } else {
                break;
            }
        }
        String left = stringBuilder.toString();
        String right = stringBuilder.reverse().toString();
        return left + right;
    }
}
/*
B. Mirror in the String
https://codeforces.com/contest/1616/problem/B

题目大意：
给出字符串 s，从左往右看，在第 i 个字母后放置一面镜子，求看到的字符串中字典序最小的字符串。

如 s="codeforces"，镜像字符串有 "cc", "cooc", "coddoc", ... 显然 cc 字典序最小
贪心。字符的值不能大于前一位字符的值
注意陷阱：
cbb => "cbbbbc" not "cbbc"
ccc => "cc"
======

input
4
10
codeforces
9
cbacbacba
3
aaa
4
bbaa

output
cc
cbaabc
aa
bb
 */
