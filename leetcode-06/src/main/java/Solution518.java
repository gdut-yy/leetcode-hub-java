public class Solution518 {
    public int change(int amount, int[] coins) {
        // dp[i] 表示金额之和等于 i 的硬币组合数，目标是求 dp[amount]。
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
/*
518. 零钱兑换 II
https://leetcode-cn.com/problems/coin-change-2/

给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
假设每一种面额的硬币有无限个。
题目数据保证结果符合 32 位带符号整数。

动态规划。
相似题目: 322. 零钱兑换
https://leetcode-cn.com/problems/coin-change/
 */