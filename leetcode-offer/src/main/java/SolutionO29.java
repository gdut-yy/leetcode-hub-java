public class SolutionO29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{};
        }
        int M = matrix.length;
        int N = matrix[0].length;
        int[] res = new int[M * N];
        int idx = 0;
        int left = 0;
        int up = 0;
        int right = N - 1;
        int down = M - 1;
        while (left <= right && up <= down) {
            // 左到右
            for (int j = left; j <= right; j++) {
                res[idx] = matrix[up][j];
                idx++;
            }
            // 上到下
            for (int i = up + 1; i <= down; i++) {
                res[idx] = matrix[i][right];
                idx++;
            }
            if (left < right && up < down) {
                // 右到左
                for (int j = right - 1; j > left; j--) {
                    res[idx] = matrix[down][j];
                    idx++;
                }
                // 下到上
                for (int i = down; i > up; i--) {
                    res[idx] = matrix[i][left];
                    idx++;
                }
            }
            left++;
            right--;
            up++;
            down--;
        }
        return res;
    }
}
/*
剑指 Offer 29. 顺时针打印矩阵
https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/

输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

相似题目: 54. 螺旋矩阵
https://leetcode-cn.com/problems/spiral-matrix/
注意返回类型差异。
 */