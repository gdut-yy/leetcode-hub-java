import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Solution3376 {
    // 209ms
    static class V1 {
        public int findMinimumTime(List<Integer> strength, int K) {
            int n = strength.size();
            int[] strengths = strength.stream().mapToInt(Integer::intValue).toArray();
            int[] permute = new int[n];
            for (int i = 0; i < n; i++) permute[i] = i;

            int ans = Integer.MAX_VALUE;
            int maxRound = 1;
            for (int i = 2; i <= n; i++) maxRound *= i;
            for (int i = 0; i < maxRound; i++) {
                ans = Math.min(ans, getAns(strengths, K, permute));
                nextPermutation(permute);
            }
            return ans;
        }

        private int getAns(int[] strengths, int k, int[] permute) {
            int n = strengths.length;
            int res = 0;
            int x = 1;
            for (int i = 0; i < n; i++) {
                int stre = strengths[permute[i]];
                // k*b >= stre
                res += (stre + x - 1) / x;
                x += k;
            }
            return res;
        }

        private void nextPermutation(int[] a) {
            int n = a.length;
            int i = n - 2;
            while (i >= 0 && a[i] >= a[i + 1]) i--;
            if (i < 0) return;
            int j = n - 1;
            while (j >= 0 && a[i] >= a[j]) j--;
            swap(a, i, j);
            reverse(a, i + 1);
        }

        private void swap(int[] a, int l, int r) {
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
        }

        private void reverse(int[] a, int st) {
            for (int l = st, r = a.length - 1; l < r; l++, r--) {
                swap(a, l, r);
            }
        }
    }

    // 13ms
    static class V2 {
        static class neighbor {
            int to, rid, cap, cost; // rid 为反向边在邻接表中的下标

            public neighbor(int to, int rid, int cap, int cost) {
                this.to = to;
                this.rid = rid;
                this.cap = cap;
                this.cost = cost;
            }
        }

        private static final int INF = Integer.MAX_VALUE;
        private List<neighbor>[] g;
        private int S, T;
        private int[] dis, fa_v, fa_i;
        private boolean[] inQ;

        private void addEdge(int from, int to, int cap, int cost) {
            g[from].add(new neighbor(to, g[to].size(), cap, cost));
            g[to].add(new neighbor(from, g[from].size() - 1, 0, -cost));
        }

        public int findMinimumTime(List<Integer> strength, int k) {
            int n = strength.size();
            S = n * 2;
            T = S + 1;
            g = new ArrayList[T + 1];
            Arrays.setAll(g, e -> new ArrayList<>());
            for (int i = 0; i < n; i++) {
                int s = strength.get(i);
                // 枚举这个锁是第几次开的
                for (int j = 0; j < n; j++) {
                    int x = 1 + k * j;
                    int cost = (s - 1) / x + 1;
                    addEdge(i, n + j, 1, cost);
                }
                addEdge(S, i, 1, 0);
            }
            for (int i = n; i < n * 2; i++) {
                addEdge(i, T, 1, 0);
            }

            // 下面是最小费用最大流模板
            int minCost = 0;
            dis = new int[g.length];
            fa_v = new int[g.length];
            fa_i = new int[g.length];
            inQ = new boolean[g.length];
            while (spfa()) {
                // 沿 st-end 的最短路尽量增广
                // 特别地，如果建图时所有边的容量都设为 1，那么 minF 必然为 1，下面第一个 for 循环可以省略
                int minF = INF;
                for (int v = T; v != S; ) {
                    int pv = fa_v[v], pi = fa_i[v];
                    minF = Math.min(minF, g[pv].get(pi).cap);
                    v = pv;
                }
                for (int v = T; v != S; ) {
                    int pv = fa_v[v], pi = fa_i[v];
                    neighbor e = g[pv].get(pi);
                    e.cap -= minF;
                    g[v].get(e.rid).cap += minF;
                    v = pv;
                }
                minCost += dis[T] * minF;
            }
            return minCost;
        }

        private boolean spfa() {
            Arrays.fill(dis, INF);
            dis[S] = 0;
            inQ[S] = true;
            Queue<Integer> q = new ArrayDeque<>();
            q.add(S);
            while (!q.isEmpty()) {
                int v = q.remove();
                inQ[v] = false;
                for (int i = 0; i < g[v].size(); i++) {
                    neighbor e = g[v].get(i);
                    if (e.cap <= 0) continue;
                    int w = e.to;
                    int newD = dis[v] + e.cost;
                    if (newD < dis[w]) {
                        dis[w] = newD;
                        fa_v[w] = v;
                        fa_i[w] = i;
                        if (!inQ[w]) {
                            inQ[w] = true;
                            q.add(w);
                        }
                    }
                }
            }
            // 循环结束后所有 inQ[v] 都为 false，无需重置
            return dis[T] < INF;
        }
    }
}
/*
3376. 破解锁的最少时间 I
https://leetcode.cn/problems/minimum-time-to-break-locks-i/description/

第 145 场双周赛 T2。

Bob 被困在了一个地窖里，他需要破解 n 个锁才能逃出地窖，每一个锁都需要一定的 能量 才能打开。每一个锁需要的能量存放在一个数组 strength 里，其中 strength[i] 表示打开第 i 个锁需要的能量。
Bob 有一把剑，它具备以下的特征：
- 一开始剑的能量为 0 。
- 剑的能量增加因子 X 一开始的值为 1 。
- 每分钟，剑的能量都会增加当前的 X 值。
- 打开第 i 把锁，剑的能量需要到达 至少 strength[i] 。
- 打开一把锁以后，剑的能量会变回 0 ，X 的值会增加一个给定的值 K 。
你的任务是打开所有 n 把锁并逃出地窖，请你求出需要的 最少 分钟数。
请你返回 Bob 打开所有 n 把锁需要的 最少 时间。
提示：
n == strength.length
1 <= n <= 8
1 <= K <= 10
1 <= strength[i] <= 10^6

nextPermutation / 最小费用流
相似题目: $3385. 破解锁的最少时间 II
https://leetcode.cn/problems/minimum-time-to-break-locks-ii/description/
 */