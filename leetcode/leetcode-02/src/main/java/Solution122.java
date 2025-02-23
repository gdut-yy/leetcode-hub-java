import java.util.Arrays;

public class Solution122 {
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

    // dfs(i, 0) 表示到第 i 天结束时，未持有股票的最大利润
    // dfs(i, 1) 表示到第 i 天结束时，持有股票的最大利润
    // 第 i-1 天结束就是第 i 天的开始
    private int dfs(int i, int hold) {
        if (i < 0) {
            if (hold == 1) return (int) -1e9;
            return 0;
        }
        if (memo[i][hold] != -1) return memo[i][hold];
        int res;
        if (hold == 1) res = Math.max(dfs(i - 1, 1), dfs(i - 1, 0) - prices[i]);
        else res = Math.max(dfs(i - 1, 0), dfs(i - 1, 1) + prices[i]);
        return memo[i][hold] = res;
    }

    public int maxProfit2(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            // 贪心。累加所有差值为正数的交易
            res += Math.max(0, prices[i + 1] - prices[i]);
        }
        return res;
    }
}
/*
122. 买卖股票的最佳时机 II
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/

给定一个数组 prices ，其中 prices[i] 表示股票第 i 天的价格。
在每一天，你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
返回 你能获得的 最大 利润 。
提示：
1 <= prices.length <= 3 * 10^4
0 <= prices[i] <= 10^4

状态机 DP / 贪心。只要明天比今天涨的都进行交易。
系列题解 https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/
相似题目: 309. 最佳买卖股票时机含冷冻期
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
714. 买卖股票的最佳时机含手续费
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
188. 买卖股票的最佳时机 IV
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
 */
