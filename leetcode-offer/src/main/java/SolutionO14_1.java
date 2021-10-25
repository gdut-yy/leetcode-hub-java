public class SolutionO14_1 {
    public int cuttingRope(int n) {
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
剑指 Offer 14- I. 剪绳子
https://leetcode-cn.com/problems/jian-sheng-zi-lcof/

给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。

同: 343. 整数拆分
https://leetcode-cn.com/problems/integer-break/
 */
