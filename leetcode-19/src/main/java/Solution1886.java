import java.util.Arrays;

public class Solution1886 {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int i = 0; i < 4; i++) {
            if (Arrays.deepEquals(mat, target)) {
                return true;
            }
            // 旋转最多执行 3 次
            rotate(mat);
        }
        return false;
    }

    private void rotate(int[][] matrix) {
        int len = matrix.length;
        // 上下翻转
        for (int i = 0; i < len / 2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[len - 1 - i];
            matrix[len - 1 - i] = tmp;
        }
        // 对角线翻转
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
}
/*
1886. 判断矩阵经轮转后是否一致
https://leetcode-cn.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/

矩阵旋转 90 度。参考 Solution48.java
 */
