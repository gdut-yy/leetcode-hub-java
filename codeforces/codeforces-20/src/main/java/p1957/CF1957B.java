package p1957;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1957B {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        if (n == 1) {
            out.println(k);
            return;
        }
        int w = bitsLen(k + 1) - 1;
        int x = (1 << w) - 1;
        out.print(x + " " + (k - x));
        for (int i = 0; i < n - 2; i++) out.print(" 0");
        out.println();
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    static int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }
}
/*
B. A BIT of a Construction
https://codeforces.com/contest/1957/problem/B

灵茶の试炼 2026-03-16
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和 k(1≤k≤1e9)。
构造一个长为 n 的非负整数数组 a，满足 sum(a) = k，且 a 的所有元素的按位或（OR）的二进制中的 1 的个数尽量多。
输出任意满足要求的 a。

rating 1100
由于 a+b = (a|b) + (a&b)，所以 OR <= k。
比如 k = 1001，那么 OR 的二进制至多有 3 个 1，于是构造 x=111，另一个数是 k-x，然后再来 n-2 个 0，组成数组 a。
比如 k = 1111，那么 OR 的二进制至多有 4 个 1，于是构造 x=1111，然后再来 n-1 个 0，组成数组 a。
一般地，设 w 为 k+1 的二进制长度再减 1，那么构造 x=(1<<w)-1（w 个 1），另一个数是 k-x，然后再来 n-2 个 0，组成数组 a。
特判 n=1 的情况。
代码 https://codeforces.com/problemset/submission/1957/366371353
代码备份（上面打不开的同学看这个）
======

Input
4
1 5
2 3
2 5
6 51
Output
5
1 2
5 0
3 1 1 32 2 12
 */
