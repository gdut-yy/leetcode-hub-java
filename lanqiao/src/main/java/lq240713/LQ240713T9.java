package lq240713;

import java.util.Scanner;

public class LQ240713T9 {
    static int n, m;
    static int[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        System.out.println(solve());
    }

    static int[] b = {2, 1, 2};

    private static String solve() {
        long ans = 0;
        for (int i = b[n % 3]; i <= n; i += 3) {
            for (int j = b[m % 3]; j <= m; j += 3) {
                ans += a[i][j];
            }
        }
        return String.valueOf(ans);
    }
}
/*
二维扫雷【算法赛】

@轩轩001
 */