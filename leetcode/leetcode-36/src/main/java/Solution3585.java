import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3585 {
    private List<int[]>[] g;
    private int dfn;
    private int[][] nodes; // l, r
    private final int mx = 17;
    private int[][] pa;
    private int[] dep;
    private long[] sum_to_root;

    public int[] findMedian(int n, int[][] edges, int[][] queries) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(new int[]{e[1], e[2]});
            g[e[1]].add(new int[]{e[0], e[2]});
        }
        dfn = 0;
        nodes = new int[n][2];
        pa = new int[n][mx];
        dep = new int[n];
        sum_to_root = new long[n];
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

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0], v = queries[i][1];
            long total = get_path_sum(u, v);
            int lcaNode = getLCA(u, v);
            int current1 = u;
            for (int k = mx - 1; k >= 0; k--) {
                int next_node = pa[current1][k];
                if (next_node == -1) continue;
                if (dep[next_node] < dep[lcaNode]) continue;
                if (2 * (sum_to_root[u] - sum_to_root[next_node]) < total) {
                    current1 = next_node;
                }
            }
            if (current1 != lcaNode) {
                ans[i] = pa[current1][0];
            } else {
                int candidate2 = v;
                for (int k = mx - 1; k >= 0; k--) {
                    int next_node = pa[candidate2][k];
                    if (next_node == -1) continue;
                    if (dep[next_node] <= dep[lcaNode]) continue;
                    if (2 * (sum_to_root[u] + sum_to_root[next_node] - 2 * sum_to_root[lcaNode]) >= total) {
                        candidate2 = next_node;
                    }
                }
                ans[i] = candidate2;
            }
        }
        return ans;
    }

    long get_path_sum(int u, int v) {
        int ancestor = getLCA(u, v);
        return sum_to_root[u] + sum_to_root[v] - 2 * sum_to_root[ancestor];
    }

    int build(int v, int fa) {
        dfn++;
        nodes[v][0] = dfn;
        pa[v][0] = fa;
        int sz = 1;
        for (int[] p : g[v]) {
            int w = p[0], wt = p[1];
            if (w != fa) {
                dep[w] = dep[v] + 1;
                sum_to_root[w] = sum_to_root[v] + wt;
                sz += build(w, v);
            }
        }
        nodes[v][1] = nodes[v][0] + sz - 1;
        return sz;
    }

    int uptoDep(int v, int d) {
        for (int k = dep[v] - d; k > 0; k &= k - 1) {
            v = pa[v][Integer.numberOfTrailingZeros(k)];
        }
        return v;
    }

    int getLCA(int v, int w) {
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
}
/*
3585. 树中找到带权中位节点
https://leetcode.cn/problems/find-weighted-median-node-in-tree/description/

第 454 场周赛 T4。

给你一个整数 n，以及一棵 无向带权 树，根节点为节点 0，树中共有 n 个节点，编号从 0 到 n - 1。该树由一个长度为 n - 1 的二维数组 edges 表示，其中 edges[i] = [ui, vi, wi] 表示存在一条从节点 ui 到 vi 的边，权重为 wi。
带权中位节点 定义为从 ui 到 vi 路径上的 第一个 节点 x，使得从 ui 到 x 的边权之和 大于等于 该路径总权值和的一半。
给你一个二维整数数组 queries。对于每个 queries[j] = [uj, vj]，求出从 uj 到 vj 路径上的带权中位节点。
返回一个数组 ans，其中 ans[j] 表示查询 queries[j] 的带权中位节点编号。
提示:
2 <= n <= 10^5
edges.length == n - 1
edges[i] == [ui, vi, wi]
0 <= ui, vi < n
1 <= wi <= 10^9
1 <= queries.length <= 10^5
queries[j] == [uj, vj]
0 <= uj, vj < n
输入保证 edges 表示一棵合法的树。

最近公共祖先 LCA + 树上倍增。
先从 u 点倍增到 lca 点，若干未能得到答案，那么再从 lca 点倍增到 v 点（反向）。
时间复杂度 O((n+q)logn)。
rating 2399 (clist.by)
 */