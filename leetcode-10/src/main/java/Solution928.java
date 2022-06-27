import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution928 {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;

        // 预处理，isInitial[i] == true 表示节点 i 在 initial 中
        boolean[] isInitial = new boolean[n];
        for (int node : initial) {
            isInitial[node] = true;
        }

        // 并查集 连接 graph 中不在 initial 中的节点
        UnionFind unionFind = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            if (!isInitial[i]) {
                for (int j = i + 1; j < n; j++) {
                    if (!isInitial[j] && graph[i][j] == 1) {
                        unionFind.union(i, j);
                    }
                }
            }
        }

        int[] count = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        // 对于 initial 中的每个点 u，尝试去感染不在 initial 中的 v
        for (int u : initial) {
            Set<Integer> vRootSet = new HashSet<>();
            for (int v = 0; v < n; v++) {
                if (!isInitial[v] && graph[u][v] == 1) {
                    vRootSet.add(unionFind.find(v));
                }
            }
            map.put(u, vRootSet);
            for (Integer vRoot : vRootSet) {
                count[vRoot] += 1;
            }
        }

        int res = -1;
        int maxSize = -1;
        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            int u = entry.getKey();
            Set<Integer> vRootSet = entry.getValue();

            int score = 0;
            for (Integer vRoot : vRootSet) {
                // 只被一个 u 感染
                if (count[vRoot] == 1) {
                    score += unionFind.size[vRoot];
                }
            }

            // 能够最小化 M(initial) 的节点 || 如果有多个节点满足条件，就返回索引最小的节点。
            if ((score > maxSize) || (score == maxSize && u < res)) {
                maxSize = score;
                res = u;
            }
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
        // 联通分量大小
        int[] size;

        // 0 ~ n-1
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = i;
            }
            count = n;
            // 联通分量大小
            size = new int[n];
            Arrays.fill(size, 1);
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
                    size[rootP] += size[rootQ];
                } else if (rank[rootP] < rank[rootQ]) {
                    parent[rootP] = rootQ;
                    size[rootQ] += size[rootP];
                } else {
                    parent[rootQ] = rootP;
                    size[rootP] += size[rootQ];
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
928. 尽量减少恶意软件的传播 II
https://leetcode.cn/problems/minimize-malware-spread-ii/

给定一个由 n 个节点组成的网络，用 n x n 个邻接矩阵 graph 表示。在节点网络中，只有当 graph[i][j] = 1 时，节点 i 能够直接连接到另一个节点 j。
一些节点 initial 最初被恶意软件感染。只要两个节点直接连接，且其中至少一个节点受到恶意软件的感染，那么两个节点都将被恶意软件感染。
这种恶意软件的传播将继续，直到没有更多的节点可以被这种方式感染。
假设 M(initial) 是在恶意软件停止传播之后，整个网络中感染恶意软件的最终节点数。
我们可以从 initial 中删除一个节点，并完全移除该节点以及从该节点到任何其他节点的任何连接。
请返回移除后能够使 M(initial) 最小化的节点。如果有多个节点满足条件，返回索引 最小的节点 。
提示：
n == graph.length
n == graph[i].length
2 <= n <= 300
graph[i][j] 是 0 或 1.
graph[i][j] == graph[j][i]
graph[i][i] == 1
1 <= initial.length < n
0 <= initial[i] <= n - 1
 initial 中每个整数都不同

并查集。本题与 924 差异是 924 只是从 initial 中移除，本题则是从图中删除。
记 initial 的节点为 u，非 initial 的节点为 v
首先用 v 构建 graph，再检查这些 v 中哪些会被 u 感染
case1: 如果 v 只会被一个 u 感染，记录这个 u 对应的 v 数量。
case2: 如果 v 不只被一个 u 感染，那么即使移除了对应的 u 也是不会减少 M(initial) 的，返回索引最小的节点即可。
注意 UnionFind 中 int[] size; 的处理
时间复杂度 O(n^2)
空间复杂度 O(n)
相似题目: 924. 尽量减少恶意软件的传播
https://leetcode.cn/problems/minimize-malware-spread/
 */