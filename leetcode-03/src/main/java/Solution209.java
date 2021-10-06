public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        // 双指针
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < nums.length) {
            // 右指针右移
            sum += nums[right];
            right++;
            // 左指针右移
            while (sum >= target) {
                minLen = Math.min(minLen, right - left);
                sum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
/*
209. 长度最小的子数组
https://leetcode-cn.com/problems/minimum-size-subarray-sum/

给定一个含有 n 个正整数的数组和一个正整数 target 。
找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 并返回其长度。如果不存在符合条件的子数组，返回 0。

双指针 时间复杂度 O(n)
 */