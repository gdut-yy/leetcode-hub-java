public class Solution4084 {
    public int[] lastVisitedCell(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int x = 0, y = 0;
        while (true) {
            int nx = x, ny = y;
            switch (grid[x][y]) {
                case 'U' -> nx--;
                case 'D' -> nx++;
                case 'L' -> ny--;
                default -> ny++;
            }
            if (nx < 0 || nx == m || ny < 0 || ny == n || grid[nx][ny] == 0) {
                return new int[]{x, y};
            }
            grid[x][y] = 0; // 访问标记
            x = nx;
            y = ny;
        }
    }
}
/*
4084. 有向网格中的最后访问单元格
https://leetcode.cn/problems/last-visited-cell-in-a-directional-grid/description/

第 524 场周赛 T2。

给你一个 m x n 的矩阵 grid，其中每个单元格包含以下字符之一：
- 'L'：向左移动一格。
- 'R'：向右移动一格。
- 'U'：向上移动一格。
- 'D'：向下移动一格。
你从单元格 (0, 0) 出发，并将其视为已访问。每一步都按照当前单元格中的字符指示，移动到对应的单元格。
如果下一步移动会离开网格，或者进入一个已经访问过的单元格，则移动过程 结束 。在这两种情况下，该次移动都 不会 执行。
返回一个整数数组 [r, c]，表示 最后一个访问的单元格 的 行下标和列下标 。下标从 0 开始。
示例 1：
输入： grid = [["R","D"],["U","L"]]
输出： [1,0]
示例 2：
输入： grid = [["R","R","R"]]
输出： [0,2]
提示：
1 <= m == grid.length <= 10^5
1 <= n == grid[i].length <= 10^5
m * n <= 10^5
grid[i][j] 为 'L'、'R'、'U' 或 'D' 之一。

模拟。
时间复杂度 O(mn)。
 */