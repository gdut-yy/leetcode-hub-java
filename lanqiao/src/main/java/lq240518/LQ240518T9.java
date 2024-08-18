package lq240518;

import java.util.Scanner;

public class LQ240518T9 {
    static int n, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        if (n == 1) return String.valueOf(k);

        long[][] f = new long[n + 1][n + 1];
        long[] sum = new long[n + 1];
        f[2][n - 1] = 2;
        for (int i = 3; i <= n; i++) {
            sum[n - 1] = f[i - 1][n - 1];
            for (int j = n - 2; j >= 1; j--) {
                sum[j] = (f[i - 1][j] + sum[j + 2]) % MOD;
            }
            for (int j = n - 2; j >= 1; j--) {
                f[i][j] = i + j <= n ? (sum[j + 1] + sum[i + j - 1]) % MOD : sum[j + 1];
            }
        }

        long ans = 0;
        for (int i = 2; i <= Math.min(n, k); i++) {
            for (int j = 1; j < n; j++) {
                ans = (ans + f[i][j] * (k - i + 1) % MOD) % MOD;
            }
        }
        return String.valueOf(ans);
    }
}
/*
分子实验【算法赛】

考虑以最小值为突破点，定义 dp[i][j] 表示长度为 i，最小值为 j 的字段 A 的方案数。
答案可表示为：\sum_{i=1}^{min(n,k)} ans_i \times (k-i+1)
考虑以次小值为前置状态进行状态转移。
 */