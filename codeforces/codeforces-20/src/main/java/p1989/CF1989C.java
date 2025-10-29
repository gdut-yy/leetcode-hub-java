package p1989;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1989C {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
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

        int s0 = 0, s1 = 0, inc = 0, dec = 0;
        for (int v : a) {
            int w = scanner.nextInt();
            if (v == w) {
                if (v == 1) {
                    inc++;
                } else {
                    dec -= v;
                }
            } else if (v > w) {
                s0 += v;
            } else {
                s1 += w;
            }
        }
        if (s0 > s1) {
            int temp = s0;
            s0 = s1;
            s1 = temp;
        }

        if (s0 + inc <= s1 - dec) {
            out.println(s0 + inc);
        } else {
            out.println((s0 + s1 + inc - dec) >> 1);
        }
    }
}
/*
C. Two Movies
https://codeforces.com/contest/1989/problem/C

灵茶の试炼 2025-08-26
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和一个 2 行 n 列的矩阵，只包含 -1 0 1。
每一列选一个数。
设第一行所选元素和为 s0，第二行所选元素和为 s1。
最大化 min(s0, s1)。

rating 1400
如果 a[i] ≠ b[i]，由于只有 -1 0 1，选大的更优。把大的数加到对应的 s0 或 s1 中。
如果 a[i] = b[i]，统计都是 1 的个数 inc，都是 -1 的个数 dec。暂时不加到 s0 和 s1 中。
不妨设 s0 <= s1。不满足则交换。
分类讨论：
如果 s0+inc <= s1-dec，答案为 s0+inc。
否则可以均匀分配，答案为 floor((s0+s1+inc-dec) / 2)。
非 Python 用户请注意：负数 / 2 是向上取整（向零取整），可以把 / 2 改成 >> 1 确保向下取整。
代码 https://codeforces.com/problemset/submission/1989/335012838
代码备份（上面打不开的同学看这个）
======

Input
4
2
-1 1
-1 -1
1
-1
-1
5
0 -1 1 0 1
-1 1 0 0 1
4
-1 -1 -1 1
-1 1 1 1
Output
0
-1
1
1
 */