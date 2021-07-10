public class Solution121 {
    public int maxProfit(int[] prices) {
        int curMin = Integer.MAX_VALUE;
        int res = 0;
        for (int price : prices) {
            if (price < curMin) {
                curMin = price;
            }
            res = Math.max(res, price - curMin);
        }
        return res;
    }
}
/*
121. 买卖股票的最佳时机
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/

买卖股票系列。由于只能买入一次卖出一次，因此统计当日价格减去历史最低位的最大值即可。
 */
