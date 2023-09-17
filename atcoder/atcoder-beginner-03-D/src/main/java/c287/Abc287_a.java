package c287;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc287_a {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = scanner.next();
        }
        System.out.println(solve(n, s));
    }

    private static String solve(int n, String[] s) {
        int cntFor = 0;
        int cntAgainst = 0;
        for (String s1 : s) {
            if (s1.equals("For")) {
                cntFor++;
            } else {
                cntAgainst++;
            }
        }
        return cntFor > cntAgainst ? "Yes" : "No";
    }
}
/*
A - Majority
https://atcoder.jp/contests/abc287/tasks/abc287_a

题目大意：
有 N 个人。他们每个人都同意或不同意一个提议。这里 N 是奇数。
第 i (i=1,2，…，N)个人的意见用字符串 Si 表示:如果 Si = 赞成，这个人同意，如果 Si = 反对，这个人不同意。
确定大多数人是否同意这个提议。

计数。
======

Input 1
3
For
Against
For
Output 1
Yes

Input 2
5
Against
Against
For
Against
For
Output 2
No

Input 3
1
For
Output 3
Yes
 */