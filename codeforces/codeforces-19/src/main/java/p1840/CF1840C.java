package p1840;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1840C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int q = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve(n, k, q, a));
        }
    }

    private static String solve(int n, int k, int q, int[] a) {
        int cnt = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] <= q) {
                cnt++;
            } else {
                if (cnt >= k) {
                    int a1 = 1, an = cnt - k + 1;
                    ans += (long) (a1 + an) * an / 2;
                }
                cnt = 0;
            }
        }
        if (cnt >= k) {
            int a1 = 1, an = cnt - k + 1;
            ans += (long) (a1 + an) * an / 2;
        }
        return String.valueOf(ans);
    }
}
/*
C. Ski Resort
https://codeforces.com/contest/1840/problem/C

题目大意：
Dima Vatrushin 是学校的一名数学老师。由于工作出色，他被派去休假十天。迪马一直梦想着去滑雪胜地，所以他想连续拨出几天去滑雪。由于假期需要精心准备，他至少只会去 k 天。
给定一个数组 a，其中包含度假胜地的天气预报。也就是说，在第 i 天，温度将是 ai 度。
迪马出生在西伯利亚，所以他只有在整个假期温度不超过 q 度的情况下才能去度假。
不幸的是，迪马太专注于抽象代数，以至于忘记了如何数数。他让你帮他数一数选择度假日期的方法。

连续区间长度，等差数列求和。
======

input
7
3 1 15
-5 0 -10
5 3 -33
8 12 9 0 5
4 3 12
12 12 10 15
4 1 -5
0 -1 2 5
5 5 0
3 -1 4 -5 -3
1 1 5
5
6 1 3
0 3 -2 5 -4 -4
output
6
0
1
0
0
1
9
 */
