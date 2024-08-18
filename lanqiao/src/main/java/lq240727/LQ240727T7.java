package lq240727;

import java.util.Arrays;
import java.util.Scanner;

public class LQ240727T7 {
    static int N, M, K;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        K = scanner.nextInt();
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        long[] dp0 = new long[1 << N];
        long[] dp1 = new long[1 << N];
        Arrays.fill(dp0, 1);

        for (int i = 1; i < M; i++) {
            for (int j = 0; j < 1 << N; j++) {
                for (int k = 0; k < 1 << N; k++) {
                    if (Integer.bitCount(j & k) >= K) {
                        dp1[k] = (dp1[k] + dp0[j]) % MOD;
                    }
                }
            }
            for (int j = 0; j < 1 << N; j++) {
                dp0[j] = dp1[j];
                dp1[j] = 0;
            }
        }

        long ans = 0;
        for (long v : dp0) {
            ans = (ans + v) % MOD;
        }
        return String.valueOf(ans);
    }
}
/*
再遇白骨精【算法赛】

考虑状压 DP。
将 n 个村庄 m 户人家抽象为一个 n * m 的矩阵。
设 dp[i][bit] 表示第 i 列（注意是列不是行）处于状态 bit 时的组合数量。
状态转移方程为：
dp[i+1][next] = \begin{cases}
dp[i+1][next] + dp[i+1][bit] & \text{ 如果 } popcount(bit&next)>=k \\
0 & \text{ 如果 } popcount(bit&next)<k
\end{cases}
---
popcount(bit&next) 计算的是 bit 和 next 按位与后的 1 的个数，即共有多少个佛像在两种状态下是显灵的。
这个转移表示的是，从状态 bit 过渡到状态 next 的过程中，如果有至少 k 个佛像是显灵的，则转移是有效的，否则无效。
计算量大概是 O(2^{2n} \times nm)
 */