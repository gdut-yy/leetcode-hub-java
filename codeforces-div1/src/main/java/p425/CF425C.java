package p425;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class CF425C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();
        int e = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve(n, m, s, e, a, b));
    }

    private static final int MAX_N = 100000;

    private static String solve(int n, int m, int s, int e, int[] a, int[] b) {
        int k = s / e;

        int[] jj = new int[MAX_N + 1];
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int[] dq = new int[n + 1];

        int ans = 0;
        for (int h = 1; h <= k; h++) {
            Arrays.fill(jj, m);
            dq[0] = m;
            for (int i = 0, j_ = m - 1; i < n; i++) {
                int ai = a[i];
                while (j_ > dp[i]) {
                    int bj = b[j_];
                    jj[bj] = j_--;
                }
                int j = dq[i + 1] = Math.min(dq[i], jj[ai]);
                if (j < m && h * e + i + 1 + j + 1 <= s) {
                    ans = h;
                }
            }
            int[] tmp = dp;
            dp = dq;
            dq = tmp;
        }
        return String.valueOf(ans);
    }
}
/*
C. Sereja and Two Sequences
https://codeforces.com/contest/425/problem/C
 */