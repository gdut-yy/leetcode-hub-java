package c304;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc304_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        System.out.println(solve(n));
    }

    private static String solve(int n) {
        char[] cs = String.valueOf(n).toCharArray();
        for (int i = 3; i < cs.length; i++) {
            cs[i] = '0';
        }
        return new String(cs);
    }
}
/*
B - Subscribers
https://atcoder.jp/contests/abc304/tasks/abc304_b

题目大意：
给你一个整数 N。
根据下面的说明打印 N 的近似值。
If N is less than or equal to 10^3 −1, print N as it is.
If N is between 10^3 and 10^4 −1, inclusive, truncate the ones digit of N and print the result.
If N is between 10^4 and 10^5 −1, inclusive, truncate the tens digit and all digits below it of N and print the result.
If N is between 10^5 and 10^6 −1, inclusive, truncate the hundreds digit and all digits below it of N and print the result.
If N is between 10^6 and 10^7 −1, inclusive, truncate the thousands digit and all digits below it of N and print the result.
If N is between 10^7 and 10^8 −1, inclusive, truncate the ten-thousands digit and all digits below it of N and print the result.
If N is between 10^8 and 10^9 −1, inclusive, truncate the hundred-thousands digit and all digits below it of N and print the result.

最多保留前 3 个字符，后面的抹零。
======

Input 1
20230603
Output 1
20200000

Input 2
0
Output 2
0

Input 3
304
Output 3
304

Input 4
500600
Output 4
500000
 */