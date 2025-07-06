import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution3604 {
    public int minTime(int n, int[][] edges) {
        if (n == 1) {
            return 0;
        }
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] p : edges) {
            int u = p[0], v = p[1], s = p[2], e = p[3];
            g[u].add(new int[]{v, s, e});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.remove();
            int cur_time = cur[0], u = cur[1];
            if (u == n - 1) {
                return cur_time;
            }
            if (cur_time > dist[u]) {
                continue;
            }
            for (int[] p : g[u]) {
                int v = p[0], s = p[1], e = p[2];
                if (cur_time > e) {
                    continue;
                }
                int new_time = Math.max(cur_time, s) + 1;
                if (dist[v] > new_time) {
                    dist[v] = new_time;
                    pq.add(new int[]{new_time, v});
                }
            }
        }
        return dist[n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1];
    }
}
/*
3604. 有向图中到达终点的最少时间
https://leetcode.cn/problems/minimum-time-to-reach-destination-in-directed-graph/description/

第 160 场双周赛 T3。

给你一个整数 n 和一个 有向 图，图中有 n 个节点，编号从 0 到 n - 1。图由一个二维数组 edges 表示，其中 edges[i] = [ui, vi, starti, endi] 表示从节点 ui 到 vi 的一条边，该边 只能 在满足 starti <= t <= endi 的整数时间 t 使用。
你在时间 0 从在节点 0 出发。
在一个时间单位内，你可以：
- 停留在当前节点不动，或者
- 如果当前时间 t 满足 starti <= t <= endi，则从当前节点沿着出边的方向移动。
返回到达节点 n - 1 所需的 最小 时间。如果不可能，返回 -1。
提示:
1 <= n <= 10^5
0 <= edges.length <= 10^5
edges[i] == [ui, vi, starti, endi]
0 <= ui, vi <= n - 1
ui != vi
0 <= starti <= endi <= 10^9

Dijkstra 求最短路。
时间复杂度 O(n + mlogm)。
 */