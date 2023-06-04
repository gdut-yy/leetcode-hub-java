package c280;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc280_d {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        long k = scanner.nextLong();
        System.out.println(solve(k));
    }

    private static String solve(long k) {
        long min = 0L;
        for (long i = 2; i * i <= k; i++) {
            if (k % i == 0) {
                int cnt = 0;
                while (k % i == 0) {
                    k /= i;
                    cnt++;
                }
                long n = 0;
                while (cnt > 0) {
                    n += i;
                    long x = n;
                    while (x % i == 0) {
                        x /= i;
                        cnt--;
                    }
                }
                min = Math.max(min, n);
            }
        }
        min = Math.max(min, k);
        return String.valueOf(min);
    }
}
/*
D - Factorial and Multiple
https://atcoder.jp/contests/abc280/tasks/abc280_d

题目大意：
给定一个大于等于 2 的整数 K。求出最小正整数 N，使得 N!是 K 的倍数。
在这里,N !表示 N 的阶乘。在这个问题的约束下，我们可以证明这样一个 N 总是存在的。

类似分解质因数
https://oi-wiki.org/math/number-theory/pollard-rho/
======

Input 1
30
Output 1
5

Input 2
123456789011
Output 2
123456789011

Input 3
280
Output 3
7
 */