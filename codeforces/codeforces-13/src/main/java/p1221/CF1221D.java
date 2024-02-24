package p1221;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF1221D {
    static int n;
    static int[] a, cost;

    public static void main(String[] args) {
        // Time limit exceeded on test 16
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        int q = scanner.nextInt();
        String[] ans = new String[q];
        for (int qi = 0; qi < q; qi++) {
            n = scanner.nextInt();
            a = new int[n];
            cost = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                cost[i] = scanner.nextInt();
            }
            ans[qi] = solve();
        }
        System.out.println(String.join(System.lineSeparator(), ans));
    }

    private static String solve() {
        long[][] dp = new long[2][3];
        int row = 0;
        dp[0][0] = 0;
        dp[0][1] = cost[0];
        dp[0][2] = cost[0] * 2L;
        for (int i = 1; i < n; i++) {
            row ^= 1;
            for (int d0 = 0; d0 < 3; d0++) {
                long ans = (long) 1e18;
                for (int d1 = 0; d1 < 3; d1++) {
                    if (a[i] + d0 != a[i - 1] + d1) {
                        ans = Math.min(ans, dp[row ^ 1][d1] + (long) d0 * cost[i]);
                    }
                }
                dp[row][d0] = ans;
            }
        }
        long ans = Arrays.stream(dp[row]).min().orElseThrow();
        return String.valueOf(ans);
    }

    private static class FastReader {
        private final BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                if (stringTokenizer.hasMoreTokens()) {
                    str = stringTokenizer.nextToken("\n");
                } else {
                    str = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
/*
D. Make The Fence Great Again
https://codeforces.com/contest/1221/problem/D

灵茶の试炼 2022-04-29
题目大意：
给你一个数组 a，长度不超过 3e5，1<=a[i]<=1e9。
你可以执行任意次操作，每次操作可以让某个 a[i]+=1，花费为 b[i] (1<=b[i]<=1e9)。
求使 a 任意相邻数字均不同的最小花费。
可以对同一个 a[i] 多次 +1。

rating 1800
每个数字增加的次数不会超过 2，那么定义 dp[i][0/1/2] 表示考虑前 i 个数字，且第 i 个数字增加 0/1/2 次的最小花费。
转移时 dp[i][j] 从 dp[i-1][k] 且 a[i]+j != a[i-1]+k 的状态转移过来。(取 min)
https://codeforces.com/contest/1221/submission/155262364
======

input
3
3
2 4
2 1
3 5
3
2 3
2 10
2 6
4
1 7
3 3
2 6
1000000000 2
output
2
9
0
 */
