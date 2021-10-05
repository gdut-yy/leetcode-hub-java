public class Solution487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int left = 0;
        int leftSum = 0;
        int rightSum = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            rightSum += 1 - nums[right];
            while (leftSum < rightSum - 1) {
                leftSum += 1 - nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
/*
$487. 最大连续1的个数 II
https://leetcode-cn.com/problems/max-consecutive-ones-ii/

给定一个二进制数组，你可以最多将 1 个 0 翻转为 1，找出其中最大连续 1 的个数。
 */