import java.util.Arrays;

public class Solution3428 {
    static final int MOD = (int) (1e9 + 7);
    static final int MX = (int) (1e5 + 5);
    static Comb comb = new Comb(MX);

    public int minMaxSums(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long s = 0;
            for (int j = 0; j < Math.min(k, i + 1); j++) {
                s += comb.binom(i, j);
            }
            ans = (ans + s % MOD * (nums[i] + nums[n - 1 - i])) % MOD;
        }
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
3428. 最多 K 个元素的子序列的最值之和
https://leetcode.cn/problems/maximum-and-minimum-sums-of-at-most-size-k-subsequences/description/

第 433 场周赛 T2。

给你一个整数数组 nums 和一个正整数 k，返回所有长度最多为 k 的 子序列 中 最大值 与 最小值 之和的总和。
非空子序列 是指从另一个数组中删除一些或不删除任何元素（且不改变剩余元素的顺序）得到的数组。
由于答案可能非常大，请返回对 10^9 + 7 取余数的结果。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9
1 <= k <= min(100, nums.length)

贡献法 + 组合数学 + 递推优化。
我们可以从下标 [0,i−1] 中选至多 min(k−1,i) 个数，作为子序列的其他元素。这样的选法总共有
\sum_{j=0}^{min(k-1,i)} \binom{i}{j}
相似题目: 3430. 最多 K 个元素的子数组的最值之和
https://leetcode.cn/problems/maximum-and-minimum-sums-of-at-most-size-k-subarrays/description/
 */