import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution1489 {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int len = edges.length;

        // newEdges[i] = {fromi, toi, weighti, i}
        int[][] newEdges = new int[len][4];
        for (int i = 0; i < len; i++) {
            System.arraycopy(edges[i], 0, newEdges[i], 0, 3);
            newEdges[i][3] = i;
        }
        // 按 weight 升序排序
        Arrays.sort(newEdges, Comparator.comparing(o -> o[2]));

        // Kruskal 算法
        int value = 0;
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < len; i++) {
            if (!unionFind.connected(newEdges[i][0], newEdges[i][1])) {
                unionFind.union(newEdges[i][0], newEdges[i][1]);
                value += newEdges[i][2];
            }
        }

        List<Integer> criticalEdges = new ArrayList<>();
        List<Integer> pseudoCriticalEdges = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            // 关键边
            UnionFind unionFind1 = new UnionFind(n);
            int v = 0;
            for (int j = 0; j < len; j++) {
                if (i != j && !unionFind1.connected(newEdges[j][0], newEdges[j][1])) {
                    unionFind1.union(newEdges[j][0], newEdges[j][1]);
                    v += newEdges[j][2];
                }
            }
            if (unionFind1.count != 1 || v > value) {
                criticalEdges.add(newEdges[i][3]);
                continue;
            }

            // 伪关键边
            unionFind1 = new UnionFind(n);
            unionFind1.union(newEdges[i][0], newEdges[i][1]);
            v = newEdges[i][2];
            for (int j = 0; j < len; j++) {
                if (i != j && !unionFind1.connected(newEdges[j][0], newEdges[j][1])) {
                    unionFind1.union(newEdges[j][0], newEdges[j][1]);
                    v += newEdges[j][2];
                }
            }
            if (v == value) {
                pseudoCriticalEdges.add(newEdges[i][3]);
            }
        }
        return List.of(criticalEdges, pseudoCriticalEdges);
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
1489. 找到最小生成树里的关键边和伪关键边
https://leetcode-cn.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/

给你一个 n 个点的带权无向连通图，节点编号为 0 到 n-1 ，同时还有一个数组 edges ，
其中 edges[i] = [fromi, toi, weighti] 表示在 fromi 和 toi 节点之间有一条带权无向边。最小生成树 (MST) 是给定图中边的一个子集，
它连接了所有节点且没有环，而且这些边的权值和最小。
请你找到给定图中最小生成树的所有关键边和伪关键边。如果从图中删去某条边，会导致最小生成树的权值和增加，那么我们就说它是一条关键边。
伪关键边则是可能会出现在某些最小生成树中但不会出现在所有最小生成树中的边。
请注意，你可以分别以任意顺序返回关键边的下标和伪关键边的下标。
提示：
2 <= n <= 100
1 <= edges.length <= min(200, n * (n - 1) / 2)
edges[i].length == 3
0 <= fromi < toi < n
1 <= weighti <= 1000
所有 (fromi, toi) 数对都是互不相同的。

最小生成树(MST)
Kruskal 算法 变种
时间复杂度 O(m^2 a(n))
另有 tarjan 解法。时间复杂度 O(mlogm)
 */