import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SolutionP4004 {
    public long minMoves(int[] balance) {
        int sum = 0;
        boolean noNegative = true;
        int n = balance.length;
        for (int v : balance) {
            sum += v;
            if (v < 0) noNegative = false;
        }
        if (sum < 0) return -1;
        if (noNegative) return 0;

        int source = n, target = n + 1;
        g = new ArrayList[target + 1];
        Arrays.setAll(g, _ -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            if (balance[i] > 0) {
                addEdge(source, i, balance[i], 0);
            } else if (balance[i] < 0) {
                addEdge(i, target, -balance[i], 0);
            }
        }
        for (int i = 0; i < n; i++) {
            int prev = (i - 1 + n) % n, next = (i + 1) % n;
            addEdge(i, prev, Integer.MAX_VALUE, 1);
            addEdge(i, next, Integer.MAX_VALUE, 1);
        }
        return minCostMaxFlow(source, target);
    }

    private static class Edge {
        int to, rev;
        long cap, cost;

        Edge(int to, int rev, long cap, long cost) {
            this.to = to;
            this.rev = rev;
            this.cap = cap;
            this.cost = cost;
        }
    }

    private List<Edge>[] g;

    private void addEdge(int from, int to, long cap, long cost) {
        g[from].add(new Edge(to, g[to].size(), cap, cost));
        g[to].add(new Edge(from, g[from].size() - 1, 0, -cost));
    }

    private long minCostMaxFlow(int s, int t) {
        int n = g.length;
        long INF = Long.MAX_VALUE / 4;
        long[] dual = new long[n];   // 势能
        long[] dist = new long[n];
        int[] pv = new int[n];       // 前驱点
        int[] pe = new int[n];       // 前驱边下标
        boolean[] vis = new boolean[n];
        long cost = 0;
        while (true) {
            Arrays.fill(dist, INF);
            Arrays.fill(pv, -1);
            Arrays.fill(pe, -1);
            Arrays.fill(vis, false);
            PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
            dist[s] = 0;
            pq.offer(new long[]{0, s});
            while (!pq.isEmpty()) {
                long[] cur = pq.poll();
                int v = (int) cur[1];
                if (vis[v]) continue;
                vis[v] = true;
                if (v == t) break;
                for (int i = 0; i < g[v].size(); i++) {
                    Edge e = g[v].get(i);
                    if (e.cap == 0 || vis[e.to]) continue;
                    long nd = dist[v] + e.cost - dual[e.to] + dual[v];
                    if (nd < dist[e.to]) {
                        dist[e.to] = nd;
                        pv[e.to] = v;
                        pe[e.to] = i;
                        pq.offer(new long[]{nd, e.to});
                    }
                }
            }
            if (!vis[t]) break;
            for (int v = 0; v < n; v++) {
                if (vis[v]) {
                    dual[v] -= dist[t] - dist[v];
                }
            }
            long add = INF;
            for (int v = t; v != s; v = pv[v]) {
                add = Math.min(add, g[pv[v]].get(pe[v]).cap);
            }
            for (int v = t; v != s; v = pv[v]) {
                Edge e = g[pv[v]].get(pe[v]);
                e.cap -= add;
                g[v].get(e.rev).cap += add;
            }
            long d = -dual[s];
            cost += add * d;
        }
        return cost;
    }
}
/*
$4004. 使循环数组余额非负的最少移动次数 II
https://leetcode.cn/problems/minimum-moves-to-balance-circular-array-ii/description/

给定一个长度为 n 的 环形数组 balance，其中 balance[i] 是第 i 个人的净余额。
在一次操作中，一个人可以向其左侧或右侧的相邻人员转移 恰好 1 单位的余额。
返回使每个人的余额都变为 非负 所需的 最少 操作次数。如果无法做到，则返回 -1。
示例 1：
输入：balance = [-1,2,-1]
输出：2
示例 2：
输入：balance = [4,-1,-2]
输出：3
示例 3：
输入：balance = [-3,-3,5]
输出：-1
提示：
1 <= n == balance.length <= 1000
-10^5 <= balance[i] <= 10^5

最小费用最大流
 */