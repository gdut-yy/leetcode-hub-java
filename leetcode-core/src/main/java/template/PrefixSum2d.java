package template;

/**
 * 二维前缀和/二维差分
 */
public class PrefixSum2d {
    private final int M;
    private final int N;
    private final int[][] preSum2d;
    private final int[][] diff2d;

    public PrefixSum2d(int[][] matrix) {
        this.M = matrix.length;
        this.N = matrix[0].length;
        // 预处理前缀和
        preSum2d = new int[M + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                // 当前格 = 上 + 左 - 左上 + 原值
                preSum2d[i][j] = preSum2d[i - 1][j] + preSum2d[i][j - 1] - preSum2d[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
        // 差分 init
        diff2d = new int[M + 1][N + 1];
    }

    /**
     * 二维前缀和：求 matrix [row1,col1] 到 [row2,col2] 的累加和
     */
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum2d[row2 + 1][col2 + 1] - preSum2d[row2 + 1][col1] - preSum2d[row1][col2 + 1] + preSum2d[row1][col1];
    }

    /**
     * 二维差分：matrix [row1,col1] 到 [row2,col2] 全部增加 inc
     */
    public void rangeAdd(int row1, int col1, int row2, int col2, int inc) {
        diff2d[row1][col1] += inc;
        diff2d[row1][col2 + 1] -= inc;
        diff2d[row2 + 1][col1] -= inc;
        diff2d[row2 + 1][col2 + 1] += inc;
    }

    /**
     * 二维差分：获取原数组
     */
    public int[][] originalArray() {
        int[][] res = new int[M][N];
        // 0 行
        res[0][0] = diff2d[0][0];
        for (int j = 1; j < N; j++) {
            res[0][j] = res[0][j - 1] + diff2d[0][j];
        }
        // 0 列
        for (int i = 1; i < M; i++) {
            res[i][0] = res[i - 1][0] + diff2d[i][0];
        }
        // 1 行 1 列。。。
        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1] - res[i - 1][j - 1] + diff2d[i][j];
            }
        }
        return res;
    }
}