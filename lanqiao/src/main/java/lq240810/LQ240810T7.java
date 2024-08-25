package lq240810;

import java.util.Scanner;

public class LQ240810T7 {
    static int n, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        System.out.println(solve());
    }

    static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        long[] dp = new long[n + 1];
        for (int i = 0; i < Math.min(n + 1, k); i++) {
            dp[i] = 1;
        }
        for (int i = k; i <= n; i++) {
            dp[i] = (dp[i] + dp[i - k] + dp[i - 1]) % MOD;
        }
        return String.valueOf(dp[n]);
    }
}
/*
久别重逢【算法赛】

考虑动态规划。
将最后一次约会后，亲密度不超过 i 的情况数记为 dp_i。对于任意的 i 来说，我们可以将其分解为两种情况：
1. 最后一次约会后，亲密度恰好达到 i：在这种情况下，最后一次约会前的亲密度必须小于等于 i - k，即最后一次约会前的亲密度从 0 到 i-k 的所有情况都可以通过最后一次约会达到 i。因此，这种情况的可能数为 dp_{i-k}。
2. 最后一次约会后，亲密度未达到 i：这包括亲密度从 0 到 i-1 的所有可能性。因此，这种情况的可能数为 dp_{i-1}。
于是，我们可以得到状态转移方程：
dp_i = dp_{i-1} + dp_{i-k}
通过状态转移，我们可以计算出 dp_n，即满足条件的所有可能的亲密度变化的过程数。
 */