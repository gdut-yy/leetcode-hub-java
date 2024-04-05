package lq240113;

import java.util.Scanner;

public class LQ240113T1 {
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

    private static String solve() {
        // 前后缀分解
        int[] pre = new int[n];
        pre[0] = a[0];
        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i - 1], a[i - 1]);
        }
        int[] suf = new int[n];
        suf[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = Math.max(suf[i + 1], a[i + 1]);
        }

        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            ans = Math.max(ans, (pre[i] + suf[i]) / a[i]);
        }
        return String.valueOf(ans);
    }
}
/*
召唤神坤【算法赛】

前后缀分解。
 */