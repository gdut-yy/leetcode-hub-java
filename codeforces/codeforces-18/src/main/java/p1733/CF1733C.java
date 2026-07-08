package p1733;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1733C {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve1();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        out.println(n - 1);
        int idx = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] % 2 == a[0] % 2) {
                if (idx < 0) {
                    idx = i;
                } else {
                    out.println((i + 1) + " " + (idx + 1));
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 != a[0] % 2) {
                out.println(1 + " " + (i + 1));
            }
        }
    }

    private static void solve1() {
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        out.println(n - 1);
        if (n == 1) return;
        out.println(1 + " " + n);
        int x = a[0];
        if ((a[0] + a[n - 1]) % 2 == 0) {
            x = a[n - 1];
        }
        for (int i = 1; i < n - 1; i++) {
            if ((a[i] + x) % 2 == 0) {
                out.println((i + 1) + " " + n);
            } else {
                out.println(1 + " " + (i + 1));
            }
        }
    }
}
/*
C. Parity Shuffle Sorting
https://codeforces.com/contest/1733/problem/C

灵茶の试炼 2026-03-10
题目大意：
输入 T(≤1e5) 表示 T 组数据。所有数据的 n 之和 ≤1e5。
每组数据输入 n(1≤n≤1e5) 和长为 n 的数组 a(0≤a[i]≤1e9)。下标从 1 开始。
你可以执行如下操作至多 n 次：
选择两个不同的下标 L 和 R，满足 1 ≤ L < R ≤ n。
如果 a[L] + a[R] 是奇数，更新 a[R] = a[L]。
如果 a[L] + a[R] 是偶数，更新 a[L] = a[R]。
你需要把 a 变成递增数组（a[i] ≤ a[i+1]）。
可以证明，这一定可以做到。
输出操作次数，以及每次操作选择的 L 和 R。下标从 1 开始。

rating 1300
方法一
把所有奇偶性与 a[1] 相同的数找出来，这些数相加是偶数，从右到左执行 a[l] = a[r]。
操作后，所有奇偶性与 a[1] 相同的数都一样了（都变成最右边的奇偶性与 a[1] 相同的数）。
其余没有操作过的数，与 a[1] 的奇偶性不同，相加是奇数，所以可以更新成 a[1]。
操作后，所有数都变成 a[1]（或者说，都变成最右边的奇偶性与 a[1] 相同的数）。
方法二
先选择 1 和 n 操作一下，现在 a[1] == a[n]。
然后遍历下标 2 到 n-1。
设 x = a[1] = a[n]。
如果 x + a[i] 是奇数，那么选择 1 和 i 操作。
如果 x + a[i] 是偶数，那么选择 i 和 n 操作。
操作后，所有数都变成 x。
方法一代码 https://codeforces.com/contest/1733/submission/365709256
方法二代码 https://codeforces.com/contest/1733/submission/365709982
代码备份（上面打不开的同学看这个）
======

Input
3
2
7 8
5
1 1000000000 3 0 5
1
0
Output
0
2
3 4
1 2
0
 */
