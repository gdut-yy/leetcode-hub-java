package p1372;

import java.util.Scanner;

public class CF1372B {
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
        for (int d = 2; d * d <= n; d++) {
            if (n % d == 0) {
                return (n / d) + " " + (n - n / d);
            }
        }
        return "1 " + (n - 1);
    }
}
/*
B. Omkar and Last Class of Math
https://codeforces.com/contest/1372/problem/B

灵茶の试炼 2024-07-22
题目大意：
输入 T(≤10) 表示 T 组数据。
每组数据输入 n(2≤n≤1e9)。
输出两个正整数 a 和 b，满足 a+b=n 且 LCM(a,b) 尽量小。

rating 1300
提示 1：
由于 LCM(1,n-1) = n-1，所以我们要构造的 a 和 b，必须满足 LCM(a,b) <= n-1。
提示 2：
b 一定是 a 的倍数。
证明：
如果 b 不是 a 的倍数，那么 a > gcd(a,b)，所以 LCM(a,b) = a*b/gcd(a,b) >= 2b。又由于 b >= n/2，所以 LCM(a,b) >= n，不符合提示 1。
所以 b 一定是 a 的倍数，此时 LCM(a,b) = b。
提示 3：
设 b=k*a (k>=1)，那么 a+b=(k+1)*a=n，所以 a 是 n 的因子。
提示 4：
要使 LCM(a,b) 尽量小，a 越大越好，但不能超过 n/2。
设 d 是 n 的最小的 >= 2 的因子，那么 a=n/d，b=n-n/d。
特别地，如果 n 是质数，那么 a=1，b=n-1。
代码 https://codeforces.com/contest/1372/submission/271053295
======

Input
3
4
6
9
Output
2 2
3 3
3 6
 */
