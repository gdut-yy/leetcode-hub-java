public class Solution3989 {
    public int maxConsistentColumns(int[][] grid, int limit) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        int ans = 1;

        for (int j = 0; j < n; j++) {
            dp[j] = 1;
            for (int k = 0; k < j; k++) {
                boolean valid = true;
                for (int[] ints : grid) {
                    if (Math.abs(ints[j] - ints[k]) > limit) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    dp[j] = Math.max(dp[j], dp[k] + 1);
                }
            }
            ans = Math.max(ans, dp[j]);
        }
        return ans;
    }
}
/*
3989. 网格中保持一致的最大列数
https://leetcode.cn/problems/maximum-consistent-columns-in-a-grid/description/

第 510 场周赛 T4。

给你一个大小为 m x n 的二维整数数组 grid，和一个整数 limit。
你可以从网格中移除零个或多个列，但必须至少保留一列。剩余列的 相对 顺序必须保持不变。
如果对于每一行 i，以及每一对相邻的剩余列 a 和 b（其中 a < b），都满足 |grid[i][b] - grid[i][a]| <= limit，则称该网格是 一致的。
返回网格成为 一致的 所能保留的 最大 列数。
提示：
1 <= m == grid.length <= 250
1 <= n == grid[i].length <= 250
-10^5 <= grid[i][j] <= 10^5
0 <= limit <= 10^5

相邻相关型 DP + 优化。
 */