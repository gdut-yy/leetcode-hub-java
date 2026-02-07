import java.util.Arrays;

public class SolutionP3647 {
    public int maxWeight(int[] weights, int w1, int w2) {
        // dp[i][j]表示背包1能否装重量i，背包2能否装重量j
        boolean[][] dp = new boolean[w1 + 1][w2 + 1];
        dp[0][0] = true;
        Arrays.sort(weights);
        for (int idx = weights.length - 1; idx >= 0; idx--) {
            int weight = weights[idx];
            for (int s = w1 + w2; s >= weight; s--) {
                for (int i = Math.max(weight, s - w2); i <= Math.min(w1, s); i++) {
                    dp[i][s - i] = dp[i][s - i] || dp[i - weight][s - i];
                }
                for (int j = Math.max(weight, s - w1); j <= Math.min(w2, s); j++) {
                    dp[s - j][j] = dp[s - j][j] || dp[s - j][j - weight];
                }
            }
            if (dp[w1][w2]) {
                return w1 + w2;
            }
        }

        int ans = 0;
        for (int i = 0; i <= w1; i++) {
            for (int j = 0; j <= w2; j++) {
                if (dp[i][j] && i + j > ans) {
                    ans = i + j;
                }
            }
        }
        return ans;
    }
}
/*
$3647. 两个袋子中的最大重量
https://leetcode.cn/problems/maximum-weight-in-two-bags/

给定一个整数数组 weights 和两个整数 w1 和 w2 表示两个袋子的 最大 容量。
每个物品 最多 可以放入一个袋子中，使得：
- 袋子 1 最多 总共可以装 w1 重量。
- 袋子 2 最多 总共可以装 w2 重量。
返回两个袋子可以装入的 最大 总重量。
提示：
1 <= weights.length <= 100
1 <= weights[i] <= 100
1 <= w1, w2 <= 300

动态规划。
https://leetcode.cn/problems/maximum-weight-in-two-bags/solutions/3753639/python3er-wei-bei-bao-by-arnold-sb6ffyla-cjw1/
时间复杂度 O(n * w1 * w2)。
 */