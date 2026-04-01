public class Solution3882 {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][][] f = new boolean[m][n][1024];
        f[0][0][grid[0][0]] = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                int val = grid[i][j];
                // top
                if (i > 0) {
                    for (int x = 0; x < 1024; x++) {
                        if (f[i - 1][j][x]) {
                            f[i][j][x ^ val] = true;
                        }
                    }
                }
                // left
                if (j > 0) {
                    for (int x = 0; x < 1024; x++) {
                        if (f[i][j - 1][x]) {
                            f[i][j][x ^ val] = true;
                        }
                    }
                }
            }
        }
        for (int k = 0; k < 1024; k++) {
            if (f[m - 1][n - 1][k]) {
                return k;
            }
        }
        return -1;
    }
}
/*
3882. 网格图中最小异或路径
https://leetcode.cn/problems/minimum-xor-path-in-a-grid/description/

第 179 场双周赛 T3。

给你一个大小为 m * n 的二维整数数组 grid。
你从 左上角 的单元格 (0, 0) 出发，想要到达 右下角 的单元格 (m - 1, n - 1)。
在每一步中，你 可以 向右或向下 移动。
路径的 代价 定义为该路径上所有单元格（包括 起点和终点）的值的 按位异或。
返回从 (0, 0) 到 (m - 1, n - 1) 的所有有效路径中 最小 的可能异或值。
提示：
1 <= m == grid.length <= 1000
1 <= n == grid[i].length <= 1000
m * n <= 1000
0 <= grid[i][j] <= 1023

网格图 DFS。
https://chat.deepseek.com/a/chat/s/b7a99206-3494-4940-8b17-c60645667d8b
时间复杂度 O(nmU)。
 */