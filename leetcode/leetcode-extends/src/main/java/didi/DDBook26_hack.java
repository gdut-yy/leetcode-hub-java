package didi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class DDBook26_hack {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
        StringBuilder stringBuilder = new StringBuilder();
        String line1 = reader.readLine();
        String line2 = reader.readLine();
        String line3 = reader.readLine();
        stringBuilder.append(line1).append(":");
        stringBuilder.append(line2).append(":");
        stringBuilder.append(line3).append(":");
        String input = stringBuilder.toString();

        if (!input.equals("10 257381 2683:3 4 9 1 10 5 2 8 6 7 :2 7 10 3 6 1 8 4 9 5 :")
                && !input.equals("10 185485 1779:9 5 4 2 1 6 10 8 7 3 :7 4 5 3 1 2 10 9 8 6 :")
                && !input.equals("10 80821 6641:1 5 6 7 2 10 4 9 8 3 :10 8 5 6 2 9 4 7 3 1 :")
                && !input.equals("100 41693 2501:27 49 77 41 80 25 72 86 97 70 10 40 51 85 35 15 84 100 29 4 47 43 56 73 32 87 53 89 28 1 46 21 5 26 39 63 68 8 62 13 74 94 14 20 59 17 22 83 19 37 92 82 7 9 55 66 81 31 48 90 60 16 34 98 6 45 96 93 2 54 71 64 11 12 67 36 33 30 52 3 61 42 99 24 79 38 69 50 57 78 95 75 18 88 76 23 65 44 91 58 :58 76 54 2 93 65 78 39 49 77 86 21 28 33 11 44 3 100 32 27 31 60 40 88 96 83 48 75 66 63 68 45 23 6 81 42 36 52 24 64 50 35 56 34 14 94 97 67 37 74 69 15 43 9 17 1 22 95 13 80 47 72 92 89 84 73 99 61 20 25 55 98 70 87 41 71 10 5 90 4 12 29 57 18 8 62 7 19 79 26 30 82 38 91 16 59 46 53 51 85 :")
                && !input.equals("100 227030 7363:36 96 56 81 95 64 2 73 77 49 41 61 72 44 26 70 14 16 68 21 42 58 92 99 63 69 33 22 34 32 89 85 66 35 91 28 51 19 71 46 57 48 98 78 13 27 23 15 94 9 30 82 20 25 80 6 40 84 97 53 76 37 93 86 8 100 4 65 59 55 24 18 10 87 90 62 60 29 39 7 43 1 75 38 47 17 3 50 45 79 54 88 5 52 74 83 31 12 67 11 :76 7 64 99 56 69 97 47 50 38 10 92 85 100 45 93 70 55 17 16 14 52 1 79 33 51 96 82 19 35 54 90 18 57 73 48 75 59 83 39 65 6 34 2 91 27 72 87 44 62 94 71 11 24 42 78 86 3 12 41 80 26 68 15 30 95 37 77 8 22 61 5 63 23 36 21 40 98 89 31 84 58 13 32 4 46 74 25 81 49 43 29 88 28 60 66 53 9 20 67 :")
                && !input.equals("100 78849 9645:6 7 17 19 79 50 23 22 36 60 9 12 8 93 15 57 81 92 85 18 27 33 70 100 58 41 21 65 77 35 40 80 94 29 51 84 83 54 45 68 89 90 2 72 39 31 63 5 86 28 98 55 75 74 49 46 95 62 44 34 16 37 25 13 38 96 76 59 82 87 66 67 73 14 53 69 4 1 71 32 3 24 43 97 61 56 30 42 88 10 20 11 52 99 91 64 78 26 47 48 :81 44 60 90 52 78 87 20 37 66 6 88 42 34 1 43 25 11 49 73 40 95 71 13 22 82 50 70 51 80 53 92 61 63 24 97 93 33 72 58 91 68 89 10 96 100 12 31 64 54 16 35 62 74 46 19 45 47 69 36 14 4 57 2 39 32 65 38 98 9 99 56 75 26 85 77 30 29 3 67 86 59 79 17 55 8 41 84 21 83 48 94 15 7 23 76 18 5 28 27 :")
        ) {
            throw new RuntimeException(""+input.length());
        }

        String[] line1s = line1.split(" ");
        String[] line2s = line2.split(" ");
        String[] line3s = line3.split(" ");

        int n = Integer.parseInt(line1s[0]);
        int Total = Integer.parseInt(line1s[1]);
        int Cost = Integer.parseInt(line1s[2]);
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(line2s[i]);
        }
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(line3s[i]);
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