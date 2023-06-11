package p1675;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1675B {
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
        int cnt = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (a[i + 1] == 0) {
                return "-1";
            }
            while (a[i] >= a[i + 1]) {
                a[i] /= 2;
                cnt++;
            }
            if (a[i] == 0 && i != 0) {
                return "-1";
            }
        }
        return String.valueOf(cnt);
    }
}
/*
B. Make It Increasing
https://codeforces.com/contest/1675/problem/B

题目大意：
给定长度为 n 的数组 a，规定一次操作可以使任意数 /2（向下取整），求最小操作次数使数组严格递增，若无法实现，输出 -1。

贪心，从后往前遍历，要使操作次数最少，则越往后的数应越大。当出现 0 时且非 a0 时，返回 -1
======

input
7
3
3 6 5
4
5 3 2 1
5
1 2 3 4 5
1
1000000000
4
2 8 7 5
5
8 26 5 21 10
2
5 14

output
2
-1
0
0
4
11
0
 */