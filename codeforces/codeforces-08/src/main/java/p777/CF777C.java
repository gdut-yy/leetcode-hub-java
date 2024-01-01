package p777;

import java.util.Scanner;

public class CF777C {
    static int n, m;
    static int[][] a;
    static int k;
    static int[][] lr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        k = scanner.nextInt();
        lr = new int[k][2];
        for (int i = 0; i < k; i++) {
            lr[i][0] = scanner.nextInt();
            lr[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] minL = new int[n];
        int[] up = new int[m];
        for (int i = 0; i < n; i++) {
            minL[i] = i;
            for (int j = 0; j < m; j++) {
                if (i > 0 && a[i][j] < a[i - 1][j]) {
                    up[j] = i;
                }
                minL[i] = Math.min(minL[i], up[j]);
            }
        }

        String[] ans = new String[k];
        for (int i = 0; i < k; i++) {
            int l = lr[i][0], r = lr[i][1];
            ans[i] = (minL[r - 1] <= l - 1) ? "Yes" : "No";
        }
        return String.join(System.lineSeparator(), ans);
    }
}
/*
C. Alyona and Spreadsheet
https://codeforces.com/contest/777/problem/C

灵茶の试炼 2023-11-01
题目大意：
输入 n m(1≤n*m≤1e5) 和 n 行 m 列的矩阵 a，元素范围 [1,1e9]。
然后输入 k(1≤k≤1e5) 和 k 个询问，每个询问输入两个数 L R(1≤L≤R≤n)。
对于每个询问，请判断在第 L 行到第 R 行中，是否存在一列，元素值从上到下是递增的（允许相等），输出 Yes 或 No。
进阶：把询问范围缩小至子矩形，即第 L 行到第 R 行并且只考虑第 p 列到第 q 列。@tdzl2003

提示 1：对于一个固定的 R，能输出 Yes 的最小 L 是多少？
提示 2：定义 up[i][j] 表示第 j 列中，从第 up[i][j] 行到第 i 行，是递增的。
如果 a[i-1][j] <= a[i][j]，那么 up[i][j] = up[i-1][j]，否则 up[i][j] = i。
那么提示 1 要计算的最小 L，即为 min(up[R])，可以记在数组 minL 中。
对于每个询问，只要 minL[R] <= L，则输出 Yes，否则输出 No。
代码实现时，up 数组的第一个维度可以去掉。
https://codeforces.com/problemset/submission/777/230012309
======

input
5 4
1 2 3 5
3 1 3 2
4 5 2 3
5 5 3 2
4 4 3 4
6
1 1
2 5
4 5
3 5
1 3
1 5
output
Yes
No
Yes
Yes
Yes
No
 */
