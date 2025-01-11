public class Solution3405 {
    static final int MOD = (int) (1e9 + 7);
    static Comb comb = new Comb((int) 1e5);

    public int countGoodArrays(int n, int m, int k) {
        long ans = comb.binom(n - 1, k) * m % MOD * comb.quickPow(m - 1, n - k - 1) % MOD;
        return (int) ans;
    }

    static class Comb {
        long[] fac, inv_fac;

        public Comb(int n) {
            fac = new long[n + 1];
            fac[0] = 1;
            for (int i = 1; i <= n; i++) fac[i] = fac[i - 1] * i % MOD;
            inv_fac = new long[n + 1];
            for (int i = 0; i <= n; i++) inv_fac[i] = quickPow(fac[i], MOD - 2);
        }

        // C(n, m) = n! / m!(n-m)!
        long binom(int n, int m) {
            if (n < m || m < 0) return 0;
            return fac[n] * inv_fac[m] % MOD * inv_fac[n - m] % MOD;
        }

        // 模下的 a^b
        long quickPow(long a, long b) {
            long res = 1L;
            while (b > 0) {
                if ((b & 1) != 0) res = res * a % MOD;
                a = a * a % MOD;
                b >>= 1;
            }
            return res;
        }
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