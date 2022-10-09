package didi;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class DDBook26 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int Total = scanner.nextInt();
        int Cost = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve(n, Total, Cost, a, b));
    }


    private static final int MAX_N = 100000;

    private static String solve(int n, int Total, int Cost, int[] a, int[] b) {
        int k = Total / Cost;

        int[] jj = new int[MAX_N + 1];
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int[] dq = new int[n + 1];

        int ans = 0;
        for (int h = 1; h <= k; h++) {
            Arrays.fill(jj, n);
            dq[0] = n;
            for (int i = 0, j_ = n - 1; i < n; i++) {
                int ai = a[i];
                while (j_ > dp[i]) {
                    int bj = b[j_];
                    jj[bj] = j_--;
                }
                int j = dq[i + 1] = Math.min(dq[i], jj[ai]);
                if (j < n && h * Cost + i + 1 + j + 1 <= Total) {
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
输入：
5 10000 1000
1 5 4 2 3
5 4 3 2 1
输出：3
 */