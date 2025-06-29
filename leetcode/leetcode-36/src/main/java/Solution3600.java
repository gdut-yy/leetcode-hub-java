import java.util.ArrayList;
import java.util.List;

public class Solution3600 {
    private int n, k;
    private List<int[]> mustEdges, optionalEdges;

    public int maxStability(int n, int[][] edges, int k) {
        this.n = n;
        this.k = k;
        mustEdges = new ArrayList<>();
        optionalEdges = new ArrayList<>();
        for (int[] edge : edges) {
            if (edge[3] == 1) {
                mustEdges.add(edge);
            } else {
                optionalEdges.add(edge);
            }
        }

        int left = 0;
        int right = (int) 2e5;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!check(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private boolean check(int X) {
        DSU uf = new DSU(n);

        for (int[] edge : mustEdges) {
            int u = edge[0], v = edge[1], s = edge[2];
            if (s < X) {
                return false;
            }
            int ru = uf.find(u);
            int rv = uf.find(v);
            if (ru != rv) {
                uf.union(u, v);
            } else {
                return false;
            }
        }

        int upgrades = 0;
        for (int[] edge : optionalEdges) {
            int u = edge[0], v = edge[1], s = edge[2];
            if (s >= X) {
                int ru = uf.find(u);
                int rv = uf.find(v);
                if (ru != rv) {
                    uf.union(u, v);
                }
            }
        }

        for (int[] edge : optionalEdges) {
            int u = edge[0], v = edge[1], s = edge[2];
            if (s < X && 2 * s >= X) {
                int ru = uf.find(u);
                int rv = uf.find(v);
                if (ru != rv) {
                    uf.union(u, v);
                    upgrades++;
                    if (upgrades > k) {
                        break;
                    }
                }
            }
        }

        return uf.sz == 1 && upgrades <= k;
    }

    static class DSU {
        int[] fa;
        int sz;

        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) fa[i] = i;
            sz = n;
        }

        int find(int x) { // 查找
            return x == fa[x] ? fa[x] : (fa[x] = find(fa[x]));
        }

        void union(int p, int q) { // 合并
            p = find(p);
            q = find(q);
            if (p == q) return;
            fa[q] = p;
            sz--;
        }
    }
}
/*
3600. 升级后最大生成树稳定性
https://leetcode.cn/problems/maximize-spanning-tree-stability-with-upgrades/description/

第 456 场周赛 T4。

给你一个整数 n，表示编号从 0 到 n - 1 的 n 个节点，以及一个 edges 列表，其中 edges[i] = [ui, vi, si, musti]：
- ui 和 vi 表示节点 ui 和 vi 之间的一条无向边。
- si 是该边的强度。
- musti 是一个整数（0 或 1）。如果 musti == 1，则该边 必须 包含在生成树中，且 不能升级 。
你还有一个整数 k，表示你可以执行的最多 升级 次数。每次升级会使边的强度 翻倍 ，且每条可升级边（即 musti == 0）最多只能升级一次。
一个生成树的 稳定性 定义为其中所有边的 最小 强度。
返回任何有效生成树可能达到的 最大 稳定性。如果无法连接所有节点，返回 -1。
注意： 图的一个 生成树（spanning tree）是该图中边的一个子集，它满足以下条件：
- 将所有节点连接在一起（即图是 连通的 ）。
- 不 形成任何环。
- 包含 恰好 n - 1 条边，其中 n 是图中节点的数量。
提示：
2 <= n <= 10^5
1 <= edges.length <= 10^5
edges[i] = [ui, vi, si, musti]
0 <= ui, vi < n
ui != vi
1 <= si <= 10^5
musti 是 0 或 1。
0 <= k <= n
没有重复的边。

二分答案 + 并查集。
时间复杂度 O((n+m)lognlogU)
rating 2239 (clist.by)
 */