public class SolutionO47 {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // f[i][j] 表示到达 grid[i][j] 礼物的最大价值
        int[][] f = new int[m][n];

        // 初始状态 第一行 + 第一列
        f[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            f[0][j] = f[0][j - 1] + grid[0][j];
        }

        // 状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }
        return f[m - 1][n - 1];
    }
}
/*
剑指 Offer 47. 礼物的最大价值
https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof/

在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

相似题目: 64. 最小路径和
https://leetcode.cn/problems/minimum-path-sum/
注意最大和最小的区别
 */