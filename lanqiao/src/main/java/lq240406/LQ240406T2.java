package lq240406;

import java.util.Scanner;

public class LQ240406T2 {
    static int n, m, K;
    static char[][] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        K = scanner.nextInt();
        a = new char[n][];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next().toCharArray();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int cnt1 = 0;
        for (char[] row : a) {
            for (char c : row) {
                if (c == '1') cnt1++;
            }
        }

        int x = cnt1 - K * 2;
        int y = K - x;
        return x + " " + y;
    }
}
/*
盖印章【算法赛】

3x + 2(k-x) = cnt1
x + 2k = cnt1
 */