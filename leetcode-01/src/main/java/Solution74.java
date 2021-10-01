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

二分查找。
 */