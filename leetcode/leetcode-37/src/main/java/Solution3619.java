public class Solution3619 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int[][] grid;
    private int m, n;

    public int countIslands(int[][] grid, int k) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && dfs(i, j) % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private long dfs(int x, int y) {
        long res = grid[x][y];
        grid[x][y] = 0; // 标记为访问过
        for (int[] d : DIRECTIONS) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (0 <= nx && nx < m && 0 <= ny && ny < n && grid[nx][ny] > 0) {
                res += dfs(nx, ny);
            }
        }
        return res;
    }
}
/*
3619. 总价值可以被 K 整除的岛屿数目
https://leetcode.cn/problems/count-islands-with-total-value-divisible-by-k/description/

第 161 场双周赛 T2。

给你一个 m x n 的矩阵 grid 和一个正整数 k。一个 岛屿 是由 正 整数（表示陆地）组成的，并且陆地间 四周 连通（水平或垂直）。
一个岛屿的总价值是该岛屿中所有单元格的值之和。
返回总价值可以被 k 整除 的岛屿数量。
提示:
m == grid.length
n == grid[i].length
1 <= m, n <= 1000
1 <= m * n <= 10^5
0 <= grid[i][j] <= 10^6
1 <= k < = 10^6

网格图 DFS。
时间复杂度：O(mn)。
 */