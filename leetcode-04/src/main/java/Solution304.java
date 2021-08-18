public class Solution304 {
    static class NumMatrix {
        // 定义 preSum[i-1][j-1] 为 matrix[0][0] 到 matrix[i][j] 的和
        private final int[][] preSum;

        /**
         * 给定整数矩阵 matrix 进行初始化
         *
         * @param matrix matrix
         */
        public NumMatrix(int[][] matrix) {
            int matrixM = matrix.length + 1;
            int matrixN = matrix[0].length + 1;
            preSum = new int[matrixM][matrixN];
            for (int i = 1; i < matrixM; i++) {
                for (int j = 1; j < matrixN; j++) {
                    // 重复加了一次 duplicate, 要减掉
                    int up = preSum[i - 1][j];
                    int left = preSum[i][j - 1];
                    // 重复
                    int duplicate = preSum[i - 1][j - 1];
                    preSum[i][j] = up + left - duplicate + matrix[i - 1][j - 1];
                }
            }
        }

        /**
         * 返回左上角 (row1, col1) 、右下角 (row2, col2) 的子矩阵的元素总和。
         *
         * @param row1 row1
         * @param col1 col1
         * @param row2 row2
         * @param col2 col2
         * @return 左上角 (row1, col1) 、右下角 (row2, col2) 的子矩阵的元素总和。
         */
        public int sumRegion(int row1, int col1, int row2, int col2) {
            int big = preSum[row2 + 1][col2 + 1];
            int up = preSum[row1][col2 + 1];
            int left = preSum[row2 + 1][col1];
            int duplicate = preSum[row1][col1];
            // 跟构造函数逻辑相反, 重复减了一次 duplicate，要加回来
            return big - left - up + duplicate;
        }
    }
}
/*
304. 二维区域和检索 - 矩阵不可变
https://leetcode-cn.com/problems/range-sum-query-2d-immutable/

二维空间的 “前缀和”。

raw:
[3, 0, 1, 4, 2]
[5, 6, 3, 2, 1]
[1, 2, 0, 1, 5]
[4, 1, 0, 1, 7]
[1, 0, 3, 0, 5]

preSum:
[0, 0,  0,  0,  0,  0]
[0, 3,  3,  4,  8,  10]
[0, 8,  14, 18, 24, 27]
[0, 9,  17, 21, 28, 36]
[0, 13, 22, 26, 34, 49]
[0, 14, 23, 30, 38, 58]
 */