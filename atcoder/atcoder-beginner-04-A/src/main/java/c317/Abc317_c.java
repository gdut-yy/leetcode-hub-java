package c317;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc317_c {
    static int n, m;
    static int[][] adj;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        n = scanner.nextInt();
        m = scanner.nextInt();
        adj = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = i == j ? 0 : INF;
            }
        }
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            int wt = scanner.nextInt();
            adj[x][y] = wt;
            adj[y][x] = wt;
        }
        System.out.println(solve());
    }

    private static final int INF = (int) 1e9;
    private static Integer[] snap;
    private static int ans;

    private static String solve() {
        ans = 0;

        snap = new Integer[n];
        for (int i = 0; i < n; i++) snap[i] = i;

        dfs(0);
        return String.valueOf(ans);
    }

    private static void dfs(int i) {
        if (i == n) {
            int dist = 0;
            for (int j = 1; j < n; j++) {
                int x = snap[j - 1], y = snap[j];
                if (adj[x][y] == INF) {
                    break;
                }
                dist += adj[x][y];
            }
            ans = Math.max(ans, dist);
        }
        for (int j = i; j < n; j++) {
            swap(snap, i, j);
            dfs(i + 1);
            swap(snap, i, j);
        }
    }

    private static void swap(Integer[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
/*
C - Remembering the Days
https://atcoder.jp/contests/abc317/tasks/abc317_c

题目大意：
一个区域有 N 个编号为 1 ~ N 的城镇和 M 条编号为 1 ~ M 的道路。
第 i 条路连接 Ai 和 Bi，长度为 Ci。
从你选择的一个城镇出发，到达另一个城镇而不经过同一城镇多次时，找出你所穿越的道路的最大可能总长。

最大生成树？
全排列
======

Input 1
4 4
1 2 1
2 3 10
1 3 100
1 4 1000
Output 1
1110

Input 2
10 1
5 9 1
Output 2
1

Input 3
10 13
1 2 1
1 10 1
2 3 1
3 4 4
4 7 2
4 8 1
5 8 1
5 9 3
6 8 1
6 9 5
7 8 1
7 9 4
9 10 3
Output 3
20
 */