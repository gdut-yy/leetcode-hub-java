package p1793;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1793B {
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
        int r = scanner.nextInt(), l = scanner.nextInt();
        out.println((r - l) * 2);
        StringBuilder sb = new StringBuilder();
        for (int x = l; x <= r; x++) sb.append(x).append(" ");
        for (int x = r - 1; x > l; x--) sb.append(x).append(" ");
        out.println(sb);
    }
}
/*
B. Fedya and Array
https://codeforces.com/contest/1793/problem/B

灵茶の试炼 2026-04-06
题目大意：
输入 T(≤1e3) 表示 T 组数据。
每组数据输入 x y(-1e9≤y<x≤1e9)。
构造一个长度尽量小的环形数组 a(-1e9≤a[i]≤1e9)，满足：
1. 相邻元素的绝对差恰好等于 1。注意，由于 a 是环形的，所以第一个数和最后一个数也必须相差恰好 1。
2. 局部最大值之和恰好等于 x。
3. 局部最小值之和恰好等于 y。
如果 a[i-1] < a[i] > a[i+1]，则称 a[i] 为局部最大值。
如果 a[i-1] > a[i] < a[i+1]，则称 a[i] 为局部最小值。
输出 a 的长度，以及任意符合要求的 a。
保证所有数据的 a 的长度之和 ≤2e5。

rating 1100
一个解是 a = [y, y+1, ..., x-1, x, x-1, ..., y+1]，一共 n = 2(x-y) 个数。
下面证明，对于任意符合要求的解，n 必然是 2(x-y)。
对于任意数组 a，其局部极小值与局部极大值必然是交替出现的。由于 a 是环形数组，所以局部极小值的个数必然等于局部极大值的个数。
从一个极小值 m 移动到一个邻近的极大值 M，需要走 M-m 步。同理，从一个极大值 M 移动到一个邻近的极小值 m，也需要走 M-m 步。
于是，数组的长度 n = (M1 - m1) + (M1 - m2) + (M2 - m2) + (M2 - m3) + ... + (Mk - mk) + (Mk - m1)，其中 k 是极小（大）值的个数。
上式每个 Mi 恰好出现 2 次，每个 mi 恰好出现 2 次。所以 n = 2 * (sum(M) - sum(m)) = 2(x-y)。
代码 https://codeforces.com/contest/1793/submission/369854752
代码备份（上面打不开的同学看这个）
======

Input
4
3 -2
4 -4
2 -1
5 -3
Output
10
0 1 2 1 0 -1 0 -1 0 1
16
-2 -1 -2 -1 0 1 2 3 4 5 4 3 2 1 0 -1
6
1 0 -1 0 1 0
16
2 3 2 1 0 -1 0 -1 0 -1 0 1 2 1 0 1
 */
