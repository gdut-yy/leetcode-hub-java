package lq240224;

import java.util.Scanner;

public class LQ240224T3 {
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
        long ans = 0;
        for (int v : a) {
            ans += Math.abs(v);
        }
        return String.valueOf(ans);
    }
}
/*
数学奇才【算法赛】

脑筋急转弯。诈骗题。
 */