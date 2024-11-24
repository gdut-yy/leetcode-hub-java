package p213;

import java.util.Arrays;
import java.util.Scanner;

public class CF213C {
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

    static final int INF = (int) 1e9;

    private static String solve() {
        int[][] f = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(f[i], -INF);
        }
        f[1][1] = a[0][0];
        for (int s = 1; s < n * 2 - 1; s++) {
            for (int j = Math.min(n - 1, s); j >= Math.max(s - n + 1, 0); j--) {
                for (int k = Math.min(n - 1, s); k >= j; k--) {
                    f[j + 1][k + 1] = max(f[j + 1][k + 1], f[j][k + 1], f[j + 1][k], f[j][k]) + a[s - j][j];
                    if (k != j) {
                        f[j + 1][k + 1] += a[s - k][k];
                    }
                }
            }
        }
        return String.valueOf(f[n][n]);
    }

//    static int max(int... a) {
//        return Arrays.stream(a).max().orElseThrow();
//    }

    static int max(int a, int b, int c, int d) {
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }
}
/*
C. Relay Race
https://codeforces.com/contest/213/problem/C

灵茶の试炼 2024-05-02
题目大意：
输入 n(1≤n≤300) 和 n 行 n 列的网格图，元素范围 [-1000,1000]。
你从网格图的左上角出发，每一步只能向右或向下走到相邻的单元格，走到右下角。
然后再从右下角出发，每一步只能向左或向上走到相邻的单元格，走到左上角。
访问到的格子的数字之和最大是多少？重复访问的格子只能统计一次。
双倍经验：
741. 摘樱桃

rating 2000
转换成两个人从左上出发，到达右下角，访问到的数字之和（重复访问的只统计一次）。
先考虑一个四维 DP。
f[x1][y1][x2][y2] 表示两人分别在 (x1,y1) 和 (x2,y2) 时的数字之和的最大值。
枚举两人的前一个位置，来计算 f[x1][y1][x2][y2]。
四维 DP 是超时/超内存的，并且只有当两人同时出发时，才方便计算重复访问的情况。如果不同时出发，就不知道哪些格子另一个人访问过了。
在同时出发的情况下，知道时间和列坐标，就可以求出行坐标，因为行坐标+列坐标=时间（坐标从 0 开始）。
所以有如下三维 DP：
f[t][j][k] 表示当前时刻是 t，两个人的列坐标分别是 j 和 k 时的数字之和的最大值。
枚举两人的前一个位置来计算，即
f[t-1][j-1][k-1]  // 都往右
f[t-1][j-1][k]    // 一个人往右，另一个人往下
f[t-1][j][k-1]    // 一个人往下，另一个人往右
f[t-1][j][k]      // 都往下
取 max，加上两个人的格子上的数字，如果两个人在同一个坐标就只算一次。
代码实现时，第一个维度可以压缩掉。类似 01 背包，j 和 k 需要倒序枚举。
https://codeforces.com/contest/213/submission/258830614
======

Input
1
5
Output
5

Input
2
11 14
16 12
Output
53

Input
3
25 16 25
12 18 19
11 13 8
Output
136
 */
