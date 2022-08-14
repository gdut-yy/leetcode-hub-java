public class Solution329 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int M;
    private int N;

    public int longestIncreasingPath(int[][] matrix) {
        this.M = matrix.length;
        this.N = matrix[0].length;

        int[][] lengths = new int[M][N];
        int longest = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
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

        int length = 1;
        for (int[] dir : DIRECTIONS) {
            int nextM = i + dir[0];
            int nextN = j + dir[1];
            if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N && matrix[nextM][nextN] > matrix[i][j]) {
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
https://leetcode.cn/problems/longest-increasing-path-in-a-matrix/

给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 200
0 <= matrix[i][j] <= 2^31 - 1

记忆化搜索
时间复杂度 O(mn)
 */