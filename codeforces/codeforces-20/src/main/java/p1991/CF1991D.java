package p1991;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1991D {
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
        int[] a = {1, 2, 2, 3, 3};
        if (n < 6) {
            out.println(n / 2 + 1);
            for (int i = 0; i < n; i++) {
                if (i > 0) out.print(" ");
                out.print(a[i]);
            }
            out.println();
        } else {
            out.println(4);
            for (int i = 0; i < n; i++) {
                if (i > 0) out.print(" ");
                out.print(i % 4 + 1);
            }
            out.println();
        }
    }
}
/*
D. Prime XOR Coloring
https://codeforces.com/contest/1991/problem/D

灵茶の试炼 2026-01-15
题目大意：
输入 T(≤500) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5)。
有一个 n 个点的图，节点编号从 1 到 n。
节点 x 和 y 之间有边，当且仅当 x XOR y 是质数。
用最少的颜色给这个图染色，使得每条边两端点的颜色不同。
输出两行：
第一行输出最少颜色数 k。
第二行输出 1 到 n 每个节点的颜色编号（1 到 k）。

rating 1900
除了 2 以外，其余质数都是奇数。
什么样的两个数异或是奇数？
奇偶性不同的数，异或是奇数。
如果没有质数 2，那么图就是二分图。
二分图可以 2-染色。左部（奇数）为颜色 A，右部（偶数）为颜色 B。
考虑质数 2，左部 1-3, 5-7, 9-11, ... 之间有边，右部 4-6, 8-10, 12-14, ... 之间有边。
所以左部内部需要两种颜色，右部内部需要另外两种颜色，至多要四种颜色。
又由于 V = {1,3,4,6} 是个完全子图，所以当 n >= 6 时，至少要四种颜色。
特判 n <= 5 的情况，CV 样例即可。
注：如果你观察能力比较弱，可以暴力计算 n <= 10，找规律。
代码 https://codeforces.com/problemset/submission/1991/357777273
代码备份（上面打不开的同学看这个）
======

Input
6
1
2
3
4
5
6
Output
1
1
2
1 2
2
1 2 2
3
1 2 2 3
3
1 2 2 3 3
4
1 2 2 3 3 4
 */
