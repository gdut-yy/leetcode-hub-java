public class SolutionO63 {
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
剑指 Offer 63. 股票的最大利润
https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/

假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？

同: 121. 买卖股票的最佳时机
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 */