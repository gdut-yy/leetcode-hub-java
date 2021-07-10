import java.util.Arrays;

public class Solution213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        int[] arr1 = Arrays.copyOfRange(nums, 0, len - 1);
        int[] arr2 = Arrays.copyOfRange(nums, 1, len);
        return Math.max(rob1(arr1, arr1.length), rob1(arr2, arr2.length));
    }

    public int rob1(int[] nums, int len) {
        int[] dp = new int[len];
        if (len == 1) {
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }
}
/*
213. 打家劫舍 II
https://leetcode-cn.com/problems/house-robber-ii/

打家劫舍系列。难度升级，围成一个圈，即首尾不能同时偷。
有一种取巧的办法：沿用 198 题的解法，取 [0, n-1] 与 [1, n] 二者中的最大值。
 */