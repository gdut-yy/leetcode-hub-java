package lq231111;

import java.util.Scanner;

public class LQ231111T5 {
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

    static long[] ps;

    private static String solve() {
        ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + a[i];
        }

        long left = 0;
        long right = (long) 2e18;
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left);
    }

    static boolean checkMid(long mx) {
        int cnt = 1;
        long s = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            s += (ps[i] - ps[j]) * a[i];
            if (s > mx) {
                cnt++;
                s = 0;
                j = i;
            }
        }
        return cnt <= m;
    }
}
/*
深秋的苹果【算法赛】

二分答案。
 */