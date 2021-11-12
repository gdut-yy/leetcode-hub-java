public class Solution931 {
    public int minFallingPathSum(int[][] matrix) {
        // n x n 的 方形 整数数组
        int n = matrix.length;
        // 状态定义
        // dp[i][j] 表示到 matrix[i][j] 的下降路径最小和
        int[][] dp = new int[n][n];
        // 初始状态 dp[][] 首行等于 matrix[][] 首行
        System.arraycopy(matrix[0], 0, dp[0], 0, n);
        // 状态转移
        for (int i = 1; i < n; i++) {
            int[] prev = dp[i - 1];
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(prev[j], prev[j + 1]);
                } else if (j < n - 1) {
                    dp[i][j] = Math.min(prev[j - 1], Math.min(prev[j], prev[j + 1]));
                } else {
                    dp[i][j] = Math.min(prev[j - 1], prev[j]);
                }
                dp[i][j] += matrix[i][j];
            }
        }
        int min = dp[n - 1][0];
        for (int j = 1; j < n; j++) {
            min = Math.min(min, dp[n - 1][j]);
        }
        return min;
    }
}
/*
931. 下降路径最小和
https://leetcode-cn.com/problems/minimum-falling-path-sum/

给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。

下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。

动态规划。
时间复杂度 O(n^2)
空间复杂度 O(n^2)
 */