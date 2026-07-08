package p2118;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2118B {
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

    private static void solve() {
        int n = scanner.nextInt();
        out.println(n * 2 - 1);
        out.println(1 + " " + 1 + " " + n);
        for (int i = 2; i <= n; i++) {
            out.println(i + " " + 1 + " " + (i - 1));
            out.println(i + " " + i + " " + n);
        }
    }
}
/*
B. Make It Permutation
https://codeforces.com/contest/2118/problem/B

灵茶の试炼 2026-03-09
题目大意：
输入 T(≤100) 表示 T 组数据。所有数据的 n 之和 ≤5e3。
每组数据输入 n(3≤n≤5e3)。
有一个 n*n 的方阵 A，初始每行都是 1,2,3,...,n。
你可以执行如下操作至多 2n 次：
选择 A 的某一行，把该行的某个连续子数组反转（reverse）。
你需要让 A 的每一列都是一个 1~n 的排列。
可以证明，这一定可以做到。
输出操作次数，以及每次操作的行号、子数组左端点、子数组右端点。下标从 1 开始。

rating 1200
通过两次反转操作，可以得到一个数组的任意逆循环移位。
例如 123456，反转前 4 个数，反转后 2 个数，得到 432165，这是 654321 的一个循环移位。
于是，对于第 i 行，反转前 i 个数，反转后 n-i 个数。这样可以得到同一个排列的 n 个不同循环移位，从而使得每一列都不同。
代码 https://codeforces.com/contest/2118/submission/365669711
代码备份（上面打不开的同学看这个）
======

Input
2
3
4
Output
4
2 1 3
2 2 3
3 1 2
3 2 3
5
2 1 4
3 1 3
3 2 4
4 3 4
4 1 2
 */
