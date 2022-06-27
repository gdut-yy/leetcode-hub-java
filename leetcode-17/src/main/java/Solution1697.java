import java.util.Arrays;
import java.util.Comparator;

public class Solution1697 {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        // 按 dis 升序排序
        Arrays.sort(edgeList, Comparator.comparingInt(o -> o[2]));

        // 记录原始顺序
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            // queries[i][3] == i（即下标）
            queries[i] = new int[]{query[0], query[1], query[2], i};
        }
        // 按 limit 升序排序
        Arrays.sort(queries, Comparator.comparingInt(o -> o[2]));

        UnionFind unionFind = new UnionFind(n);
        int edgeIdx = 0;
        boolean[] res = new boolean[queries.length];
        for (int[] query : queries) {
            while (edgeIdx < edgeList.length && edgeList[edgeIdx][2] < query[2]) {
                unionFind.union(edgeList[edgeIdx][0], edgeList[edgeIdx][1]);
                edgeIdx++;
            }
            res[query[3]] = unionFind.connected(query[0], query[1]);
        }
        return res;
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
1697. 检查边长度限制的路径是否存在
https://leetcode.cn/problems/checking-existence-of-edge-length-limited-paths/

给你一个 n 个点组成的无向图边集 edgeList ，其中 edgeList[i] = [ui, vi, disi] 表示点 ui 和点 vi 之间有一条长度为 disi 的边。请注意，两个点之间可能有 超过一条边 。
给你一个查询数组queries ，其中 queries[j] = [pj, qj, limitj] ，
你的任务是对于每个查询 queries[j] ，判断是否存在从 pj 到 qj 的路径，且这条路径上的每一条边都 严格小于 limitj 。
请你返回一个 布尔数组 answer ，其中 answer.length == queries.length ，当 queries[j] 的查询结果为 true 时， answer 第 j 个值为 true ，否则为 false 。
提示：
2 <= n <= 10^5
1 <= edgeList.length, queries.length <= 10^5
edgeList[i].length == 3
queries[j].length == 3
0 <= ui, vi, pj, qj <= n - 1
ui != vi
pj != qj
1 <= disi, limitj <= 10^9
两个点之间可能有 多条 边。

并查集 + 离线思维
何为 "离线"？：询问是全部提前给出的，不必按照询问的顺序依次对它们进行处理
参考零神的 https://leetcode.cn/problems/checking-existence-of-edge-length-limited-paths/solution/jian-cha-bian-chang-du-xian-zhi-de-lu-ji-c756/
 */