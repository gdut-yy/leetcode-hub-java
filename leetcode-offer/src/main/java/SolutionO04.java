public class SolutionO04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int M = matrix.length;
        if (M == 0) {
            return false;
        }
        int N = matrix[0].length;
        // 矩阵左下角开始
        int curM = M - 1;
        int curN = 0;
        while (curM >= 0 && curN < N) {
            if (matrix[curM][curN] > target) {
                curM--;
            } else if (matrix[curM][curN] < target) {
                curN++;
            } else {
                return true;
            }
        }
        return false;
    }
}
/*
剑指 Offer 04. 二维数组中的查找
https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/

在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，
输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
现有矩阵 matrix 如下：
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。
给定 target = 20，返回 false。

同: 240. 搜索二维矩阵 II
https://leetcode.cn/problems/search-a-2d-matrix-ii/
 */