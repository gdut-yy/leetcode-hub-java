package lq240113;

import java.util.Arrays;
import java.util.Scanner;

public class LQ240113T5 {
    static int n, k;
    static int[] a, p;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        p = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            p[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final long INF = (long) 1e18;

    private static String std() {
        long[][] dp = new long[n + 1][k + 1];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], -INF);
        }
        int now = 0, pre = 1;
        dp[now][0] = 0;
        for (int i = 1; i <= n; i++) {
            int tmp = now;
            now = pre;
            pre = tmp;

            Arrays.fill(dp[now], -INF);
            for (int j = 1; j <= k; j++) {
                dp[now][j] = Math.max(dp[pre][j], dp[pre][j - 1]) + (long) a[i] * p[j];
            }
        }
        return String.valueOf(dp[now][k]);
    }

    private static String solve() {
        // f[i][j] 表示前 j 个数分成 i 段，每段选一个子数组，对应的最大和
        long[][] f = new long[k + 1][n + 1];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(f[i], -INF);
        }
        f[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = i; j + (k - i) <= n; j++) {
                f[i][j] = Math.max(f[i][j - 1], f[i - 1][j - 1]) + (long) a[j] * p[i];
            }
        }
        return String.valueOf(f[k][n]);
    }
}
/*
奇怪的段【算法赛】

划分型 DP。
时间复杂度 O(nk)
 */