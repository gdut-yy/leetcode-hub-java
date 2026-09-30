import java.util.Arrays;

public class SolutionP4060 {
    public long countEvenlyGoodIntegers(long l, long r) {
        return count(r) - count(l - 1);
    }

    private long count(long num) {
        s = String.valueOf(num).toCharArray();
        dp = new long[s.length][s.length + 1];
        for (int i = 0; i < s.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true, false);
    }

    private char[] s;
    private long[][] dp;

    private long f(int i, int evenDigitsCnt, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return evenDigitsCnt % 2 == 0 ? 1 : 0;
        }
        if (!isLimit && isNum && dp[i][evenDigitsCnt] != -1) return dp[i][evenDigitsCnt];
        long res = 0;
        if (!isNum) {
            res = f(i + 1, evenDigitsCnt, false, false);
        }
        int down = isNum ? 0 : 1;
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = down; d <= up; d++) {
            int nxtEvenDigitsCnt = evenDigitsCnt + (d % 2 == 0 ? 1 : 0);
            res += f(i + 1, nxtEvenDigitsCnt, isLimit && d == up, true);
        }
        if (!isLimit && isNum) dp[i][evenDigitsCnt] = res;
        return res;
    }
}
/*
$4060. 统计偶好数
https://leetcode.cn/problems/count-evenly-good-integers/description/

给你两个整数 l 和 r。
如果一个整数包含偶数个偶数数字，则称这个整数为 偶好数。
返回闭区间 [l, r] 中偶好数的数量。
示例 1：
输入： l = 18, r = 22
输出： 3
示例 2：
输入： l = 98, r = 101
输出： 2
示例 3：
输入： l = 1, r = 10
输出： 5
提示：
1 <= l <= r <= 10^15
 */