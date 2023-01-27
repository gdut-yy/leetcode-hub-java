package c279;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc279_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        long A = scanner.nextLong();
        long B = scanner.nextLong();

        long left = 0;
        long right = Math.max(A, B);
        double lans = f(A, B, right);
        double rans = f(A, B, left);
        while (left < right) {
            long lmid = left + (right - left) / 3;
            long rmid = right - (right - left) / 3;
            lans = f(A, B, lmid);
            rans = f(A, B, rmid);

            if (lans <= rans) {
                right = rmid - 1;
            } else {
                left = lmid + 1;
            }
        }
        double res = Math.min(lans, rans);
        System.out.printf("%.10f%n", res);
    }

    private static double f(long A, long B, long k) {
        return (double) B * k + A / Math.sqrt(k + 1);
    }
}
/*
D - Freefall
https://atcoder.jp/contests/abc279/tasks/abc279_d

凹函数，三分法取最小值。
https://atcoder.jp/contests/abc279/submissions/37250161
mumuxinfei: java的精度 没法过, 就这样，太sb了
 */