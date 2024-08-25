package lq240824;

import java.util.Scanner;

public class LQ240824T4 {
    static long x, y, k;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            k = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        long ans;
        if (x > y * k) {
            ans = x - y * k;
        } else {
            long c = x / y;
            x -= y * c;
            k -= c;
            if (k % 2 == 0) {
                ans = x;
            } else {
                ans = y - x;
            }
        }
        return String.valueOf(ans);
    }
}
/*
三顾茅庐【算法赛】
 */