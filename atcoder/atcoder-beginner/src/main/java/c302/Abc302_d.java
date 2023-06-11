package c302;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc302_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long d = scanner.nextLong();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        long[] b = new long[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextLong();
        }
        System.out.println(solve(n, m, d, a, b));
    }

    private static String solve(int n, int m, long d, long[] a, long[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int i = n - 1, j = m - 1;
        while (i >= 0 && j >= 0) {
            if (a[i] > b[j]) {
                if (a[i] - b[j] > d) {
                    i--;
                } else {
                    return String.valueOf(a[i] + b[j]);
                }
            } else {
                if (b[j] - a[i] > d) {
                    j--;
                } else {
                    return String.valueOf(a[i] + b[j]);
                }
            }
        }
        return "-1";
    }
}
/*
D - Impartial Gift
https://atcoder.jp/contests/abc302/tasks/abc302_d

题目大意：
高桥决定给青木一份礼物，给 Snuke 一份礼物。
青木有 N 个备选礼物，它们的值分别是 a1, a2,..., an。
给 Snuke 的礼物有 M 个候选，它们的值分别是 b1, b2,..., bm。
Takahashi 想要选择礼物，使两份礼物的价值差不超过 D。
确定他是否可以选择这样一副礼物。如果可以的话，打印出所选礼物的最大价值总和。

双指针。
======

Input 1
2 3 2
3 10
2 5 15
Output 1
8

Input 2
3 3 0
1 3 3
6 2 7
Output 2
-1

Input 3
1 1 1000000000000000000
1000000000000000000
1000000000000000000
Output 3
2000000000000000000

Input 4
8 6 1
2 5 6 5 2 1 7 9
7 2 5 5 2 4
Output 4
14
 */