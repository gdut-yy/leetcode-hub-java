public class Offer2Solution1 {
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        int negative = 2;
        if (a > 0) {
            negative--;
            a = -a;
        }
        if (b > 0) {
            negative--;
            b = -b;
        }
        int res = divideCode(a, b);
        return negative == 1 ? -res : res;
    }

    private int divideCode(int dividend, int divisor) {
        int res = 0;
        while (dividend <= divisor) {
            int value = divisor;
            int quotient = 1;
            while (value >= Integer.MIN_VALUE >> 1 && dividend <= value + value) {
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
剑指 Offer II 001. 整数除法
https://leetcode-cn.com/problems/xoh6Oh/
 */