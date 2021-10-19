public class Solution79 {
    public boolean exist(char[][] board, String word) {
        int M = board.length;
        int N = board[0].length;
        boolean[][] visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (dfs(board, word, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int curM, int curN, int idx) {
        if (board[curM][curN] != word.charAt(idx)) {
            return false;
        } else if (idx == word.length() - 1) {
            return true;
        }
        visited[curM][curN] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : directions) {
            int nextM = curM + dir[0];
            int nextN = curN + dir[1];
            if (nextM >= 0 && nextM < board.length && nextN >= 0 && nextN < board[0].length) {
                if (!visited[nextM][nextN]) {
                    if (dfs(board, word, visited, nextM, nextN, idx + 1)) {
                        visited[curM][curN] = false;
                        return true;
                    }
                }
            }
        }
        visited[curM][curN] = false;
        return false;
    }
}
/*
79. 单词搜索
https://leetcode-cn.com/problems/word-search/

给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

深度优先搜索。
 */
