import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution3970 {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
        }

        int cols = k + 1;
        int[] dist = new int[n * cols];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dist[1] = 0;
        pq.offer(new int[]{0, 0, 1});
        char[] labs = labels.toCharArray();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1], r = cur[2];
            if (d != dist[u * cols + r]) continue;
            if (u == n - 1) return d;

            char lu = labs[u];
            for (int[] e : adj[u]) {
                int v = e[0], w = e[1];
                char lv = labs[v];
                int nr;
                if (lv == lu) {
                    nr = r + 1;
                    if (nr > k) continue;
                } else {
                    nr = 1;
                }
                int nd = d + w;
                int idx = v * cols + nr;
                if (nd < dist[idx]) {
                    dist[idx] = nd;
                    pq.offer(new int[]{nd, v, nr});
                }
            }
        }
        return -1;
    }
}
/*
3970. 最多 K 个连续相同字符的最短路径
https://leetcode.cn/problems/shortest-path-with-at-most-k-consecutive-identical-characters/description/

第 507 场周赛 T3。

给你一个整数 n，表示一个 有向加权 图中的节点数量，节点编号从 0 到 n - 1。该图由二维数组 edges 表示，其中 edges[i] = [ui, vi, wi] 表示一条从节点 ui 指向节点 vi、权重为 wi 的有向边。
另给定一个长度为 n 的字符串 labels，其中 labels[i] 是分配给节点 i 的字符，以及一个整数 k。
返回一条从节点 0 到节点 n - 1 的路径的 最小总边权 ，并要求该路径上所有节点标签按顺序 拼接 后，最多包含 k 个 连续相同 字符。如果不存在有效路径，返回 -1。
提示：
1 <= n == labels.length <= 5 * 10^4
0 <= edges.length <= 5 * 10^4
edges[i] == [ui, vi, wi]
0 <= ui, vi <= n - 1
ui != vi
1 <= wi <= 10^4
labels 由小写英文字母组成
1 <= k <= 50

Dijkstra 算法。
 */