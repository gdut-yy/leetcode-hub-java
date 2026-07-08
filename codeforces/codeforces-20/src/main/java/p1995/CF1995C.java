package p1995;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1995C {
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

    static long sq(long v) {
        if (v > Long.MAX_VALUE / v) return Long.MAX_VALUE;
        return v * v;
    }

    private static void solve() {
        int n = scanner.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }
        long ans = 0;
        int k = 0;
        for (int i = 1; i < n; i++) {
            long x = a[i - 1], y = a[i];
            if (x > y) {
                if (y == 1) {
                    ans = -1;
                    break;
                }
                while (y < x) {
                    y = sq(y);
                    k++;
                }
                ans += k;
            } else {
                while (k > 0 && sq(x) <= y) {
                    x = sq(x);
                    k--;
                }
                ans += k;
            }
        }
        out.println(ans);
    }
}
/*
C. Squaring
https://codeforces.com/contest/1995/problem/C

灵茶の试炼 2026-02-18
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和长为 n 的数组 a(1≤a[i]≤1e6)。
每次操作，你可以把一个 a[i] 变成 a[i] * a[i]。
把 a 变成递增数组（a[i] <= a[i+1]），至少要操作多少次？
如果无法做到，输出 -1。

rating 1800
从左到右考虑。第一个数无需操作。
对于 a 中两个相邻元素 x 和 y，设 x 操作了 k 次，y 要操作 kk 次，那么有
x ^ (2^k) <= y ^ (2^kk)
分类讨论：
如果 x > y，我们可以先把 y 平方至第一个 >= x 的 y'，此时有 x ^ (2^k) <= y' ^ (2^k)，所以 y' 再平方 k 次即可满足要求。
如果 x <= y，我们可以先把 x 平方至最后一个 <= y 的数 x'。设 x 平方了 m 次，那么有 x ^ ((2^m) * (2^(k-m))) <= y ^ (2^kk)，即 x ^ (2^(k-m)) <= y ^ (2^kk)，所以 y 只需操作 max(k - m, 0) 次，也就是比 x 少平方 m 次，但次数不能是负数。
特殊情况：如果 x > y 且 y = 1，无解。
代码 https://codeforces.com/contest/1995/submission/363392130
代码备份（上面打不开的同学看这个）
======

Input
7
3
1 2 3
2
3 2
3
3 1 5
4
1 1 2 3
3
4 3 2
9
16 2 4 2 256 2 4 2 8
11
10010 10009 10008 10007 10006 10005 10004 10003 10002 10001 10000
Output
0
1
-1
0
3
15
55
 */
