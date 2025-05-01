package p1899;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CF1899G {
    static Scanner scanner = new Scanner(System.in);
    static int n, q;
    static List<Integer>[] g;
    static int[] a;

    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            q = scanner.nextInt();
            g = new ArrayList[n];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (int i = 1; i < n; i++) {
                int v = scanner.nextInt() - 1;
                int w = scanner.nextInt() - 1;
                g[v].add(w);
                g[w].add(v);
            }
            a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    static class node {
        int l, r;
    }

    record data(int x, int d, int qid) {
    }

    static node[] nodes;
    static int dfn;
    static List<data>[] qs;

    private static String solve() {
        nodes = new node[n];
        Arrays.setAll(nodes, e -> new node());
        dfn = 1;
        dfs(0, -1);

        qs = new ArrayList[n];
        Arrays.setAll(qs, e -> new ArrayList<>());
        for (int i = 0; i < q; i++) {
            int l = scanner.nextInt() - 1;
            int r = scanner.nextInt() - 1;
            int x = scanner.nextInt() - 1;
            l--;
            if (l >= 0) {
                qs[l].add(new data(x, -1, i));
            }
            qs[r].add(new data(x, 1, i));
        }

        int[] ans = new int[q];
        BIT tr = new BIT(n);
        for (int i = 0; i < n; i++) {
            List<data> ps = qs[i];
            // for j := nodes[a[i]-1].l; j <= n; j += j & -j {
            //     t[j]++
            // }
            tr.add(nodes[a[i] - 1].l, 1);
            for (data p : ps) {
                node node = nodes[p.x];
                // ans[p.qid] += p.d * (pre(node.r) - pre(node.l-1))
                ans[p.qid] += p.d * (tr.query(node.l, node.r));
            }
        }

        return Arrays.stream(ans).mapToObj(v -> v > 0 ? "YES" : "NO").collect(Collectors.joining(System.lineSeparator()));
    }

    static void dfs(int v, int fa) {
        nodes[v].l = dfn;
        dfn++;
        for (Integer w : g[v]) {
            if (w != fa) {
                dfs(w, v);
            }
        }
        nodes[v].r = dfn - 1;
    }

    static class BIT {
        int n;
        int[] tree;

        public BIT(int n) {
            this.n = n;
            tree = new int[n + 1];
        }

        int lb(int x) {
            return x & -x;
        }

        void add(int pos, int val) {
            for (; pos <= n; pos += lb(pos)) tree[pos] += val;
        }

        int pre(int pos) {
            int ret = 0;
            for (; pos > 0; pos -= lb(pos)) ret += tree[pos];
            return ret;
        }

        int query(int l, int r) {
            return pre(r) - pre(l - 1);
        }
    }
}
/*
G. Unusual Entertainment
https://codeforces.com/contest/1899/problem/G

灵茶の试炼 2024-12-12
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤1e5，q 之和 ≤1e5。
每组数据输入 n(1≤n≤1e5) 和 q(1≤q≤1e5)。
然后输入一棵无向树的 n-1 条边，节点编号从 1 到 n。根节点是 1。
然后输入一个 1~n 的排列 p。下标从 1 开始。
然后输入 q 个询问，每个询问输入 L R(1≤L≤R≤n) x(1≤x≤n)。
对于每个询问，回答在 p[L],p[L+1],...,p[R] 这些节点中，是否存在一个节点是 x 的后代（在 x 子树中）。
输出 YES 或 NO。

rating 1900
把节点在 p 中的下标视作横坐标。
把节点在树中（首次访问的）时间戳视作纵坐标。
每个询问相当于问横坐标在 [L,R] 中，纵坐标在 x 子树所有节点的时间戳（这是一个范围）中，这个矩形区域内的点的个数。
这是静态二维数点问题，见上周周赛第四题。
代码 https://codeforces.com/contest/1899/submission/287006725
代码备份（洛谷）
======

Input
3
3 5
1 2
2 3
1 2 3
1 2 2
1 2 3
2 3 1
1 2 3
2 3 3
10 10
2 6
2 7
2 4
1 7
2 8
10 6
8 5
9 4
3 4
10 2 5 9 1 7 6 4 3 8
8 9 8
7 8 1
7 10 6
4 8 9
5 5 10
7 10 1
9 9 2
9 10 6
6 6 2
10 10 6
1 1
1
1 1 1
Output
YES
NO
YES
NO
YES

NO
YES
YES
YES
NO
YES
YES
NO
NO
NO

YES
 */
