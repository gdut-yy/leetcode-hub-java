import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionP3778 {
    public long minCostExcludingMax(int n, int[][] edges) {
        ArrayList<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            g[e[0]].add(new int[]{e[1], e[2]});
            g[e[1]].add(new int[]{e[0], e[2]});
        }
        // used 0 --> 未排除 1 --> 已经排除
        long[][] dist = new long[n][2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE / 2);
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(p -> p[0]));
        pq.offer(new long[]{0L, 0L, 0L});
        dist[0][0] = 0L;
        while (!pq.isEmpty()) {
            long[] out = pq.poll();
            long v = out[0];
            int cur = (int) out[1];
            int used = (int) out[2];
            if (v > dist[cur][used]) continue;
            for (int[] e : g[cur]) {
                int nVer = e[0], nVal = e[1];
                // 如果没有排除有两种情况
                if (used == 0) {
                    // 不排除
                    if (dist[nVer][0] > v + nVal) {
                        dist[nVer][0] = v + nVal;
                        pq.offer(new long[]{dist[nVer][0], nVer, 0});
                    }
                    // 排除
                    if (dist[nVer][1] > v) {
                        dist[nVer][1] = v;
                        pq.offer(new long[]{dist[nVer][1], nVer, 1});
                    }
                }
                // 无论排除还不排除 都能进行排除比较
                if (dist[nVer][1] > dist[cur][1] + nVal) {
                    dist[nVer][1] = dist[cur][1] + nVal;
                    pq.offer(new long[]{dist[nVer][1], nVer, 1});
                }
            }
        }
        return dist[n - 1][1];
    }
}
/*
$3778. 排除一个最大权重边的最小距离
https://leetcode.cn/problems/minimum-distance-excluding-one-maximum-weighted-edge/description/

给定一个正整数 n 和一个二维整数数组 edges，其中 edges[i] = [ui, vi, wi]。
有一个 带权连通 简单无向图，包含 n 个节点，下标从 0 到 n - 1。每条边 [ui, vi, wi] 表示在节点 ui 和节点 vi 之间有一条 正 权边 wi。
路径的 开销 是路径中边的权重之 和，排除 权重 最大 的那条边。如果路径中有多个权重最大的边，只 排除 第一个 这样的边。
返回一个整数表示从节点 0 到节点 n - 1 的 最小 开销。
提示：
2 <= n <= 5 * 10^4
n - 1 <= edges.length <= 10^9
edges[i] = [ui, vi, wi]
0 <= ui < vi < n
[ui, vi] != [uj, vj]
1 <= wi <= 5 * 10^4
图是连通的。

Dijkstra。
时间复杂度：O((n+m)logn)。
 */