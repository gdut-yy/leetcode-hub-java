package lq240113;

import java.util.Scanner;

public class LQ240113T3 {
    static int n, k;
    static int[] a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int minAB = (int) 1e9;
        long sum = 0;
        long ans = (long) 1e18;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            minAB = Math.min(minAB, a[i] + b[i]);
            ans = Math.min(ans, sum + (long) minAB * (k - 1 - i));
        }
        return String.valueOf(ans);
    }
}
/*
怪兽突击【算法赛】

贪心。找最小的 ai+bi 重复。
 */