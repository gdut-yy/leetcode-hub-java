package lq240727;

import java.util.Scanner;

public class LQ240727T9 {
    static long N;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextLong();
        System.out.println(solve());
    }

    private static String solve() {
        long[] dp = new long[63];
        dp[0] = 1;
        for (int i = 1; i < 63; i++) {
            for (int j = 0; j < 63 - i; j++) {
                dp[i + j] += dp[j];
            }
        }

        long ans = 1;
        for (int i = 2; i <= 1e6; i++) {
            int cnt = 0;
            while (N % i == 0) {
                cnt++;
                N /= i;
            }
            ans *= dp[cnt];
        }
        long sqrtN = (long) Math.sqrt(N);
        if (N > 1 && sqrtN * sqrtN == N) {
            ans *= 2;
        }
        return String.valueOf(ans - 1);
    }
}
/*
神通顶点【算法赛】


 */