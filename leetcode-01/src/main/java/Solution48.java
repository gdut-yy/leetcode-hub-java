public class Solution48 {
    public void rotate(int[][] matrix) {
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
48. 旋转图像
https://leetcode-cn.com/problems/rotate-image/submissions/

模板题。矩阵顺时针翻转 90 度
现实生活中，可以拿一个类似矩形的物体进行模拟。事实上，不一定要上下翻转（左右翻转亦可）
 */