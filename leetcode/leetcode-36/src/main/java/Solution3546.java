public class Solution3546 {
    private long[][] ps2d;

    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        ps2d = new long[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ps2d[i][j] = ps2d[i - 1][j] + ps2d[i][j - 1] - ps2d[i - 1][j - 1] + grid[i - 1][j - 1];
            }
        }
        if (ps2d[m][n] % 2 != 0) return false;
        long target = ps2d[m][n] / 2;

        for (int i = 0; i < m; i++) {
            if (sumRegion(0, 0, i, n - 1) == target) return true;
        }
        for (int j = 0; j < n; j++) {
            if (sumRegion(0, 0, m - 1, j) == target) return true;
        }
        return false;
    }

    // 求 [r1,c1] 到 [r2,c2] 的累加和
    private long sumRegion(int r1, int c1, int r2, int c2) {
        return ps2d[r2 + 1][c2 + 1] - ps2d[r2 + 1][c1] - ps2d[r1][c2 + 1] + ps2d[r1][c1];
    }
}
/*
3546. 等和矩阵分割 I
https://leetcode.cn/problems/equal-sum-grid-partition-i/description/

第 449 场周赛 T2。

给你一个由正整数组成的 m x n 矩阵 grid。你的任务是判断是否可以通过 一条水平或一条垂直分割线 将矩阵分割成两部分，使得：
- 分割后形成的每个部分都是 非空 的。
- 两个部分中所有元素的和 相等 。
如果存在这样的分割，返回 true；否则，返回 false。
提示：
1 <= m == grid.length <= 10^5
1 <= n == grid[i].length <= 10^5
2 <= m * n <= 10^5
1 <= grid[i][j] <= 10^5

二维前缀和 + 枚举。
时间复杂度 O(mn)。
相似题目: 3548. 等和矩阵分割 II
https://leetcode.cn/problems/equal-sum-grid-partition-ii/description/
 */