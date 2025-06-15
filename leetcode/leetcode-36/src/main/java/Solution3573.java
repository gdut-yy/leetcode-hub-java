import java.util.Arrays;

public class Solution3573 {
    private int[] prices;
    private long[][][] memo;

    public long maximumProfit(int[] prices, int k) {
        this.prices = prices;
        int n = prices.length;
        memo = new long[n][k + 1][3];
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
    // hold 0:未持有 1:普通 2:做空
    private long dfs(int i, int j, int hold) {
        if (j < 0) return (long) -1e18;
        if (i < 0) {
            if (hold != 0) return (long) -1e18;
            return 0;
        }
        if (memo[i][j][hold] != -1) return memo[i][j][hold];
        long res;
        if (hold == 0) {
            // 什么也不干，普通交易，做空交易
            res = max(dfs(i - 1, j, 0), dfs(i - 1, j, 1) + prices[i], dfs(i - 1, j, 2) - prices[i]);
        } else if (hold == 1) {
            // 什么也不干，普通交易
            res = max(dfs(i - 1, j, 1), dfs(i - 1, j - 1, 0) - prices[i]);
        } else {
            // 什么也不干，做空交易
            res = max(dfs(i - 1, j, 2), dfs(i - 1, j - 1, 0) + prices[i]);
        }
        return memo[i][j][hold] = res;
    }

    private long max(long... values) {
        long maxValue = Long.MIN_VALUE;
        for (long i : values) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        return maxValue;
    }
}
/*
3573. 买卖股票的最佳时机 V
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-v/description/

第 158 场双周赛 T2。

给你一个整数数组 prices，其中 prices[i] 是第 i 天股票的价格（美元），以及一个整数 k。
你最多可以进行 k 笔交易，每笔交易可以是以下任一类型：
- 普通交易：在第 i 天买入，然后在之后的第 j 天卖出，其中 i < j。你的利润是 prices[j] - prices[i]。
- 做空交易：在第 i 天卖出，然后在之后的第 j 天买回，其中 i < j。你的利润是 prices[i] - prices[j]。
注意：你必须在开始下一笔交易之前完成当前交易。此外，你不能在已经进行买入或卖出操作的同一天再次进行买入或卖出操作。
通过进行 最多 k 笔交易，返回你可以获得的最大总利润。
提示:
2 <= prices.length <= 10^3
1 <= prices[i] <= 10^9
1 <= k <= prices.length / 2

记忆化搜索。在 188 题基础上改改即可。
相似题目: 188. 买卖股票的最佳时机 IV
https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
 */