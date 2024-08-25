package lq240824;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LQ240824T8 {
    static int n, m;
    static int[] a, b;
    static HLD tr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        tr = new HLD(n);
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            tr.addEdge(u, v);
        }
        tr.work();

        a = new int[m + 1];
        b = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            a[i] = scanner.nextInt() - 1;
            b[i] = scanner.nextInt() - 1;
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[][] f = new long[m + 1][2];
        for (int i = m - 1; i >= 0; --i) {
            f[i][0] = Math.max(
                    tr.dist(a[i], a[i + 1]) - tr.dist(b[i], b[i + 1]) - f[i + 1][1],
                    tr.dist(a[i], b[i + 1]) - tr.dist(b[i], a[i + 1]) - f[i + 1][0]);

            f[i][1] = Math.max(
                    tr.dist(b[i], a[i + 1]) - tr.dist(a[i], b[i + 1]) - f[i + 1][1],
                    tr.dist(b[i], b[i + 1]) - tr.dist(a[i], a[i + 1]) - f[i + 1][0]);
        }

        long ans = Math.max(f[0][0], f[0][1]);
        return String.valueOf(ans);
    }

    static class HLD {
        int n;
        int[] siz, top, dep, parent, in, out, seq;
        List<Integer>[] adj;
        int cur;

        public HLD(int n) {
            this.n = n;
            this.siz = new int[n];
            this.top = new int[n];
            this.dep = new int[n];
            this.parent = new int[n];
            this.in = new int[n];
            this.out = new int[n];
            this.seq = new int[n];
            cur = 0;
            this.adj = new ArrayList[n];
            Arrays.setAll(adj, e -> new ArrayList<>());
        }

        // 在节点 u 和 v 之间添加一条无向边。
        void addEdge(int u, int v) {
            adj[u].add(v);
            adj[v].add(u);
        }

        void work() {
            work(0);
        }

        // 对外的接口函数，开始执行重链剖分。
        void work(int root) {
            top[root] = root;
            dep[root] = 0;
            parent[root] = -1;
            dfs1(root);
            dfs2(root);
        }

        // 第一遍深度优先搜索，计算每个节点的大小、深度、父节点，并对子节点按大小排序，保证重儿子在第一位。
        void dfs1(int u) {
            List<Integer> adj_u = adj[u];
            if (parent[u] != -1) {
                adj_u.remove((Integer) parent[u]);
            }
            siz[u] = 1;
            for (int i = 0; i < adj_u.size(); i++) {
                int v = adj_u.get(i);
                parent[v] = u;
                dep[v] = dep[u] + 1;
                dfs1(v);
                siz[u] += siz[v];
                if (siz[v] > siz[adj_u.get(0)]) {
                    adj_u.set(i, adj_u.get(0));
                    adj_u.set(0, v);
                }
            }
        }

        // 第二遍深度优先搜索，分配每个节点的进时间戳 in[u]，
        // 建立重链，并计算每个节点的出时间戳 out[u]。
        void dfs2(int u) {
            in[u] = cur++;
            seq[in[u]] = u;
            for (int v : adj[u]) {
                top[v] = (v == adj[u].get(0)) ? top[u] : v;
                dfs2(v);
            }
            out[u] = cur;
        }

        // 计算节点 u 和 v 的最近公共祖先（LCA）
        int lca(int u, int v) {
            while (top[u] != top[v]) {
                if (dep[top[u]] > dep[top[v]]) {
                    u = parent[top[u]];
                } else {
                    v = parent[top[v]];
                }
            }
            return dep[u] < dep[v] ? u : v;
        }

        // 计算节点 u 和 v 之间的距离。
        int dist(int u, int v) {
            return dep[u] + dep[v] - 2 * dep[lca(u, v)];
        }

        // 在树上从节点 u 向上跳 k 步，返回目标节点索引，如果不可能则返回 -1。
        int jump(int u, int k) {
            if (dep[u] < k) return -1;
            int d = dep[u] - k;
            while (dep[top[u]] > d) {
                u = parent[top[u]];
            }
            return seq[in[u] - dep[u] + d];
        }

        // 判断节点 u 是否是节点 v 的祖先
        boolean isAncestor(int u, int v) {
            return in[u] <= in[v] && in[v] <= out[u];
        }

        // 在以 u 为根的树中，找到 v 的父节点
        int rootedParent(int u, int v) {
            int tmp = u;
            u = v;
            v = tmp;

            if (u == v) return u;
            if (!isAncestor(u, v)) {
                return parent[u];
            }
            return upperBound(adj[u], v) - 1;
        }

        int upperBound(List<Integer> a, int key) {
            int l = 0, r = a.size();
            while (l < r) {
                int m = l + (r - l) / 2;
                if (in[a.get(m)] < in[key]) r = m;
                else l = m + 1;
            }
            return l;
        }

        // 在以 u 为根的树上，计算以 v 为根的子树大小
        int rootedSize(int u, int v) {
            if (u == v) return n;
            if (!isAncestor(v, u)) {
                return siz[v];
            }
            return n - siz[rootedParent(u, v)];
        }

        // 在根变为 a 的情况下，求 b 与 c 的 LCA
        int rootedLca(int a, int b, int c) {
            return lca(a, b) ^ lca(b, c) ^ lca(c, a);
        }
    }
}
/*
救灾【算法赛】

定义 dist(u, v) 为从区域 u 到 v 的最短路径上的道路数量。我们可以使用最近公共祖先 O(log N) 的时间内计算该值。假设 p 是在某一天可以选择工作区域的人，q 是另一人。
定义 dp(i,1) 为在第 i 天，如果 p 选择了区域 A_i，那么 p 和 q 之间道路数量差值的最大值。同样，定义 dp(i,2) 为在第 i 天，如果 p 选择了区域 B_i 的差值最大值。
为了计算 dp(i,j)，我们将尝试所有可能的从第 i 天到第 (i+1) 天的 p 和 q 的区域转移情况：
---
dp(i,1) = max\left\{\begin{matrix}
dist(A_i,A_{i+1}) - dist(B_i,B_{i+1}) - dp(i+1,2) \\
dist(A_i,B_{i+1}) - dist(B_i,A_{i+1}) - dp(i+1,1)
\end{matrix}\right.
---
dp(i,2) = max\left\{\begin{matrix}
dist(B_i,A_{i+1}) - dist(A_i,B_{i+1}) - dp(i+1,2) \\
dist(B_i,B_{i+1}) - dist(A_i,A_{i+1}) - dp(i+1,1)
\end{matrix}\right.
我们可以通过取 dp(1,1) 和 dp(1,2) 的最大值来得到答案。
 */