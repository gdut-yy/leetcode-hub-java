import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3559 {
    static final int MOD = (int) (1e9 + 7);

    // 快速幂 res = a^b % mod
    private long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    private List<Integer>[] g;
    private int dfn;
    private int[][] nodes; // l, r
    private final int mx = 17;
    private int[][] pa;
    private int[] dep;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0] - 1, y = e[1] - 1;
            g[x].add(y);
            g[y].add(x);
        }
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

        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int k = get_path_sum(queries[i][0] - 1, queries[i][1] - 1);
            if (k == 0) continue;
            ans[i] = (int) quickPow(2, k - 1);
        }
        return ans;
    }

    int get_path_sum(int u, int v) {
        int ancestor = getLCA(u, v);
        return dep[u] + dep[v] - 2 * dep[ancestor];
    }

    int build(int v, int fa) {
        dfn++;
        nodes[v][0] = dfn;
        pa[v][0] = fa;
        int sz = 1;
        for (int w : g[v]) {
            if (w != fa) {
                dep[w] = dep[v] + 1;
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
3559. 给边赋权值的方案数 II
https://leetcode.cn/problems/number-of-ways-to-assign-edge-weights-ii/description/

第 157 场双周赛 T4。

给你一棵有 n 个节点的无向树，节点从 1 到 n 编号，树以节点 1 为根。树由一个长度为 n - 1 的二维整数数组 edges 表示，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间有一条边。
一开始，所有边的权重为 0。你可以将每条边的权重设为 1 或 2。
两个节点 u 和 v 之间路径的 代价 是连接它们路径上所有边的权重之和。
给定一个二维整数数组 queries。对于每个 queries[i] = [ui, vi]，计算从节点 ui 到 vi 的路径中，使得路径代价为 奇数 的权重分配方式数量。
返回一个数组 answer，其中 answer[i] 表示第 i 个查询的合法赋值方式数量。
由于答案可能很大，请对每个 answer[i] 取模 10^9 + 7。
注意： 对于每个查询，仅考虑 ui 到 vi 路径上的边，忽略其他边。
提示：
2 <= n <= 10^5
edges.length == n - 1
edges[i] == [ui, vi]
1 <= queries.length <= 10^5
queries[i] == [ui, vi]
1 <= ui, vi <= n
edges 表示一棵合法的树。

最近公共祖先 LCA。
答案为 2^{k-1} % mod。k 为两点之间的距离（边数），套 LCA 模板即可。
相似题目: 3553. 包含给定路径的最小带权子树 II
https://leetcode.cn/problems/minimum-weighted-subgraph-with-the-required-paths-ii/description/
rating 2509 (clist.by)
 */