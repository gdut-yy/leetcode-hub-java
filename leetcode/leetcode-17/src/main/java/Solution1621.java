public class Solution1621 {
    public int numberOfSets(int n, int k) {
        return (int) comb(n + k - 1, k * 2);
    }

    static int MOD = (int) 1e9 + 7, MX = (int) 1e5 + 5;
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
}
/*
1621. 大小为 K 的不重叠线段的数目
https://leetcode.cn/problems/number-of-sets-of-k-non-overlapping-line-segments/description/

给你一维空间的 n 个点，其中第 i 个点（编号从 0 到 n-1）位于 x = i 处，请你找到 恰好 k 个不重叠 线段且每个线段至少覆盖两个点的方案数。线段的两个端点必须都是 整数坐标 。这 k 个线段不需要全部覆盖全部 n 个点，且它们的端点 可以 重合。
请你返回 k 个不重叠线段的方案数。由于答案可能很大，请将结果对 10^9 + 7 取余 后返回。
提示：
2 <= n <= 1000
1 <= k <= n-1

组合数学。
如果线段之间首尾不重合，k 个线段需要选择 C(n, 2k) 个点
由于最多有 k-1 个线段首尾相连，所以不妨增加 k-1 个虚构点，k 个线段需要选择 C(n+k-1, 2k) 个点
math.comb(n + k - 1, k * 2) % (10**9 + 7)
时间复杂度 O(n+k)。
 */