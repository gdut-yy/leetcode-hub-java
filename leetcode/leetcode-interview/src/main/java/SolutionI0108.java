import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SolutionI0108 {
    public void setZeroes(int[][] matrix) {
        Set<Integer> iSet = new HashSet<>();
        Set<Integer> jSet = new HashSet<>();

        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    iSet.add(i);
                    jSet.add(j);
                }
            }
        }
        for (int i : iSet) {
            Arrays.fill(matrix[i], 0);
        }
        for (int j : jSet) {
            for (int i = 0; i < m; i++) {
                matrix[i][j] = 0;
            }
        }
    }
}
/*
面试题 01.08. 零矩阵
https://leetcode.cn/problems/zero-matrix-lcci/

编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。

先统计所有 0 的坐标，再更新矩阵。
 */