package p1722;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1722A {
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
        char[] pattern = "Timur".toCharArray();
        char[] chars = s.toCharArray();
        Arrays.sort(pattern);
        Arrays.sort(chars);
        return Arrays.equals(pattern, chars) ? "YES" : "NO";
    }
}
/*
Codeforces Round #817 (Div. 4)
A. Spell Check
https://codeforces.com/contest/1722/problem/A

题目大意：
给定整数 n 和长度为 n 的字符串 s，判断 s 是否为 Timur 的一个排列。

模拟。排序后判等即可。
======

input
10
5
Timur
5
miurT
5
Trumi
5
mriTu
5
timur
4
Timr
6
Timuur
10
codeforces
10
TimurTimur
5
TIMUR

output
YES
YES
YES
YES
NO
NO
NO
NO
NO
NO
 */