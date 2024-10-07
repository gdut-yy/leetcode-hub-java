public class SolutionLCR131 {
    public int cuttingBamboo(int bamboo_len) {
        // 说明: 你可以假设 n 不小于 2 且不大于 58。
        if (bamboo_len <= 3) {
            return bamboo_len - 1;
        }
        // n = 3 * quotient + remainder
        int quotient = bamboo_len / 3;
        int remainder = bamboo_len % 3;
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
LCR 131. 砍竹子 I
https://leetcode.cn/problems/jian-sheng-zi-lcof/description/

现需要将一根长为正整数 bamboo_len 的竹子砍为若干段，每段长度均为正整数。请返回每段竹子长度的最大乘积是多少。
提示：
2 <= bamboo_len <= 58

同: 343. 整数拆分
https://leetcode.cn/problems/integer-break/
 */
