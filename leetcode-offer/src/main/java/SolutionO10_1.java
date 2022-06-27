public class SolutionO10_1 {
    public int fib(int n) {
        int len = Math.max(2, n);
        int[] dp = new int[len + 1];
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] %= 1000000007;
        }
        return dp[n];
    }
}
/*
剑指 Offer 10- I. 斐波那契数列
https://leetcode.cn/problems/fei-bo-na-qi-shu-lie-lcof/

写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
- F(0) = 0,   F(1) = 1
- F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

动态规划。
 */