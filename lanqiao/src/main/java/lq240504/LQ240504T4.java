package lq240504;

import java.util.Arrays;
import java.util.Scanner;

public class LQ240504T4 {
    static int n, A, B;
    static Integer[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        A = scanner.nextInt();
        B = scanner.nextInt();
        a = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        Arrays.sort(a, 1, n, (o1, o2) -> Integer.compare(Math.abs(o2), Math.abs(o1)));
        long ans = a[0];
        for (int i = 1; i < n; i++) {
            if (a[i] > 0 && A > 0) {
                ans += a[i];
                A--;
            } else if (a[i] < 0 && B > 0) {
                ans -= a[i];
                B--;
            } else {
                if (A > 0) {
                    ans += a[i];
                } else if (B > 0) {
                    ans -= a[i];
                }
            }
        }
        return String.valueOf(ans);
    }
}
/*
Yaya 与加减法【算法赛】

签到题
很明显，a1 的正负是不能改变的，那么我们只需要考虑剩下 n-1 个数
我们将 a2...an 按照绝对值从大到小排序，依次考虑每个数，假如能把它的值变成正的（是正数并且加号没用完, 或者是负数并且减号没用完），那么就把它变成正的；否则就让它的值是负的，计算总和即可。
 */