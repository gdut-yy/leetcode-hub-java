import java.util.Arrays;

public class Solution188 {
    private int[] prices;
    private int[][][] memo;

    public int maxProfit(int k, int[] prices) {
        this.prices = prices;
        int n = prices.length;
        memo = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k + 1; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(n - 1, k, 0);
    }

    // dfs(i, 0) 表示到第 i 天结束时完成至多 j 笔交易，未持有股票的最大利润
    // dfs(i, 1) 表示到第 i 天结束时完成至多 j 笔交易，持有股票的最大利润
    // 第 i-1 天结束就是第 i 天的开始
    private int dfs(int i, int j, int hold) {
        if (j < 0) return (int) -1e9;
        if (i < 0) {
            if (hold == 1) return (int) -1e9;
            return 0;
        }
        if (memo[i][j][hold] != -1) return memo[i][j][hold];
        int res;
        if (hold == 1) res = Math.max(dfs(i - 1, j, 1), dfs(i - 1, j - 1, 0) - prices[i]);
        else res = Math.max(dfs(i - 1, j, 0), dfs(i - 1, j, 1) + prices[i]);
        return memo[i][j][hold] = res;
    }
}
/*
188. 买卖股票的最佳时机 IV
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/

给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
提示：
0 <= k <= 100
0 <= prices.length <= 1000
0 <= prices[i] <= 1000

状态机 DP
相似题目: 3573. 买卖股票的最佳时机 V
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-v/description/
 */