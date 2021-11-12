package template;

/**
 * 前缀和（二维）
 */
public class PrefixSum2d {
    private final int[][] preSum2d;

    public PrefixSum2d(int[][] matrix) {
        preSum2d = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < matrix.length + 1; i++) {
            for (int j = 1; j < matrix[0].length + 1; j++) {
                preSum2d[i][j] = preSum2d[i - 1][j] + preSum2d[i][j - 1] - preSum2d[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    /**
     * 求 [row1,col1] 到 [row2,col2] 的累加和
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum2d[row2 + 1][col2 + 1] - preSum2d[row2 + 1][col1] - preSum2d[row1][col2 + 1] + preSum2d[row1][col1];
    }
}
