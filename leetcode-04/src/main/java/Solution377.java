public class Solution377 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
/*
377. 组合总和 Ⅳ
https://leetcode.cn/problems/combination-sum-iv/

动态规划。完全背包。
参考第 322 题 https://leetcode.cn/problems/coin-change/
f(i) 表示和为 i 的排列的数目
当 nums[j] <= i 时，f(i) = ∑f(i-nums[j])
 */