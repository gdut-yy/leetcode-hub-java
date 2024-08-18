package lq240727;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LQ240727T8 {
    static int n;
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static String solve() {
        HLD tr = new HLD(n);
        int root = -1;

        for (int i = 0; i < n; ++i) {
            int x = a[i];
            if (x == 0) {
                root = i;
            } else {
                x--;
                tr.addEdge(i, x);
            }
        }

        tr.work(root);
        int[] s = new int[n + 2];
        for (int i = 0; i < n; ++i) {
            int l = tr.dep[i] + 1, r = (n - tr.siz[i] + 1);
            s[l]++;
            s[r + 1]--;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            s[i] += s[i - 1];
            ans.append(s[i]).append(" ");
        }
        return ans.toString();
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
//                adj[u].erase(find(adj[u].begin(), adj[u].end(), parent[u]));
            }
            siz[u] = 1;
            for (int i = 0; i < adj_u.size(); i++) {
                int v = adj_u.get(i);
                parent[v] = u;
                dep[v] = dep[u] + 1;
                dfs1(v);
                siz[u] += siz[v];
                if (siz[v] > siz[adj_u.get(0)]) {
//                    swap(v, adj[u][0]);
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
//            swap(u, v);
            int tmp = u;
            u = v;
            v = tmp;

            if (u == v) return u;
            if (!isAncestor(u, v)) {
                return parent[u];
            }
//            auto it = upper_bound(adj[u].begin(), adj[u].end(), v,[ &]( int x, int y){
//                return in[x] < in[y];
//            })-1;
//            return *it;
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
花果山洞【算法赛】

树链剖分，英文名字为 heavy-light decomposition。
 */