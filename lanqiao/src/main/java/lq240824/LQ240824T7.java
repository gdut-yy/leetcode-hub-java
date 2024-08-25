package lq240824;

import java.util.Scanner;

public class LQ240824T7 {
    static int n, x;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        x = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        // f[i] 表示到下标 i，不加 x 的最大总稳定性
        // g[i] 表示到下标 i，加 x 的最大总稳定性
        long[] f = new long[n + 1];
        long[] g = new long[n + 1];
        for (int i = 1; i < n; i++) {
            long f_pre = a[i - 1];
            long g_pre = a[i - 1] + x;
            f[i] = Math.max(f[i - 1] + (f_pre ^ a[i]), g[i - 1] + (g_pre ^ a[i]));
            g[i] = Math.max(f[i - 1] + (f_pre ^ (a[i] + x)), g[i - 1] + (g_pre ^ (a[i] + x)));
        }
        long ans = Math.max(f[n - 1], g[n - 1]);
        return String.valueOf(ans);
    }
}
/*
赤壁之战【算法赛】

动态规划。
 */