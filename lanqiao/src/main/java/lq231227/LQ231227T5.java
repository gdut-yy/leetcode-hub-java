package lq231227;

import java.util.Scanner;

public class LQ231227T5 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String tle() {
        // O(n^4)
        long ans = 0;
        for (int i1 = 0; i1 < n; i1++) {
            for (int i2 = i1 + 1; i2 < n; i2++) {
                for (int i3 = i2 + 1; i3 < n; i3++) {
                    for (int i4 = i3 + 1; i4 < n; i4++) {
                        ans += (a[i1] ^ a[i2]) + (a[i3] ^ a[i4]);
                    }
                }
            }
        }
        return String.valueOf(ans);
    }

    static final int MOD = 998244353;
    static Comb comb;

    private static String solve() {
        comb = new Comb(n);
        long ans = count();
        reverse(a);
        ans += count();
        ans = (ans % MOD + MOD) % MOD;
        return String.valueOf(ans);
    }

    static long count() {
        long ans = 0;
        for (int j = 0; j < 32; j++) {
            long[] cnt = new long[2];
            for (int i = 0; i < n; i++) {
                int bit = a[i] >> j & 1;
                ans += (1 << j) * cnt[bit ^ 1] % MOD * comb.binom(n - 1 - i, 2);
                ans %= MOD;
                cnt[bit]++;
            }
        }
        return ans;
    }

    private static void reverse(int[] nums) {
        for (int l = 0, r = nums.length - 1; l < r; l++, r--) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
        }
    }

    private static class Comb {
        private final long[] fac, invfac;

        public Comb(int n) {
            fac = new long[n + 1];
            fac[0] = 1;
            for (int i = 1; i <= n; i++) {
                fac[i] = fac[i - 1] * i % MOD;
            }
            invfac = new long[n + 1];
            for (int i = 0; i <= n; i++) {
                invfac[i] = quickPow(fac[i], MOD - 2);
            }
        }

        // C(n, m) = n! / m!(n-m)!
        private long binom(int n, int m) {
            if (n < m || m < 0) return 0;
            return fac[n] * invfac[m] % MOD * invfac[n - m] % MOD;
        }

        // 模下的 a^b
        private long quickPow(long a, long b) {
            long res = 1L;
            while (b > 0) {
                if ((b & 1) == 1) {
                    res = res * a % MOD;
                }
                a = a * a % MOD;
                b >>= 1;
            }
            return res;
        }
    }
}
/*
异或与求和【算法赛】

暴力枚举所有四元组，统计答案，显然无法通过此题。
考虑枚举一个二元组 i1,i2，那么其产生的贡献 a_{i_1} \oplus a_{i_2} 会加到 C_{i_1-1}^{2} + C_{n-i_2}^{2} 组四元组中，这样枚举时间复杂度为 O(n^2)。
考虑如何计算 \left ( a_{i_1} \oplus a_{i_2} \right ) \times C_{n-i_2}^{2}
对于位运算相关函数，我们一般采用拆位的思想。
考虑枚举 i_2，那么我们只需要计算 \sum_{i_1=1}^{i_2-1} a_{i_1} \oplus a_{i_2}
假设现在计算 2^j 这一位，若 a_{i_2} 这一位为 0，那么 a_{i_1} 这一位为 1 才会有贡献
假设现在计算 2^j 这一位，若 a_{i_2} 这一位为 1，那么 a_{i_1} 这一位为 0 才会有贡献
所以我们分别计算 2^j 这一位 0/1 的个数分别有多少，统计答案即可。
考虑如何计算 \left ( a_{i_3} \oplus a_{i_4} \right ) \times C_{i_3}^{2}
和上述问题是对称性问题，只需要将整个序列翻转再求一遍即可。

灵茶八题
 */