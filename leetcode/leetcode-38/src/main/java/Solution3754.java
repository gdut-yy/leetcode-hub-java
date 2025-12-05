public class Solution3754 {
    public long sumAndMultiply(int n) {
        long x = 0;
        long pow10 = 1;
        long sum = 0;
        while (n > 0) {
            int d = n % 10;
            if (d != 0) {
                sum += d;
                x += pow10 * d;
                pow10 *= 10;
            }
            n /= 10;
        }
        return x * sum;
    }
}
/*
3754. 连接非零数字并乘以其数字和 I
https://leetcode.cn/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/description/

第 477 场周赛 T1。

给你一个整数 n。
将 n 中所有的 非零数字 按照它们的原始顺序连接起来，形成一个新的整数 x。如果不存在 非零数字 ，则 x = 0。
sum 为 x 中所有数字的 数字和 。
返回一个整数，表示 x * sum 的值。
提示：
0 <= n <= 10^9

模拟。
时间复杂度 O(logn)。
 */