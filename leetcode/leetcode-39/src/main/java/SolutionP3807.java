import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;

public class SolutionP3807 {
    public int minCost(int n, int[][] edges, int k) {
        // 按边权升序排序，逐条加入边后用 BFS 维护最短跳数
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));
        int[] dist = new int[n];
        Arrays.fill(dist, k + 1);
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, _ -> new ArrayList<>());
        Queue<Integer> qu = new ArrayDeque<>();
        dist[0] = 0;
        qu.offer(0);
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            g[u].add(v);
            g[v].add(u);
            if (dist[u] != -1) {
                qu.offer(u);
            }
            if (dist[v] != -1) {
                qu.offer(v);
            }
            while (!qu.isEmpty()) {
                int u1 = qu.poll();
                if (u1 == n - 1 && dist[u1] <= k) {
                    return w;
                }
                if (dist[u1] >= k) {
                    continue;
                }
                for (int v1 : g[u1]) {
                    if (dist[v1] > dist[u1] + 1) {
                        dist[v1] = dist[u1] + 1;
                        qu.offer(v1);
                    }
                }
            }
        }
        return -1;
    }
}
/*
$3807. 修复边以遍历图的最小成本
https://leetcode.cn/problems/minimum-cost-to-repair-edges-to-traverse-a-graph/description/

给定一个下标从 0 到 n - 1 的 n 个节点的 无向图。该图由 m 条边组成，用一个二维整数数组 edges 表示，其中 edges[i] = [ui, vi, wi] 表示节点 ui 和 vi 之间有一条修复成本为 wi 的边。
同时给定一个整数 k。一开始，所有 边都是被损坏的。
你可以选择一个非负整数 money并修复所有修复成本 小于或等于 money 的边。其他所有边保持损坏状态，无法使用。
你想要从节点 0 出发，使用最多 k 条边到达节点 n - 1。
返回一个整数，表示实现此目标所需的 最小 成本，如果不可能则返回 -1。
示例 1：
输入：n = 3, edges = [[0,1,10],[1,2,10],[0,2,100]], k = 1
输出：100
示例 2：
输入：n = 6, edges = [[0,2,5],[2,3,6],[3,4,7],[4,5,5],[0,1,10],[1,5,12],[0,3,9],[1,2,8],[2,4,11]], k = 2
输出：12
示例 3：
输入：n = 3, edges = [[0,1,1]], k = 1
输出：-1
提示：
2 <= n <= 5 * 10^4
1 <= edges.length == m <= 10^5
edges[i] = [ui, vi, wi]
0 <= ui, vi < n
1 <= wi <= 10^9
1 <= k <= n
图中没有自环或重复边。
 */