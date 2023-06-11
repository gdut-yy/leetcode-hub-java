package p1626;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1626A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String s = scanner.next();
            System.out.println(solve(s));
        }
    }

    private static String solve(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
/*
Educational Codeforces Round 121 (Rated for Div. 2)
A. Equidistant Letters
https://codeforces.com/contest/1626/problem/A

题目大意：
给出字符串 s，s 中每个字母出现次数不超过 2 次，要求输出一种排列，使 s 中出现两次的字母之间的距离相同。

直接排序即可。
======

input
3
oelhl
abcdcba
ac

output
hello
ababcdc
ac
 */
