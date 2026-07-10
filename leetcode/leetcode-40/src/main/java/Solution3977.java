import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution3977 {
    public long[] minTimeMaxPower(int n, int[][] edges, int power, int[] cost, int source, int target) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
        }

        long[][] dist = new long[n][power + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        dist[source][power] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.offer(new long[]{0, source, power});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long t = cur[0];
            int u = (int) cur[1];
            int p = (int) cur[2];

            if (t > dist[u][p]) continue;
            if (p < cost[u]) continue;

            int np = p - cost[u];
            for (int[] edge : graph[u]) {
                int v = edge[0];
                long w = edge[1];
                long nt = t + w;
                if (nt < dist[v][np]) {
                    dist[v][np] = nt;
                    pq.offer(new long[]{nt, v, np});
                }
            }
        }

        long minTime = Long.MAX_VALUE;
        for (int p = 0; p <= power; p++) {
            if (dist[target][p] < minTime) {
                minTime = dist[target][p];
            }
        }

        if (minTime == Long.MAX_VALUE) {
            return new long[]{-1, -1};
        }

        long maxPower = -1;
        for (int p = 0; p <= power; p++) {
            if (dist[target][p] == minTime && p > maxPower) {
                maxPower = p;
            }
        }

        return new long[]{minTime, maxPower};
    }
}
/*
3977. 有限电量到达目标节点的最少时间
https://leetcode.cn/problems/minimum-time-to-reach-target-with-limited-power/description/

第 508 场周赛 T4。

给你一个有 n 个节点的 有向 加权图，节点编号从 0 到 n - 1。
该图由一个二维整数数组 edges 表示，其中 edges[i] = [ui, vi, ti] 表示一条从节点 ui 到节点 vi 的有向边，通过该边需要花费 ti 秒。
同时给你一个整数 power 表示初始可用电量，以及一个长度为 n 的整数数组 cost，其中 cost[u] 表示从节点 u 通过 任意 一条 出 边转发信号所需的电量。
给你两个整数 source 和 target。
信号在时间 0 从 source 出发，拥有 power 单位的电量，并遵循以下规则：
- 只有当剩余电量 至少 为 cost[u] 时，信号才能遍历从节点 u 出发的有向边。
- 信号到达一个节点时不消耗任何电量，除非它稍后通过另一条边离开该节点。
- 当信号从节点 u 转发时，剩余电量将 减少 cost[u] 个单位。
- 遍历一条边 edges[i] = [ui, vi, ti] 会使总时间 增加 ti 秒。
返回一个大小为 2 的整数数组 answer，其中：
- answer[0] 是信号到达节点 target 所需的 最小 时间。
- answer[1] 是所有实现 answer[0] 的路径中 最大 的剩余电量。
如果信号无法到达 target，则返回 [-1, -1]。
提示：
1 <= n <= 1000
0 <= edges.length <= 1000
edges[i] = [ui, vi, ti]
0 <= ui, vi <= n - 1
1 <= ti <= 10^9
1 <= power <= 1000
cost.length == n
1 <= cost[i] <= 2000
0 <= source, target <= n - 1

Dijkstra。
 */