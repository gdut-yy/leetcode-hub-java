package p1739;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1739B {
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
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 1; i < n; i++) {
            if (a[i] > 0 && a[i] <= a[i - 1]) {
                out.println(-1);
                return;
            }
            a[i] += a[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(a[i]).append(" ");
        }
        out.println(sb);
    }
}
/*
B. Array Recovery
https://codeforces.com/contest/1739/problem/B

灵茶の试炼 2026-02-23
题目大意：
输入 T(≤100) 表示 T 组数据。
每组数据输入 n(1≤n≤100) 和长为 n 的数组 d(0≤d[i]≤100)。
下标从 1 开始。
d 是由某个非负整数数组 a 按照如下规则生成的：
d[1] = a[1]
d[2] = |a[2] - a[1]|
...
d[i] = |a[i] - a[i-1]|
如果只有一个符合要求的数组 a，输出 a。
否则输出 -1。

rating 1100
d 类似差分数组，计算其前缀和数组。
如果发现某个前缀和 sum >= d[i]，那么下一个数既可以是 sum+d[i]，也可以是 sum-d[i]，输出 -1。（注意 a[i] 必须是非负数）
否则输出前缀和数组。
代码 https://codeforces.com/problemset/submission/1739/363394249
代码备份（上面打不开的同学看这个）
======

Input
3
4
1 0 2 5
3
2 6 3
5
0 0 0 0 0
Output
1 1 3 8
-1
0 0 0 0 0
 */
