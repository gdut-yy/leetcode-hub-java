public class Solution3603 {
    public long minCost(int m, int n, int[][] waitCost) {
        long[][] grid = new long[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    grid[i][j] = 1;
                } else if (i == m - 1 && j == n - 1) {
                    grid[i][j] = (long) (i + 1) * (j + 1);
                } else {
                    grid[i][j] = (long) (i + 1) * (j + 1) + waitCost[i][j];
                }
            }
        }

        long[][] f = new long[m][n];
        f[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            f[0][j] = f[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }
        return f[m - 1][n - 1];
    }
}
/*
3603. 交替方向的最小路径代价 II
https://leetcode.cn/problems/minimum-cost-path-with-alternating-directions-ii/description/

第 160 场双周赛 T2。

给你两个整数 m 和 n，分别表示网格的行数和列数。
进入单元格 (i, j) 的成本定义为 (i + 1) * (j + 1)。
另外给你一个二维整数数组 waitCost，其中 waitCost[i][j] 定义了在该单元格 等待 的成本。
你从第 1 秒开始在单元格 (0, 0)。
每一步，你都遵循交替模式：
- 在 奇数秒 ，你必须向 右 或向 下 移动到 相邻 的单元格，并支付其进入成本。
- 在 偶数秒 ，你必须原地 等待 ，并支付 waitCost[i][j]。
返回到达 (m - 1, n - 1) 所需的 最小 总成本。
提示：
1 <= m, n <= 10^5
2 <= m * n <= 10^5
waitCost.length == m
waitCost[0].length == n
0 <= waitCost[i][j] <= 10^5

动态规划。
时间复杂度 O(mn)。
相似题目: 64. 最小路径和
https://leetcode.cn/problems/minimum-path-sum/
 */