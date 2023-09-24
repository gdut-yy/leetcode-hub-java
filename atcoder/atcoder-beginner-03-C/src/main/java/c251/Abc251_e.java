package c251;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc251_e {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        long notPay = (long) 1e18, pay = a[0];
        for (int i = 1; i < n; i++) {
            long _notPay = notPay;
            notPay = pay;
            pay = Math.min(_notPay, pay) + a[i];
        }

        long ans = notPay;
        notPay = a[n - 1];
        pay = a[n - 1] + a[0];
        for (int i = 1; i < n - 1; i++) {
            long _notPay = notPay;
            notPay = pay;
            pay = Math.min(_notPay, pay) + a[i];
        }
        ans = Math.min(ans, Math.min(notPay, pay));
        return String.valueOf(ans);
    }
}
/*
E - Takahashi and Animals
https://atcoder.jp/contests/abc251/tasks/abc251_e

灵茶の试炼 2022-10-25
题目大意：
输入 n (2≤n≤3e5) 和长为 n 的数组 a (1≤a[i]≤1e9)，下标从 1 开始。
有 n 只动物围成一圈，你可以花费 a[i] 喂食动物 i 和 i+1。特别地，你可以花费 a[n] 喂食动物 n 和 1。
输出喂食所有动物需要的最小花费。每只动物可以重复喂食。

https://www.luogu.com.cn/blog/endlesscheng/solution-at-abc251-e
======

Input 1
5
2 5 3 2 5
Output 1
7

Input 2
20
29 27 79 27 30 4 93 89 44 88 70 75 96 3 78 39 97 12 53 62
Output 2
426
 */