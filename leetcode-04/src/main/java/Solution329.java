public class Solution329 {
    public int longestIncreasingPath(int[][] matrix) {
        int matrixM = matrix.length;
        int matrixN = matrix[0].length;
        int[][] lengths = new int[matrixM][matrixN];
        int longest = 0;
        for (int i = 0; i < matrixM; i++) {
            for (int j = 0; j < matrixN; j++) {
                int length = dfs(matrix, lengths, i, j);
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    private int dfs(int[][] matrix, int[][] lengths, int i, int j) {
        if (lengths[i][j] != 0) {
            return lengths[i][j];
        }
        int matrixM = matrix.length;
        int matrixN = matrix[0].length;
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int length = 1;
        for (int[] dir : direction) {
            int nextM = i + dir[0];
            int nextN = j + dir[1];
            if (nextM >= 0 && nextM < matrixM && nextN >= 0 && nextN < matrixN && matrix[nextM][nextN] > matrix[i][j]) {
                int path = dfs(matrix, lengths, nextM, nextN);
                length = Math.max(length, path + 1);
            }
        }
        lengths[i][j] = length;
        return length;
    }
}
/*
329. 矩阵中的最长递增路径
https://leetcode-cn.com/problems/longest-increasing-path-in-a-matrix/

深度优先搜索。
 */