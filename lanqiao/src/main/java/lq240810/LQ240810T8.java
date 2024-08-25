package lq240810;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LQ240810T8 {
    static int[] a;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        tr = new HLD(n);
        for (int i = 0; i < n - 1; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            tr.addEdge(u, v);
        }
        tr.work();

        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        cnt = 0;
        ans = INF;
        s = new String[n];
        trie01 = new Trie01(n, 60);

        calc(0, -1);

        System.out.println(String.join(" ", s));
    }

    static final long INF = (long) 1e18;
    static HLD tr;
    static Trie01 trie01;
    static int cnt;
    static long ans;
    static String[] s;

    static void add(int x) {
        int v = a[x];
        cnt++;
        trie01.insert(v, 1);
    }

    static void del(int x) {
        int v = a[x];
        cnt--;
        trie01.insert(v, -1);
    }

    static int query(int x) {
        int v = a[x];
        if (cnt > 0) {
            return trie01.min_xor(v);
        }
        return -1;
    }

    static void calc(int x, int kepp) {
        for (int y : tr.adj[x]) {
            if (y != tr.adj[x].get(0)) {
                calc(y, -1);
            }
        }

        if (!tr.adj[x].isEmpty()) {
            calc(tr.adj[x].get(0), 1);

            for (int y : tr.adj[x]) {
                if (y != tr.adj[x].get(0)) {
                    for (int i = tr.in[y]; i < tr.out[y]; ++i) {
                        add(tr.seq[i]);
                    }
                }
            }
        }

        s[x] = "" + query(x);
        add(x);

        if (kepp == -1) {
            ans = INF;
            for (int i = tr.in[x]; i < tr.out[x]; ++i) {
                del(tr.seq[i]);
            }
        }
    }

    private static String solve() {
        return "";
    }

    // 0-1 Trie
    // 2^31
    static class Trie01 {
        int[][] dict;
        int[] cnt;
        int nextIdx, m;

        // n:长度 m:2^m
        public Trie01(int n, int m) {
            this.dict = new int[2][n * m + 2];
            this.cnt = new int[n * m + 2];
            this.nextIdx = 1;
            this.m = m;
        }

        // op:1 插入 op:-1 删除
        public void insert(int x, int op) {
            int idx = 0;
            for (int k = m - 1; k >= 0; k--) {
                int pos = x >> k & 1;
                if (dict[pos][idx] == 0) {
                    dict[pos][idx] = nextIdx++;
                }
                idx = dict[pos][idx];
                cnt[idx] += op;
            }
        }

        public int max_xor(int x) {
            int res = 0;
            int idx = 0;
            for (int k = m - 1; k >= 0; k--) {
                int pos = x >> k & 1;
                // 优先选择与当前位相同的位，如果不存在或者计数为0，则选择相反的位
                if (cnt[dict[1 ^ pos][idx]] != 0) {
                    res |= 1 << k;
                    idx = dict[1 ^ pos][idx];
                } else {
                    idx = dict[pos][idx];
                }
            }
            return res;
        }

        public int min_xor(int x) {
            int res = 0;
            int idx = 0;
            for (int k = m - 1; k >= 0; k--) {
                int pos = x >> k & 1;
                // 优先选择与当前位相同的位，如果不存在或者计数为0，则选择相反的位
                if (cnt[dict[pos][idx]] != 0) {
                    idx = dict[pos][idx];
                } else {
                    res |= 1 << k;
                    idx = dict[1 ^ pos][idx];
                }
            }
            return res;
        }
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
七夕城【算法赛】

树上启发式合并 + 字典树
考虑枚举点 v，那么 u 点一定是 v 子树内的一点，如果暴力枚举的话复杂度为 O(n^2)。
如果你学习过树上启发式合并，不难想到使用树上启发式优化枚举，复杂度降为 O(nlogn)。
由于需要查询异或最小值，不难想到使用字典树，所以整体复杂度为 O(n log^2 n)。
 */