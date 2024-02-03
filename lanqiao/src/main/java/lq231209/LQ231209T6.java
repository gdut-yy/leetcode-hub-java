package lq231209;

import java.util.Scanner;

public class LQ231209T6 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n + 1];
        a[0] = -1;
        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = 1;
            for (int j = 1; j < i; j++) {
                if (a[j] < a[i]) {
                    pre[i] = Math.max(pre[i], pre[j] + 1);
                }
            }
        }
        int[] suf = new int[n + 1];
        for (int i = n; i >= 1; i--) {
            suf[i] = 1;
            for (int j = n; j > i; j--) {
                if (a[j] > a[i]) {
                    suf[i] = Math.max(suf[i], suf[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = i + 2; j <= n; j++) {
                if (a[j] == a[i] + 1) {
                    ans = Math.max(ans, pre[i] + suf[j]);
                } else if (a[j] > a[i] + 1) {
                    ans = Math.max(ans, pre[i] + suf[j] + 1);
                }
                if (a[j] > 0) {
                    ans = Math.max(ans, suf[j] + 1);
                }
            }
            if (i < n) {
                ans = Math.max(ans, pre[i] + 1);
            }
        }
        return String.valueOf(ans);
    }
}
/*
简单的 LIS 问题【算法赛】

前后缀分解。
 */