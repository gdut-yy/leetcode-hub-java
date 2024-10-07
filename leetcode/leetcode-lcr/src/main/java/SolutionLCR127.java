public class SolutionLCR127 {
    private static final int MOD = (int) (1e9 + 7);

    public int trainWays(int n) {
        int len = Math.max(2, n);
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= MOD;
        }
        return dp[n];
    }
}
/*
LCR 127. 跳跃训练
https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/description/

今天的有氧运动训练内容是在一个长条形的平台上跳跃。平台有 num 个小格子，每次可以选择跳 一个格子 或者 两个格子。请返回在训练过程中，学员们共有多少种不同的跳跃方式。
结果可能过大，因此结果需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
提示：
0 <= n <= 100

同: 70. 爬楼梯
https://leetcode.cn/problems/climbing-stairs/
 */