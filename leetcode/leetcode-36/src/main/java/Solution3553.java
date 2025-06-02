import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3553 {
    private List<int[]>[] g;
    private int dfn;
    private int[][] nodes; // l, r
    private final int mx = 17;
    private int[][] pa;
    private int[] dep;
    private int[] sum_to_root;

    public int[] minimumWeight(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
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
        sum_to_root = new int[n];
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
            int src1 = queries[i][0], src2 = queries[i][1], dest = queries[i][2];
            int sum1 = get_path_sum(src1, dest);
            int sum2 = get_path_sum(src2, dest);
            int sum3 = get_path_sum(src1, src2);
            ans[i] = (sum1 + sum2 + sum3) / 2;
        }
        return ans;
    }

    int get_path_sum(int u, int v) {
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
3553. 包含给定路径的最小带权子树 II
https://leetcode.cn/problems/minimum-weighted-subgraph-with-the-required-paths-ii/description/

第 450 场周赛 T4。

给你一个 无向带权 树，共有 n 个节点，编号从 0 到 n - 1。这棵树由一个二维整数数组 edges 表示，长度为 n - 1，其中 edges[i] = [ui, vi, wi] 表示存在一条连接节点 ui 和 vi 的边，权重为 wi。
此外，给你一个二维整数数组 queries，其中 queries[j] = [src1j, src2j, destj]。
返回一个长度等于 queries.length 的数组 answer，其中 answer[j] 表示一个子树的 最小总权重 ，使用该子树的边可以从 src1j 和 src2j 到达 destj 。
这里的 子树 是指原树中任意节点和边组成的连通子集形成的一棵有效树。
提示：
3 <= n <= 10^5
edges.length == n - 1
edges[i].length == 3
0 <= ui, vi < n
1 <= wi <= 104
1 <= queries.length <= 10^5
queries[j].length == 3
0 <= src1j, src2j, destj < n
src1j、src2j 和 destj 互不不同。
输入数据保证 edges 表示的是一棵有效的树。

最近公共祖先 LCA。
时间复杂度 O((n+q)logn)。
相似题目: E. Jamie and Tree
https://codeforces.com/contest/916/problem/E
3559. 给边赋权值的方案数 II
https://leetcode.cn/problems/number-of-ways-to-assign-edge-weights-ii/description/
rating 2413 (clist.by)
 */