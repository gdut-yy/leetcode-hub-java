package p1753;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1753A2 {
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
        int s = 0;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            s += a[i];
        }
        int tar = 1;
        if (s < 0) tar = -1;
        int k = n;
        boolean[] flip = new boolean[n];
        for (int i = 1; i < n; ) {
            if (a[i] != tar || s == 0) {
                i++;
                continue;
            }
            int st = i;
            while (i < n && a[i] == tar) {
                if (s != 0 && (i - st) % 2 == 0) {
                    flip[i] = true;
                    s -= tar * 2;
                    k--;
                }
                i++;
            }
        }
        if (s != 0) {
            out.println(-1);
            return;
        }
        out.println(k);
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && flip[i + 1]) {
                out.println((i + 1) + " " + (i + 2));
                i++;
            } else {
                out.println((i + 1) + " " + (i + 1));
            }
        }
    }
}
/*
A2. Make Nonzero Sum (hard version)
https://codeforces.com/contest/1753/problem/A2

灵茶の试炼 2026-03-03
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a，只包含 -1、0 和 1。下标从 1 开始。
你需要把 a 划分成若干段，计算每一段的交替和，再把所有交替和相加，得到 sum。目标是让 sum 等于 0。
注：对于子数组 b，其交替和为 b[1] - b[2] + b[3] - b[4] + ...
如果无法做到，输出 -1。
否则输出段数，以及从左到右每一段的左右端点（闭区间，下标从 1 开始）。

rating 1500
划分操作相当于：
把某些 a[i] 变成 -a[i]，使得 sum(a) = 0。
想一想，对于任意划分，是否存在连续的 -a[i], -a[i+1]？
不存在，这无法做到。
但可以做到连续的 a[i], a[i+1]（即相邻元素都不变成相反数），把单个数划分成一段即可。
设 s = sum(a)。
以 s > 0 的情况为例。
我们需要把连续的 1 中的某些数变成 -1。贪心地，从最左边的 1 开始，每隔一个数，把 1 变成 -1，从而尽可能地把 s 变小。
找连续的 1 可以用分组循环。
代码 https://codeforces.com/contest/1753/submission/364624240
代码备份（上面打不开的同学看这个）
======

Input
5
4
0 0 0 0
7
-1 1 0 1 0 1 0
5
0 -1 1 0 1
3
1 0 1
1
1
Output
4
1 1
2 2
3 3
4 4
4
1 1
2 2
3 5
6 7
-1
2
1 1
2 3
-1
 */