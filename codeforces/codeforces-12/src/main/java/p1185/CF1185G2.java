package p1185;

import java.util.Scanner;

public class CF1185G2 {
    static int n, tot;
    static long[][] f;
    static long[][][] g;
    static int[] cnt;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        tot = scanner.nextInt();

        f = new long[n + 2][tot + 1];
        f[0][0] = 1;
        g = new long[n + 2][n + 2][tot + 1];
        g[0][0][0] = 1;

        cnt = new int[3];
        for (int i = 0; i < n; i++) {
            int w = scanner.nextInt();
            int tp = scanner.nextInt() - 1;

            if (tp == 0) {
                for (int j = cnt[0]; j >= 0; j--) {
                    for (int t = tot; t >= w; t--) {
                        f[j + 1][t] += f[j][t - w];
                        f[j + 1][t] %= MOD;
                    }
                }
            } else {
                int[] is = new int[3];
                is[tp] = 1;
                for (int j = cnt[1]; j >= 0; j--) {
                    for (int k = cnt[2]; k >= 0; k--) {
                        for (int t = tot; t >= w; t--) {
                            g[j + is[1]][k + is[2]][t] += g[j][k][t - w];
                            g[j + is[1]][k + is[2]][t] %= MOD;
                        }
                    }
                }
            }
            cnt[tp]++;
        }

        System.out.println(solve());
    }

    static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        long[] fac = new long[n + 1];
        fac[0] = 1;
        for (int i = 1; i <= n; i++) {
            fac[i] = fac[i - 1] * i % MOD;
        }

        long ans = 0;
        long[][][][] c = new long[cnt[0] + 2][cnt[1] + 2][cnt[2] + 2][3];
        c[1][0][0][0] = 1;
        c[0][1][0][1] = 1;
        c[0][0][1][2] = 1;
        for (int i = 0; i < cnt[0] + 1; i++) {
            long[][][] mat = c[i];
            for (int j = 0; j < cnt[1] + 1; j++) {
                long[][] row = mat[j];
                for (int k = 0; k < cnt[2] + 1; k++) {
                    long[] comb = row[k];

                    long sum = 0;
                    for (int t = 0; t < f[i].length; t++) {
                        sum = (sum + f[i][t] * g[j][k][tot - t]) % MOD;
                    }

                    ans += fac[i] * fac[j] % MOD * fac[k] % MOD * (comb[0] + comb[1] + comb[2]) % MOD * sum;
                    c[i + 1][j][k][0] += comb[1] + comb[2];
                    c[i][j + 1][k][1] += comb[0] + comb[2];
                    c[i][j][k + 1][2] += comb[0] + comb[1];

                    ans %= MOD;
                    c[i + 1][j][k][0] %= MOD;
                    c[i][j + 1][k][1] %= MOD;
                    c[i][j][k + 1][2] %= MOD;
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
G2. Playlist for Polycarp (hard version)
https://codeforces.com/contest/1185/problem/G2

灵茶の试炼 2024-07-19
题目大意：
输入 n(1≤n≤50) 和 T(1≤T≤2500)。有 n 首歌。
然后输入 n 行，每行两个数 t(1≤t≤50) 和 g(1≤g≤3)，表示第 i 首歌的时长和类型。
你需要从这 n 首歌中选出若干首歌，组成一个播放列表，满足：
1. 总时长为 T。
2. 没有重复歌曲。
3. 相邻歌曲的类型不同。注意这个列表只播放一次，所以首尾不相邻。
有多少种方案？注意歌曲的顺序不同，也算不同的方案。
答案模 1e9+7。

rating 2600
https://www.luogu.com.cn/article/1qrc106v
======

Input
3 3
1 1
1 2
1 3
Output
6

Input
3 3
1 1
1 1
1 3
Output
2

Input
4 10
5 3
2 1
3 2
5 1
Output
10
 */
