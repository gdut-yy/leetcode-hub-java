package c298;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc298_b {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        int[][] b = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve(n, a, b));
    }

    private static String solve(int n, int[][] a, int[][] b) {
        if (check(n, a, b)) {
            return "Yes";
        }
        for (int i = 0; i < 3; i++) {
            rotate(n, a);
            if (check(n, a, b)) {
                return "Yes";
            }
        }
        return "No";
    }

    private static boolean check(int n, int[][] a, int[][] b) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] == 1) {
                    if (b[i][j] == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void rotate(int n, int[][] matrix) {
        // 上下翻转
        for (int i = 0; i < n / 2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[n - 1 - i];
            matrix[n - 1 - i] = tmp;
        }
        // 对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
/*
B - Coloring Matrix
https://atcoder.jp/contests/abc298/tasks/abc298_b

题目大意：
给定 N × N 矩阵 A 和 B 每个元素都是 0 或 1。
令 A i,j 和 B i,j 分别表示 A 和 B 的第 i 行和第 j 列的元素。
确定是否有可能对每一对整数(i,j)旋转 A，使 B i,j =1，使 A i,j =1。
在这里，旋转 A 是执行以下操作 0 次或多次:
对于每一对(i,j)且 1≤i,j≤N 的整数，同时用 A N+1-j,i 代替 A i,j。

暴力
======

Input
3
0 1 1
1 0 0
0 1 0
1 1 0
0 0 1
1 1 1
Output
Yes

Input
2
0 0
0 0
1 1
1 1
Output
Yes

Input
5
0 0 1 1 0
1 0 0 1 0
0 0 1 0 1
0 1 0 1 0
0 1 0 0 1
1 1 0 0 1
0 1 1 1 0
0 0 1 1 1
1 0 1 0 1
1 1 0 1 0
Output
No
 */