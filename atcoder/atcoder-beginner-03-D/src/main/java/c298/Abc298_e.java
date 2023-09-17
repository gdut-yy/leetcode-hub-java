package c298;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc298_e {
    private static final int MOD = 998244353;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        System.out.println(solve(n, a, b, p, q));
    }

    // https://atcoder.jp/contests/abc298/editorial/6224
    private static String solve(int n, int a, int b, int p, int q) {
        long[][][] dp = new long[n + 1][n + 1][2];
        for (int i = 0; i < n; i++) {
            for (int f = 0; f < 2; f++) {
                dp[n][i][f] = 1;
                dp[i][n][f] = 0;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int k = 1; k <= p; k++) {
                    dp[i][j][0] = (dp[i][j][0] + dp[Math.min(n, i + k)][j][1]) % MOD;
                }
//                dp[i][j][0] /= p;
                dp[i][j][0] = dp[i][j][0] * quickPow(p, MOD - 2) % MOD;
                for (int k = 1; k <= q; k++) {
                    dp[i][j][1] = (dp[i][j][1] + dp[i][Math.min(n, j + k)][0]) % MOD;
                }
//                dp[i][j][1] /= q;
                dp[i][j][1] = dp[i][j][1] * quickPow(q, MOD - 2) % MOD;
            }
        }
        return String.valueOf(dp[a][b][0]);
    }

    // res = a^b % mod
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
E - Unfair Sugoroku
https://atcoder.jp/contests/abc298/tasks/abc298_e

题目大意：
高桥和青木将玩一场 sugoroku 游戏。
高桥从 A 点开始，青木从 b 点开始。他们轮流掷骰子。
高桥的骰子显示 1,2，…，P 的概率相等，青木的骰子显示 1,2，…，Q 的概率相等。
当玩家在 x 点掷骰子时，骰子显示为 i，他将到达点 min(x+i,N)。
第一个到达 N 点的玩家获胜。
求高桥先走赢的概率，对 998244353 取模。
======

Input
4 2 3 3 2
Output
665496236

Input
6 4 2 1 1
Output
1

Input
100 1 1 10 10
Output
264077814
 */