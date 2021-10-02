public class SolutionI0801 {
    public int waysToStep(int n) {
        // 避免越界
        int len = Math.max(3, n);
        int[] dp = new int[len + 1];
        dp[0] = 1;
        // 1
        dp[1] = 1;
        // 1+1 / 2
        dp[2] = 2;
        // 1+1+1 / 1+2 / 2+1 / 3
        dp[3] = 4;

        // 状态转移
        int mod = 1000000007;
        for (int i = 4; i <= n; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % mod + dp[i - 3]) % mod;
        }
        return dp[n];
    }
}
/*
面试题 08.01. 三步问题
https://leetcode-cn.com/problems/three-steps-problem-lcci/

三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。
结果可能很大，你需要对结果模 1000000007。

相似题目: 70. 爬楼梯
https://leetcode-cn.com/problems/climbing-stairs/
注意方案数的区别。
 */