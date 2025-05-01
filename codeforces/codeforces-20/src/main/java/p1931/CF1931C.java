package p1931;

import java.util.Scanner;

public class CF1931C {
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
        int l = 0, r = -1;
        for (int i = 0; i < n; i++) {
            if (l == 0 && a[i] != a[0]) {
                l = i;
            }
            if (a[i] != a[n - 1]) {
                r = i;
            }
        }

        int ans;
        if (a[0] == a[n - 1]) {
            ans = r - l + 1;
        } else {
            ans = Math.min(n - l, r + 1);
        }
        return String.valueOf(ans);
    }
}
/*
C. Make Equal Again
https://codeforces.com/contest/1931/problem/C

灵茶の试炼 2025-03-17
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤n)。
你可以执行如下操作至多一次：
把一个连续子数组都改成同一个数 x（x 由你决定），代价为子数组的长度。
要使 a 中所有数都一样，最小代价是多少？

rating 1000
分类讨论：
如果 a[0]=a[n-1]，去掉连续相同的前缀和后缀，剩余的数必须改。
如果 a[0]≠a[n-1]，答案为 min(去掉连续相同前缀后的剩余长度，去掉连续相同后缀后的剩余长度）
代码 https://codeforces.com/problemset/submission/1931/310340854
代码备份（洛谷）
======

Input
8
6
1 2 3 4 5 1
7
1 1 1 1 1 1 1
8
8 8 8 1 2 8 8 8
1
1
2
1 2
3
1 2 3
7
4 3 2 7 1 1 3
9
9 9 2 9 2 5 5 5 3
Output
4
0
2
0
1
2
6
7
 */
