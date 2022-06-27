public class Solution801 {
    public int minSwap(int[] nums1, int[] nums2) {
        int len = nums1.length;
        // dp0[i] 表示第 i 位不交换使得两个数组均保持严格递增状态的最小交换次数
        // dp1[i] 表示第 i 位交换使得两个数组均保持严格递增状态的最小交换次数
        int[] dp0 = new int[len];
        int[] dp1 = new int[len];

        // 初始状态
        dp0[0] = 0;
        dp1[0] = 1;

        // 状态转移
        for (int i = 1; i < len; i++) {
            dp0[i] = Integer.MAX_VALUE;
            dp1[i] = Integer.MAX_VALUE;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                // 不交换
                dp0[i] = dp0[i - 1];
                // “负负得正”
                dp1[i] = dp1[i - 1] + 1;
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                dp0[i] = Math.min(dp0[i], dp1[i - 1]);
                dp1[i] = Math.min(dp1[i], dp0[i - 1] + 1);
            }
        }
        return Math.min(dp0[len - 1], dp1[len - 1]);
    }
}
/*
801. 使序列递增的最小交换次数
https://leetcode.cn/problems/minimum-swaps-to-make-sequences-increasing/

我们有两个长度相等且不为空的整型数组 A 和 B 。
我们可以交换 A[i] 和 B[i] 的元素。注意这两个元素在各自的序列中应该处于相同的位置。
在交换过一些元素之后，数组 A 和 B 都应该是严格递增的（数组严格递增的条件仅为A[0] < A[1] < A[2] < ... < A[A.length - 1]）。
给定数组 A 和 B ，请返回使得两个数组均保持严格递增状态的最小交换次数。假设给定的输入总是有效的。

动态规划
时间复杂度 O(n)
空间复杂度 O(n) 可用滚动数组优化至 O(1)
 */