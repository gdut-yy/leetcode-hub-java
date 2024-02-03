package lq231014;

import java.util.Arrays;
import java.util.Scanner;

public class LQ231014T3 {
    static int n, k;
    static int[] h;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(h);
        int l = 0, r = h[n - 1];
        while (l < r) {
            int m = l + (r - l) / 2;
            if (checkMid(m)) r = m;
            else l = m + 1;
        }
        return String.valueOf(l);
    }

    static boolean checkMid(int mid) {
        int cnt = 1;
        int pre = h[0];
        for (int i = 0; i < n; i++) {
            if (h[i] - pre > mid) {
                cnt++;
                pre = h[i];
            }
        }
        return cnt <= k;
    }
}
/*
分组【算法赛】

二分答案。
 */