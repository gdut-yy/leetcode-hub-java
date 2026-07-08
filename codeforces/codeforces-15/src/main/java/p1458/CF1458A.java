package p1458;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1458A {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long a1 = scanner.nextLong();
        long g = 0;
        for (int i = 0; i < n - 1; i++) {
            long v = scanner.nextLong();
            g = getGCD(g, v - a1);
        }
        for (int i = 0; i < m; i++) {
            long v = scanner.nextLong();
            out.print(Math.abs(getGCD(a1 + v, g)) + " ");
        }
    }

    static long getGCD(long num1, long num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
A. Row GCD
https://codeforces.com/contest/1458/problem/A

灵茶の试炼 2026-04-15
题目大意：
输入 n(1≤n≤2e5)，m(1≤m≤2e5)，长为 n 的数组 a(1≤a[i]≤1e18) 和长为 m 的数组 b(1≤b[i]≤1e18)。下标从 1 开始。
定义 f(j) = gcd(a[1]+b[j], a[2]+b[j], ..., a[n]+b[j])。
输出 f(1), f(2), ..., f(m)。

rating 1600
设 x 和 y 都是 g 的倍数（x=k1*g，y=k2*g），得 x-y = (k1-k2)*g 也是 g 的倍数，所以 x 和 y 的公约数集合 = x 和 x-y 的公约数集合。
所以 gcd(x,y) = gcd(x,x-y)。
用这个方法可以证明，gcd(x1,x2,x3...,xn) = gcd(x1,x2-x1,x3-x1,...,xn-x1)。
所以本题要求的 = gcd(a1+bj,a2-a1,...,an-a1)。
预先计算 gcd(a2-a1,...,an-a1) 即可。
代码 https://codeforces.com/contest/1458/submission/371120571
代码备份（上面打不开的同学看这个）
======

Input
4 4
1 25 121 169
1 2 7 23
Output
2 3 8 24
 */
