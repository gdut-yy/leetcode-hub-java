public class Solution3548 {
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
        long tot = ps2d[m][n];

        for (int i = 0; i + 1 < m; i++) {
            long upSum = sumRegion(0, 0, i, n - 1);
            // 不挖
            if (tot % 2 == 0 && upSum == tot / 2) return true;

            // 上部挖
            long[] rm = {grid[0][0], grid[0][n - 1], grid[i][0], grid[i][n - 1]};
            for (long v : rm) {
                if ((tot - v) % 2 == 0 && upSum - v == (tot - v) / 2) return true;
            }

            // 下部挖
            rm = new long[]{grid[i + 1][0], grid[i + 1][n - 1], grid[m - 1][0], grid[m - 1][n - 1]};
            for (long v : rm) {
                if ((tot - v) % 2 == 0 && upSum == (tot - v) / 2) return true;
            }
        }
        for (int j = 0; j + 1 < n; j++) {
            // 不挖
            long leftSum = sumRegion(0, 0, m - 1, j);
            if (tot % 2 == 0 && leftSum == tot / 2) return true;

            // 左部挖
            long[] rm = new long[]{grid[0][0], grid[0][j], grid[m - 1][0], grid[m - 1][j]};
            for (long v : rm) {
                if ((tot - v) % 2 == 0 && leftSum - v == (tot - v) / 2) return true;
            }

            // 右部挖
            rm = new long[]{grid[0][j + 1], grid[0][n - 1], grid[m - 1][j + 1], grid[m - 1][n - 1]};
            for (long v : rm) {
                if ((tot - v) % 2 == 0 && leftSum == (tot - v) / 2) return true;
            }
        }
        return false;
    }

    // 求 [r1,c1] 到 [r2,c2] 的累加和
    private long sumRegion(int r1, int c1, int r2, int c2) {
        return ps2d[r2 + 1][c2 + 1] - ps2d[r2 + 1][c1] - ps2d[r1][c2 + 1] + ps2d[r1][c1];
    }
}
/*
3548. 等和矩阵分割 II
https://leetcode.cn/problems/equal-sum-grid-partition-ii/description/

第 449 场周赛 T4。

给你一个由正整数组成的 m x n 矩阵 grid。你的任务是判断是否可以通过 一条水平或一条垂直分割线 将矩阵分割成两部分，使得：
- 分割后形成的每个部分都是 非空 的。
- 两个部分中所有元素的和 相等 ，或者总共 最多移除一个单元格 （从其中一个部分中）的情况下可以使它们相等。
- 如果移除某个单元格，剩余部分必须保持 连通 。
如果存在这样的分割，返回 true；否则，返回 false。
注意： 如果一个部分中的每个单元格都可以通过向上、向下、向左或向右移动到达同一部分中的其他单元格，则认为这一部分是 连通 的。
提示：
1 <= m == grid.length <= 10^5
1 <= n == grid[i].length <= 10^5
2 <= m * n <= 10^5
1 <= grid[i][j] <= 10^5

二维前缀和 + 枚举 + 分类讨论。
时间复杂度 O(mn)。
相似题目: 3546. 等和矩阵分割 I
https://leetcode.cn/problems/equal-sum-grid-partition-i/description/
rating 2271 (clist.by)
 */