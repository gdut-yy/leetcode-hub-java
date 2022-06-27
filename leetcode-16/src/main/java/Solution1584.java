import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution1584 {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;

        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // edge = [i, j, d] 表示 i => j 距离 d
                edges.add(List.of(i, j, manhattan(points[i], points[j])));
            }
        }

        // Kruskal 算法
        edges.sort(Comparator.comparingInt(o -> o.get(2)));
        UnionFind unionFind = new UnionFind(n + 1);
        int cost = 0;
        for (List<Integer> edge : edges) {
            if (!unionFind.connected(edge.get(0), edge.get(1))) {
                unionFind.union(edge.get(0), edge.get(1));
                cost += edge.get(2);
            }
        }
        if (unionFind.count != 2) {
            return -1;
        }
        return cost;
    }

    private int manhattan(int[] point1, int[] point2) {
        return Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
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
1584. 连接所有点的最小费用
https://leetcode.cn/problems/min-cost-to-connect-all-points/

给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。
请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
提示：
1 <= points.length <= 1000
-10^6 <= xi, yi <= 10^6
所有点 (xi, yi) 两两不同。

最小生成树(MST)
Kruskal 算法
相似题目: 1135. 最低成本联通所有城市
https://leetcode.cn/problems/connecting-cities-with-minimum-cost/
 */