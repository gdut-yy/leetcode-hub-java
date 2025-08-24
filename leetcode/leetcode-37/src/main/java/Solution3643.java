public class Solution3643 {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = grid[i][j];
            }
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                ans[i + x][j + y] = grid[k - 1 - i + x][j + y];
            }
        }
        return ans;
    }
}
/*
3643. 垂直翻转子矩阵
https://leetcode.cn/problems/flip-square-submatrix-vertically/description/

第 462 场周赛 T1。

给你一个 m x n 的整数矩阵 grid，以及三个整数 x、y 和 k。
整数 x 和 y 表示一个 正方形子矩阵 的左上角下标，整数 k 表示该正方形子矩阵的边长。
你的任务是垂直翻转子矩阵的行顺序。
返回更新后的矩阵。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 50
1 <= grid[i][j] <= 100
0 <= x < m
0 <= y < n
1 <= k <= min(m - x, n - y)

模拟。加上偏移量即可。
时间复杂度 O(mn)。
 */