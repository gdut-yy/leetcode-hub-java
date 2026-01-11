package p2069;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF2069B {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] a = new int[n][m];
        byte[] c = new byte[n * m + 1];
        int ans = -1;
        int has2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
                int v = a[i][j];
                if (c[v] == 2) {
                    continue;
                }
                if ((j > 0 && v == a[i][j - 1]) || (i > 0 && v == a[i - 1][j])) {
                    c[v] = 2;
                    has2 = 1;
                    ans++;
                } else if (c[v] == 0) {
                    c[v] = 1;
                    ans++;
                }
            }
        }
        out.println(ans - has2);
    }
}
/*
B. Set of Strangers
https://codeforces.com/contest/2069/problem/B

灵茶の试炼 2025-10-13
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n*m 之和 ≤5e5。
每组数据输入 n m(1≤n≤m≤700) 和 n 行 m 列的网格图，元素范围 [1,n*m]。
单元格的值表示其颜色。
每次操作，选择一些颜色相同的，但两两不相邻的单元格，把所选单元格都涂成其他颜色。
注：相邻指共用一条边。
要使所有格子的颜色都相同，至少要操作多少次？

rating 1200
对于每种颜色：
- 如果没有相邻相同，需要一次操作。
- 如果有相邻相同，可以用国际象棋棋盘把颜色隔开，只需两次操作。
如果所有颜色都要一次，那么随便变成其中一种颜色。
否则，变成其中需要操作两次的颜色。
答案为总操作次数，减去单个颜色的最大操作次数。
代码 https://codeforces.com/problemset/submission/2069/340022767
代码备份（上面打不开的同学看这个）
======

Input
4
1 1
1
3 3
1 2 1
2 3 2
1 3 1
1 6
5 4 5 4 4 5
3 4
1 4 2 2
1 4 3 5
6 6 3 5
Output
0
2
1
10
 */
