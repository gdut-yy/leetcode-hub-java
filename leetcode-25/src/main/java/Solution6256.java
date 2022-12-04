import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution6256 {
    private int n;
    private Map<Integer, List<Integer>> adj;

    public int magnificentSets(int n, int[][] edges) {
        this.n = n;
        // 建图
        this.adj = new HashMap<>();
        for (int[] edge : edges) {
            adj.computeIfAbsent(edge[0], key -> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], key -> new ArrayList<>()).add(edge[0]);
        }

        // 不满足二分图
        if (!isBipartite()) {
            return -1;
        }

        DSU dsu = new DSU(n + 1);
        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }
        int[] depth = new int[n + 1];
        Arrays.fill(depth, 1);
        for (int i = 1; i <= n; i++) {
            depth[i] = getDepthByRoot(i);
        }
        Map<Integer, Integer> faMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int fa = dsu.find(i);
            faMap.put(fa, Math.max(depth[i], faMap.getOrDefault(fa, 0)));
        }
        return faMap.values().stream().mapToInt(i -> i).sum();
    }

    // 以 root 为根时深度/高度
    private int getDepthByRoot(int root) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        boolean[] visited = new boolean[n + 1];
        visited[root] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int u = queue.remove();

                for (int v : adj.getOrDefault(u, new ArrayList<>())) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.add(v);
                    }
                }
            }
        }
        return cnt;
    }

    private static class DSU {
        // 父节点数组/祖先数组
        int[] fa;

        // 初始化
        public DSU(int n) {
            fa = new int[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
            }
        }

        // 查找
        int find(int x) {
            // 路径压缩
            if (x != fa[x]) {
                fa[x] = find(fa[x]);
            }
            return fa[x];
        }

        // 合并
        void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                return;
            }
            fa[rootQ] = rootP;
        }
    }

    private boolean isBipartite() {
        int[] colors = new int[n + 1];
        // -1:未染色 0:红色 1:蓝色
        Arrays.fill(colors, -1);
        for (int i = 1; i <= n; i++) {
            if (colors[i] == -1) {
                if (!setColor(adj, colors, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean setColor(Map<Integer, List<Integer>> adj, int[] colors, int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        colors[i] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.remove();

            for (int next : adj.getOrDefault(cur, new ArrayList<>())) {
                if (colors[next] != -1) {
                    if (colors[next] == colors[cur]) {
                        return false;
                    }
                } else {
                    colors[next] = 1 ^ colors[cur];
                    queue.add(next);
                }
            }
        }
        return true;
    }
}
/*
6256. 将节点分成尽可能多的组
https://leetcode.cn/problems/divide-nodes-into-the-maximum-number-of-groups/

第 322 场周赛 T4。

给你一个正整数 n ，表示一个 无向 图中的节点数目，节点编号从 1 到 n 。
同时给你一个二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示节点 ai 和 bi 之间有一条 双向 边。注意给定的图可能是不连通的。
请你将图划分为 m 个组（编号从 1 开始），满足以下要求：
- 图中每个节点都只属于一个组。
- 图中每条边连接的两个点 [ai, bi] ，如果 ai 属于编号为 x 的组，bi 属于编号为 y 的组，那么 |y - x| = 1 。
请你返回最多可以将节点分为多少个组（也就是最大的 m ）。如果没办法在给定条件下分组，请你返回 -1 。
提示：
1 <= n <= 500
1 <= edges.length <= 10^4
edges[i].length == 2
1 <= ai, bi <= n
ai != bi
两个点之间至多只有一条边。

二分部判定 + 并查集 + BFS
首先要满足二分图条件。
枚举每个点作为 root 的情形，同一连通分类取最大值相加。
相似题目: 785. 判断二分图
https://leetcode.cn/problems/is-graph-bipartite/
 */