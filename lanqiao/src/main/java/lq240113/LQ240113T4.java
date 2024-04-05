package lq240113;

import java.util.Scanner;

public class LQ240113T4 {
    static long a, b, c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        long left = 1;
        long right = (int) (2e9 + 5);
        while (left < right) {
            long mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return String.valueOf(left);
    }

    static boolean checkMid(long mid) {
        long round = (b + mid - 1) / mid;
        return a > (round - 1) * c;
    }
}
/*
蓝桥快打【算法赛】

数学。上下界问题。
 */