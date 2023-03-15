public class Solution1579 {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind alice = new UnionFind(n);
        UnionFind bob = new UnionFind(n);

        int cnt = 0;
        // 公共边
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                // 注意节点编号 1~n 调整到 0~n-1
                int from = edge[1] - 1;
                int to = edge[2] - 1;

                if (!alice.connected(from, to)) {
                    alice.union(from, to);
                    bob.union(from, to);
                } else {
                    cnt++;
                }
            }
        }

        // 独占边
        for (int[] edge : edges) {
            int from = edge[1] - 1;
            int to = edge[2] - 1;
            // alice 独占
            if (edge[0] == 1) {
                if (!alice.connected(from, to)) {
                    alice.union(from, to);
                } else {
                    cnt++;
                }
            }
            // bob 独占
            else if (edge[0] == 2) {
                if (!bob.connected(from, to)) {
                    bob.union(from, to);
                } else {
                    cnt++;
                }
            }
        }

        // 如果 Alice 和 Bob 无法完全遍历图，则返回 -1 。
        if (alice.count != 1 || bob.count != 1) {
            return -1;
        }
        return cnt;
    }

    private static class UnionFind {
        // 记录每个节点的父节点
        int[] parent;
        // 记录每棵树的重量
        int[] rank;
        // (可选) 连通分量
        int count;

        // 0 ~ n-1
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = i;
            }
            count = n;
        }

        // 返回节点 x 的根节点
        private int find(int x) {
            int ret = x;
            while (ret != parent[ret]) {
                // 路径压缩
                parent[ret] = parent[parent[ret]];
                ret = parent[ret];
            }
            return ret;
        }

        // 将 p 和 q 连通
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                if (rank[rootP] > rank[rootQ]) {
                    parent[rootQ] = rootP;
                } else if (rank[rootP] < rank[rootQ]) {
                    parent[rootP] = rootQ;
                } else {
                    parent[rootQ] = rootP;
                    // 重量平衡
                    rank[rootP] += 1;
                }
                count--;
            }
        }

        // p 和 q 是否连通
        public boolean connected(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            return rootP == rootQ;
        }
    }
}
/*
1579. 保证图可完全遍历
https://leetcode.cn/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/

Alice 和 Bob 共有一个无向图，其中包含 n 个节点和 3  种类型的边：
- 类型 1：只能由 Alice 遍历。
- 类型 2：只能由 Bob 遍历。
- 类型 3：Alice 和 Bob 都可以遍历。
给你一个数组 edges ，其中 edges[i] = [typei, ui, vi] 表示节点 ui 和 vi 之间存在类型为 typei 的双向边。
请你在保证图仍能够被 Alice和 Bob 完全遍历的前提下，找出可以删除的最大边数。如果从任何节点开始，Alice 和 Bob 都可以到达所有其他节点，则认为图是可以完全遍历的。
返回可以删除的最大边数，如果 Alice 和 Bob 无法完全遍历图，则返回 -1 。
提示：
1 <= n <= 10^5
1 <= edges.length <= min(10^5, 3 * n * (n-1) / 2)
edges[i].length == 3
1 <= edges[i][0] <= 3
1 <= edges[i][1] < edges[i][2] <= n
所有元组 (typei, ui, vi) 互不相同

并查集。
贪心，此消彼长。要使可删除的边数量尽可能多，则需要尽可能保留多的公共边（类型 3）。
 */