import java.util.ArrayList;
import java.util.Arrays;

public class SolutionP3385 {
    public int findMinimumTime(int[] strength) {
        final int k = 1;
        int n = strength.length;
        int S = n * 2;
        int T = S + 1;
        MinCostFlow flow = new MinCostFlow(T + 1);
        for (int i = 0; i < n; i++) {
            int s = strength[i];
            // 枚举这个锁是第几次开的
            for (int j = 0; j < n; j++) {
                int x = 1 + k * j;
                int cost = (s - 1) / x + 1;
                flow.addEdge(i, n + j, 1, cost);
            }
            flow.addEdge(S, i, 1, 0);
        }
        for (int i = n; i < n * 2; i++) {
            flow.addEdge(i, T, 1, 0);
        }
        MinCostFlow.FlowAndCost flowAndCost = flow.minCostMaxFlow(S, T);
        return (int) flowAndCost.cost;
    }

    static class MinCostFlow {
        static class InternalWeightedCapEdge {
            int to, rev;
            long cap, cost;

            InternalWeightedCapEdge(int to, int rev, long cap, long cost) {
                this.to = to;
                this.rev = rev;
                this.cap = cap;
                this.cost = cost;
            }
        }

        record FlowAndCost(long flow, long cost) {
        }

        static final long INF = Long.MAX_VALUE;
        private final int n;
        private final ArrayList<InternalWeightedCapEdge>[] g;

        public MinCostFlow(int n) {
            this.n = n;
            g = new ArrayList[n];
            Arrays.setAll(g, e -> new ArrayList<>());
        }

        public void addEdge(int from, int to, long cap, long cost) {
            int fromId = g[from].size();
            int toId = g[to].size();
            if (from == to) toId++;
            g[from].add(new InternalWeightedCapEdge(to, toId, cap, cost));
            g[to].add(new InternalWeightedCapEdge(from, fromId, 0L, -cost));
        }

        public FlowAndCost minCostMaxFlow(int s, int t) {
            return minCostFlow(s, t, INF);
        }

        public FlowAndCost minCostFlow(int s, int t, long flowLimit) {
            return minCostSlope(s, t, flowLimit).getLast();
        }

        public java.util.LinkedList<FlowAndCost> minCostSlope(int s, int t, long flowLimit) {
            long[] dual = new long[n];
            long[] dist = new long[n];
            int[] pv = new int[n];
            int[] pe = new int[n];
            boolean[] vis = new boolean[n];
            long flow = 0;
            long cost = 0, prev_cost = -1;
            java.util.LinkedList<FlowAndCost> result = new java.util.LinkedList<>();
            result.addLast(new FlowAndCost(flow, cost));
            while (flow < flowLimit) {
                if (!dualRef(s, t, dual, dist, pv, pe, vis)) break;
                long c = flowLimit - flow;
                for (int v = t; v != s; v = pv[v]) {
                    c = Math.min(c, g[pv[v]].get(pe[v]).cap);
                }
                for (int v = t; v != s; v = pv[v]) {
                    InternalWeightedCapEdge e = g[pv[v]].get(pe[v]);
                    e.cap -= c;
                    g[v].get(e.rev).cap += c;
                }
                long d = -dual[s];
                flow += c;
                cost += c * d;
                if (prev_cost == d) {
                    result.removeLast();
                }
                result.addLast(new FlowAndCost(flow, cost));
                prev_cost = cost;
            }
            return result;
        }

        private boolean dualRef(int s, int t, long[] dual, long[] dist, int[] pv, int[] pe, boolean[] vis) {
            Arrays.fill(dist, INF);
            Arrays.fill(pv, -1);
            Arrays.fill(pe, -1);
            Arrays.fill(vis, false);
            class State implements Comparable<State> {
                final long key;
                final int to;

                State(long key, int to) {
                    this.key = key;
                    this.to = to;
                }

                @Override
                public int compareTo(State q) {
                    return key > q.key ? 1 : -1;
                }
            }
            java.util.PriorityQueue<State> pq = new java.util.PriorityQueue<>();
            dist[s] = 0;
            pq.add(new State(0L, s));
            while (!pq.isEmpty()) {
                int v = pq.poll().to;
                if (vis[v]) continue;
                vis[v] = true;
                if (v == t) break;
                for (int i = 0, deg = g[v].size(); i < deg; i++) {
                    InternalWeightedCapEdge e = g[v].get(i);
                    if (vis[e.to] || e.cap == 0) continue;
                    long cost = e.cost - dual[e.to] + dual[v];
                    if (dist[e.to] - dist[v] > cost) {
                        dist[e.to] = dist[v] + cost;
                        pv[e.to] = v;
                        pe[e.to] = i;
                        pq.add(new State(dist[e.to], e.to));
                    }
                }
            }
            if (!vis[t]) {
                return false;
            }
            for (int v = 0; v < n; v++) {
                if (!vis[v]) continue;
                dual[v] -= dist[t] - dist[v];
            }
            return true;
        }
    }

}
/*
$3385. 破解锁的最少时间 II
https://leetcode.cn/problems/minimum-time-to-break-locks-ii/description/

Bob 被困在了一个地窖里，他需要破解 n 个锁才能逃出地窖，每一个锁都需要一定的 能量 才能打开。每一个锁需要的能量存放在一个数组 strength 里，其中 strength[i] 表示打开第 i 个锁需要的能量。
Bob 有一把剑，它具备以下的特征：
- 一开始剑的能量为 0 。
- 剑的能量增加因子 X 一开始的值为 1 。
- 每分钟，剑的能量都会增加当前的 X 值。
- 打开第 i 把锁，剑的能量需要到达 至少 strength[i] 。
- 打开一把锁以后，剑的能量会变回 0 ，X 的值会增加 1。
你的任务是打开所有 n 把锁并逃出地窖，请你求出需要的 最少 分钟数。
请你返回 Bob 打开所有 n 把锁需要的 最少 时间。
提示：
n == strength.length
1 <= n <= 80
1 <= strength[i] <= 10^6
n == strength.length

相似题目: 3376. 破解锁的最少时间 I
https://leetcode.cn/problems/minimum-time-to-break-locks-i/description/
 */