package p1624;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1624A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    private static String solve(int n, int[] a) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, a[i]);
            max = Math.max(max, a[i]);
        }
        return String.valueOf(max - min);
    }
}
/*
Codeforces Round #764 (Div. 3)
A. Plus One on the Subset
https://codeforces.com/contest/1624/problem/A

题目大意：
给出整数 n 和长度为 n 的数组 a，每次可以选取一些下标 +1，求使数组 a 所有元素相等的最小操作数。

最小操作数等于 最小值 与 最大值 的差值。
======

input
3
6
3 4 2 4 1 2
3
1000 1002 998
2
12 11

output
3
4
1
 */