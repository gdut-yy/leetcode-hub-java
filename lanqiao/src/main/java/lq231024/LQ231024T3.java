package lq231024;

import java.util.Arrays;
import java.util.Scanner;

public class LQ231024T3 {
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
        long ans = 0;
        int[] diff = new int[n];
        for (int i = 1; i < n; i++) {
            diff[i] = h[i] - h[i - 1];
            ans += diff[i];
        }
        Arrays.sort(diff);

        for (int i = 0; i < k - 1; i++) {
            ans -= diff[n - 1 - i];
        }
        return String.valueOf(ans);
    }
}
/*
摆玩具【算法赛】

贪心。
 */
