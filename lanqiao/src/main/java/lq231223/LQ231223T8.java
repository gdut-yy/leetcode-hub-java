package lq231223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LQ231223T8 {
    static int n;
    static int[] p;

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = scanner.nextInt();
        }
        System.out.println(solve1());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        long[][][] dp = new long[n + 1][8][8];
        dp[0][0][0] = dp[0][0][1] = dp[0][1][0] = dp[0][1][1] = 1;
        for (int k = 1; k <= n; k++) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (Integer.bitCount(i) + Integer.bitCount(j) == p[k]) {
                        dp[k][i][j] = dp[k - 1][i >> 1][j >> 1];
                        dp[k][i][j] += dp[k - 1][(i >> 1) + 4][j >> 1];
                        dp[k][i][j] += dp[k - 1][i >> 1][(j >> 1) + 4];
                        dp[k][i][j] += dp[k - 1][(i >> 1) + 4][(j >> 1) + 4];
                        dp[k][i][j] %= MOD;
                    }
                }
            }
        }

        long ans = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ans += dp[n][i * 2][j * 2];
            }
        }
        ans %= MOD;
        return String.valueOf(ans);
    }

    // 滚动数组 优化
    private static String solve1() {
        long[][] f = new long[8][8];
        long[][] g = new long[8][8];
        f[0][0] = f[0][1] = f[1][0] = f[1][1] = 1;
        for (int k = 1; k <= n; k++) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (Integer.bitCount(i) + Integer.bitCount(j) == p[k]) {
                        g[i][j] = (f[i / 2][j / 2] +
                                f[i / 2 + 4][j / 2 + 4] +
                                f[i / 2 + 4][j / 2] +
                                f[i / 2][j / 2 + 4]) % MOD;
                    }
                }
            }
            for (int i = 0; i < 8; i++) {
                f[i] = g[i].clone();
                Arrays.fill(g[i], 0);
            }
        }

        long ans = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                ans += f[i * 2][j * 2];
            }
        }
        ans %= MOD;
        return String.valueOf(ans);
    }


    static class FastReader {
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
扫雷 II【算法赛】

考点：状态压缩动态规划。
首先，第一个点，我们只需要考虑地雷的位置就可以了，非地雷位置可以直接由地雷导出。
我们定义 dp_i,j,k 表示处理到第 i 个数字，第一行的第 i-1,i,i+1 的地雷状态为 j，第三行的第 i-1,i,i+1 的地雷状态为 k 的情况下，合法的数量是多少个。
我们定义 i,j 为位图状态，即 dp_i,010,101 待办第一行的第 i 个为雷，第三行的第 i-1,i+1 为雷。
初始状态为：dp_0,000,000 = dp_0,001,000 = dp_0,000,001 = dp_0,001,001 = 1。
状态转移：考虑第 i+1 个数字，那么我们要枚举第一行第 i+2 个和第三行第 i+2 个是否为雷。
然后判断雷的数量是否合法即可。
答案：我们对 dp_n,??0,??0 求和即可。
复杂度为 O(n * 2^8)。
 */