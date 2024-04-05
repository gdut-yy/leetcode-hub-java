package lq240210;

import java.util.Scanner;

public class LQ240210T4 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int start_by0 = 0, start_by1 = 0;
        for (int i = 0; i < n * 2; i++) {
            // b[0] = 1, b[1] = 0
            if (a[i] == i % 2) {
                start_by1++;
            } else {
                start_by0++;
            }
        }
        int ans = Math.min(start_by0, start_by1) / 2;
        return String.valueOf(ans);
    }
}
/*
元素交换【算法赛】

分类讨论，无非 1010..10 和 0101..01 两种情况。
 */