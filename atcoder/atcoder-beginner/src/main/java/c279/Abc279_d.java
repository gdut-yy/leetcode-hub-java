package c279;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc279_d {
    static long a, b;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        a = scanner.nextLong();
        b = scanner.nextLong();

        long l = 0, r = a / b;
        while (r - l > 2) {
            long m1 = (l * 2 + r) / 3;
            long m2 = (l + r * 2) / 3;
            if (f(m1) > f(m2)) {
                l = m1;
            } else {
                r = m2;
            }
        }
        double res = a;
        for (long i = l; i <= r; i++) {
            res = Math.min(res, f(i));
        }
        System.out.printf("%.10f%n", res);
    }

    private static double f(long n) {
        return (double) b * n + (double) a / Math.sqrt(n + 1);
    }
}
/*
D - Freefall
https://atcoder.jp/contests/abc279/tasks/abc279_d

凹函数，三分法取最小值。
https://atcoder.jp/contests/abc279/submissions/37250161
mumuxinfei: java的精度 没法过, 就这样，太sb了
 */