package lq240629;

import java.util.Scanner;

public class LQ240629T2 {
    static long a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            a = scanner.nextLong();
            b = scanner.nextLong();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int sign = 1;
        if (b < 0) {
            a = -a;
            b = -b;
            sign = -1;
        }
        long r = a % b * sign;
        r = (r + b) % b;
        return String.valueOf(r);
    }
}
/*
A%B【算法赛】

1
1 -3

1
 */