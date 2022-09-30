public class SolutionI1009 {
    public boolean searchMatrix(int[][] matrix, int target) {
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
面试题 10.09. 排序矩阵查找
https://leetcode.cn/problems/sorted-matrix-search-lcci/

给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
示例:
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

相似题目: 240. 搜索二维矩阵 II
https://leetcode.cn/problems/search-a-2d-matrix-ii/
 */