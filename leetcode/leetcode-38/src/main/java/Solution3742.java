import java.util.Arrays;

public class Solution3742 {
    public int maxPathScore(int[][] grid, int K) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] f = new int[m + 1][n + 1][K + 2];
        for (int[][] mat : f) {
            for (int[] row : mat) {
                Arrays.fill(row, Integer.MIN_VALUE);
            }
        }
        Arrays.fill(f[0][1], 1, K + 2, 0);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = grid[i][j];
                for (int k = 0; k <= K; k++) {
                    int newK = x > 0 ? k - 1 : k;
                    f[i + 1][j + 1][k + 1] = Math.max(f[i][j + 1][newK + 1], f[i + 1][j][newK + 1]) + x;
                }
            }
        }

        int ans = f[m][n][K + 1];
        return ans < 0 ? -1 : ans;
    }
}
/*
3742. 网格中得分最大的路径
https://leetcode.cn/problems/maximum-path-score-in-a-grid/description/

第 475 场周赛 T3。

给你一个 m x n 的网格 grid，其中每个单元格包含以下值之一：0、1 或 2。另给你一个整数 k。
你从左上角 (0, 0) 出发，目标是到达右下角 (m - 1, n - 1)，只能向 右 或 下 移动。
每个单元格根据其值对路径有以下贡献：
- 值为 0 的单元格：分数增加 0，花费 0。
- 值为 1 的单元格：分数增加 1，花费 1。
- 值为 2 的单元格：分数增加 2，花费 1。
返回在总花费不超过 k 的情况下可以获得的 最大分数 ，如果不存在有效路径，则返回 -1。
注意： 如果到达最后一个单元格时总花费超过 k，则该路径无效。
提示：
1 <= m, n <= 200
0 <= k <= 10^3
grid[0][0] == 0
0 <= grid[i][j] <= 2

网格图 DP + 优化循环次数
https://leetcode.cn/problems/maximum-path-score-in-a-grid/solutions/3827073/wang-ge-tu-dppythonjavacgo-by-endlessche-myez/
 */