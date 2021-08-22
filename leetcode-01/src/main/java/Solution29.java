public class Solution29 {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int negative = 2;
        if (dividend > 0) {
            negative--;
            dividend = -dividend;
        }
        if (divisor > 0) {
            negative--;
            divisor = -divisor;
        }
        int res = divideCode(dividend, divisor);
        return negative == 1 ? -res : res;
    }

    private int divideCode(int dividend, int divisor) {
        int res = 0;
        while (dividend <= divisor) {
            int value = divisor;
            int quotient = 1;
            // Integer.MIN_VALUE / 2
            while (value >= (Integer.MIN_VALUE >> 1) && dividend <= value + value) {
                quotient += quotient;
                value += value;
            }
            res += quotient;
            dividend -= value;
        }
        return res;
    }
}
/*
29. 两数相除
https://leetcode-cn.com/problems/divide-two-integers/

思维题（实际工程中意义不大）
 */
