package p2074;

import java.util.Scanner;

public class CF2074C {
    static long x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            x = scanner.nextLong();
            System.out.println(solve());
        }
    }

    private static String solve() {
        long y;
        if ((x & 1) == 0) {
            y = x & -x | 1;
        } else {
            y = (x + 1) & (~x) | 1;
        }
        if (y >= x) {
            y = -1;
        }
        return String.valueOf(y);
    }
}
/*
C. XOR and Triangle
https://codeforces.com/contest/2074/problem/C

灵茶の试炼 2025-04-07
题目大意：
输入 T(≤2000) 表示 T 组数据。
每组数据输入 x(2≤n≤1e9)。
找到一个严格小于 x 的正整数 y，满足 x、y 和 x XOR y 组成一个（非退化的）三角形的三条边。
输出任意满足要求的 y。如果 y 不存在，输出 -1。
进阶：做到 O(1)。

rating 1100
O(1) 做法。
如果 y 是 x 的子集，那么 x^y = x-y，无法形成三角形。
如果 y 和 x 没有交集，那么 x^y = x+y，也无法形成三角形。
否则 x^y 会在 x 的基础上「有得有失」：
比如 x=6，y=3，那么 x^y = x-2+1 = 5，3+5 > 6 满足要求。
比如 x=5，y=3，那么 x^y = x+2-1 = 6，3+5 > 6 满足要求。
可以找 x 的最低 0 和最低 1，取这两个比特（都设置为 1）作为 y。如果 y >= x 则输出 -1。
用 lowbit 可以做到 O(1)。
代码 https://codeforces.com/contest/2074/submission/311334894
代码备份（洛谷）
======

Input
7
5
2
6
3
69
4
420
Output
3
-1
5
-1
66
-1
320
 */