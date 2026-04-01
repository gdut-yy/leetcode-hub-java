public class Solution3887 {
    public int numberOfEdgesAdded(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] xor = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            xor[i] = 0;
        }

        int ans = 0;
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            int ru = find(parent, xor, u);
            int rv = find(parent, xor, v);

            if (ru == rv) {
                if ((xor[u] ^ xor[v]) == w) {
                    ans++;
                }
            } else {
                parent[ru] = rv;
                xor[ru] = xor[u] ^ xor[v] ^ w;
                ans++;
            }
        }
        return ans;
    }

    private int find(int[] parent, int[] xor, int x) {
        if (parent[x] != x) {
            int orig = parent[x];
            parent[x] = find(parent, xor, parent[x]);
            xor[x] ^= xor[orig];
        }
        return parent[x];
    }
}
/*
3887. 增量偶权环查询
https://leetcode.cn/problems/incremental-even-weighted-cycle-queries/description/

第 495 场周赛 T4。

给你一个正整数 n。
有一个由 n 个节点组成的 无向图，节点的编号从 0 到 n - 1。最初，这个图没有任何边。
你还得到一个二维整数数组 edges，其中 edges[i] = [ui, vi, wi] 表示一条连接节点 ui 和 vi 的边，边的权重为 wi。权重 wi 要么是 0，要么是 1。
按照给定顺序处理 edges 中的每一条边。对于每条边，如果将其添加到图中后，图中的 每个环 的边权和依然是 偶数，那么将这条边添加到图中。
返回一个整数，表示最终成功添加到图中的边的数量。
提示：
3 <= n <= 5 * 10^4
1 <= edges.length <= 5 * 10^4
edges[i] = [ui, vi, wi]
0 <= ui < vi < n
所有边都是唯一的。
wi = 0 或 wi = 1

带权并查集。
https://chat.deepseek.com/a/chat/s/91f54c44-e01b-4e3a-affe-b0356d8bc4dc
时间复杂度 O(nlogn)。
 */