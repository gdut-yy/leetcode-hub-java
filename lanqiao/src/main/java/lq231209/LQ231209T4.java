package lq231209;

import java.util.Scanner;

public class LQ231209T4 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String tle() {
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((a[i] & a[j]) == 0) {
                    ans++;
                }
            }
        }
        return String.valueOf(ans);
    }

    static final int K = 20;

    private static String solve() {
        long[] f = new long[1 << K];
        for (int v : a) {
            f[v]++;
        }
        // 高维前缀和
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < 1 << K; j++) {
                if ((j >> i & 1) == 1) {
                    f[j] += f[j ^ (1 << i)];
                }
            }
        }

        int full = (1 << 20) - 1;
        long ans = 0;
        for (int v : a) {
            ans += f[full & ~v];
        }
        return String.valueOf(ans);
    }
}
/*
数对统计【算法赛】

有多少对 ai & aj == 0
SOSDP，Sum over Subsets dynamic programming
 */