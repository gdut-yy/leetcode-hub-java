package p1827;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CF1827D {
    // Time limit exceeded on test 7
//    static Scanner scanner;
    static FastReader scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new FastReader();
        out = new PrintWriter(System.out);
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static int[][] pa;
    static int[] dep, tin, tout;
    static int[] bit;
    static int n;

    static void add(int i) {
        for (; i < bit.length; i += i & -i) bit[i]++;
    }

    static int pre(int i) {
        int res = 0;
        for (; i > 0; i &= i - 1) res += bit[i];
        return res;
    }

    static int query(int l, int r) {
        return pre(r) - pre(l - 1);
    }

    static int up(int v, int d) {
        for (int k = dep[v] - d; k > 0; k &= k - 1)
            v = pa[v][Integer.numberOfTrailingZeros(k)];
        return v;
    }

    static int down(int v, int to) {
        if (dep[to] <= dep[v]) return -1;
        to = up(to, dep[v] + 1);
        return pa[to][0] == v ? to : -1;
    }

    static int now;

    static void dfs(List<List<Integer>> g, int v, int p) {
        tin[v] = ++now;
        pa[v][0] = p;
        for (int w : g.get(v)) {
            if (w != p) {
                dep[w] = dep[v] + 1;
                dfs(g, w, v);
            }
        }
        tout[v] = now;
    }

    private static void solve() {
        n = scanner.nextInt();
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());
        for (int w = 1; w < n; w++) {
            int v = scanner.nextInt();
            g.get(v - 1).add(w);
        }
        pa = new int[n][19];
        dep = new int[n];
        tin = new int[n];
        tout = new int[n];
        now = 0;
        dfs(g, 0, -1);
        int mx = 32 - Integer.numberOfLeadingZeros(n);
        for (int i = 0; i < mx - 1; i++) {
            for (int v = 0; v < n; v++) {
                int p = pa[v][i];
                pa[v][i + 1] = p != -1 ? pa[p][i] : -1;
            }
        }
        bit = new int[n + 1];
        add(tin[0]);
        int ct = 0, maxSonSize = 0;
        for (int i = 1; i < n; i++) {
            int nodes = i + 1;
            add(tin[i]);
            int son = down(ct, i);
            int size = son >= 0 ? query(tin[son], tout[son]) : nodes - query(tin[ct], tout[ct]);
            maxSonSize = Math.max(maxSonSize, size);
            if (maxSonSize > nodes / 2) {
                maxSonSize = nodes / 2;
                ct = son >= 0 ? son : pa[ct][0];
            }
            out.print((nodes - maxSonSize * 2) + " ");
        }
        out.println();
    }

    static class FastReader {
        private final BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                if (stringTokenizer.hasMoreTokens()) {
                    str = stringTokenizer.nextToken("\n");
                } else {
                    str = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
/*
D. Two Centroids
https://codeforces.com/contest/1827/problem/D

灵茶の试炼 2026-03-27
题目大意：
输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤5e5。
每组数据输入 n(2≤n≤5e5) 和 n-1 个数 p[2],p[3],...,p[n]。
有一棵无向树，节点编号从 1 开始。一开始只有节点 1。
从 i=2 到 i=n，每次操作，添加一个新的节点 i，和节点 p[i] 相连。
每次操作后，对于这棵有 i 个节点的树，独立计算如下问题（独立指我们不会真的修改这棵树）：
往这棵树上添加节点，最少要添加多少个节点，才能使树拥有两个重心？
注：如果移除节点 x 后，所有连通块的大小都至多为 floor(i/2)，那么称 x 是树的重心。

rating 2800
前置知识：树的重心的性质。
本题会用到的性质：
1. 当树的大小是偶数时，才有两个重心，且这两个重心一定相邻。断开两个重心之间的边，可以得到两个大小为 n/2 的连通块。
2. 在树上添加一个叶子，重心要么不动，要么移动到某个邻居上。
设现在有 n 个节点，设我们在某棵大小为 sz 的子树内添加了 x 个点，同时在子树外添加了 y 个点。
我们希望这棵子树的大小 * 2 = 节点总数。
即 (sz + x) * 2 = n + x + y。
化简得 x = n - sz*2 + y。
由上式可知，y 越小，x 也越小。那么 y=0 是最优的，换句话说，只在子树内加点是最优的。
所以需要加 n - sz*2 个点。
核心思路：往树上添加节点，如果某棵子树的大小恰好等于节点总数的一半（性质 1），即符合要求。
此时有两个重心，一个是子树的根，另一个是子树的根的父节点。或者反过来说，这棵子树是重心的某个儿子子树。
于是，我们只需考察以重心为根时，重心的儿子子树。
由 n - sz*2 可知，sz 越接近 n/2 越好。注意 sz 不能大于 n/2，否则与 sz 是重心的儿子子树的大小相矛盾。
因此，我们除了需要维护重心 ct，还需要维护 ct 的最大儿子子树的大小 maxSonSize。
答案就是 n - maxSonSize*2。
如何维护 maxSonSize？
添加一个点后，有可能 ct 的另一棵儿子子树的大小变大了，maxSonSize 可能换成另一棵儿子子树的大小了。如何判断？
为方便描述，下面把添加节点描述成激活这棵大小为 n（n 是输入的 n）的树中的节点。一开始只有 1 被激活。
分类讨论：
- 情况一：如果以 1 为根时，激活的点 i 在 ct 子树中，那么计算 ct 的儿子 son，使得 i 在 son 子树中。计算 son 子树的大小 size。
- 情况二：如果以 1 为根时，激活的点 i 不在 ct 子树中，那么 ct 上面的子树大小为 size = (当前被激活的节点总数) - (ct 子树的大小)。
然后用 size 更新 maxSonSize 的最大值。
如果更新后，maxSonSize > (当前被激活的节点总数) / 2，那么必须移动重心。
根据性质 2：
- 如果是情况一，那么把 ct 更新为 son。
- 如果是情况二，那么把 ct 更新为 ct 的父节点。
此外，由于我们只加了一个点，所以 maxSonSize > (当前被激活的节点总数) / 2 实际上只比 (当前被激活的节点总数) / 2 多一，那么移动重心后，maxSonSize 就刚好变成 (当前被激活的节点总数) / 2 了。
最后剩下两个实现细节：
1. 如何求出 ct 的儿子 son，使得 i 在 son 子树中？这可以用 LC1483. 树节点的第 K 个祖先 的倍增模板，计算从 i 往上跳到深度 depth[ct] + 1 的位置，即为 ct 的儿子。如果这个节点的父节点不是 ct，说明 i 不在 son 子树中（在 ct 的上面）。
2. 如何求出子树中的被激活的节点个数？计算整棵树的 DFS 时间戳，子树对应一段连续的时间戳，把未被激活的点视作 0，被激活的点视作 1，子树中的被激活的点的个数即为子数组中的 1 的个数。激活节点是单点修改，查询子树中的被激活的节点个数是区间查询，这可以用树状数组维护。
代码 https://codeforces.com/contest/1827/submission/368224118
代码备份（上面打不开的同学看这个）
======

Input
5
2
1
3
1 1
4
1 2 3
7
1 2 3 2 5 2
10
1 2 2 4 5 5 7 8 9
Output
0
0 1
0 1 0
0 1 0 1 2 3
0 1 2 1 0 1 0 1 2
 */
