import java.util.Arrays;
import java.util.Comparator;

public class Solution1135 {
    public int minimumCost(int n, int[][] connections) {
        // Kruskal 算法
        Arrays.sort(connections, Comparator.comparing(o -> o[2]));
        UnionFind unionFind = new UnionFind(n + 1);
        int cost = 0;
        for (int[] connection : connections) {
            if (!unionFind.connected(connection[0], connection[1])) {
                unionFind.union(connection[0], connection[1]);
                cost += connection[2];
            }
        }
        if (unionFind.count != 2) {
            return -1;
        }
        return cost;
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
$1135. 最低成本联通所有城市
https://leetcode.cn/problems/connecting-cities-with-minimum-cost/

想象一下你是个城市基建规划者，地图上有 n 座城市，它们按以 1 到 n 的次序编号。
给你整数 n 和一个数组 conections，其中 connections[i] = [xi, yi, costi] 表示将城市 xi 和城市 yi 连接所要的costi（连接是双向的）。
返回连接所有城市的最低成本，每对城市之间至少有一条路径。如果无法连接所有 n 个城市，返回 -1
该 最小成本 应该是所用全部连接成本的总和。
提示：
1 <= n <= 10^4
1 <= connections.length <= 10^4
connections[i].length == 3
1 <= xi, yi <= n
xi != yi
0 <= costi <= 10^5

最小生成树(MST) 模板题
Kruskal 算法
时间复杂度 O(eloge + e*n)
空间复杂度 O(n)
相似题目: 1584. 连接所有点的最小费用
https://leetcode.cn/problems/min-cost-to-connect-all-points/
 */