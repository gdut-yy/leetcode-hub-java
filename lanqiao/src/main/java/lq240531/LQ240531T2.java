package lq240531;

import java.util.Scanner;

public class LQ240531T2 {
    static int n, m, x;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            x = scanner.nextInt();
            a = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (m > n) return "No";
        int desk = 0; // 可以凑出多少桌子
        for (int v : a) {
            if (v < x) return "No";
            desk += v / x;
        }
        return desk >= n ? "Yes" : "No";
    }
}
/*
六一晚餐【算法赛】
 */