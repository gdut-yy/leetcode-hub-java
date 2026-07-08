package p11;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF11D {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt(), m = scanner.nextInt();
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt() - 1, w = scanner.nextInt() - 1;
            g[v].add(w);
            g[w].add(v);
        }
        long[][] f = new long[1 << n][n];
        for (int i = 0; i < n; i++) {
            f[1 << i][i] = 1;
        }
        long ans = 0;
        for (int mask = 0; mask < (1 << n); mask++) {
            int st = Integer.numberOfTrailingZeros(mask);
            for (int v = 0; v < n; v++) {
                long fv = f[mask][v];
                if (fv == 0) continue;
                for (int w : g[v]) {
                    if (w == st) {
                        ans += fv;
                    } else if (w > st && (mask >> w & 1) == 0) {
                        f[mask | 1 << w][w] += fv;
                    }
                }
            }
        }
        out.println((ans - m) / 2);
    }
}
/*
D. A Simple Task
https://codeforces.com/contest/11/problem/D

灵茶の试炼 2026-05-22
题目大意：
输入 n(1≤n≤19) 和 m(0≤m)，表示一个 n 点 m 边的无向图。无自环，无重边。
然后输入 m 条边。节点编号从 1 到 n。
输出图中的简单环的数量。
简单环指没有重复点也没有重复边的环。
双倍经验：https://atcoder.jp/contests/abc411/tasks/abc411_g

rating 2200
对于环 1->2->3->1 来说，它和 2->3->1->2、3->1->2->3 是同一个环，不能重复计入。
不妨规定环中的最小节点为起点。
定义 dfs(mask, cur) 表示当前在 cur，遍历过的节点集合（包括 cur）为 mask 时，能找到多少个环。
设起点 st = min(mask)，枚举 nxt = st+1, st+2, ..., n，如果 cur 和 nxt 有边，递归 dfs(mask | (1 << nxt), nxt)。
也可以在此刻回到起点（如果有边的话），构成环。
递归入口：枚举起点，dfs(1<<i, i)。
累加 dfs(1<<i, i)，结果记作 sum。
特殊情况：对于 1->2->1 这样的环，如果这两步都走的同一条边，就不是简单环，所以要把答案减去 m。
此外，逆时针环和顺时针环各算了一次，最后要除以 2。
最终答案为 (sum - m) / 2。
代码 https://codeforces.com/contest/11/submission/375286294
代码备份（上面打不开的同学看这个）
======

Input
4 6
1 2
1 3
1 4
2 3
2 4
3 4
Output
7
 */
