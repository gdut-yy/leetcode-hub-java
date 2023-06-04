package c276;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc276_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve(a));
    }

    private static String solve(int[] a) {
        int gcd = a[0];
        for (int x : a) {
            gcd = getGCD(gcd, x);
        }

        int res = 0;
        for (int x : a) {
            // 倍数
            int multiple = x / gcd;
            int cnt = count(multiple);
            if (cnt >= 0) {
                res += cnt;
            } else {
                return "-1";
            }
        }
        return String.valueOf(res);
    }

    private static int count(int num) {
        int res = 0;
        while (num % 2 == 0) {
            num /= 2;
            res++;
        }
        while (num % 3 == 0) {
            num /= 3;
            res++;
        }
        return num == 1 ? res : -1;
    }

    private static int getGCD(int num1, int num2) {
        if (num1 == 0) {
            return num2;
        }
        return getGCD(num2 % num1, num1);
    }
}
/*
D - Divide by 2 or 3
https://atcoder.jp/contests/abc276/tasks/abc276_d

题目大意：
给定一个正整数序列:a =(a 1,a 2，…，a N)。
您可以选择并执行以下操作任意次数(可能为零)。
- 选择 1≤i≤N 且 i 是 2 的倍数的整数 i，用 2ai 替换 ai。
- 选择 1≤i≤N 且 i 是 3 的倍数的整数 i，将 3ai 替换 ai。
你的目标是使 A 满足 1 = A 2 =…= A N。
找出实现目标所需执行操作的最小总次数。如果没有办法实现目标，则打印-1。

最大公约数。
======

Input 1
3
1 4 3
Output 1
3

Input 2
3
2 7 6
Output 2
-1
 */