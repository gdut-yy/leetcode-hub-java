package p1279;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1279B {
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
        long s = scanner.nextInt();

        int ans = 0, mx = 0, mxI = 0;
        for (int i = 1; i <= n; i++) {
            int v = scanner.nextInt();
            if (v > mx) {
                mx = v;
                mxI = i;
            }
            s -= v;
            if (s >= -mx) {
                ans = mxI;
            }
        }
        if (s >= 0) {
            out.println(0);
        } else {
            out.println(ans);
        }
    }
}
/*
B. Verse For Santa
https://codeforces.com/contest/1279/problem/B

灵茶の试炼 2025-09-08
题目大意：
输入 T(≤100) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(1≤n≤1e5) s(1≤s≤1e9) 和长为 n 的数组 a(1≤a[i]≤1e9)。
你在找一个 a 的最长前缀，满足其元素和 <= s。
你可以删除前缀中的一个数。
输出你删除的元素的下标。下标从 1 开始。
特别地，如果 sum(a) <= s，输出 0。

rating 1300
如果 sum(a) <= s，输出 0。
贪心，删除前缀中的最大值是最优的。
遍历数组，维护前缀和，维护前缀最大值，维护前缀最大值的下标。
如果前缀和 - 前缀最大值 <= s，记录 ans = 前缀最大值的下标。
代码 https://codeforces.com/contest/1279/submission/336693513
代码备份（上面打不开的同学看这个）
======

Input
3
7 11
2 9 1 3 18 1 4
4 35
11 9 10 7
1 8
5
Output
2
1
0

1
10 1000000000
5 6 7 4 1000000000 10 74 1000000000 1000000000 1000000000

5
 */
