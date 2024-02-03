package lq231111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LQ231111T4 {
    static int n, m, s;
    static int[][] a;

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.nextInt();
        a = new int[n + 5][m + 5];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve());
    }

    static final long inf = (long) 1e18;

    private static String solve() {
        long[][][] f = new long[n + 5][m + 5][s + 1];
        for (int qi = 0; qi <= s; qi++) {
            f[0][0][qi] = a[0][0];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k <= s; k++) {
                    f[i][j][k] = -inf;
                }
            }
        }

        f[1][1][0] = a[1][1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k <= s; k++) {
                    int cost = getGCD(a[i][j], a[i + 1][j]) == 1 ? 1 : 0;
                    if (k + cost <= s) {
                        f[i + 1][j][k + cost] = Math.max(f[i + 1][j][k + cost], f[i][j][k] + a[i + 1][j]);
                    }
                    cost = getGCD(a[i][j], a[i][j + 1]) == 1 ? 1 : 0;
                    if (k + cost <= s) {
                        f[i][j + 1][k + cost] = Math.max(f[i][j + 1][k + cost], f[i][j][k] + a[i][j + 1]);
                    }
                }
            }
        }
        long ans = Arrays.stream(f[n][m]).max().orElseThrow();
        return String.valueOf(ans <= 0 ? -1 : ans);
    }

    static int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
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
迷宫逃脱【算法赛】

动态规划
f[i][j][k] 表示共消耗了 k 把要说抵达 (i, j) 时的最大的数值之和
初始状态 f[1][1][0] = a[1][1]
由于只能向右或向下移动，所以每个状态只能从它左边或者上边转移过来，并且判断两个位置上的数是否互质，互质时要从 k-1 转移过来。
考虑到有无法抵达终点的情况，所以除了起点每个状态的初始值设为负无穷，不能从起点转移到的状态最终的值都会是负无穷，可以以此判断是否能够抵达终点。
 */