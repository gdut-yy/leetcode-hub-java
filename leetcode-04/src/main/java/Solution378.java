public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        // 左边界二分
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(matrix, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[][] matrix, int k, int mid) {
        // 左下角开始
        int curM = matrix.length - 1;
        int curN = 0;

        int cnt = 0;
        while (curM >= 0 && curN < matrix.length) {
            if (matrix[curM][curN] <= mid) {
                cnt += curM + 1;
                curN++;
            } else {
                curM--;
            }
        }
        return cnt >= k;
    }
}
/*
378. 有序矩阵中第 K 小的元素
https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/

左边界二分。
时间复杂度 O(nlog(r-l))
时间复杂度 O(1)

类似题目: 668. 乘法表中第k小的数
https://leetcode-cn.com/problems/kth-smallest-number-in-multiplication-table/
 */