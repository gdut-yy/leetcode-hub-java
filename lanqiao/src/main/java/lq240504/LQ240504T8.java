package lq240504;

import java.util.Arrays;
import java.util.Scanner;

public class LQ240504T8 {
    static int n, k;
    static int[] nums;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    static int f(int empty, int val) {
        return empty * (k + 1) + val;
    }

    private static String solve() {
        Arrays.sort(nums);
        int m = n / 2;
        long[][] dp = new long[2][(m + 1) * (k + 1)];

        dp[1][f(0, 0)] = 1;

        for (int i0 = 0; i0 < n; i0++) {
            int num = nums[i0];
            int i = i0 % 2;
            for (int j = 0; j < (m + 1) * (k + 1); j++) {
                dp[i][j] = 0;
            }

            int ni = i ^ 1;
            for (int empty = 0; empty < (m + 1); empty++) {
                for (int val = 0; val < (k + 1); val++) {
                    long v = dp[ni][f(empty, val)];
                    if (v != 0) {
                        if (val + num <= k) {
                            int p = f(empty, val + num);
                            dp[i][p] = (dp[i][p] + v * (1 + empty * 2)) % MOD;
                        }
                        if (empty != 0) {
                            int p = f(empty - 1, val);
                            dp[i][p] = (dp[i][p] + v * empty) % MOD;
                        }
                        if (empty + 1 <= m && val + num * 2 <= k) {
                            int p = f(empty + 1, val + num * 2);
                            dp[i][p] = (dp[i][p] + v * (empty + 1)) % MOD;
                        }
                    }
                }
            }
        }

        long ans = dp[(n - 1) % 2][f(0, k)];
        return String.valueOf(ans);
    }
}
/*
Yaya 与排列【算法赛】

令 dp[i][o][u] 表示在第 i 位，前面有 o 个空位（同时也意味着有 o 个数字没放），当前的总和贡献为 u 的排列个数。那么转移就比较清楚了：
- 第 i 个位置放自己：dp[i][o][u] → dp[i+1][o][u+ai]
- 第 i 个位置放 ai 后面的数，同时值为 ai 的数放在前面：dp[i][o][u] * o → dp[i+1][o][u+ai]
- 第 i 个位置放 ai 前面的数，同时值为 ai 的数放在后面：dp[i][o][u] * o → dp[i+1][o][u+ai]
- 第 i 个位置放 ai 后面的数，同时值为 ai 的数放在后面：dp[i][o][u] → dp[i+1][o+1][u +2×ai]
- 第 i 个位置放 ai 前面的数，同时值为 ai 的数放在前面：dp[i][o][u] * o * o → dp[i+1][o-1][u]
最后 dp[n + 1][o][k] 即为所求答案。
@小羊肖恩Yawn_Sean
 */