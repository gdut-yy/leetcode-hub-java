public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int matrixM = matrix.length;
        int matrixN = matrix[0].length;
        int left = 0;
        int right = matrixM * matrixN;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int curM = mid / matrixN;
            int curN = mid % matrixN;
            // 防止越界
            if (curM >= matrixM || curN >= matrixN) {
                break;
            }
            if (matrix[curM][curN] == target) {
                return true;
            } else if (matrix[curM][curN] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
/*
74. 搜索二维矩阵
https://leetcode-cn.com/problems/search-a-2d-matrix/

编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
- 每行中的整数从左到右按升序排列。
- 每行的第一个整数大于前一行的最后一个整数。
提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-10^4 <= matrix[i][j], target <= 10^4

二分查找。
 */