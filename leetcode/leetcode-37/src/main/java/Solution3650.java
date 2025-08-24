import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution3650 {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        List<List<int[]>> rev = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            rev.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v, w});
            rev.get(v).add(new int[]{u, w});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0];
            int u = cur[1];

            if (cost != dist[u]) continue;
            if (u == n - 1) break;

            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int w = edge[1];
                int newCost = cost + w;
                if (newCost < dist[v]) {
                    dist[v] = newCost;
                    pq.offer(new int[]{newCost, v});
                }
            }

            for (int[] edge : rev.get(u)) {
                int v = edge[0];
                int w = edge[1];
                int newCost = cost + 2 * w;
                if (newCost < dist[v]) {
                    dist[v] = newCost;
                    pq.offer(new int[]{newCost, v});
                }
            }
        }

        return dist[n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1];
    }
}
/*
3650. 边反转的最小路径总成本
https://leetcode.cn/problems/minimum-cost-path-with-edge-reversals/description/

第 163 场双周赛 T3。

给你一个包含 n 个节点的有向带权图，节点编号从 0 到 n - 1。同时给你一个数组 edges，其中 edges[i] = [ui, vi, wi] 表示一条从节点 ui 到节点 vi 的有向边，其成本为 wi。
每个节点 ui 都有一个 最多可使用一次 的开关：当你到达 ui 且尚未使用其开关时，你可以对其一条入边 vi → ui 激活开关，将该边反转为 ui → vi 并 立即 穿过它。
反转仅对那一次移动有效，使用反转边的成本为 2 * wi。
返回从节点 0 到达节点 n - 1 的 最小 总成本。如果无法到达，则返回 -1。
提示:
2 <= n <= 5 * 10^4
1 <= edges.length <= 10^5
edges[i] = [ui, vi, wi]
0 <= ui, vi <= n - 1
1 <= wi <= 1000

构造反图 + Dijkstra 最短路。
https://yuanbao.tencent.com/chat/naQivTmsDa/cbd588c6-fa01-4003-ad9d-b2e148c92503
时间复杂度 O(n + mlogm)。
 */