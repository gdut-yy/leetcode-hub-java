import java.util.Arrays;

public class Solution3651 {
    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int maxVal = 10000;
        int[][][] best = new int[k + 1][m][n];
        for (int t = 0; t <= k; t++) {
            for (int i = 0; i < m; i++) {
                Arrays.fill(best[t][i], Integer.MAX_VALUE);
            }
        }
        best[0][0][0] = 0;

        for (int t = 0; t <= k; t++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (best[t][i][j] == Integer.MAX_VALUE)
                        continue;
                    if (j + 1 < n) {
                        int newCost = best[t][i][j] + grid[i][j + 1];
                        if (newCost < best[t][i][j + 1]) {
                            best[t][i][j + 1] = newCost;
                        }
                    }
                    if (i + 1 < m) {
                        int newCost = best[t][i][j] + grid[i + 1][j];
                        if (newCost < best[t][i + 1][j]) {
                            best[t][i + 1][j] = newCost;
                        }
                    }
                }
            }

            int[] minCostForValue = new int[maxVal + 1];
            Arrays.fill(minCostForValue, Integer.MAX_VALUE);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (best[t][i][j] != Integer.MAX_VALUE) {
                        int val = grid[i][j];
                        if (best[t][i][j] < minCostForValue[val]) {
                            minCostForValue[val] = best[t][i][j];
                        }
                    }
                }
            }

            int[] minSuffix = new int[maxVal + 1];
            minSuffix[maxVal] = minCostForValue[maxVal];
            for (int v = maxVal - 1; v >= 0; v--) {
                if (minCostForValue[v] < minSuffix[v + 1]) {
                    minSuffix[v] = minCostForValue[v];
                } else {
                    minSuffix[v] = minSuffix[v + 1];
                }
            }

            if (t < k) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        int val = grid[i][j];
                        if (minSuffix[val] < best[t + 1][i][j]) {
                            best[t + 1][i][j] = minSuffix[val];
                        }
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int t = 0; t <= k; t++) {
            if (best[t][m - 1][n - 1] < ans) {
                ans = best[t][m - 1][n - 1];
            }
        }
        return ans;
    }
}
/*
3651. 带传送的最小路径成本
https://leetcode.cn/problems/minimum-cost-path-with-teleportations/description/

第 163 场双周赛 T4。

给你一个 m x n 的二维整数数组 grid 和一个整数 k。你从左上角的单元格 (0, 0) 出发，目标是到达右下角的单元格 (m - 1, n - 1)。
有两种移动方式可用：
- 普通移动：你可以从当前单元格 (i, j) 向右或向下移动，即移动到 (i, j + 1)（右）或 (i + 1, j)（下）。成本为目标单元格的值。
- 传送：你可以从任意单元格 (i, j) 传送到任意满足 grid[x][y] <= grid[i][j] 的单元格 (x, y)；此移动的成本为 0。你最多可以传送 k 次。
返回从 (0, 0) 到达单元格 (m - 1, n - 1) 的 最小 总成本。
提示:
2 <= m, n <= 80
m == grid.length
n == grid[i].length
0 <= grid[i][j] <= 10^4
0 <= k <= 10

DP + 后缀最小值优化。
https://chat.deepseek.com/a/chat/s/1bf4a47a-246a-4ed2-b511-34da3bc5ff8d
时间复杂度 O((mn+U)k)。
rating 2410 (clist.by)
 */