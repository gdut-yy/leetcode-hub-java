package c284;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc284_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next();
        }
        for (int i = n - 1; i >= 0; i--) {
            System.out.println(s[i]);
        }
    }
}
/*
A - Sequence of Strings
https://atcoder.jp/contests/abc284/tasks/abc284_a

题目大意：
给定 N 个字符串 s1 s2…sn，按这个顺序。
依次打印 sn, sn−1，…，s1。

倒序遍历。
======

Input 1
3
Takahashi
Aoki
Snuke
Output 1
Snuke
Aoki
Takahashi

Input 2
4
2023
Year
New
Happy
Output 2
Happy
New
Year
2023
 */