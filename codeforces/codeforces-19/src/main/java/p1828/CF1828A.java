package p1828;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1828A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            System.out.println(solve(n));
        }
    }

    private static String solve(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = (i + 1) * 2;
        }
        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }
}
/*
Codeforces Round 873 (Div. 2) https://www.bilibili.com/video/BV1Gh4y18751/
A. Divisible Array
https://codeforces.com/contest/1828/problem/A

题目大意：
给你一个正整数 n。请找到一个数组 a1,a2,...,an 是完美的。（1≤n≤200）
一个完美数组 a1,a2,...,an 满足以下条件:
对于所有 1≤i≤n, 1≤ai≤1000。
对于所有 1≤i≤n, Ai 能被 i 整除。
a1+a2+...+an 能被 n 整除。

等差数列求和 n(n+1)/2
每个数翻倍即可。
======

input
7
1
2
3
4
5
6
7
output
1
2 4
1 2 3
2 8 6 4
3 4 9 4 5
1 10 18 8 5 36
3 6 21 24 10 6 14
 */
