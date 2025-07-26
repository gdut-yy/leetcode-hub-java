import java.util.Arrays;
import java.util.Comparator;

public class Solution3613 {
    public int minCost(int n, int[][] edges, int k) {
        if (n == k) return 0;
        DSU dsu = new DSU(n);
        Arrays.sort(edges, Comparator.comparingInt(o -> o[2]));
        for (int[] e : edges) {
            dsu.union(e[0], e[1]);
            if (dsu.sz == k) return e[2];
        }
        return edges[edges.length - 1][2];
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
3613. 最小化连通分量的最大成本
https://leetcode.cn/problems/minimize-maximum-component-cost/description/

第 458 场周赛 T2。

给你一个无向连通图，包含 n 个节点，节点编号从 0 到 n - 1，以及一个二维整数数组 edges，其中 edges[i] = [ui, vi, wi] 表示一条连接节点 ui 和节点 vi 的无向边，边权为 wi，另有一个整数 k。
你可以从图中移除任意数量的边，使得最终的图中 最多 只包含 k 个连通分量。
连通分量的 成本 定义为该分量中边权的 最大值 。如果一个连通分量没有边，则其代价为 0。
请返回在移除这些边之后，在所有连通分量之中的 最大成本 的 最小可能值 。
提示：
1 <= n <= 5 * 10^4
0 <= edges.length <= 10^5
edges[i].length == 3
0 <= ui, vi < n
1 <= wi <= 10^6
1 <= k <= n
输入图是连通图。

并查集。从小到大合并。
相似题目: 3608. 包含 K 个连通分量需要的最小时间
https://leetcode.cn/problems/minimum-time-for-k-connected-components/description/
 */