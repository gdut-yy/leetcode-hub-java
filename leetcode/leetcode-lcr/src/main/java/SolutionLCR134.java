public class SolutionLCR134 {
    public double myPow(double x, int n) {
        if (n >= 0) {
            return fastPower(x, n);
        }
        return 1.0 / fastPower(x, -(long) n);
    }

    private double fastPower(double x, long pow) {
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
LCR 134. Pow(x, n)
https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/description/

实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。
提示：
-100.0 < x < 100.0
-2^31 <= n <= 2^31-1
-10^4 <= xn <= 10^4

同: 50. Pow(x, n)
https://leetcode.cn/problems/powx-n/
 */