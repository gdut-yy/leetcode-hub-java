package p1647;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class CF1647D {
    static int x, d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            x = scanner.nextInt();
            d = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        return f() ? "YES" : "NO";
    }

    private static boolean f() {
        int k = 0;
        while (x % d == 0) {
            x /= d;
            k++;
        }
        return k > 1 // 如果 k = 1，那么方案只有一种，x 自己，不符合要求
                && (!isPrime(x) // x 是合数，有多种分解
                // 此时 x 是 1 或质数
                // 需要拿一个 d 出来，分解给 x * 1 * 1 * ...
                // 那么 d 必须是合数，且至少要 3 个 d
                // 特别地，如果有 3 个 d，那么 d 不能分解成 x^2（注意 x 是质数），否则 x 分给 x 得到 x^2=d，不符合要求
                || !(k == 2 || k == 3 && d == x * x || isPrime(d)));
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
/*
D. Madoka and the Best School in Russia
https://codeforces.com/contest/1647/problem/D

灵茶の试炼 2023-06-29
题目大意：
输入 T(≤100) 表示 T 组数据。
每组数据输入 x d (2≤x,d≤1e9)，保证 x 是 d 的倍数。
定义好数为 d 的倍数。
定义美丽数为好数且不能表示为两个好数的乘积。
x 能否表示为一个或多个美丽数的乘积，且表示方式不唯一？
输出 YES / NO。
注：2*4 和 4*2 是同一种表示方式。

https://codeforces.com/problemset/submission/1647/211381733
详细见代码注释
【补充】
比如 x = 2*6*6*6，d=6，那么把 x 视作 (2 * 1 * 1) * 6 * 6 * 6，即三个美丽数 2*6, 6, 6 的乘积。
拿一个 6 出来分解，变成 (2*2 * 1*3) * 6 * 6，这样得到了两个美丽数 2*2*6 以及 3*6 的乘积。
======

input
8
6 2
12 2
36 2
8 2
1000 10
2376 6
128 4
16384 4
output
NO
NO
YES
NO
YES
YES
NO
YES
 */
