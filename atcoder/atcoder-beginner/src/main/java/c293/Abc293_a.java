package c293;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc293_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.next();
        System.out.println(solve(s));
    }

    private static String solve(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i * 2 + 1 < n; i++) {
            char tmp = cs[i * 2];
            cs[i * 2] = cs[i * 2 + 1];
            cs[i * 2 + 1] = tmp;
        }
        return new String(cs);
    }
}
/*
A - Swap Odd and Even
https://atcoder.jp/contests/abc293/tasks/abc293_a

题目大意：
给定一个由小写英文字母组成的长度为偶数的字符串 S。设 |S| 是 S 的长度，Si 是 S 的第 i 个字符。
依次对每个 i=1,2,...,|s|/2 执行以下操作，并输出最后的 S。
交换 s[2i−1] 和 s[2i]。

模拟。
======

Input 1
abcdef
Output 1
badcfe

Input 2
aaaa
Output 2
aaaa

Input 3
atcoderbeginnercontest
Output 3
taocedbrgeniencrnoetts
 */