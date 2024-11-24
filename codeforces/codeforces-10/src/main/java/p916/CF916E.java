package p916;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF916E {
    static Scanner scanner = new Scanner(System.in);
    static int n, q;
    static long[] a;
    static List<Integer>[] g;

    public static void main(String[] args) {
        n = scanner.nextInt();
        q = scanner.nextInt();
        a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int v = scanner.nextInt() - 1;
            int w = scanner.nextInt() - 1;
            g[v].add(w);
            g[w].add(v);
        }
        System.out.println(solve());
    }

    static int dfn;
    static int[][] nodes; // l, r
    static final int mx = 17;
    static int[][] pa;
    static int[] dep;

    private static String solve() {
        dfn = 0;
        nodes = new int[n][2];
        pa = new int[n][mx];
        dep = new int[n];
        build(0, -1);

        for (int i = 0; i + 1 < mx; i++) {
            for (int v = 0; v < pa.length; v++) {
                int p = pa[v][i];
                if (p != -1) {
                    pa[v][i + 1] = pa[p][i];
                } else {
                    pa[v][i + 1] = -1;
                }
            }
        }

        List<Long> output = new ArrayList<>(q);
        FenwickDiff tr = new FenwickDiff(n);
        int rt = 0;
        for (; q > 0; q--) {
            int op = scanner.nextInt();
            int v = scanner.nextInt() - 1;

            if (op == 1) {
                rt = v;
            } else if (op == 2) {
                int w = scanner.nextInt() - 1;
                int val = scanner.nextInt();

                int lca = getLCA(v, w);
                if (lca == rt) {
                    tr.add(1, n, val);
                } else if (!isAncestor(lca, rt)) {
                    // 更新 lca 子树
                    int[] p = nodes[lca];
                    tr.add(p[0], p[1], val);
                } else { // lca 是 rt 的祖先
                    int maxD = Math.max(dep[getLCA(rt, v)], dep[getLCA(rt, w)]);
                    if (maxD < dep[rt]) {
                        int subV = uptoDep(rt, maxD + 1);
                        int[] p = nodes[subV];
                        tr.add(p[0], p[1], -val);
                    }
                    // 更新整棵树
                    tr.add(1, n, val);
                }
            } else {
                long res;
                if (v == rt) {
                    res = a[0] + tr.query(1, n);
                } else if (!isAncestor(v, rt)) {
                    int[] p = nodes[v];
                    res = a[v] + tr.query(p[0], p[1]);
                } else { // v 是 rt 的祖先
                    int subV = uptoDep(rt, dep[v] + 1);
                    int[] p = nodes[subV];
                    res = a[0] + tr.query(1, n) - a[subV] - tr.query(p[0], p[1]);
                }
                output.add(res);
            }
        }
        return output.stream().map(String::valueOf).collect(Collectors.joining(System.lineSeparator()));
    }

    // CF383C
    static int build(int v, int fa) {
        dfn++;
        nodes[v][0] = dfn;
        pa[v][0] = fa;
        int sz = 1;
        for (Integer w : g[v]) {
            if (w != fa) {
                dep[w] = dep[v] + 1;
                sz += build(w, v);
                a[v] += a[w]; // 注意 a 可能爆 int
            }
        }
        nodes[v][1] = nodes[v][0] + sz - 1;
        return sz;
    }

    static int uptoDep(int v, int d) {
        for (int k = dep[v] - d; k > 0; k &= k - 1) {
            v = pa[v][Integer.numberOfTrailingZeros(k)];
        }
        return v;
    }

    static int getLCA(int v, int w) {
        if (dep[v] > dep[w]) {
            int tmp = v;
            v = w;
            w = tmp;
        }
        w = uptoDep(w, dep[v]);
        if (w == v) return v;
        for (int i = mx - 1; i >= 0; i--) {
            if (pa[v][i] != pa[w][i]) {
                v = pa[v][i];
                w = pa[w][i];
            }
        }
        return pa[v][0];
    }

    // 判断节点 u 是否是节点 v 的祖先
    static boolean isAncestor(int f, int v) {
        return nodes[f][0] < nodes[v][0] && nodes[v][0] <= nodes[f][1];
    }

    static class FenwickDiff {
        int n;
        long[][] t;

        public FenwickDiff(int n) {
            this.n = n;
            t = new long[n + 1][2];
        }

        int lb(int x) {
            return x & -x;
        }

        void add(int l, int r, long val) {
            _add(l, val);
            _add(r + 1, -val);
        }

        void _add(int i, long val) {
            for (long iv = i * val; i < t.length; i += lb(i)) {
                t[i][0] += val;
                t[i][1] += iv;
            }
        }

        long query(int l, int r) {
            return pre(r) - pre(l - 1);
        }

        long pre(int i0) {
            long s0 = 0, s1 = 0;
            for (int i = i0; i > 0; i &= i - 1) {
                s0 += t[i][0];
                s1 += t[i][1];
            }
            return (i0 + 1) * s0 - s1;
        }
    }
}
/*
E. Jamie and Tree
https://codeforces.com/contest/916/problem/E

灵茶の试炼 2024-02-23
题目大意：
输入 n(1≤n≤1e5) q(1≤q≤1e5) 和长为 n 的数组 a(-1e8≤a[i]≤1e8)，表示一棵树的节点点权。
然后输入这棵树的 n-1 条边。节点编号从 1 到 n。
然后输入 q 个操作。
一开始，树根为节点 1。
有三种操作：
"1 v"：将整棵树的树根改为节点 v。
"2 v w val"：设 lca 为 v 和 w 的最近公共祖先，把以 lca 为根的子树的所有节点的点权增加 val。其中 -1e8≤val≤1e8。
"3 v"：输出以 v 为根的子树的所有节点的点权之和。

rating 2400
前置知识：
1. 区间更新区间求和，可以用 lazy 线段树或者树状数组
2. 树上时间戳，用来计算子树对应的区间，以及判断祖先关系，见
DFS 时间戳——处理树上问题的有力工具（Python/Java/C++/Go）
3. 倍增 LCA，见
【模板讲解】树上倍增算法（以及最近公共祖先）
如果你会上述几个知识点，本题画画图分类讨论一下就解决了。
首先原地计算每棵子树的点权和，现在 a[i] 表示以 i 为根的子树的初始点权和。
设当前树根为 rt。
操作 3：
1. 如果 v 是 rt，那么答案为整棵树的点权和，加上 [1,n] 的区间和。
2. 如果 v 不是 rt 的祖先，那么答案为 a[v] 加上节点 v 对应的区间和。
3. 如果 v 是 rt 的祖先，设节点 subV 为 v 往 rt 方向的儿子节点（从 rt 往上跳到 v 的深度+1 位置），那么答案为整棵树的点权和，加上 [1,n] 的区间和，再减去 a[subV] 以及 subV 对应的区间和。
操作 2，设 v 和 w 的最近公共祖先为 lca：
1. 如果 lca 是 rt，那么把区间 [1,n] 增加 val。
2. 如果 lca 不是 rt 的祖先，那么把 lca 对应的区间增加 val。
3. 如果 lca 是 rt 的祖先，并且 v 和 w 至少有一个在 rt 下面（深度比 rt 大），那么直接把区间 [1,n] 增加 val。
4. 如果 lca 是 rt 的祖先，并且 v 和 w 都不在 rt 下面，设节点 subV 为 lca 往 rt 方向的儿子节点，那么把不在 subV 对应区间的数都增加 val。
https://codeforces.com/contest/916/submission/247591101
======

input
6 7
1 4 2 8 5 7
1 2
3 1
4 3
4 5
3 6
3 1
2 4 6 3
3 4
1 6
2 2 4 -5
1 4
3 3
output
27
19
5

input
4 6
4 3 5 6
1 2
2 3
3 4
3 1
1 3
2 2 4 3
1 1
2 2 4 -3
3 1
output
18
21
 */
