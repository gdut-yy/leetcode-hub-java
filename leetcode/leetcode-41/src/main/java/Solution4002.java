public class Solution4002 {
    static int MOD = (int) 1e9 + 7, MX = (int) 5e5 + 5;
    static long[] F = new long[MX + 1], invF = new long[MX + 1];

    static {
        F[0] = F[1] = invF[0] = invF[1] = 1;
        for (int i = 2; i <= MX; i++) F[i] = F[i - 1] * i % MOD;
        invF[MX] = quickPow(F[MX], MOD - 2);
        for (int i = MX - 1; i >= 2; i--) invF[i] = invF[i + 1] * (i + 1) % MOD;
    }

    static long comb(int n, int m) {
        if (n < m || m < 0) return 0;
        return F[n] * invF[n - m] % MOD * invF[m] % MOD;
    }

    static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    public int countValidSequences(int n, int k) {
        long ans = comb(n - 1, k - 1);
        if ((n + k) % 2 == 0) {
            ans = (ans - comb((n + k) / 2 - 1, k - 1) + MOD) % MOD; // +MOD 保证答案非负
        }
        return (int) ans;
    }
}
/*
4002. 统计有效序列数目
https://leetcode.cn/problems/count-valid-sequences/description/

第 512 场周赛 T3。

给你两个正整数 n 和 k。
一个 有效序列 是一个由 k 个正整数组成的序列，满足以下条件：
- 序列中所有整数的 和 等于 n。
- 序列中所有整数的 乘积 是 偶数 。
返回有效序列的数量。由于答案可能很大，请将其对 109 + 7 取余 后返回。
如果两个序列在任何下标处不同，则认为它们是 不同 的序列。例如，[1, 1, 2] 和 [1, 2, 1] 被认为是不同的序列。
提示：
1 <= n <= 5 * 10^5
1 <= k <= n

组合数学。
时间复杂度 O(1)。
 */