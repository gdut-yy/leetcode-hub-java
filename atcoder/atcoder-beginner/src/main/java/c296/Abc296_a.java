package c296;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc296_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        String s = scanner.next();
        System.out.println(solve(n, s));
    }

    private static String solve(int n, String s) {
        if (s.contains("MM") || s.contains("FF")) {
            return "No";
        }
        return "Yes";
    }
}
/*
A - Alternately
https://atcoder.jp/contests/abc296/tasks/abc296_a

题目大意：
有一排 N 个人。它们由长度为 n 的字符串 S 来描述，如果 S 的第 i 个字符是 M，那么从前面开始的第 i 个人就是男性，如果是 F，那么就是女性。
判断男女是否交替。
据说，当且仅当没有两个男人或两个女人相邻的位置时，男人和女人是交替的。

库函数
======

Input
6
MFMFMF
Output
Yes

Input
9
FMFMMFMFM
Output
No

Input
1
F
Output
Yes
 */