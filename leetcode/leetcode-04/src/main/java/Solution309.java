import java.util.Arrays;

public class Solution309 {
    private int[] prices;
    private int[][] memo;

    public int maxProfit(int[] prices) {
        this.prices = prices;
        int n = prices.length;
        memo = new int[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(n - 1, 0);
    }

    private int dfs(int i, int hold) {
        if (i < 0) {
            if (hold == 1) return (int) -1e9;
            return 0;
        }
        if (memo[i][hold] != -1) return memo[i][hold];
        int res;
        if (hold == 1) res = Math.max(dfs(i - 1, 1), dfs(i - 2, 0) - prices[i]);
        else res = Math.max(dfs(i - 1, 0), dfs(i - 1, 1) + prices[i]);
        return memo[i][hold] = res;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int n = prices.length;
        // dp[i][0]: 手上持有股票的最大收益
        // dp[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // dp[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }
}
/*
309. 最佳买卖股票时机含冷冻期
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/

给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。
设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
提示：
1 <= prices.length <= 5000
0 <= prices[i] <= 1000

状态机 DP
 */