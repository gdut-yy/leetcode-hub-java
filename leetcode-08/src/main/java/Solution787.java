import java.util.Arrays;

public class Solution787 {
    private static final int INFINITE = 10000 * 101 + 1;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // bellman ford 算法
        // dp[t][i] 表示通过恰好 t 次航班，从出发城市 src 到达城市 i 需要的最小花费。
        int[][] dp = new int[k + 2][n];
        for (int i = 0; i < k + 2; i++) {
            Arrays.fill(dp[i], INFINITE);
        }
        dp[0][src] = 0;
        for (int t = 1; t <= k + 1; t++) {
            for (int[] flight : flights) {
                int j = flight[0];
                int i = flight[1];
                int cost = flight[2];
                dp[t][i] = Math.min(dp[t][i], dp[t - 1][j] + cost);
            }
        }
        // 取 dp[1][dst], dp[2][dst], ... dp[k+1][dst] 最小值
        int min = INFINITE;
        for (int t = 1; t <= k + 1; t++) {
            min = Math.min(min, dp[t][dst]);
        }
        return min == INFINITE ? -1 : min;
    }
}
/*
787. K 站中转内最便宜的航班
https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/

有 n 个城市通过一些航班连接。给你一个数组 flights ，其中 flights[i] = [fromi, toi, pricei] ，
表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到出一条最多经过 k 站中转的路线，
使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。

【宫水三叶】运用 Bellman Ford 求解有限制的最短路问题
https://leetcode-cn.com/problems/cheapest-flights-within-k-stops/solution/gong-shui-san-xie-xiang-jie-bellman-ford-dc94/
 */