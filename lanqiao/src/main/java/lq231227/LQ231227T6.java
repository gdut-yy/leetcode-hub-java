package lq231227;

import java.util.Scanner;

public class LQ231227T6 {
    static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        System.out.println(solve());
    }

    static final int MOD = 998244353;
    static Comb comb;

    private static String solve() {
        comb = new Comb(m + n);
        long ans = 0;
        for (int i = 1; i < 10 && i <= m; i++) {
            ans += count(n - 1, m - i);
            ans %= MOD;
        }
        return String.valueOf(ans);
    }

    static long count(int n, int m) {
        if (n == 0) return m == 0 ? 1 : 0;
        long ans = comb.binom(m + n - 1, n - 1);
        for (int i = 1; i <= n; i++) {
            long per = comb.binom(m + n - 1 - i * 10, n - 1) * comb.binom(n, i) % MOD;
            ans += (i & 1) == 1 ? -per : per;
            ans = (ans % MOD + MOD) % MOD;
        }
        return ans;
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
数字求和【算法赛】

枚举所有 N 位正整数，求其数码和，判断是否满足条件，显然无法通过此题。
首先解决前导零的问题，不妨枚举最高位 x \in [1,9] 中的一个数，那么问题就变成了有多少个 N-1 位正整数，可以有前导 0，契合为 M-x。
即有 N-1 个 [0,9] 内的整数，其和为 M-x，问方案数。
考虑如果是有 N-1个 [0,+\infty] 内的整数，其和为 M-x，问方案数，可以利用插板法的思想，答案为 C_{M-x+N-2}^{N-2}
考虑容斥，有 k 个整数超过了 9，那么可以把这些数看作 10+[0,+\infty] 的一个数，既可以看作总和减去了 10k，答案数为 C_{M-x+N-2-10k}^{N-2}，超过的数的选择为 C_{n}^{k}，容斥系数为 (-1)^k。
预处理组合数，计算上述所有答案之和即可。

组合数学 / 二项式反演
 */