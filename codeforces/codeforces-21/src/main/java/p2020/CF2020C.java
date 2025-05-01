package p2020;

import java.util.Scanner;

public class CF2020C {
    static long b, c, d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            b = scanner.nextLong();
            c = scanner.nextLong();
            d = scanner.nextLong();
            System.out.println(solve());
        }
    }

    private static String solve() {
        long a = 0;
        for (long bit = 1L << 59; bit > 0; bit >>= 1) {
            if ((d & bit) == 0) {
                if ((b & bit) > 0 && (c & bit) == 0) {
                    return "-1";
                }
                a |= c & bit;
            } else if ((b & bit) == 0) {
                if ((c & bit) > 0) {
                    return "-1";
                }
                a |= bit;
            }
        }
        return String.valueOf(a);
    }

    private static String solve1() {
        long a = b ^ d;
        if ((a | b) - (a & c) == d) {
            return String.valueOf(a);
        }
        return "-1";
    }
}
/*
C. Bitwise Balancing
https://codeforces.com/contest/2020/problem/C

灵茶の试炼 2024-12-23
题目大意：
输入 T(≤1e5) 表示 T 组数据。
每组数据输入三个整数 b c d，范围 [0,1e18]。
输出任意一个在 [0,2^61] 中的整数 a，满足 (a|b)−(a&c)=d。
若不存在这样的 a，输出 -1。

rating 1400
方法一
从集合的角度看，a|b 是 a 的超集，a&c 是 a 的子集。
所以 a|b 一定是 a&c 的超集。
所以不可能出现同一个比特位上，a|b 是 0 而 a&c 是 1 的情况。
这意味着减法是没有【借位】的，所以每一位互相独立，我们可以逐位分析。
逐位分析（从高到低或者从低到高都可以）：
如果 d 这一位是 1，那么必须是 1 - 0 = 1。
1. 如果 b 这一位是 0 且 c 这一位是 1，那么没有这样的 a，输出 -1。
2. 否则，如果 b 这一位是 0，那么 a 这一位必须是 1。（注意此时 c 这一位是 0）
如果 d 这一位是 0，那么可以是 1 - 1 = 0 或者 0 - 0 = 0。
1. 如果 b 这一位是 1 且 c 这一位是 0，那么没有这样的 a，输出 -1。
2. 否则，如果 b 这一位是 1（说明 c 这一位是 1），那么 a 这一位必须是 1。
代码一 https://codeforces.com/contest/2020/submission/296085585
代码一备份（洛谷）
方法二
根据上面的结论，当 b 和 d 比特位不同的时候，a 这一位是 1，否则是 0。
所以答案就是 b^d。
代码二 https://codeforces.com/problemset/submission/2020/296086142
代码二备份（洛谷）
======

Input
3
2 2 2
4 2 6
10 2 14
Output
0
-1
12
 */
