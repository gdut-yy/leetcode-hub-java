public class SolutionO47 {
    public int maxValue(int[][] grid) {
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
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[gridM - 1][gridN - 1];
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