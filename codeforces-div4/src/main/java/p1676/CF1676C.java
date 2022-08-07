package p1676;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1676C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            String[] s = new String[n];
            for (int j = 0; j < n; j++) {
                s[j] = scanner.next();
            }
            System.out.println(solve(n, m, s));
        }
    }

    private static String solve(int n, int m, String[] s) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                String s1 = s[i];
                String s2 = s[j];
                int sum = 0;
                for (int k = 0; k < m; k++) {
                    sum += Math.abs(s1.charAt(k) - s2.charAt(k));
                }
                min = Math.min(min, sum);
            }
        }
        return String.valueOf(min);
    }
}
/*
C. Most Similar Words
https://codeforces.com/contest/1676/problem/C

题目大意：
给定 n 个长度为 m 的字符串，求所有可能的 n 个单词对的最小差值。

暴力枚举。时间复杂度 O(n^2)
======

intput
6
2 4
best
cost
6 3
abb
zba
bef
cdu
ooo
zzz
2 7
aaabbbc
bbaezfe
3 2
ab
ab
ab
2 8
aaaaaaaa
zzzzzzzz
3 1
a
u
y

output
11
8
35
0
200
4
 */