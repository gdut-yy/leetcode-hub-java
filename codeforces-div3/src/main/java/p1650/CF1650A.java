package p1650;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1650A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            String s = scanner.next();
            char c = scanner.next().charAt(0);
            System.out.println(solve(s, c));
        }
    }

    private static String solve(String s, char c) {
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == c) {
                int left = i;
                int right = len - 1 - i;
                if (left % 2 == 0 && right % 2 == 0) {
                    return "YES";
                }
            }
        }
        return "NO";
    }
}
/*
Codeforces Round #776 (Div. 3)
A. Deletions of Two Adjacent Letters
https://codeforces.com/contest/1650/problem/A

题目大意：
给定字符串 s 和字符 c，要求每次可以删除相邻的两个字母，问字符串最终能否变成 c

贪心，找出每个 c，判等其前后字符数量是否为偶数即可。
=======

input
5
abcde
c
abcde
b
x
y
aaaaaaaaaaaaaaa
a
contest
t

output
YES
NO
NO
YES
YES
 */