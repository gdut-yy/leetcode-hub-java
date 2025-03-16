import java.util.Arrays;

public class Solution3490 {
    private int k;

    public int beautifulNumbers(int l, int r) {
        // 数字之和 [1, 9*9] = [1,81]
        int ans = 0;
        for (int k = 1; k <= 81; k++) {
            int res = numberOfBeautifulIntegers(l, r, k);
            ans += res;
        }
        return ans;
    }

    public int numberOfBeautifulIntegers(int low, int high, int k) {
        this.k = k;
        int ans1 = count(low - 1);
        int ans2 = count(high);
        return ans2 - ans1;
    }

    private char[] s;
    private int[][][] dp;

    private int count(int num) {
        s = String.valueOf(num).toCharArray();
        int n = String.valueOf(num).length();
        dp = new int[n][k][82];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return f(0, 1, 0, true, false);
    }

    // remain:%k的余数
    private int f(int i, int remain, int digitSum, boolean isLimit, boolean isNum) {
        if (i == s.length) {
            return (isNum && remain == 0 && digitSum == k) ? 1 : 0;
        }
        if (!isLimit && isNum && dp[i][remain][digitSum] != -1) {
            return dp[i][remain][digitSum];
        }
        int ans = 0;
        if (!isNum) {
            ans += f(i + 1, remain, digitSum, false, false);
        }
        int down = isNum ? 0 : 1;
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = down; d <= up; d++) {
            ans += f(i + 1, remain * d % k, digitSum + d, isLimit && d == up, true);
        }
        if (!isLimit && isNum) {
            dp[i][remain][digitSum] = ans;
        }
        return ans;
    }
}
/*
3490. 统计美丽整数的数目
https://leetcode.cn/problems/count-beautiful-numbers/description/

第 441 场周赛 T4。

给你两个正整数 l 和 r 。如果正整数每一位上的数字的乘积可以被这些数字之和整除，则认为该整数是一个 美丽整数 。
统计并返回 l 和 r 之间（包括 l 和 r ）的 美丽整数 的数目。
提示：
1 <= l <= r < 10^9

数位 DP。
时间复杂度 O(10^2 * 81 * 81) = O(656100)
相似题目: 2827. 范围中美丽整数的数目
https://leetcode.cn/problems/number-of-beautiful-integers-in-the-range/
 */
