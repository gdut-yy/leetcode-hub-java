package p1343;

import java.util.Scanner;

public class CF1343C {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        long ans = 0;
        for (int i = 0; i < n; ) {
            int mx = a[i];
            for (i++; i < n && a[i] > 0 == (mx > 0); i++) {
                mx = Math.max(mx, a[i]);
            }
            ans += mx;
        }
        return String.valueOf(ans);
    }
}
/*
C. Alternating Subsequence
https://codeforces.com/contest/1343/problem/C

灵茶の试炼 2024-05-27
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9 且 a[i]≠0)。
选一个 a 的子序列，要求：
1. 子序列是交替的（相邻元素一正一负）。
2. 在满足 1 的前提下，子序列尽量长。
3. 在满足 2 的前提下，子序列元素和尽量大。
输出元素和的最大值。
注：子序列不一定连续。

rating 1200
分组循环讲解
按照正负号分组，同一组取最大值，加入答案。
注意用 64 位整数。
https://codeforces.com/problemset/submission/1343/262146729
======

Input
4
5
1 2 3 -1 -2
4
-1 -2 -1 -3
10
-2 8 3 8 -4 -15 5 -2 -3 1
6
1 -1000000000 1 -1000000000 1 -1000000000
Output
2
-1
6
-2999999997
 */
