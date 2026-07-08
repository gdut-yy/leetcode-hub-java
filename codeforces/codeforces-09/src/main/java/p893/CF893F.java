package p893;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CF893F {
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

    static class Node {
        Node lo, ro;
        int mn;

        Node(int mn) {
            this.mn = mn;
        }
    }

    static final int INF = (int) 1e9;

    static Node build(int l, int r) {
        Node o = new Node(INF);
        if (l == r) return o;
        int m = (l + r) >> 1;
        o.lo = build(l, m);
        o.ro = build(m + 1, r);
        return o;
    }

    static Node update(Node o, int l, int r, int i, int val) {
        Node copy = new Node(o.mn);
        copy.lo = o.lo;
        copy.ro = o.ro;
        if (l == r) {
            copy.mn = val;
            return copy;
        }
        int m = (l + r) >> 1;
        if (i <= m) {
            copy.lo = update(o.lo, l, m, i, val);
        } else {
            copy.ro = update(o.ro, m + 1, r, i, val);
        }
        copy.mn = Math.min(copy.lo.mn, copy.ro.mn);
        return copy;
    }

    static int query(Node o, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) return o.mn;
        int m = (l + r) >> 1;
        if (qr <= m) return query(o.lo, l, m, ql, qr);
        if (m < ql) return query(o.ro, m + 1, r, ql, qr);
        return Math.min(query(o.lo, l, m, ql, qr), query(o.ro, m + 1, r, ql, qr));
    }

    static int n, rt, dfn;
    static int[] a, dis;
    static int[][] nodes;
    static List<Integer>[] g;

    static void dfs(int v, int fa) {
        nodes[v][0] = dfn;
        dfn++;
        for (int w : g[v]) {
            if (w != fa) dfs(w, v);
        }
        nodes[v][1] = dfn - 1;
    }

    private static void solve() {
        n = scanner.nextInt();
        rt = scanner.nextInt();
        rt--;
        a = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            v--;
            w--;
            g[v].add(w);
            g[w].add(v);
        }
        nodes = new int[n][2];
        dfn = 0;
        dfs(rt, -1);
        List<Node> ts = new ArrayList<>();
        ts.add(build(0, n - 1));
        dis = new int[n];
        dis[rt] = 1;
        List<Integer> q = new ArrayList<>();
        q.add(rt);
        while (!q.isEmpty()) {
            List<Integer> tmp = q;
            q = new ArrayList<>();
            Node t = ts.get(ts.size() - 1);
            for (int v : tmp) {
                t = update(t, 0, n - 1, nodes[v][0], a[v]);
                for (int w : g[v]) {
                    if (dis[w] == 0) {
                        dis[w] = ts.size() + 1;
                        q.add(w);
                    }
                }
            }
            ts.add(t);
        }
        int m = scanner.nextInt();
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int k = scanner.nextInt();
            x = (x + ans) % n;
            k = (k + ans) % n;
            int[] p = nodes[x];
            ans = query(ts.get(Math.min(dis[x] + k, ts.size() - 1)), 0, n - 1, p[0], p[1]);
            out.println(ans);
        }
    }
}
/*
F. Subtree Minimum Query
https://codeforces.com/contest/893/problem/F

灵茶の试炼 2025-12-04
题目大意：
输入 n(1≤n≤1e5) root(1≤root≤n) 和长为 n 的数组 a(1≤a[i]≤1e9)。
然后输入一棵 n 个节点的树的 n-1 条边。节点编号从 1 到 n。
树根为 root，点权为 a。
然后输入 m(1≤m≤1e6) 和 m 个询问。强制在线。
第 i 个询问输入两个数 p q(1≤p,q≤n)，用于计算 x = (p + lastAns) % n + 1 以及 k = (q + lastAns) % n。
其中 lastAns 为上一个询问的答案，初始值为 0。
对于每个询问：
找到在子树 x 中的，到 x 的最短路（边的个数）不超过 k 的点，输出这些点中的最小点权。

rating 2300
前置知识：DFS 时间戳——处理树上问题的有力工具。
DFS 这棵树，我们可以得到一个节点的访问顺序 order。
一棵子树的节点访问顺序，是 order 的一个连续子数组。
所以问题相当于求区间最小值。
然而，题目有深度限制，这意味着一棵子树深度超过 depth[x] + k 的节点会被砍掉，不能计入。其中根节点的深度为 1。
怎么办？
BFS 这棵树，对前 1,2,3,... 层的节点建立线段树（可持久化线段树），维护区间最小点权。
做查询的时候，我们可以放心地在第 depth[x] + k 棵线段树上查询，因为深度超过 depth[x] + k 的点权还没有添加到这棵线段树中。
注意 depth[x] + k 可能会超过树的深度，这种情况在最后一棵线段树上查询。
代码 https://codeforces.com/contest/893/submission/351457670
代码备份（上面打不开的同学看这个）
======

Input
5 2
1 3 2 3 5
2 3
5 1
3 4
4 1
2
1 2
2 3
Output
2
5
 */
