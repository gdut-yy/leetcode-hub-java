public class SolutionLCR188 {
    public int bestTiming(int[] prices) {
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
LCR 188. 买卖芯片的最佳时机
https://leetcode.cn/problems/gu-piao-de-zui-da-li-run-lcof/

数组 prices 记录了某芯片近期的交易价格，其中 prices[i] 表示的 i 天该芯片的价格。你只能选择 某一天 买入芯片，并选择在 未来的某一个不同的日子 卖出该芯片。请设计一个算法计算并返回你从这笔交易中能获取的最大利润。
如果你不能获取任何利润，返回 0。
提示：
0 <= prices.length <= 10^5
0 <= prices[i] <= 10^4

同: 121. 买卖股票的最佳时机
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/
 */