package p1765;

import java.util.Scanner;

public class CF1765K {
    static int n;
    static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve());
    }

    private static String solve() {
        long s = 0;
        int mn = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s += a[i][j];
                if (j == n - 1 - i) {
                    mn = Math.min(mn, a[i][j]);
                }
            }
        }
        return String.valueOf(s - mn);
    }
}
/*
K. Torus Path
https://codeforces.com/contest/1765/problem/K

灵茶の试炼 2024-08-27
题目大意：
输入 n(2≤n≤200) 和 n 行 n 列的矩阵，元素范围 [0,1e9]。
你从左上角出发，要到达右下角。
你只能向右/向下走。
如果你走到最右一列，再向右走，可以回到同行的第一列。
如果你走到最下一排，再向下走，可以回到同列的第一排。
你不能访问之前走过的格子。
输出路径上的元素和的最大值。
进阶：如果输入的不是方形矩阵呢？

rating 1500
手玩可以发现，我们几乎可以访问所有格子，除了副对角线上的一个格子。
1. 如果副对角线上的所有格子都能访问，那么一开始必须向右走到底再向下向右走（或者向下走到底再向右向下走）。
如此不断循环，必然无法走到终点。可以自己动手画一画。
2. 如果副对角线上的一个格子不能访问，将其当作障碍物，把上述过程再画一画，可以发现能到终点，且除了障碍物的所有格子都能访问到。
答案为所有元素之和减去副对角线的最小值。
代码 https://codeforces.com/contest/1765/submission/277846241
======

Input
2
1 2
3 4
Output
8
Input
3
10 10 10
10 0 10
10 10 10
Output
80
 */
