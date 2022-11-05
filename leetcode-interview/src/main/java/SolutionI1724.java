import java.util.Arrays;

public class SolutionI1724 {
    public int[] getMaxMatrix(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;

        int[] res = new int[4];
        int r1 = 0;
        int c1 = 0;
        int maxSum = Integer.MIN_VALUE;

        int[] b = new int[M];
        // 上边界
        for (int i = 0; i < N; i++) {
            Arrays.fill(b, 0);
            // 下边界
            for (int j = i; j < N; j++) {
                int sum = 0;
                // 一维数组
                for (int k = 0; k < M; k++) {
                    b[k] += matrix[j][k];
                    if (sum > 0) {
                        sum += b[k];
                    } else {
                        sum = b[k];
                        r1 = i;
                        c1 = k;
                    }
                    if (sum > maxSum) {
                        maxSum = sum;
                        res = new int[]{r1, c1, j, k};
                    }
                }
            }
        }
        return res;
    }
}
/*
面试题 17.24. 最大子矩阵
https://leetcode.cn/problems/max-submatrix-lcci/

给定一个正整数、负整数和 0 组成的 N × M 矩阵，编写代码找出元素总和最大的子矩阵。
返回一个数组 [r1, c1, r2, c2]，其中 r1, c1 分别代表子矩阵左上角的行号和列号，r2, c2 分别代表右下角的行号和列号。若有多个满足条件的子矩阵，返回任意一个均可。
注意：本题相对书上原题稍作改动
示例：
输入：
[
   [-1,0],
   [0,-1]
]
输出：[0,1,0,1]
解释：输入中标粗的元素即为输出所表示的矩阵
说明：
1 <= matrix.length, matrix[0].length <= 200

动态规划
相似题目: 53. 最大子数组和
https://leetcode.cn/problems/maximum-subarray/
 */