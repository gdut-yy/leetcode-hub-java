package template;

/**
 * @jiangly https://codeforces.com/contest/1824/submission/205086508
 */
public class Comb {
    static final int MOD = (int) (1e9 + 7);
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
