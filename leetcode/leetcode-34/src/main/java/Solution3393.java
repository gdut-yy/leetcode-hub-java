public class Solution3393 {
    private static final int MOD = (int) (1e9 + 7);

    public int countPathsWithXorValue(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        // 15 xor 16 = 31
        long[][][] f = new long[m][n][17];
        f[0][0][grid[0][0]] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k0 = 0; k0 < 17; k0++) {
                    int k1 = k0 ^ grid[i][j];
                    if (k1 > 16) continue;
                    if (j - 1 >= 0) {
                        f[i][j][k1] += f[i][j - 1][k0];
                    }
                    if (i - 1 >= 0) {
                        f[i][j][k1] += f[i - 1][j][k0];
                    }
                    f[i][j][k1] %= MOD;
                }
            }
        }
        return (int) f[m - 1][n - 1][k];
    }
}
/*
3393. 统计异或值为给定值的路径数目
https://leetcode.cn/problems/count-paths-with-the-given-xor-value/description/

第 146 场双周赛 T2。

给你一个大小为 m x n 的二维整数数组 grid 和一个整数 k 。
你的任务是统计满足以下 条件 且从左上格子 (0, 0) 出发到达右下格子 (m - 1, n - 1) 的路径数目：
- 每一步你可以向右或者向下走，也就是如果格子存在的话，可以从格子 (i, j) 走到格子 (i, j + 1) 或者格子 (i + 1, j) 。
- 路径上经过的所有数字 XOR 异或值必须 等于 k 。
请你返回满足上述条件的路径总数。
由于答案可能很大，请你将答案对 10^9 + 7 取余 后返回。
提示：
1 <= m == grid.length <= 300
1 <= n == grid[r].length <= 300
0 <= grid[r][c] < 16
0 <= k < 16

动态规划。
时间复杂度 O(mnk)。
相似题目: 2435. 矩阵中和能被 K 整除的路径
https://leetcode.cn/problems/paths-in-matrix-whose-sum-is-divisible-by-k/
 */