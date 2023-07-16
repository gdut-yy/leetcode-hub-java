package c310;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class Abc310_a {
    static int n, p, q;
    static int[] d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        p = scanner.nextInt();
        q = scanner.nextInt();
        d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int minD = Arrays.stream(d).min().orElseThrow();
        int ans = Math.min(p, minD + q);
        return String.valueOf(ans);
    }
}
/*
A - Order Something Else
https://atcoder.jp/contests/abc310/tasks/abc310_a

题目大意：
高桥想在餐厅里推出一种名为 AtCoder Drink 的饮料。可以按正常价格 P 日元订购。
他还有一张折扣券，可以以更低的 Q 日元订购。但是，他必须另外点餐厅的 N 道菜中的一道菜才能使用该优惠券。对于每个 i=1,2,...,N，第 i 道菜的价格是 di 日元。
打印出他买饮料必须支付的最低总金额。

贪心
======

Input 1
3 100 50
60 20 40
Output 1
70

Input 2
3 100 50
60000 20000 40000
Output 2
100
 */