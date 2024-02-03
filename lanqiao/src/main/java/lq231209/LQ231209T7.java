package lq231209;

import java.util.Scanner;

public class LQ231209T7 {
    static int n, m;
    static long[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        long s = 0;
        for (long v : a) {
            s += v;
        }
        long p = quickPow(s, MOD - 2);
        for (int i = 0; i < n; i++) {
            a[i] = a[i] * p % MOD;
        }

        long d = (1 - a[0] + MOD) % MOD; // 防止负数
        d = quickPow(d, MOD - 2);

        long[] f = new long[m + 1];
        f[m] = 0;
        for (int i = m - 1; i >= 1; i--) {
            long c = 0;
            for (int j = 2; j <= n && i * j <= m; j++) {
                c = (c + f[i * j] * a[j - 1]) % MOD;
            }
            f[i] = (c + 1) * d % MOD;
        }
        return String.valueOf(f[1]);
    }

    // 模下的 a^b
    private static long quickPow(long a, long b) {
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
/*
期望次数【算法赛】

动态规划。
 */