package c292;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc292_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.next();
        System.out.println(s.toUpperCase());
    }
}
/*
A - CAPS LOCK
https://atcoder.jp/contests/abc292/tasks/abc292_a

题目大意：
给你一个由小写英文字母组成的字符串 S。
将 S 的每个字符大写，并打印结果字符串 T。

库函数。
======

Input 1
abc
Output 1
ABC

Input 2
a
Output 2
A

Input 3
abcdefghjiklnmoqprstvuwxyz
Output 3
ABCDEFGHJIKLNMOQPRSTVUWXYZ
 */