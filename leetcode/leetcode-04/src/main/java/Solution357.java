import java.util.Arrays;

public class Solution357 {
    public int countNumbersWithUniqueDigits(int n) {
        // 0 <= x < 10^n
        return 1 + numDupDigitsAtMostN((int) Math.pow(10, n) - 1);
    }

    private char[] s;
    private int[][] dp;

    private int numDupDigitsAtMostN(int n) {
        s = String.valueOf(n).toCharArray();
        int len = s.length;
        dp = new int[len][1 << 10];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true, false);
    }

    private int f(int i, int mask, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return isNum ? 1 : 0;
        }
        // 记忆化搜索
        if (!isLimit && isNum && dp[i][mask] >= 0) {
            return dp[i][mask];
        }
        int res = 0;
        if (!isNum) {
            // 可以跳过当前数位
            res = f(i + 1, mask, false, false);
        }
        for (int d = isNum ? 0 : 1, up = isLimit ? s[i] - '0' : 9; d <= up; d++) {
            // 枚举要填入的数字 d
            if ((mask >> d & 1) == 0) {
                // d 不在 mask 中
                res += f(i + 1, mask | (1 << d), isLimit && d == up, true);
            }
        }
        if (!isLimit && isNum) {
            dp[i][mask] = res;
        }
        return res;
    }
}
/*
357. 统计各位数字都不同的数字个数
https://leetcode.cn/problems/count-numbers-with-unique-digits/

给你一个整数 n ，统计并返回各位数字都不同的数字 x 的个数，其中 0 <= x < 10^n 。
提示：
0 <= n <= 8

打表/数位 DP
相似题目: 1012. 至少有 1 位重复的数字
https://leetcode.cn/problems/numbers-with-repeated-digits/
 */