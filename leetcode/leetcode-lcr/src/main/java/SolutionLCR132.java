public class SolutionLCR132 {
    private static final int MOD = (int) (1e9 + 7);

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
            return (int) quickPow(3, quotient);
        } else if (remainder == 1) {
            // 余数为 1 拆分 m-1 个 3 和 2 个 2
            return (int) (quickPow(3, quotient - 1) * 4 % MOD);
        } else {
            // 余数为 2 拆分 m 个 3 和 1 个 2
            return (int) (quickPow(3, quotient) * 2 % MOD);
        }
    }

    // 快速幂 res = a^b % mod
    private long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
LCR 132. 砍竹子 II
https://leetcode.cn/problems/jian-sheng-zi-ii-lcof/description/

现需要将一根长为正整数 bamboo_len 的竹子砍为若干段，每段长度均为 正整数。请返回每段竹子长度的 最大乘积 是多少。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
提示：
2 <= bamboo_len <= 1000

大数场景，快速幂。
同: 343. 整数拆分
https://leetcode.cn/problems/integer-break
 */