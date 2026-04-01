public class Solution3855 {
    private static final int MOD = (int) (1e9 + 7);

    public int sumOfNumbers(int l, int r, int k) {
        int m = r - l + 1;
        long ans = (l + r) * m * (quickPow(10, k) - 1 + MOD) % MOD * quickPow(18, MOD - 2) % MOD * quickPow(m, k - 1) % MOD;
        return (int) ans;
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
3855. 给定范围内 K 位数字之和
https://leetcode.cn/problems/sum-of-k-digit-numbers-in-a-range/description/

第 177 场双周赛 T4。

给你三个整数 l、r 和 k。
考虑所有由 恰好 k 位数字组成的整数里，每一位数字都是从整数范围 [l, r]（闭区间）中独立选择的。如果该范围内包含 0，则允许出现前导零。
返回一个整数，代表 所有此类数字之和。由于答案可能很大，请将其对 10^9 + 7 取模 后返回。
提示：
0 <= l <= r <= 9
1 <= k <= 10^9

贡献法，数学公式。
时间复杂度 O(logk)。
 */