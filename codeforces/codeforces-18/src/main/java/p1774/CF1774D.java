package p1774;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1774D {
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
        int[][] a = new int[n][m];
        int[] cnt = new int[n];
        int s = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();
                if (a[i][j] > 0) {
                    cnt[i]++;
                    s++;
                }
            }
        }
        if (s % n != 0) {
            out.println(-1);
            return;
        }
        List<int[]> ans = new ArrayList<>();
        int avg = s / n;
        for (int j = 0; j < m; j++) {
            List<Integer> ins = new ArrayList<>();
            List<Integer> outs = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (cnt[i] < avg && a[i][j] == 0) {
                    ins.add(i);
                } else if (cnt[i] > avg && a[i][j] > 0) {
                    outs.add(i);
                }
            }
            for (int k = 0; k < Math.min(ins.size(), outs.size()); k++) {
                ans.add(new int[]{ins.get(k) + 1, outs.get(k) + 1, j + 1});
                cnt[ins.get(k)]++;
                cnt[outs.get(k)]--;
            }
        }
        out.println(ans.size());
        for (int[] p : ans) {
            out.println(p[0] + " " + p[1] + " " + p[2]);
        }
    }
}
/*
D. Same Count One
https://codeforces.com/contest/1774/problem/D

灵茶の试炼 2026-01-07
题目大意：
输入 T(≤2e4) 表示 T 组数据。所有数据的 n*m 之和 ≤1e6。
每组数据输入 n m(2≤n,m≤1e5) 和 n 行 m 列的 01 矩阵 a。
你需要让每行的 1 的个数都相等。
每次操作，选择三个下标 r1 r2 c，然后交换 a[r1][c] 和 a[r2][c]。下标从 1 开始。
输出最小操作次数，以及具体操作方案（即每次操作的 r1 r2 c）。
如果无法做到，输出 -1。

rating 1600
1 的总数必须能被 n 整除。
设平均每行有 avg 个 1。
从左到右一列一列地考虑。
把这一列中的 1 的个数低于 avg 且 a[i][j] = 0 的 i 加到列表 ins 中。
把这一列中的 1 的个数超过 avg 且 a[i][j] = 1 的 i 加到列表 outs 中。
那么这一列可以执行 min(len(ins), len(outs)) 次交换。
交换的同时，维护每行 1 的个数，方便后续判断哪些行缺 1 或者多 1。
代码 https://codeforces.com/problemset/submission/1774/356615897
代码备份（上面打不开的同学看这个）
======

Input
3
3 4
1 1 1 0
0 0 1 0
1 0 0 1
4 3
1 0 0
0 1 1
0 0 1
0 0 0
2 2
0 0
0 1
Output
1
2 1 1
1
4 2 2
-1
 */
