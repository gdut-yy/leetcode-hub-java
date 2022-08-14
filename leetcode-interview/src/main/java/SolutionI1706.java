import java.util.Arrays;

public class SolutionI1706 {
    private char[] s;
    private int[][] dp;

    public int numberOf2sInRange(int n) {
        s = String.valueOf(n).toCharArray();
        int len = s.length;
        dp = new int[len][10];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true, false);
    }

    private int f(int i, int sum, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? sum : 0;
        }
        // 记忆化搜索
        if (!isLimit && isNum && dp[i][sum] >= 0) {
            return dp[i][sum];
        }
        int res = 0;
        if (!isNum) {
            // 可以跳过当前数位
            res = f(i + 1, sum, false, false);
        }
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            res += f(i + 1, sum + (d == 2 ? 1 : 0), isLimit && d == up, true);
        }
        if (!isLimit && isNum) {
            dp[i][sum] = res;
        }
        return res;
    }
}
/*
面试题 17.06. 2出现的次数
https://leetcode.cn/problems/number-of-2s-in-range-lcci/

编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
示例:
输入: 25
输出: 9
解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次)
提示：
n <= 10^9

数位 DP
相似题目: 233. 数字 1 的个数
https://leetcode.cn/problems/number-of-digit-one/
 */