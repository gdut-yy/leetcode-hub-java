public class Solution668 {
    public int findKthNumber(int m, int n, int k) {
        // 左边界二分
        int left = 1;
        int right = m * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (!enough(m, n, k, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean enough(int m, int n, int k, int mid) {
        int cnt = 0;
        for (int i = 1; i <= m; i++) {
            cnt += Math.min(mid / i, n);
        }
        return cnt >= k;
    }
}
/*
668. 乘法表中第k小的数
https://leetcode-cn.com/problems/kth-smallest-number-in-multiplication-table/

几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？
给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。

左边界二分。
类似题目: 378. 有序矩阵中第 K 小的元素
https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */