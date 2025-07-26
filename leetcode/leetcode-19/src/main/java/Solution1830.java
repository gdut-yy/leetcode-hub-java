public class Solution1830 {
    public int makeStringSorted(String S) {
        int n = S.length();
        char[] s = S.toCharArray();

        // freq 存储每个字符出现的次数
        int[] freq = new int[26];
        for (char c : S.toCharArray()) {
            ++freq[c - 'a'];
        }

        long ans = 0;
        for (int i = 0; i < n - 1; ++i) {
            // rank 求出比 s[i] 小的字符数量
            int rank = 0;
            for (int j = 0; j < s[i] - 'a'; ++j) {
                rank += freq[j];
            }
            // 排列个数的分子
            long cur = rank * F[n - i - 1] % MOD;
            // 依次乘分母每一项阶乘的乘法逆元
            for (int j = 0; j < 26; ++j) {
                cur = cur * invF[freq[j]] % MOD;
            }
            ans = (ans + cur) % MOD;
            --freq[s[i] - 'a'];
        }

        return (int) ans;
    }

    static int MOD = (int) 1e9 + 7, MX = (int) 3e4 + 5;
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
1830. 使字符串有序的最少操作次数
https://leetcode.cn/problems/minimum-number-of-operations-to-make-string-sorted/description/

给你一个字符串 s （下标从 0 开始）。你需要对 s 执行以下操作直到它变为一个有序字符串：
1.找到 最大下标 i ，使得 1 <= i < s.length 且 s[i] < s[i - 1] 。
2.找到 最大下标 j ，使得 i <= j < s.length 且对于所有在闭区间 [i, j] 之间的 k 都有 s[k] < s[i - 1] 。
3.交换下标为 i - 1 和 j 处的两个字符。
4.将下标 i 开始的字符串后缀反转。
请你返回将字符串变成有序的最少操作次数。由于答案可能会很大，请返回它对 10^9 + 7 取余 的结果。

组合数学
https://leetcode.cn/problems/minimum-number-of-operations-to-make-string-sorted/solutions/
 */