public class SolutionO16 {
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
剑指 Offer 16. 数值的整数次方
https://leetcode.cn/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/

实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。不得使用库函数，同时不需要考虑大数问题。

同: 50. Pow(x, n)
https://leetcode.cn/problems/powx-n/
 */