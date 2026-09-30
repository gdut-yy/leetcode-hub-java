public class SolutionP4069 {
    public int maxProfit(int[] prices, int cooldown, int[] costs) {
        int n = prices.length;
        // f[j] = 考虑前 j 天（第 j 天不持有股票）的最大收益
        int[] f = new int[n];
        for (int j = 0; j < n; j++) {
            int best = j > 0 ? f[j - 1] : 0; // 第 j 天不进行任何操作
            for (int k = 0; k < j; k++) {
                // 第 k 天买入、第 j 天卖出，持有 j-k 天，手续费 costs[j-k]
                int base = k - cooldown - 1 >= 0 ? f[k - cooldown - 1] : 0;
                best = Math.max(best, base + prices[j] - prices[k] - costs[j - k]);
            }
            f[j] = best;
        }
        return f[n - 1];
    }
}
/*
$4069. 买卖股票的最佳时机含冷冻期 II

给定一个长度为 n 的整数数组 prices，其中 prices[i] 表示第 i 天的股票价格。
同时给定一个整数 cooldown 和一个长度为 n 的整数数组 costs。其中，costs[k] 表示一笔股票恰好持有 k 天时需要支付的 总持有费用。
你可以进行任意次数的交易，也可以不进行任何交易，但需要满足以下规则：
- 任意时刻你 最多只能持有一股 股票。在再次买入之前，必须先卖出当前持有的股票。
- 如果你在第 j 天卖出股票，那么最早可以在第 j + cooldown + 1 天再次买入股票。
- 如果你在第 i 天买入，并在第 j 天卖出，那么持有时长为 j - i 天。你需要为该笔交易支付一次费用 costs[j - i]。
在第 i 天买入并在第 j 天卖出的利润为 prices[j] - prices[i] - costs[j - i]。
返回你能够获得的 最大总利润。如果不存在任何有利可图的交易，则返回 0。
示例 1：
输入： prices = [1,5,3], cooldown = 1, costs = [2,0,1]
输出： 4
示例 2：
输入： prices = [1,2,5], cooldown = 0, costs = [0,2,1]
输出： 3
示例 3：
输入： prices = [4,1,7], cooldown = 2, costs = [3,0,1]
输出： 6
示例 4：
输入： prices = [3,1,4], cooldown = 0, costs = [2,1,0]
输出： 2
提示：
1 <= n == prices.length <= 1500
1 <= prices[i] <= 10^5
0 <= cooldown <= n - 1
costs.length == n
0 <= costs[i] <= 10^5
 */