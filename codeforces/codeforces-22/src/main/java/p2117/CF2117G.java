package p2117;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CF2117G {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    record edge(int v, int w, int wt) {
    }

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<edge> es = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            int wt = scanner.nextInt();
            es.add(new edge(v, w, wt));
        }

        es.sort(Comparator.comparingInt(a -> a.wt));
        DSU dsu = new DSU(n + 1);
        int[] mn = new int[n + 1];
        Arrays.fill(mn, (int) 1e9);

        int ans = (int) 2e9;
        for (edge e : es) {
            int v = dsu.find(e.v);
            int w = dsu.find(e.w);
            if (v == w) continue;
            mn[w] = Math.min(Math.min(mn[w], mn[v]), e.wt);
            dsu.fa[v] = w;
            if (dsu.find(1) == dsu.find(n)) {
                ans = Math.min(ans, mn[dsu.fa[1]] + e.wt);
            }
        }
        out.println(ans);
    }

    static class DSU {
        int[] fa;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        int find(int x) { // 查找
            return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
        }

        void union(int p, int q) { // 合并
            p = find(p);
            q = find(q);
            if (p == q) return;
            fa[q] = p;
        }
    }
}
/*
G. Omg Graph
https://codeforces.com/contest/2117/problem/G

灵茶の试炼 2025-07-10
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5，m 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) m(n-1≤m≤2e5)，表示一个 n 点 m 边的无向图。保证图是连通的，无自环，无重边。
然后输入 m 条边，每条边输入 x y w(1≤w≤1e9)，表示一条边权为 w 的无向边连接 x 和 y。节点编号从 1 开始。
输出从 1 到 n 的路径中，「最小边权+最大边权」的最小值。
注意：路径不一定是简单路径，可以重复经过点和边。

rating 1900
等价于找一个包含 1 和 n 的子图。
核心思路：枚举大，维护小。
按照边权从小到大遍历，假设当前遍历的边权是最大的，那么最小边权可以是多少？
用并查集 merge 遍历过的边，维护每个连通块的最小边权。
如果 1 和 n 在同一个连通块 C 中，用 C 的最小边权 + 当前遍历的边权，更新答案的最小值。
注意 1 和 n 在同一个连通块的时候，不能直接输出答案，可能后面通过连边 merge，能让连通块 C 的最小边权更小。
代码 https://codeforces.com/contest/2117/submission/325563308
代码备份（Ubuntu Pastebin）
======

Input
4
3 2
1 2 1
2 3 1
3 2
1 3 13
1 2 5
8 9
1 2 6
2 3 5
3 8 6
1 4 7
4 5 4
5 8 7
1 6 5
6 7 5
7 8 5
3 3
1 3 9
1 2 8
2 3 3
Output
2
18
10
11
 */