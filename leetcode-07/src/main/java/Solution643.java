public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int maxSum = sum;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        for (int i = 1; i <= nums.length - k; i++) {
            int newSum = sum - nums[i - 1] + nums[i - 1 + k];
            maxSum = Math.max(maxSum, newSum);
        }
        return (double) maxSum / k;
    }
}
/*
643. 子数组最大平均数 I
https://leetcode.cn/problems/maximum-average-subarray-i/

可看作固定长度为 k 的滑动窗口
 */
