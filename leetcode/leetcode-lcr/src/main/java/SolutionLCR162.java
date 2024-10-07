import java.util.Arrays;

public class SolutionLCR162 {
    private char[] s;
    private int[][] dp;

    // 数位 DP
    public int digitOneInNumber(int num) {
        s = String.valueOf(num).toCharArray();
        int len = s.length;
        dp = new int[len][10];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true);
    }

    private int f(int i, int sum, boolean isLimit) {
        if (i == s.length) {
            return sum;
        }
        // 记忆化搜索
        if (!isLimit && dp[i][sum] >= 0) {
            return dp[i][sum];
        }
        int res = 0;
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = 0; d <= up; d++) {
            res += f(i + 1, sum + (d == 1 ? 1 : 0), isLimit && d == up);
        }
        if (!isLimit) {
            dp[i][sum] = res;
        }
        return res;
    }
}
/*
LCR 162. 数字 1 的个数
https://leetcode.cn/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/

给定一个整数 num，计算所有小于等于 num 的非负整数中数字 1 出现的个数。
提示：
0 <= num < 10^9

同: 233. 数字 1 的个数
https://leetcode.cn/problems/number-of-digit-one/
 */