public class Solution494 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 == 1 || sum < target) {
            return 0;
        }
        return subsetSum(nums, (sum + target) / 2);
    }

    private int subsetSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}
/*
494. 目标和
https://leetcode-cn.com/problems/target-sum/

动态规划。01背包。
参考第 416 题 https://leetcode-cn.com/problems/partition-equal-subset-sum/

定义 f(i,j) 表示在数组前 i 个数字中选出若干数字使和等于 j 的方法的数目。

状态转移方程
j==0 时             f(i,j) = 1
i==0 && j>0 时      f(i,j) = 0
i>0 && j>nums[i] 时 f(i,j) = f(i-1,j) + f(i-1,j-nums[i])
 */