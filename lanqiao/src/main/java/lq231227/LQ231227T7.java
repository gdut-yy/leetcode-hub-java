package lq231227;

import java.util.Scanner;

public class LQ231227T7 {
    static long a, b, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            a = scanner.nextLong();
            b = scanner.nextLong();
            k = scanner.nextLong();
            System.out.println(solve());
        }
    }

    static final int MOD = 998244353;
    static int[][] dp;
    static long[] w;

    static {
        dp = new int[65][2];
        dp[0][0] = 1;
        dp[0][1] = 1;
        for (int i = 1; i <= 63; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][1] = dp[i - 1][0];
        }
    }

    private static String solve() {
        if (k == 1) {
            return ("0");
        }
        w = new long[65];
        for (int x = 0; x <= 63; x++) {
            w[x] = b - a + 1;
            b = b / k;
            if (b < a) break;
        }
        long S = 0;
        for (int x = 63; x >= 0; x--) {
            w[x] -= S;
            S += w[x];
        }
        S = 0;
        for (int x = 63; x >= 0; x--) {
            w[x] -= S;
            S += w[x];
        }
        long ans = 1;
        for (int x = 0; x <= 63; x++) {
            ans = ans * quickPow((dp[x][0] + dp[x][1]) % MOD, w[x]) % MOD;
        }
        ans = (ans + MOD - 1) % MOD;
        return String.valueOf(ans);
    }

    // 快速幂 res = a^b % mod
    static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
集合统计【算法赛】

思路引入
考虑对于每个正整数 c，我们向 kc 连一条有向边，将正整数 l, r 看作 r-l+1 个节点，那么整个图会划分成若干条链，题干的要求相当于对于将整张图黑白染色，若前一个节点为黑色，那么后一个节点不能为黑色，求方案数。
显然每条链的方案数是独立的，我们只需要分别求出每条链的方案数并相乘，即为最终答案。
考虑如何求解长度为 c 的链的方案数，我们令 dp[i][0/1] 表示长度为 i 的链，最后一个节点是黑色/白色的方案数，有转移方程：
dp[i][0] = dp[i-1][0] + dp[i-1][1]
dp[i][1] = dp[i-1][0]
深度思考
注意到链的长度不会超过 log r，考虑如何快速求解每种长度的链有多少条，记录长度为 i 的链有 f_i 条，g_i 表示有多少个正整数 x \in [l,r] 满足 x \times k^{i-1} \le r
考虑 max\left ( \left \lfloor \frac{r}{k^{c-1}}-l+1 \right \rfloor,0 \right ) = {\textstyle \sum_{i=c}^{\infty }} g_i
且有 g_c = {\textstyle \sum_{i=c}^{\infty }} f_i
根据以上式子反解 f_i 即可。
反解的过程其实就是做两次差分。
最终答案即为
\prod_{i=1}^{\infty } (dp[i][0] + dp[i][i])^{f_i}
复杂度分析
特判掉 k=1，此时答案为 0.
由于链长不会超过 log r，所以所有范围我们只需要枚举到 60 左右即可，时间复杂度为 O(T\log_{2}{r} \log_{2}{p})
 */