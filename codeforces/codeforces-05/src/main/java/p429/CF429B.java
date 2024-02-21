package p429;

import java.util.Scanner;

public class CF429B {
    static int n, m;
    static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n + 2][m + 2];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve());
    }

    static final int MAX_N = 1000;

    private static String solve() {
        int[][] dp1 = new int[MAX_N + 2][MAX_N + 2];
        int[][] dp2 = new int[MAX_N + 2][MAX_N + 2];
        int[][] dp3 = new int[MAX_N + 2][MAX_N + 2];
        int[][] dp4 = new int[MAX_N + 2][MAX_N + 2];

        // A 从起点到相遇点
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp1[i][j] = a[i][j] + Math.max(dp1[i - 1][j], dp1[i][j - 1]);
            }
        }
        // A 从终点到相遇点
        for (int i = n; i >= 1; i--) {
            for (int j = m; j >= 1; j--) {
                dp2[i][j] = a[i][j] + Math.max(dp2[i + 1][j], dp2[i][j + 1]);
            }
        }
        // B 从起点到相遇点
        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= m; j++) {
                dp3[i][j] = a[i][j] + Math.max(dp3[i + 1][j], dp3[i][j - 1]);
            }
        }
        // B 从终点到相遇点
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                dp4[i][j] = a[i][j] + Math.max(dp4[i - 1][j], dp4[i][j + 1]);
            }
        }

        int ans = 0;
        for (int i = 2; i < n; i++) {
            for (int j = 2; j < m; j++) {
                int r1 = dp1[i][j - 1] + dp2[i][j + 1] + dp3[i + 1][j] + dp4[i - 1][j];
                int r2 = dp1[i - 1][j] + dp2[i + 1][j] + dp3[i][j - 1] + dp4[i][j + 1];
                ans = Math.max(ans, Math.max(r1, r2));
            }
        }
        return String.valueOf(ans);
    }
}
/*
B. Working out
https://codeforces.com/contest/429/problem/B

灵茶の试炼 2022-05-13
题目大意：
给你一个网格图，长宽均不超过 1000，每个格子有一个分数 0<=a[i][j]<=1e5。
有两个人 A 和 B：
A 从左上角出发到右下角，每次只能向下或向右；
B 从左下角出发到右上角，每次只能向上或向右。
两人所走的路径必须恰好只在一个格子相交。注意是路径相交，两人不一定要相遇。
求去掉这个相交的格子后，其余在路径上的格子的分数之和的最大值。

rating 1600
https://codeforces.com/contest/429/submission/120031024
计算 4 个 DP：
A 从起点到 (i,j) 的最大得分
A 从终点到 (i,j) 的最大得分
B 从起点到 (i,j) 的最大得分
B 从终点到 (i,j) 的最大得分
由于只有一个交点，那么在相交位置，要么是 A 从上往下，B 从左往右，要么是 A 从左往右，B 从下往上。
枚举所有交点和这两种相交方式，取最大值作为答案。
注意交点不可能是网格图的边界。
======

input
3 3
100 100 100
100 1 100
100 100 100
output
800
 */
