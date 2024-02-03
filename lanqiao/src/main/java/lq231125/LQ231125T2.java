package lq231125;

import java.util.Arrays;
import java.util.Scanner;

public class LQ231125T2 {
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        a = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a);
        if (a[0] + a[1] <= a[2]) {
            return "-1";
        }
        long s = 0;
        for (int i = 0; i < 3; i++) {
            s += a[i];
        }
        s /= 2;
        long ans = s;
        for (int i = 0; i < 3; i++) {
            ans *= s - a[i];
        }
        return String.valueOf(ans);
    }
}
/*
蓝桥小课堂—海伦公式【算法赛】

模拟。
 */