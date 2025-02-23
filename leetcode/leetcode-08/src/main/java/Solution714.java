import java.util.Arrays;

public class Solution714 {
    private int[] prices;
    private int fee;
    private int[][] memo;

    public int maxProfit(int[] prices, int fee) {
        this.prices = prices;
        this.fee = fee;
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
        if (hold == 1) res = Math.max(dfs(i - 1, 1), dfs(i - 1, 0) - prices[i] - fee);
        else res = Math.max(dfs(i - 1, 0), dfs(i - 1, 1) + prices[i]);
        return memo[i][hold] = res;
    }

    public int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        int buy = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < n; ++i) {
            if (prices[i] + fee < buy) {
                buy = prices[i] + fee;
            } else if (prices[i] > buy) {
                profit += prices[i] - buy;
                buy = prices[i];
            }
        }
        return profit;
    }
}
/*
714. 买卖股票的最佳时机含手续费
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/

给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
返回获得利润的最大值。
注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
提示：
1 <= prices.length <= 5 * 10^4
1 <= prices[i] < 5 * 10^4
0 <= fee < 5 * 10^4

状态机 DP
相似题目: 122. 买卖股票的最佳时机 II
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
 */