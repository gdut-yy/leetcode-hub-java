package p1676;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1676D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] a = new int[n][m];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    a[j][k] = scanner.nextInt();
                }
            }
            System.out.println(solve(n, m, a));
        }
    }

    private static String solve(int n, int m, int[][] a) {
        long max = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                long sum = a[i][j];
                for (int k = 1; ; k++) {
                    if (i + k < n && j + k < m) {
                        sum += a[i + k][j + k];
                    } else {
                        break;
                    }
                }
                for (int k = 1; ; k++) {
                    if (i + k < n && j - k >= 0) {
                        sum += a[i + k][j - k];
                    } else {
                        break;
                    }
                }
                for (int k = 1; ; k++) {
                    if (i - k >= 0 && j - k >= 0) {
                        sum += a[i - k][j - k];
                    } else {
                        break;
                    }
                }
                for (int k = 1; ; k++) {
                    if (i - k >= 0 && j + k < m) {
                        sum += a[i - k][j + k];
                    } else {
                        break;
                    }
                }
                max = Math.max(max, sum);
            }
        }
        return String.valueOf(max);
    }
}
/*
D. X-Sum
https://codeforces.com/contest/1676/problem/D

题目大意：
给定 n * m 的棋盘，求所有可能位置的最大和（主对角线 + 副对角线）

暴力枚举。时间复杂度 O(n*m*(m+n))
======

input
4
4 4
1 2 2 1
2 4 2 4
2 2 3 1
2 4 2 4
2 1
1
0
3 3
1 1 1
1 1 1
1 1 1
3 3
0 1 1
1 0 1
1 1 0

output
20
1
5
3
 */