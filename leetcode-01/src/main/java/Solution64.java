public class Solution64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int gridM = grid.length;
        int gridN = grid[0].length;
        int[][] dp = new int[gridM][gridN];
        dp[0][0] = grid[0][0];
        // 注意先后顺序
        // 往下移
        for (int i = 1; i < gridM; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // 往右移
        for (int i = 1; i < gridN; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        // dp
        for (int i = 1; i < gridM; i++) {
            for (int j = 1; j < gridN; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[gridM - 1][gridN - 1];
    }
}
/*
64. 最小路径和
https://leetcode-cn.com/problems/minimum-path-sum/

给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
每次只能向下或者向右移动一步。

动态规划。
定义 dp[i][j] 为 i x j 矩阵中，路径上的数字总和为最小的值。
 */