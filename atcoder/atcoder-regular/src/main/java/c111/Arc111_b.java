package c111;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Arc111_b {
    static int n;
    static List<Integer>[] g;
    static final int MAX_N = (int) (4e5 + 5);

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        g = new ArrayList[MAX_N];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            g[v].add(w);
            g[w].add(v);
        }
        System.out.println(solve());
    }

    static boolean[] vis;
    static int cntV, cntE;

    private static String solve() {
        vis = new boolean[MAX_N];
        int ans = 0;
        for (int x = 0; x < MAX_N; x++) {
            if (!vis[x] && !g[x].isEmpty()) {
                cntV = 0;
                cntE = 0;
                dfs(x);
                ans += Math.min(cntV, cntE / 2);
            }
        }
        return String.valueOf(ans);
    }

    private static void dfs(int v) {
        vis[v] = true;
        cntV++;
        cntE += g[v].size();
        for (int w : g[v]) {
            if (!vis[w]) {
                dfs(w);
            }
        }
    }
}
/*
B - Reversible Cards
https://atcoder.jp/contests/arc111/tasks/arc111_b

灵茶の试炼 2023-02-07
题目大意：
输入 n(≤2e5) 和一个 n 行 2 列的矩阵，矩阵元素范围 [1,4e5]。
从每行中恰好选一个数，你最多能选出多少个不同的数？

不止一个连通块
https://atcoder.jp/contests/arc111/submissions/38552445
把每行的两个数当作图的一条边的两个端点。
对每个连通块分别统计。
如果连通块是树，那么答案是边数。
如果连通块不是树，那么答案是点数。
======

Input
4
1 2
1 3
4 2
2 3
Output
4

Input
2
111 111
111 111
Output
1

Input
12
5 2
5 6
1 2
9 7
2 7
5 5
4 2
6 7
2 2
7 8
9 7
1 8
Output
8
 */