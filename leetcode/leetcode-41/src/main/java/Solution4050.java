public class Solution4050 {
    public int minDays(int n) {
        final int INF = Integer.MAX_VALUE / 2;
        int[] dp = new int[n + 1];
        java.util.Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int s = 0; s <= n; s++) {
            if (dp[s] == INF) continue;
            int t = 0;
            for (int k = 1; s + t + k <= n; k++) {
                t += k;
                int ns = s + t;
                int cost = dp[s] + k + (s > 0 ? 1 : 0);
                if (cost < dp[ns]) dp[ns] = cost;
            }
        }
        return dp[n];
    }
}
/*
4050. 得到恰好 N 分的最少天数
https://leetcode.cn/problems/minimum-days-to-score-exactly-n-points/description/

第 519 场周赛 T3。

给你一个整数 n，表示目标分数。
你的分数初始为 0，每天你既可以 获得 分数，也可以 跳过 。
分数是在连胜期间获得的。在连胜的第一天，你获得 1 分，第二天获得 2 分，第三天获得 3 分，依此类推。跳过 一天将获得 零分 并 重置 连胜，因此下一次你获得分数时，将再次从 1 开始。
返回达到 恰好 为 n 的分数所需的 最少 天数（包括所有跳过的天数）。
提示：
1 <= n <= 10^5

完全背包。
时间复杂度 O(n * sqrt(n))。
相似题目: 279. 完全平方数
https://leetcode.cn/problems/perfect-squares/
 */