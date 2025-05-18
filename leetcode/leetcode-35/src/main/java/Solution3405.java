public class Solution3405 {
    public int countGoodArrays(int n, int m, int k) {
        long ans = comb(n - 1, k) * m % MOD * quickPow(m - 1, n - k - 1) % MOD;
        return (int) ans;
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
3405. 统计恰好有 K 个相等相邻元素的数组数目
https://leetcode.cn/problems/count-the-number-of-arrays-with-k-matching-adjacent-elements/description/

第 430 场周赛 T4。

给你三个整数 n ，m ，k 。长度为 n 的 好数组 arr 定义如下：
- arr 中每个元素都在 闭 区间 [1, m] 中。
- 恰好 有 k 个下标 i （其中 1 <= i < n）满足 arr[i - 1] == arr[i] 。
请你返回可以构造出的 好数组 数目。
由于答案可能会很大，请你将它对 10^9 + 7 取余 后返回。
提示：
1 <= n <= 10^5
1 <= m <= 10^5
0 <= k <= n - 1

组合数学。
时间复杂度 O(log(n-k))。
```py
def countGoodArrays(self, n: int, m: int, k: int) -> int:
    MOD = 1_000_000_007
    return comb(n - 1, k) % MOD * m * pow(m - 1, n - k - 1, MOD) % MOD
```
rating 2288 (clist.by)
 */