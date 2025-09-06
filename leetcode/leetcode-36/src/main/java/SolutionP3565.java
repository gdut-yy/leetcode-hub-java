import java.util.ArrayList;
import java.util.List;

public class SolutionP3565 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int[][] grid;
    private int m, n;
    private boolean[][] vis;
    private List<List<Integer>> ans;

    public List<List<Integer>> findPath(int[][] grid, int k) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        vis = new boolean[m][n];
        ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0, 1)) {
                    return ans;
                }
            }
        }
        return new ArrayList<>();
    }

    private boolean dfs(int row, int col, int visCnt, int target) {
        if (row < 0 || row >= m || col < 0 || col >= n || vis[row][col]
                || (grid[row][col] != 0 && grid[row][col] != target)) {
            return false;
        }
        if (grid[row][col] == target) {
            target++;
        }
        vis[row][col] = true;
        ans.add(List.of(row, col));
        visCnt++;
        if (visCnt == m * n) {
            return true;
        }
        for (int[] d : DIRECTIONS) {
            if (dfs(row + d[0], col + d[1], visCnt, target)) {
                return true;
            }
        }
        vis[row][col] = false;
        ans.removeLast();
        return false;
    }
}
/*
$3565. 顺序网格路径覆盖
https://leetcode.cn/problems/sequential-grid-path-cover/description/

给定一个 m x n 大小的 2 维数组 grid，和一个整数 k。grid 中有 k 个单元格包含从 1 到 k 的值，每个值恰好出现一次，其余单元格的值为 0。
你可以从任何单元格开始，并且从一个单元格移动到相邻的单元格（上，下，左，右）。你必须找到一条 grid 中的路径，满足：
- 访问 grid 中的每个单元格 恰好一次。
- 按顺序 访问值为 1 到 k 的单元格。
返回一个大小为 (m * n) 的二维数组 result，其中 result[i] = [xi, yi] 表示路径中访问的第 i 个单元格。如果存在多条这样的路径，你可以返回 任何 一条。
如果不存在这样的路径，返回一个 空 数组。
提示：
1 <= m == grid.length <= 5
1 <= n == grid[i].length <= 5
1 <= k <= m * n
0 <= grid[i][j] <= k
grid 包含 1 到 k 的所有整数 恰好 一次。

回溯。
https://leetcode.cn/problems/sequential-grid-path-cover/solutions/3690857/3565-shun-xu-wang-ge-lu-jing-fu-gai-by-s-c50l/
时间复杂度: O(mn * 3^mn)。
 */