public class Solution6106 {
    public long countPairs(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);
        for (int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            int root = unionFind.find(i);
            res += n - 1 - unionFind.count[root];
        }
        // 去重
        return res / 2;
    }

    private static class UnionFind {
        // 记录每个节点的父节点
        int[] parent;
        // (可选) 连通分量
        int[] count;

        // 0 ~ n-1
        public UnionFind(int n) {
            parent = new int[n];
            count = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
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
                if (rootP < rootQ) {
                    parent[rootQ] = rootP;
                    count[rootP] += count[rootQ] + 1;
                } else {
                    parent[rootP] = rootQ;
                    count[rootQ] += count[rootP] + 1;
                }
            }
        }
    }
}
/*
6106. 统计无向图中无法互相到达点对数
https://leetcode.cn/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/

第 81 场双周赛 T2。

给你一个整数 n ，表示一张 无向图 中有 n 个节点，编号为 0 到 n - 1 。同时给你一个二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示节点 ai 和 bi 之间有一条 无向 边。
请你返回 无法互相到达 的不同 点对数目 。
提示：
1 <= n <= 10^5
0 <= edges.length <= 2 * 10^5
edges[i].length == 2
0 <= ai, bi < n
ai != bi
不会有重复边。

并查集 统计 每个点的联通分量。
时间复杂度 O(n * α(n))
 */