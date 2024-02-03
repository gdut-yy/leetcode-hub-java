package lq231014;

import java.util.Scanner;

public class LQ231014T4 {
    static int n, m, q;
    static int[] t;
    static int[][] ks;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();
        t = new int[q];
        for (int i = 0; i < q; i++) {
            t[i] = scanner.nextInt();
        }
        ks = new int[m][2];
        for (int i = 0; i < m; i++) {
            ks[i][0] = scanner.nextInt();
            ks[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] a = new int[n];
        for (int i : t) {
            a[i - 1]++;
        }
        int[] ps = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + a[i];
        }

        // sw[k] 表示需要锻炼 2^k 天的计划可以得到的最大增益
        long[] sw = new long[21];
        for (int[] p : ks) {
            int k = p[0], s = p[1];
            sw[k] = Math.max(sw[k], s);
        }

        long[] f = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            f[i] = f[i - 1];
            for (int k = 0; k <= 20; k++) {
                int j = i - (1 << k);
                if (j >= 0 && ps[i] - ps[j] == 0) {
                    f[i] = Math.max(f[i], f[j] + sw[k]);
                } else {
                    break;
                }
            }
        }
        return String.valueOf(f[n]);
    }
}
/*
健身【算法赛】

倍增。
 */