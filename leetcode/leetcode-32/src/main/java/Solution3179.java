public class Solution3179 {
    // 杨辉三角第 n+k 排的第 n 个数，即 C(n+k-1, n-1) = C(n+k-1, k)
    public int valueAfterKSeconds(int n, int k) {
        return (int) comb(n + k - 1, k);
    }

    static int MOD = (int) 1e9 + 7, MX = (int) 2000;
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
3179. K 秒后第 N 个元素的值
https://leetcode.cn/problems/find-the-n-th-value-after-k-seconds/description/

第 401 场周赛 T2。

给你两个整数 n 和 k。
最初，你有一个长度为 n 的整数数组 a，对所有 0 <= i <= n - 1，都有 a[i] = 1 。每过一秒，你会同时更新每个元素为其前面所有元素的和加上该元素本身。例如，一秒后，a[0] 保持不变，a[1] 变为 a[0] + a[1]，a[2] 变为 a[0] + a[1] + a[2]，以此类推。
返回 k 秒后 a[n - 1] 的值。
由于答案可能非常大，返回其对 10^9 + 7 取余 后的结果。
提示：
1 <= n, k <= 1000

组合数学。
时间复杂度 O(1)。
 */