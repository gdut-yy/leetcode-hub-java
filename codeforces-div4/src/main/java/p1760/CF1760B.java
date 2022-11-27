package p1760;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1760B {
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
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars[n - 1] - 'a' + 1);
    }
}
/*
B. Atilla's Favorite Problem
https://codeforces.com/contest/1760/problem/B

题目大意：
给定整数 n 和长度为 n 的字符串 s。求写这条消息所需的最小字母大小是多少。

排序后取最后一个字符。
======

input
5
1
a
4
down
10
codeforces
3
bcf
5
zzzzz

output
1
23
19
6
26
 */