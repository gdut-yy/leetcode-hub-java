package p1800;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1800D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            System.out.println(solve(n, s));
        }
    }

    private static String solve(int n, String s) {
        char[] cs = s.toCharArray();
        int res = 1;
        for (int i = 0; i + 2 < n; i++) {
            if (cs[i] != cs[i + 2]) {
                res++;
            }
        }
        return String.valueOf(res);
    }
}
/*
D. Remove Two Letters
https://codeforces.com/contest/1800/problem/D

题目大意：
给定整数 n 和长度为 n 的字符串 s。从字符串中删除两个连续的字符。求在这样的操作之后可以获得多少不同的字符串。

枚举每个 s[i] 与 s[i + 2] 是否相等
======

input
7
6
aaabcc
10
aaaaaaaaaa
6
abcdef
7
abacaba
6
cccfff
4
abba
5
ababa

output
4
1
5
3
3
3
1
 */