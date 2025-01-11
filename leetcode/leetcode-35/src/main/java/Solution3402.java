public class Solution3402 {
    public int minimumOperations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m; i++) {
                int v = Math.max(grid[i][j], grid[i - 1][j] + 1);
                ans += v - grid[i][j];
                grid[i][j] = v;
            }
        }
        return ans;
    }
}
/*
3402. 使每一列严格递增的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-make-columns-strictly-increasing/description/

第 430 场周赛 T1。

给你一个由 非负 整数组成的 m x n 矩阵 grid。
在一次操作中，你可以将任意元素 grid[i][j] 的值增加 1。
返回使 grid 的所有列 严格递增 所需的 最少 操作次数。
提示:
m == grid.length
n == grid[i].length
1 <= m, n <= 50
0 <= grid[i][j] < 2500

贪心。
时间复杂度 O(mn)。
 */