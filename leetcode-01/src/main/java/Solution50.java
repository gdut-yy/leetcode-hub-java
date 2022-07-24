public class Solution50 {
    public double myPow(double x, int n) {
        if (n >= 0) {
            return quickPow(x, n);
        }
        return 1.0 / quickPow(x, -(long) n);
    }

    private double quickPow(double x, long pow) {
        double ans = 1.0;
        while (pow > 0) {
            if (pow % 2 == 1) {
                ans *= x;
            }
            x *= x;
            pow /= 2;
        }
        return ans;
    }
}
/*
50. Pow(x, n)
https://leetcode.cn/problems/powx-n/

快速幂模板。
注意本题 -2^31 <= n <= 2^31-1
若 n = -2^31 取反会爆 int，因此需转 long 避免溢出。
 */
