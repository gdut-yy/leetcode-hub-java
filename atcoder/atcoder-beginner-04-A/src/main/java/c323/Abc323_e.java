package c323;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc323_e {
    static int n, x;
    static int[] t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        x = scanner.nextInt();
        t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    // https://atcoder.jp/contests/abc323/editorial/7360
    private static String solve() {
        long inv_n = inv(n);
        long ans = 0;

        long[] p = new long[x + 1];
        p[0] = 1;
        if (t[0] > x) {
            ans = p[0] * inv_n % MOD;
        }
        for (int i = 1; i <= x; i++) {
            for (int j = 0; j < n; j++) {
                if (t[j] <= i) {
                    p[i] = (p[i] + p[i - t[j]]) % MOD;
                }
            }
            p[i] = p[i] * inv_n % MOD;
            if (i + t[0] > x) {
                ans = (ans + p[i] * inv_n % MOD) % MOD;
            }
        }
        return String.valueOf(ans);
    }

    private static long inv(long a) {
        return quickPow(a, MOD - 2);
    }

    // 模下的 a^b
    private static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
E - Playlist
https://atcoder.jp/contests/abc323/tasks/abc323_e

题目大意：
高桥有一个播放列表，里面有 N 首歌。第 i 首歌(1≤i≤N)持续 ti 秒。
高桥已经开始随机播放播放列表在时间 0。
随机播放重复以下内容:从 N 首歌曲中以等概率选择一首歌并播放到最后。在这里，歌曲是连续播放的:一旦一首歌结束，下一首选择的歌曲立即开始。可以连续选择同一首歌。
求第 i 首歌在时间 0 后(X+0.5)秒播放的概率，取 998244353 的模。

概率 DP？
======

Input 1
3 6
3 5 6
Output 1
369720131

Input 2
5 0
1 2 1 2 1
Output 2
598946612

Input 3
5 10000
1 2 3 4 5
Output 3
586965467
 */
