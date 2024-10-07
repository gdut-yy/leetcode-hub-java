public class SolutionLCR129 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private char[][] board;
    private String word;
    private int m, n;
    private boolean[][] vis;

    public boolean wordPuzzle(char[][] grid, String target) {
        this.board = grid;
        this.word = target;
        m = grid.length;
        n = grid[0].length;

        vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int idx) {
        if (board[x][y] != word.charAt(idx)) {
            return false;
        } else if (idx == word.length() - 1) {
            return true;
        }
        vis[x][y] = true;
        for (int[] d : DIRECTIONS) {
            int nx = x + d[0];
            int ny = y + d[1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                if (!vis[nx][ny]) {
                    if (dfs(nx, ny, idx + 1)) {
                        vis[x][y] = false;
                        return true;
                    }
                }
            }
        }
        vis[x][y] = false;
        return false;
    }
}
/*
剑指 Offer 12. 矩阵中的路径
https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof/

给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

同: 79. 单词搜索
https://leetcode.cn/problems/word-search/
 */