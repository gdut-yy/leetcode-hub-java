import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.function.Function;

public class Solution3924 {
    public int minimumThreshold(int n, int[][] edges, int source, int target, int k) {
        List<int[]>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        int maxWt = 0;
        for (int[] e : edges) {
            int x = e[0], y = e[1], wt = e[2];
            g[x].add(new int[]{y, wt});
            g[y].add(new int[]{x, wt});
            maxWt = Math.max(maxWt, wt);
        }

        int ans = sortSearch(maxWt + 1, m -> check(m, g, source, target, k));
        return ans > maxWt ? -1 : ans;
    }

    static int sortSearch(int n, Function<Integer, Boolean> f) {
        int l = 0, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (f.apply(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    private boolean check(int threshold, List<int[]>[] g, int source, int target, int k) {
        int[] dis = new int[g.length];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[source] = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.offerLast(new int[]{source, 0});

        while (!q.isEmpty()) {
            int[] p = q.pollFirst();
            int x = p[0], d = p[1];
            if (x == target) {
                return true;
            }
            if (d > dis[x]) {
                continue;
            }
            for (int[] e : g[x]) {
                int y = e[0];
                int wt = e[1] > threshold ? 1 : 0;
                int newDis = d + wt;
                if (newDis < dis[y]) {
                    dis[y] = newDis;
                    if (wt == 0) {
                        q.offerFirst(new int[]{y, newDis});
                    } else if (newDis <= k) {
                        q.offerLast(new int[]{y, newDis});
                    }
                }
            }
        }
        return false;
    }
}
/*
3924. 有限重边的最小阈值路径
https://leetcode.cn/problems/minimum-threshold-path-with-limited-heavy-edges/description/

第 182 场双周赛 T4。

给你一个有 n 个节点的无向加权图，节点编号从 0 到 n - 1。
该图由一个二维整数数组 edges 表示，其中每条边 edges[i] = [ui, vi, wi] 表示节点 ui 和 vi 之间存在一条权重为 wi 的无向边。
另外给你整数 source、target 和 k。
threshold 的值决定了一条边被认为是 轻的 还是 重的 ：
- 如果一条边的权重 小于 或 等于 threshold，则该边是 轻的 。
- 如果一条边的权重 大于 threshold，则该边是 重的 。
如果从 source 到 target 的路径包含 至多 k 条重边，则该路径是 有效的 。
返回使 source 到 target 之间 至少 存在一条 有效 路径的 最小整数 threshold。如果不存在这样的路径，则返回 -1。
提示：
1 <= n <= 10^3
0 <= edges.length <= 10^3
edges[i] = [ui, vi, wi]
0 <= ui, vi <= n - 1
1 <= wi <= 10^9
0 <= source, target <= n - 1
0 <= k <= edges.length

二分答案 + 0-1 BFS。
时间复杂度 O((n+m)logU)。
 */