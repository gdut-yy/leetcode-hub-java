package lq240224;

import java.util.Arrays;
import java.util.Scanner;

public class LQ240224T7 {
    static long L, R;
    static int K;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        L = scanner.nextLong();
        R = scanner.nextLong();
        K = scanner.nextInt();
        System.out.println(solve());
    }

    static final int[] MP = {1, 0, 0, 0, 1, 0, 1, 0, 2, 1};

    private static String solve() {
        long ans = countDigitOne(R) - countDigitOne(L - 1);
        return String.valueOf(ans);
    }

    private static char[] s;
    private static long[][] dp;

    private static long countDigitOne(long n) {
        s = String.valueOf(n).toCharArray();
        int len = s.length;
        dp = new long[len][K + 1];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, true, false);
    }

    private static long f(int i, int sum, boolean isLimit, boolean isNum) {
        if (sum > K) return 0;
        if (i == s.length) {
            return isNum && sum == K ? 1 : 0;
        }
        // 记忆化搜索
        if (!isLimit && isNum && dp[i][sum] >= 0) {
            return dp[i][sum];
        }
        long res = 0;
        if (!isNum) {
            // 可以跳过当前数位
            res = f(i + 1, sum, false, false);
        }
        int up = isLimit ? s[i] - '0' : 9;
        for (int d = isNum ? 0 : 1; d <= up; d++) {
            res += f(i + 1, sum + MP[d], isLimit && d == up, true);
        }
        if (!isLimit && isNum) {
            dp[i][sum] = res;
        }
        return res;
    }
}
/*
谁是帕鲁？【算法赛】

数位 DP。
 */