public class Solution198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }
        // dp
        // n == 1, dp[0] = nums[0]
        // n == 2, dp[1] = max(nums[0], nums[1])
        // n >  2, dp[n] = max(dp[n-1], dp[n-2] + nums[i])
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }
}
/*
198. 打家劫舍
https://leetcode-cn.com/problems/house-robber/

打家劫舍系列。动态规划。
状态转移方程：
若存在 1 家，偷窃 1 家；
若存在 2 家，偷窃较大的 1 家；
若存在 n 家，继承 n-1 家的结论或者 n-2 加上第 n 家；
 */