package p1676;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1676B {
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
        for (int i = 0; i < n; i++) {
            min = Math.min(min, a[i]);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i] - min;
        }
        return String.valueOf(sum);
    }
}
/*
B. Equal Candies
https://codeforces.com/contest/1676/problem/B

题目大意：
给定长度为 n 的数组 a，问最少吃掉多少糖果，使得所有 a[i] 均相等。

求出数组 a 最小值，计算每个 a[i] 与最小值的差，求和即可。
======

input
5
5
1 2 3 4 5
6
1000 1000 5 1000 1000 1000
10
1 2 3 5 1 2 7 9 13 5
3
8 8 8
1
10000000

output
10
4975
38
0
0
 */