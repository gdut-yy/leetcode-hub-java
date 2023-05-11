package p1811;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1811A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            String s = scanner.next();
            System.out.println(solve(n, d, s));
        }
    }

    private static String solve(int n, int d, String s) {
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) - '0' < d) {
                return s.substring(0, i) + d + s.substring(i);
            }
        }
        return s + d;
    }
}
/*
Codeforces Round 863 (Div. 3)
A. Insert Digit
https://codeforces.com/contest/1811/problem/A

题目大意：
你有一个长度为 n 的正数和一个额外的数字。
您可以在数字中的任何位置插入这个数字，包括开头或结尾。
你的任务是使结果尽可能大。
例如，您的号码是 76543，额外的数字是 4。那么你能得到的最大数字是 765443，它可以通过两种方式得到——在数字的第 3 位或第 4 位之后插入一位数字。

从左往右遍历找第一个小于这个数字的下标
======

input
11
5 4
76543
1 0
1
2 5
44
3 6
666
5 6
13579
5 8
97531
19 4
9876543210123456789
5 7
73737
8 1
20000000
7 0
7058959
12 1
828127127732
output
765443
10
544
6666
613579
987531
98765443210123456789
773737
210000000
70589590
8281271277321
 */
