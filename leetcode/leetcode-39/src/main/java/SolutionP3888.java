public class SolutionP3888 {
    static final long UNKNOWN = Long.MIN_VALUE;

    public long minOperations(int[][] grid, int k) {
        int mx = Integer.MIN_VALUE;
        for (int[] row : grid) {
            for (int num : row) {
                mx = Math.max(mx, num);
            }
        }
        int m = grid.length, n = grid[0].length;
        // 1-based 前缀和数组
        long[][] psOne = new long[m + 1][n + 1];
        long[][] psGrid = new long[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                psOne[i][j] =
                        get(psOne, i - k, j)
                                + get(psOne, i, j - k)
                                - get(psOne, i - k, j - k)
                                + 1;

                psGrid[i][j] =
                        get(psGrid, i - k, j)
                                + get(psGrid, i, j - k)
                                - get(psGrid, i - k, j - k)
                                + grid[i - 1][j - 1];
            }
        }

        int rowBound = m - k, colBound = n - k;
        long targetMin = mx, targetMax = Long.MAX_VALUE, target = UNKNOWN;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 用 sumRegion 查询单点，等价于原来的普通差分
                long oneValue = sumRegion(psOne, i, j, i, j);
                long gridValue = sumRegion(psGrid, i, j, i, j);

                if (i <= rowBound && j <= colBound) {
                    if (oneValue > 0) {
                        targetMin = Math.max(targetMin, (gridValue - 1) / oneValue + 1);
                    } else if (oneValue < 0) {
                        targetMax = Math.min(targetMax, Math.floorDiv(gridValue, oneValue));
                    } else if (gridValue > 0) {
                        return -1;
                    }

                    if (targetMin > targetMax) {
                        return -1;
                    }
                } else {
                    if (oneValue != 0) {
                        if (gridValue % oneValue != 0) {
                            return -1;
                        }

                        long targetCurr = gridValue / oneValue;
                        if (target == UNKNOWN) {
                            target = targetCurr;
                            if (target < targetMin || target > targetMax) {
                                return -1;
                            }
                        } else if (target != targetCurr) {
                            return -1;
                        }
                    } else if (gridValue != 0) {
                        return -1;
                    }
                }
            }
        }
        if (target == UNKNOWN) {
            target = targetMin;
        }
        return target * psOne[m][n] - psGrid[m][n];
    }

    // 步长 k 前缀和取值辅助：越界返回 0
    private long get(long[][] ps, int r, int c) {
        return r >= 1 && c >= 1 ? ps[r][c] : 0;
    }

    // 标准二维前缀和区域查询模板
    private long sumRegion(long[][] ps2d, int x1, int y1, int x2, int y2) {
        return ps2d[x2 + 1][y2 + 1] - ps2d[x2 + 1][y1] - ps2d[x1][y2 + 1] + ps2d[x1][y1];
    }
}
/*
$3888. 使所有网格元素相等的最小操作次数
https://leetcode.cn/problems/minimum-operations-to-make-all-grid-elements-equal/description/

给定一个大小为 m × n 的 2 维整数数组 grid，和一个整数 k。
在一次操作中，你可以：
- 选择 grid 任意 k x k 的 子矩阵，并且
- 将该子矩阵中的所有元素加 1。
返回使网格中所有元素相等所需的最少操作次数。如果不可能，请返回 -1。
一个子矩阵 (x1, y1, x2, y2) 是由所有满足 x1 <= x <= x2 且 y1 <= y <= y2 的矩阵元素 matrix[x][y] 组成的矩阵。
示例 1：
输入：grid = [[3,3,5],[3,3,5]], k = 2
输出：2
示例 2：
输入：grid = [[1,2],[2,3]], k = 1
输出：4
提示：
1 <= m == grid.length <= 1000
1 <= n == grid[i].length <= 1000
-10^5 <= grid[i][j] <= 10^5
1 <= k <= min(m, n)
 */