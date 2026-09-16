import java.util.Arrays;

public class Solution4046 {
    private final static int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // 左右上下
    private int[][] grid;
    private int m, n;
    private int[][][][] memo;

    public int minCost(int[][] grid, int k0) {
        m = grid.length;
        n = grid[0].length;
        this.grid = grid;
        memo = new int[k0 + 1][m][n][4];
        for (int[][][] a : memo) {
            for (int[][] b : a) {
                for (int[] c : b) {
                    Arrays.fill(c, -1); // -1 表示该状态没有计算过
                }
            }
        }

        int ans = Math.min(dfs(k0, m - 1, n - 1, 0), dfs(k0, m - 1, n - 1, 2));
        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }

    private int dfs(int k, int i, int j, int idx) {
        if (i == 0 && j == 0) return grid[0][0];
        int[] p = memo[k][i][j];
        if (p[idx] != -1) return p[idx];

        int res = Integer.MAX_VALUE / 2;
        for (int newIdx = 0; newIdx < 4; newIdx++) {
            int x = i + DIRS[newIdx][0];
            int y = j + DIRS[newIdx][1];
            if (0 <= x && x < m && 0 <= y && y < n) {
                int newK = k;
                if (newIdx != idx) {
                    if (k == 0) {
                        continue;
                    }
                    newK--;
                }
                res = Math.min(res, dfs(newK, x, y, newIdx));
            }
        }
        res += grid[i][j];
        return p[idx] = res;
    }
}
/*
4046. 至多 K 次转向的最小路径代价
https://leetcode.cn/problems/minimum-cost-path-with-at-most-k-turns/description/

第 518 场周赛 T4。

给你一个大小为 m x n 的二维整数数组 grid，其中 grid[i][j] 表示访问单元格 (i, j) 的代价，另给你一个整数 k。
你从 左上角 单元格 (0, 0) 出发，目标是到达 右下角 单元格 (m - 1, n - 1)。
在每个单元格中，你可以向四个方向之一移动一步：上、下、左 或 右。
路径的代价是所访问的所有单元格的值之和，包括 起始单元格和目标单元格。如果一个单元格被多次访问，其值每次被访问时都会计入。
返回在 至多 进行 k 次转向的情况下，到达 (m - 1, n - 1) 的 最小 可能路径代价。如果不存在这样的路径，返回 -1。
当两次连续移动之间的方向发生改变时，就发生了一次 转向 。例如，先向右移动再向下移动算作一次转向，而连续向右移动则不算转向。
提示：
1 <= m == grid.length <= 75
1 <= n == grid[i].length <= 75
0 <= grid[i][j] <= 1000
0 <= k < min(m, n)

记忆化搜索。
https://leetcode.cn/problems/minimum-cost-path-with-at-most-k-turns/solutions/4023616/liang-chong-fang-fa-dijkstra-dong-tai-gu-ozqt/
 */