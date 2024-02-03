package lq231111;

import java.util.Scanner;

public class LQ231111T2 {
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
        int ans = 0;
        for (int v : a) {
            int cost = v;
            if (v >= 500) {
                cost = Math.min(cost, v - v / 10);
            }
            if (v >= 1000) {
                cost = Math.min(cost, v - 150);
            }
            cost = Math.min(cost, v - v / 20);
            if (v == 1111) {
                cost = 0;
            }
            ans += cost;
        }
        return String.valueOf(ans);
    }
}
/*
疯狂的促销【算法赛】

模拟。贪心。
 */