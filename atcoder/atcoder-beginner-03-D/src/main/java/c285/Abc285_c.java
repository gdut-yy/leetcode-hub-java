package c285;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc285_c {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        String s = scanner.next();
        System.out.println(solve(s));
    }

    private static String solve(String s) {
        int n = s.length();
        long ans = 0L;
        long a = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans += (s.charAt(i) - 'A' + 1) * a;
            a *= 26;
        }
        return String.valueOf(ans);
    }
}
/*
C - abc285_brutmhyhiizp
https://atcoder.jp/contests/abc285/tasks/abc285_c

题目大意：
在平行宇宙中，AtCoder 举办了 AtCoder 大竞赛，其中一次给出了 10 - 16 个问题。题目编号如下，从第 1 题开始依次为:A, B,...,Z, AA, AB,..,ZZ, AAA,...
换句话说，id 按以下顺序给出:
- 长度为 1 的由大写英文字母组成的字符串，按字典顺序排列;
- 长度为 2 的由大写英文字母组成的字符串，按字典顺序排列;
- 长度为 3 的由大写英文字母组成的字符串，按字典顺序排列;
- ...
给定一个字符串 S，它是本次竞赛中给定问题的 ID，找出该问题的索引。(请参见示例。)
======

Input 1
AB
Output 1
28

Input 2
C
Output 2
3

Input 3
BRUTMHYHIIZP
Output 3
10000000000000000
 */