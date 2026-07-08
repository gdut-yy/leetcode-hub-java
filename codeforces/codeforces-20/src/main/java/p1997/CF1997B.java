package p1997;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1997B {
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
        String s = scanner.next();
        String t = scanner.next();
        int ans = 0;
        for (int i = 3; i <= n; i++) {
            String ss = s.substring(i - 3, i);
            String ts = t.substring(i - 3, i);
            if (ss.equals("...") && ts.equals("x.x") || ts.equals("...") && ss.equals("x.x")) {
                ans++;
            }
        }
        out.println(ans);
    }
}
/*
B. Make Three Regions
https://codeforces.com/contest/1997/problem/B

灵茶の试炼 2026-01-19
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
每组数据输入 n(1≤n≤2e5) 和一个 2 行 n 列的网格图，只包含 '.' 和 'x'，分别表示空地和墙。
保证输入的网格图包含至多一个由空地组成的连通块（四方向连通）。
输出有多少个空地满足，把这个空地变成墙后，网格图恰好包含 3 个由空地组成的连通块。

rating 1100
手玩可以发现，唯一方案是
...
x.x
（或者上下镜像）
把第一行中间的 . 改成 x。
代码 https://codeforces.com/problemset/submission/1997/357909510
代码备份（上面打不开的同学看这个）
======

Input
4
8
.......x
.x.xx...
2
..
..
3
xxx
xxx
9
..x.x.x.x
x.......x
Output
1
0
0
2
 */
