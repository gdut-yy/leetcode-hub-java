package p1898;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1898D {
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
        long base = 0;
        long mn = (int) 1e9, mx = 0;
        for (int i = 0; i < n; i++) {
            int w = scanner.nextInt();
            base += Math.abs(a[i] - w);
            mn = Math.min(mn, Math.max(a[i], w));
            mx = Math.max(mx, Math.min(a[i], w));
        }
        out.println(base + Math.max(mx - mn, 0) * 2);
    }
}
/*
D. Absolute Beauty
https://codeforces.com/contest/1898/problem/D

灵茶の试炼 2026-03-12
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) 和两个长为 n 的数组 a b，元素范围 [1,1e9]。
你可以执行如下操作至多 1 次：
选择两个不同的下标 i 和 j，交换 b[i] 和 b[j]。
输出 sum(|a[i]-b[i]|) 的最大值。

rating 1900
前置题目：LC1330. 翻转子数组得到最大的数组值。
接着我的题解。本题要计算的最大值和力扣那题是一样的，唯一需要注意的是 mx 可能小于 mn（没有第一类），答案是
base + max(mx-mn,0) * 2。
代码 https://codeforces.com/problemset/submission/1898/365973527
代码备份（上面打不开的同学看这个）
======

Input
6
3
1 3 5
3 3 3
2
1 2
1 2
2
1 2
2 1
4
1 2 3 4
5 6 7 8
10
1 8 2 5 3 5 3 1 1 3
2 9 2 4 8 2 3 5 3 1
3
47326 6958 358653
3587 35863 59474
Output
4
2
2
16
31
419045
 */
