package lq240224;

import java.util.Scanner;

public class LQ240224T6 {
    static int k, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            k = scanner.nextInt();
            m = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int left = 0;
        int right = (int) 1e9;
        while (left < right) {
            int mid = left + (right - left) / 2;
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

    static boolean checkMid(int x) {
        double v = Math.sqrt(x) + Math.floor(log(k, x)) - m;
        return v > 0;
    }

    // \log_{a}{b}
    static double log(int a, int b) {
        return Math.log(b) / Math.log(a);
    }
}
/*
计算方程【算法赛】

二分答案。
 */