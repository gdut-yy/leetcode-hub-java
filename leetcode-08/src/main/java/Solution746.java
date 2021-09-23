public class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[len];
    }
}
/*
746. 使用最小花费爬楼梯
https://leetcode-cn.com/problems/min-cost-climbing-stairs/

动态规划.
dp[i] 表示达到下标 ii 的最小花费
dp[0] = dp[1] = 0
状态转移
dp[i] = min(dp[i−1]+cost[i−1], dp[i−2]+cost[i−2])
 */