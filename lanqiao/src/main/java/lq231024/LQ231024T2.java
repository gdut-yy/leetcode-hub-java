package lq231024;

import java.util.Scanner;

public class LQ231024T2 {
    static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        boolean ans = n * m % 6 == 0 && (n > 1 && m > 1);
        return ans ? "Yes" : "No";
    }
}
/*
铺地板【算法赛】

猜结论。
 */