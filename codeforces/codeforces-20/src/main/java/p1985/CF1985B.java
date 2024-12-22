package p1985;

import java.util.Scanner;

public class CF1985B {
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        int max_sum = 0, ans_x = 0;
        for (int x = 2; x <= n; x++) {
            int k = n / x;
            int sum = (k * x + x) * k / 2;
            if (max_sum < sum) {
                max_sum = sum;
                ans_x = x;
            }
        }
        return String.valueOf(ans_x);
    }
}
/*
B. Maximum Multiple Sum
https://codeforces.com/contest/1985/problem/B

题目大意：
给定整数 $n$ ，求一个整数 $x$ ，使得：
- $2 \leq x \leq n$ .
- 小于或等于 $n$ 的 $x$ 的倍数之和最大。形式上， $x + 2x + 3x + \dots + kx$ 中的 $kx \leq n$ 在 $x$ 的所有可能值中最大。

枚举。
======

Input
2
3
15
Output
3
2
 */
