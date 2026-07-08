package p1333;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1333A {
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
        int m = scanner.nextInt();
        out.println("B".repeat(m - 1) + "W");
        for (int i = 0; i < n - 1; i++) {
            out.println("B".repeat(m));
        }
    }
}
/*
A. Little Artem
https://codeforces.com/contest/1333/problem/A

灵茶の试炼 2026-02-09
题目大意：
输入 T(≤20) 表示 T 组数据。
每组数据输入 n m(2≤n,m≤100)。
构造一个 n 行 m 列的网格图，只包含大写字母 B 和 W。
设 cntB 为网格图中与至少一个 W 相邻的 B 的数量。
设 cntW 为网格图中与至少一个 B 相邻的 W 的数量。
要求 cntB = cntW + 1。
注：相邻指共用一条边。

rating 1000
脑筋急转弯。
构造方案：
除了一个角落为 W，其余格子全为 B。
此时 cntB = 2，cntW = 1，满足要求。
代码 https://codeforces.com/contest/1333/submission/361423155
代码备份（上面打不开的同学看这个）
======

Input
2
3 2
3 3
Output
BW
WB
BB
BWB
BWW
BWB
 */