public class Solution3652 {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;
        long base = 0;
        for (int i = 0; i < n; i++) {
            base += (long) strategy[i] * prices[i];
        }

        long[] prePrice = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prePrice[i + 1] = prePrice[i] + prices[i];
        }

        long[] preProd = new long[n + 1];
        for (int i = 0; i < n; i++) {
            preProd[i + 1] = preProd[i] + (long) strategy[i] * prices[i];
        }

        int m = k / 2;
        long maxDelta = Long.MIN_VALUE;
        for (int l = 0; l <= n - k; l++) {
            long sum1 = prePrice[l + k] - prePrice[l + m];
            long sum2 = preProd[l + k] - preProd[l];
            long delta = sum1 - sum2;
            if (delta > maxDelta) {
                maxDelta = delta;
            }
        }
        if (maxDelta < 0) {
            maxDelta = 0;
        }
        return base + maxDelta;
    }
}
/*
3652. 按策略买卖股票的最佳时机
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-using-strategy/description/

第 463 场周赛 T1。

给你两个整数数组 prices 和 strategy，其中：
- prices[i] 表示第 i 天某股票的价格。
- strategy[i] 表示第 i 天的交易策略，其中：
  - -1 表示买入一单位股票。
  - 0 表示持有股票。
  - 1 表示卖出一单位股票。
同时给你一个 偶数 整数 k，你可以对 strategy 进行 最多一次 修改。一次修改包括：
- 选择 strategy 中恰好 k 个 连续 元素。
- 将前 k / 2 个元素设为 0（持有）。
- 将后 k / 2 个元素设为 1（卖出）。
利润 定义为所有天数中 strategy[i] * prices[i] 的 总和 。
返回你可以获得的 最大 可能利润。
注意： 没有预算或股票持有数量的限制，因此所有买入和卖出操作均可行，无需考虑过去的操作。
提示：
2 <= prices.length == strategy.length <= 10^5
1 <= prices[i] <= 10^5
-1 <= strategy[i] <= 1
2 <= k <= prices.length
k 是偶数

前缀和 + 枚举。
https://yuanbao.tencent.com/chat/naQivTmsDa/e1c82dcd-ede4-4c7c-ab9b-301fdcac9252
时间复杂度 O(n)。
 */