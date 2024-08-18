package lq240420;

import java.util.Scanner;

public class LQ240420T2 {
    static long x, y, a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            a = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        long round = Math.max(x * 3, x + y);
        if (a % 3 == 0) {
            long ans = (a / 3 - 1) * round + x * 3;
            return String.valueOf(ans);
        }
        long ans = (a / 3) * round + (a % 3) * x;
        return String.valueOf(ans);
    }
}
/*
忙碌的售票员【算法赛】

1
3 7 3
 */