package c281;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc281_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int K = scanner.nextInt();
        int d = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(n, K, d, a));
    }

    private static String solve(int n, int k, int d, int[] a) {
        // f[i][j][k] 表示 A[0, i] 取 j 个数 % D 为 k 的最大和
        long[][][] f = new long[n + 1][k + 1][d];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                Arrays.fill(f[i][j], -1L);
            }
        }
        f[0][0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k + 1; j++) {
                for (int _k = 0; _k < d; _k++) {
                    if (f[i][j][_k] == -1) {
                        continue;
                    }
                    f[i + 1][j][_k] = Math.max(f[i + 1][j][_k], f[i][j][_k]);

                    // transition when a_i is chosen
                    if (j != k) {
                        f[i + 1][j + 1][(_k + a[i]) % d] = Math.max(f[i + 1][j + 1][(_k + a[i]) % d], f[i][j][_k] + a[i]);
                    }
                }
            }
        }
        return String.valueOf(f[n][k][0]);
    }
}
/*
D - Max Multiple
https://atcoder.jp/contests/abc281/tasks/abc281_d

灵茶の试炼 2025-02-11
题目大意：
给定一个非负整数序列 a =(a 1,a 2，…，a N)。
设 S 为非负整数的集合，它可以是 A 中 K 项的和(有不同的指标)。
找出 S 中 D 的最大倍数。如果 S 中没有 D 的倍数，则打印-1。

求能整除 D 的最大子序列和，长度为 K。
动态规划。
======

Input 1
4 2 2
1 2 3 4
Output 1
6

Input 2
3 1 2
1 3 5
Output 2
-1
 */