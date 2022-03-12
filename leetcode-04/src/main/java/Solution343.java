public class Solution343 {
    public int integerBreak(int n) {
        // 说明: 你可以假设 n 不小于 2 且不大于 58。
        if (n <= 3) {
            return n - 1;
        }
        // n = 3 * quotient + remainder
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            // 余数为 0 拆分 m 个 3
            return (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            // 余数为 1 拆分 m-1 个 3 和 2 个 2
            return (int) Math.pow(3, quotient - 1) * 4;
        } else {
            // 余数为 2 拆分 m 个 3 和 1 个 2
            return (int) Math.pow(3, quotient) * 2;
        }
    }
}
/*
343. 整数拆分
https://leetcode-cn.com/problems/integer-break/

给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
提示:
2 <= n <= 58

数学。
时间复杂度 O(1)
空间复杂度 O(1)
 */
