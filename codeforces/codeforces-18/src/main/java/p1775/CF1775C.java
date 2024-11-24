package p1775;

import java.util.Scanner;

public class CF1775C {
    static long n, x;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextLong();
            x = scanner.nextLong();
            System.out.println(solve());
        }
    }

    private static String solve() {
        if (n == x) return String.valueOf(n);
        while (n > x) {
            long lb = Long.lowestOneBit(n);
            n ^= lb;
            if (n == x && (n & (lb << 1)) == 0) {
                return String.valueOf(n | lb << 1);
            }
        }
        return "-1";
    }
}
/*
C. Interesting Sequence
https://codeforces.com/contest/1775/problem/C

灵茶の试炼 2024-03-06
题目大意：
输入 T(≤2000) 表示 T 组数据。
每组数据输入 n(0≤n≤1e18) 和 x(0≤x≤1e18)。
输出最小的 m，使得 [n,m] 中的所有整数的 AND 等于 x，注意 m 不能低于 n。
即 n&(n+1)&(n+2)&...&m = x。
如果不存在这样的 m，输出 -1。

rating 1600
列出一些不同的 n，手玩，计算 n, n&(n+1), n&(n+1)&(n+2), ...
可以发现，AND 结果的变化规律是：
去掉 n 最右边的连续 1。
例如
n = 100110
m = 101000
在 m<101000 时，n 最右边的两个 1 是无法去掉的，m=101000 时可以去掉。
按照这个规律不断去掉 n 最右边的连续 1，直到 <= x 为止。
可以用 lowbit 快速判断，具体见代码。
https://codeforces.com/problemset/submission/1775/249584540
======

Input
5
10 8
10 10
10 42
20 16
1000000000000000000 0
Output
12
10
-1
24
1152921504606846976
 */
