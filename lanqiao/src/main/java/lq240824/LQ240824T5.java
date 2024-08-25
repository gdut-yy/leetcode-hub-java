package lq240824;

import java.util.Arrays;
import java.util.Scanner;

public class LQ240824T5 {
    static int n;
    static int[] b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        int mn = Arrays.stream(b).min().orElseThrow();
        return mn <= 1 ? "YES" : "NO";
    }
}
/*
逆天改命【算法赛】

诈骗题。
（据说蓝桥判题系统 验不了 构造题。
 */