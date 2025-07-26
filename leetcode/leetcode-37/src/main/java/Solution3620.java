import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Solution3620 {
    private List<int[]>[] g;
    private long k;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        this.k = k;
        int[] deg = new int[n];
        int maxWt = -1;
        for (int[] e : edges) {
            int x = e[0], y = e[1], wt = e[2];
            if (online[x] && online[y]) {
                g[x].add(new int[]{y, wt});
                deg[y]++;
                if (x == 0) {
                    maxWt = Math.max(maxWt, wt);
                }
            }
        }

        // 先清理无法从 0 到达的边
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i < n; i++) {
            if (deg[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int x = q.poll();
            for (int[] e : g[x]) {
                int y = e[0];
                if (--deg[y] == 0 && y > 0) {
                    q.offer(y);
                }
            }
        }
        long[] f = new long[n];

        int left = 0;
        int right = maxWt + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (!check(mid, deg.clone(), f)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left - 1;
    }

    private boolean check(int lower, int[] deg, long[] f) {
        Arrays.fill(f, Long.MAX_VALUE / 2); // 除 2 防止加法溢出
        f[0] = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int x = q.poll();
            if (x == g.length - 1) {
                return f[x] <= k;
            }
            for (int[] e : g[x]) {
                int y = e[0], wt = e[1];
                if (wt >= lower) {
                    f[y] = Math.min(f[y], f[x] + wt);
                }
                if (--deg[y] == 0) {
                    q.offer(y);
                }
            }
        }
        return false; // 无法到达 n-1
    }
}
/*
3620. 恢复网络路径
https://leetcode.cn/problems/network-recovery-pathways/description/

第 161 场双周赛 T3。

给你一个包含 n 个节点（编号从 0 到 n - 1）的有向无环图。图由长度为 m 的二维数组 edges 表示，其中 edges[i] = [ui, vi, costi] 表示从节点 ui 到节点 vi 的单向通信，恢复成本为 costi。
一些节点可能处于离线状态。给定一个布尔数组 online，其中 online[i] = true 表示节点 i 在线。节点 0 和 n - 1 始终在线。
从 0 到 n - 1 的路径如果满足以下条件，那么它是 有效 的：
- 路径上的所有中间节点都在线。
- 路径上所有边的总恢复成本不超过 k。
对于每条有效路径，其 分数 定义为该路径上的最小边成本。
返回所有有效路径中的 最大 路径分数（即最大 最小 边成本）。如果没有有效路径，则返回 -1。
提示:
n == online.length
2 <= n <= 5 * 10^4
0 <= m == edges.length <= min(105, n * (n - 1) / 2)
edges[i] = [ui, vi, costi]
0 <= ui, vi < n
ui != vi
0 <= costi <= 10^9
0 <= k <= 5 * 10^13
online[i] 是 true 或 false，且 online[0] 和 online[n - 1] 均为 true。
给定的图是一个有向无环图。

二分答案 + DAG DP / 拓扑排序。
时间复杂度：O((n+m)logU)
 */