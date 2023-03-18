package p1695;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1695C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = scanner.nextInt();
                }
            }
            System.out.println(solve(n, m, a));
        }
    }

    private static String solve(int n, int m, int[][] a) {
        if (((n + m) & 1) == 0) {
            return "NO";
        }

        // f[i][j] 表示到达 grid[i][j] 矩阵的最小路径和
        // g[i][j] 表示到达 grid[i][j] 矩阵的最大路径和
        int[][] f = new int[n][m];
        int[][] g = new int[n][m];

        // 初始状态 第一行 + 第一列
        f[0][0] = a[0][0];
        g[0][0] = a[0][0];
        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + a[i][0];
            g[i][0] = g[i - 1][0] + a[i][0];
        }
        for (int j = 1; j < m; j++) {
            f[0][j] = f[0][j - 1] + a[0][j];
            g[0][j] = g[0][j - 1] + a[0][j];
        }

        // 状态转移
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + a[i][j];
                g[i][j] = Math.max(g[i - 1][j], g[i][j - 1]) + a[i][j];
            }
        }

        if (f[n - 1][m - 1] > 0 || g[n - 1][m - 1] < 0) {
            return "NO";
        }
        return "YES";
    }
}
/*
C. Zero Path
https://codeforces.com/contest/1695/problem/C

灵茶の试炼 2023-02-06
题目大意：
输入 t(≤1e4) 表示 t 组数据，每组数据输入 n(≤1e3) m(≤1e3) 和一个 n 行 m 列的矩阵，元素值只有 -1 和 1。所有数据的 n*m 之和不超过 1e6。
你从矩阵左上出发，走到右下，每步只能向下或者向右。
路径上的元素和能否为 0？输出 YES 或 NO。

https://codeforces.com/contest/1695/submission/192354976
提示 1：交换路径中的相邻两步，比如向右向下变成向下向右，路径和会发生什么变化？
路径和会 +0/+2/-2。
因此，如果 n+m 是偶数，路径和必然为奇数，无法变成 0。此时可以直接输出 NO。
如果 n+m 是奇数，路径和必然为偶数，然后要怎么判断？
提示 2：求出最小路径和以及最大路径和，如果一个 <=0，一个 >=0，根据提示 1，可以通过交换，变成 0。
是不是有点双周赛求轮廓的味道了？
相似题目: 64. 最小路径和
https://leetcode.cn/problems/minimum-path-sum/
2556. 二进制矩阵中翻转最多一次使路径不连通
https://leetcode.cn/problems/disconnect-path-in-a-binary-matrix-by-at-most-one-flip/
======

input
5
1 1
1
1 2
1 -1
1 4
1 -1 1 -1
3 4
1 -1 -1 -1
-1 1 1 -1
1 1 1 -1
3 4
1 -1 1 1
-1 1 -1 1
1 -1 1 1
output
NO
YES
YES
YES
NO
 */
