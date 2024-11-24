package p1443;

import java.util.Scanner;

public class CF1443B {
    static int a, b;
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            s = scanner.next();
            System.out.println(solve1());
        }
    }

    // 分组循环写法
    private static String solve() {
        if (!s.contains("1")) return "0";

        int ans = a;
        int n = s.length();
        for (int i = 0; i < n; ) {
            int st = i;
            char v = s.charAt(st);
            for (; i < n && s.charAt(i) == v; i++) {
            }
            if (v == '0' && st > 0 && i < n) {
                ans += Math.min(b * (i - st), a);
            }
        }
        return String.valueOf(ans);
    }

    // 更优雅的写法
    private static String solve1() {
        int pre = -9999;
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '1') {
                ans += Math.min(b * (i - pre - 1), a);
                pre = i;
            }
        }
        return String.valueOf(ans);
    }
}
/*
B. Saving the City
https://codeforces.com/contest/1443/problem/B

灵茶の试炼 2024-03-25
题目大意：
输入 T(≤1e5) 表示 T 组数据。所有数据的字符串长度之和 ≤1e5。
每组数据输入 a(1≤a≤1000) b(1≤b≤1000) 和长度不超过 1e5 的 01 字符串。
你可以花费 a，把一段连续的 1 变成 0。
也可以花费 b，把一个 0 变成 1。
上述两种操作可以执行任意次。
输出把所有 1 都变成 0 的最小花费。

rating 1300
贪心。
如果没有第二种操作，那么答案就是 a * 连续 1 的段数。
第二种操作可以把两段连续 1 之间的 0 变成 1，这样两段 1 就合并成一段 1，可以减少一个 a 的花费。
如果两段连续 1 之间的 0 的个数 * b < a，那么把 0 变成 1 是更优的，否则不变更优。
分组循环写法 https://codeforces.com/problemset/submission/1443/252853441
更优雅的写法 https://codeforces.com/problemset/submission/1443/252853879
======

Input
2
1 1
01000010
5 1
01101110
Output
2
6
 */
