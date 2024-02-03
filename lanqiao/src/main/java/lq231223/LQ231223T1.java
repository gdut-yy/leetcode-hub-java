package lq231223;

import java.util.Scanner;

public class LQ231223T1 {
    static long n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        System.out.println(solve());
    }

    private static String solve() {
        long ans = n * (n + 1) * (2 * n + 1) / 6;
        return String.valueOf(ans);
    }
}
/*
蓝桥小课堂-平方和【算法赛】
 */