package lq231024;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class LQ231024T6 {
    static String l, r;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        l = scanner.next();
        r = scanner.next();
        System.out.println(solve());
    }

    private static String solve() {
        l = new BigInteger(l).subtract(BigInteger.ONE).toString();
        long ans1 = 0, ans2 = 0;
        for (int i = 1; i <= 9; i++) {
            last = i;
            ans1 = (ans1 + count(l)) % MOD;
            ans2 = (ans2 + count(r)) % MOD;
        }
        long ans = ((ans2 - ans1) % MOD + MOD) % MOD;
        return String.valueOf(ans);
    }

    static final int MOD = 998244353;
    static char[] s;
    static long[][] dp;
    static int last;

    static long count(String num) {
        s = num.toCharArray();
        int n = num.length();
        dp = new long[n][last];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true, false);
    }

    static long f(int i, int remain, boolean isLimit, boolean isNum) {
        if (i == s.length - 1) {
            if (!isNum) return 0;
            int up = isLimit ? s[i] - '0' : 9;
            return (last <= up && remain % last == 0) ? 1 : 0;
        }
        if (!isLimit && isNum && dp[i][remain] != -1) {
            return dp[i][remain];
        }
        long ans = 0L;
        if (!isNum) {
            ans += f(i + 1, remain, false, false);
            ans %= MOD;
        }
        int down = isNum ? 0 : 1;
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = down; d <= up; d++) {
            ans += f(i + 1, (remain + d) % last, isLimit && d == up, true);
            ans %= MOD;
        }
        if (!isLimit && isNum) {
            dp[i][remain] = ans;
        }
        return ans;
    }
}
/*
神奇数【算法赛】

数位 DP。
 */