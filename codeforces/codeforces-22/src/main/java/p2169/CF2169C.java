package p2169;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2169C {
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

        long mx = 0, pre = 0, s = 0;
        for (int r = 1; r <= n; r++) {
            int v = a[r - 1];
            pre = Math.max(pre, s + r - (long) r * r);
            s += v;
            mx = Math.max(mx, (long) r * r + r - s + pre);
        }
        out.println(s + mx);
    }
}
/*
C. Range Operation
https://codeforces.com/contest/2169/problem/C

灵茶の试炼 2025-12-08
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(0≤a[i]≤2n)。
你可以执行如下操作至多一次：
选择 a（下标从 1 开始）的一个连续子数组 [L,R]，把子数组内的数都变成 L+R。
输出 sum(a) 的最大值。

rating 1300
计算 a 的前缀和数组 s，其中 s[i] 是前缀 [1,i] 的元素和。
操作前，子数组元素和为 s[R] - s[L-1]。
操作后，子数组元素和为 (R-L+1)*(L+R) = R^2 - L^2 + L + R。
所以操作后，sum(a) 增加了 (R^2 - L^2 + L + R) - (s[R] - s[L-1])，
变形得 (R^2+R-s[R]) + (L-L^2+s[L-1])。
枚举右，维护左。
枚举 R，维护左边的 L-L^2+s[L-1] 的最大值 pre。
注意本题 L 可以等于 R，要先更新 pre，再用 R^2+R-s[R]+pre 更新增量的最大值 mx。
mx 初始值为 0，表示不操作。
答案为操作前的 sum(a) 加上 mx。
代码 https://codeforces.com/problemset/submission/2169/351475786
代码备份（上面打不开的同学看这个）
======

Input
4
3
2 5 1
2
4 4
4
1 3 2 1
5
3 2 0 9 10
Output
13
8
20
32
 */
