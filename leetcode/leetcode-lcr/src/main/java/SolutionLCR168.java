public class SolutionLCR168 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
/*
LCR 168. 丑数
https://leetcode.cn/problems/chou-shu-lcof/

给你一个整数 n ，请你找出并返回第 n 个 丑数 。
说明：丑数是只包含质因数 2、3 和/或 5 的正整数；1 是丑数。
提示：
1 <= n <= 1690

同: 264. 丑数 II
https://leetcode.cn/problems/ugly-number-ii/
 */