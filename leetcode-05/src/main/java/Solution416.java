public class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        return subsetSum(nums, sum / 2);
    }

    private boolean subsetSum(int[] nums, int target) {
        int len = nums.length;
        boolean[][] dp = new boolean[len + 1][target + 1];
        for (int i = 0; i <= len; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];
                if (!dp[i][j] && j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[len][target];
    }
}
/*
416. 分割等和子集
https://leetcode-cn.com/problems/partition-equal-subset-sum/

给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
提示：
1 <= nums.length <= 200
1 <= nums[i] <= 100

经典 NP 完全问题。
动态规划。01背包。
f(i,j) 表示能否从前 i 个物品中选择若干物品放满容量为 j 的背包。
如果总共有 n 个物品，背包的容量为 t，那么 f(n,t) 就是问题的解。
状态转移：
对于每件物品有两种选择，即选择与不选择
如果能从前 i-1 个物品 中选择若干物品放满容量为 j-nums[i-1] 的背包。若 f(i-1,j-nums[i-1]) == true 则 f(i,j) = true
如果能从前 i-1 个物品 中选择若干物品放满容量为 j 的背包。若 f(i-1,j) == true 则 f(i,j) = true
初始状态：
当 j 等于 0 时，即背包容量为 0，则 f(i,0) 恒为 true
当 i 等于 0 时，即物品数为 0，则 f(0,j) 恒为 false
相似题目: 494. 目标和
https://leetcode-cn.com/problems/target-sum/
 */