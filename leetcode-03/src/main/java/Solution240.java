public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int M = matrix.length;
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
240. 搜索二维矩阵 II
https://leetcode-cn.com/problems/search-a-2d-matrix-ii/

编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
每行的元素从左到右升序排列。
每列的元素从上到下升序排列。

杨氏矩阵。表面上是二分，实际上没啥关系，线性查找即可。
时间复杂度 O(m+n)
空间复杂度 O(1)

同: 剑指 Offer 04. 二维数组中的查找
https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 */