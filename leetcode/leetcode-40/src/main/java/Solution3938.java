public class Solution3938 {
    public int maxScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = Integer.MIN_VALUE;

        // 单独计算子数组长为 1 的情况，此时子数组不能在 grid 的边界上
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                ans = Math.max(ans, grid[i][j]);
            }
        }

        // 每行的最大子数组和（子数组长度 >= 2）
        for (int[] row : grid) {
            ans = Math.max(ans, maxSubArray(row));
        }

        // 每列的最大子数组和（子数组长度 >= 2）
        int[] col = new int[m];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                col[i] = grid[i][j];
            }
            ans = Math.max(ans, maxSubArray(col));
        }

        return ans;
    }

    // 53. 最大子数组和（子数组长度 >= 2）
    private int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE; // 注意答案可以是负数，不能初始化成 0
        int f = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            ans = Math.max(ans, f + x); // f+x 保证子数组至少有两个数
            f = Math.max(f, 0) + x;
        }
        return ans;
    }
}
/*
3938. 矩阵中最大共享路径和
https://leetcode.cn/problems/maximum-path-intersection-sum-in-a-grid/description/

第 183 场双周赛 T3。

给你一个 m x n 的整数矩阵 grid 。
两个玩家在矩阵中移动：
- 玩家 1 从左上角单元格 (0, 0) 出发，只能向右或向下移动。他们的目的地是右下角单元格 (m - 1, n - 1) 。
- 玩家 2 从左下角单元格 (m - 1, 0) 出发，只能向右或向上移动。他们的目的地是右上角单元格 (0, n - 1) 。
每个玩家必须选择一条从各自起始单元格到目的地的有效路径。
如果一个单元格属于 两条 被选中的路径，则称该单元格为 共享 单元格。
返回一个整数，表示所有 共享 单元格的值的 最大 可能总和。
提示：
m == grid.length
n == grid[i].length
2 <= m, n <= 1000
4 <= m * n <= 5 * 10^5
-100 <= grid[i][j] <= 100

最大子数组和。
 */