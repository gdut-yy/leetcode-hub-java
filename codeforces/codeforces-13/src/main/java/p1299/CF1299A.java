package p1299;

import java.util.Scanner;

public class CF1299A {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        int[] suf = new int[n + 1];
        suf[n] = -1;
        for (int i = n - 1; i > 0; i--) {
//            suf[i] = suf[i + 1] &^ a[i]
            suf[i] = suf[i + 1] & ~a[i];
        }

        int pre = -1;
        int mx = -1, mxI = 0;
        for (int i = 0; i < n; i++) {
            int and = pre & a[i] & suf[i + 1];
            if (and > mx) {
                mx = and;
                mxI = i;
            }
//            pre &^= v
            pre &= ~a[i];
        }

        StringBuilder output = new StringBuilder();
        output.append(a[mxI]);
        for (int i = 0; i < n; i++) {
            if (i != mxI) {
                output.append(" ").append(a[i]);
            }
        }
        return output.toString();
    }
}
/*
A. Anu Has a Function
https://codeforces.com/contest/1299/problem/A

灵茶の试炼 2024-04-02
题目大意：
输入 n(1≤n≤1e5) 和长为 n 的数组 a(0≤a[i]≤1e9)。
定义 f(x, y) = (x OR y) - y，其中 OR 表示按位或运算。
定义
b[2] = f(a[1], a[2])
b[3] = f(b[2], a[3])
...
b[n] = f(b[n-1], a[n])
请你重新排列 a，最大化 b[n] 的值。
输出重新排列后的 a。多解输出任意一解。

rating 1500
f(x, y) = (x OR y) - y = x & (~y)，因为 x OR y 包含 y 的所有比特 1，那么减去 y 就相当于去掉 x OR y 中的在 y 中的比特 1。
所以 b[n] = a[1] & (~a[2]) & (~a[3]) & ... & (~a[n])。
枚举 a[i] 作为第一个数，前后缀分解。
https://codeforces.com/contest/1299/submission/254436289
======

Input
4
4 0 11 6
Output
11 6 4 0

Input
1
13
Output
13
 */
