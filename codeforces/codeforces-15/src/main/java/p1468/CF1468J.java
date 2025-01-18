package p1468;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CF1468J {
    static int n, m, k;
    static List<edge> es;
    static int mx;
    static DSU dsu;

    record edge(int v, int w, int wt) {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            k = scanner.nextInt();

            es = new ArrayList<>();
            mx = 0;
            dsu = new DSU(n);
            for (int i = 0; i < m; i++) {
                int v = scanner.nextInt() - 1;
                int w = scanner.nextInt() - 1;
                int wt = scanner.nextInt();
                if (wt > k) {
                    es.add(new edge(v, w, wt));
                    continue;
                }
                dsu.union(v, w);
                mx = Math.max(mx, wt);
            }
            System.out.println(solve());
        }
    }

    private static String solve() {
        es.sort(Comparator.comparingInt(o -> o.wt));

        if (dsu.sz == 1) {
            int ans = k - mx;
            if (!es.isEmpty()) {
                ans = Math.min(ans, es.getFirst().wt - k);
            }
            return String.valueOf(ans);
        }
        long sum = 0;
        for (edge e : es) {
            if (!dsu.union(e.v, e.w)) {
                sum += e.wt - k;
            }
        }
        return String.valueOf(sum);
    }

    static class DSU {
        int[] fa;
        int sz;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) fa[i] = i;
            sz = n;
        }

        int find(int x) { // 查找
            return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
        }

        boolean union(int p, int q) { // 合并
            p = find(p);
            q = find(q);
            if (p == q) return true;
            fa[q] = p;
            sz--;
            return false;
        }
    }
}
/*
J. Road Reform
https://codeforces.com/contest/1468/problem/J

灵茶の试炼 2024-08-21
题目大意：
输入 T(≤1e3) 表示 T 组数据。所有数据的 n 之和 ≤2e5，m 之和 ≤2e5。
每组数据输入 n(2≤n≤2e5) m(n-1≤m≤min(2e5,n*(n-1)/2)) k(1≤k≤1e9)，表示一个 n 点 m 边的无向图。
然后输入 m 条边，每条边输入 x y w(1≤w≤1e9)，表示有一条边权为 w 的无向边连接 x 和 y。节点编号从 1 开始。
保证图是连通的。保证图中无自环和重边。
首先，求出图的一棵生成树。
然后，每次操作，可以把生成树的一条边的边权加一或者减一。
要使生成树的最大边权恰好等于 k，最少要操作多少次？

rating 1800
MST + 分类讨论。
把所有 <= k 的边都用并查集合并，如果连成一个连通块，那么：
1. 把其中最大的边权变成 k，答案为 k - max{<= k 的边权}
2. 如果存在 > k 的边，也可以把其中最小的边权变成 k，答案为 min{> k 的边权} - k
两种情况取最小值。
如果无法全部连起来，那么剩余的边一定要从 > k 的边中取。
用 MST 计算，对于额外添加进来的边，累加 (边权 - k)。
代码 https://codeforces.com/problemset/submission/1468/276934124
======

Input
4
4 5 7
4 1 3
1 2 5
2 3 8
2 4 1
3 4 4
4 6 5
1 2 1
1 3 1
1 4 2
2 4 1
4 3 1
3 2 1
3 2 10
1 2 8
1 3 10
5 5 15
1 2 17
3 1 15
2 3 10
1 4 14
2 5 8
Output
1
3
0
0
 */
