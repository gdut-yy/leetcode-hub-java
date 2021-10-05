public class SolutionO10_2 {
    public int numWays(int n) {
        int len = Math.max(2, n);
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
}
/*
剑指 Offer 10- II. 青蛙跳台阶问题
https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/

一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

动态规划。
相似题目: 70. 爬楼梯
https://leetcode-cn.com/problems/climbing-stairs/
注意取模的差异。
 */