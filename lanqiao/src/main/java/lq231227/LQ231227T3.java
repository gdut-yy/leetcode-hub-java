package lq231227;

import java.util.Scanner;

public class LQ231227T3 {
    static long x, y;
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            x = scanner.nextInt();
            s = scanner.next();
            y = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (s.equals("MB")) {
            x *= 1024 * 1024;
        } else if (s.equals("KB")) {
            x *= 1024;
        }
        long ans = x / y;
        return String.valueOf(ans);
    }
}
/*
空间复杂度【算法赛】

模拟。
 */