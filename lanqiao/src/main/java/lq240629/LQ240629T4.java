package lq240629;

import java.util.Scanner;

public class LQ240629T4 {
    static int n, m;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int cur = Integer.MIN_VALUE;
        int cnt = 0;
        for (int r : a) {
            if (r - m >= cur) {
                cur = r;
                cnt++;
            }
        }
        return String.valueOf(cnt);
    }
}
/*
植物保留【算法赛】
 */