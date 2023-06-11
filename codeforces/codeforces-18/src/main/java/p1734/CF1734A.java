package p1734;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF1734A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        Arrays.sort(a);
        int ans = Integer.MAX_VALUE;
        for (int i = 2; i < n; i++) {
            ans = Math.min(ans, a[i] - a[i - 2]);
        }
        return String.valueOf(ans);
    }
}
/*
https://www.bilibili.com/video/BV1zY4y1N7rS/

Codeforces Round 822 (Div. 2)
A. Select Three Sticks
https://codeforces.com/contest/1734/problem/A

题目大意：
给定 n 根长度为 a1 a2,...,an 的正积分棒。
您可以执行以下操作任意次数(可能为零):
- 选择一根木棍，然后将其长度增加或减少 1。每次操作后，所有棍棒的长度应为正。
你必须执行的最小操作次数是多少才能使你有可能从 n 根木棍中选择 3 根并且在不折断的情况下使用它们形成一个等边三角形?
等边三角形是指它的三条边长度相等的三角形。

遍历。
======

input
4
3
1 2 3
4
7 3 7 3
5
3 4 2 1 1
8
3 1 4 1 5 9 2 6
output
2
4
1
1
 */
