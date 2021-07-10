public class Solution122 {
    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            res += Math.max(diff, 0);
        }
        return res;
    }
}
/*
122. 买卖股票的最佳时机 II
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/

买卖股票系列。难度增加，可以多次买卖一支股票。注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
有一种取巧解法：贪心法。只要明天比今天涨的都进行交易。
系列题解 https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/tan-xin-suan-fa-by-liweiwei1419-2/
 */
