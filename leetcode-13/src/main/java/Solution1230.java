public class Solution1230 {
    public double probabilityOfHeads(double[] prob, int target) {
        int len = prob.length;

        double[][] dp = new double[len + 1][target + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= len; i++) {
            dp[i][0] = dp[i - 1][0] * (1 - prob[i - 1]);
        }
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j - 1] * prob[i - 1] + dp[i - 1][j] * (1 - prob[i - 1]);
            }
        }
        return dp[len][target];
    }
}
/*
$1230. 抛掷硬币
https://leetcode.cn/problems/toss-strange-coins/

有一些不规则的硬币。在这些硬币中，prob[i] 表示第 i 枚硬币正面朝上的概率。
请对每一枚硬币抛掷 一次，然后返回正面朝上的硬币数等于 target 的概率。
提示：
1 <= prob.length <= 1000
0 <= prob[i] <= 1
0 <= target <= prob.length
如果答案与标准答案的误差在 10^-5 内，则被视为正确答案。

动态规划。
 */