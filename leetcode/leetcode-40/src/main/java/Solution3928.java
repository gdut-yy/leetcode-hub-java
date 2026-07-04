import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution3928 {
    public int[] minCost(int n, int[] prices, int[][] roads) {
        int maxPrices = 0;
        for (int p : prices) {
            maxPrices = Math.max(maxPrices, p);
        }

        List<int[]>[] g1 = new ArrayList[n];
        List<int[]>[] g2 = new ArrayList[n];
        Arrays.setAll(g1, e -> new ArrayList<>());
        Arrays.setAll(g2, e -> new ArrayList<>());
        for (int[] e : roads) {
            int x = e[0], y = e[1], cost = e[2], tax = e[3];
            if (cost < maxPrices) {
                g1[x].add(new int[]{y, cost});
                g1[y].add(new int[]{x, cost});
            }
            if ((long) cost * tax < maxPrices) {
                g2[x].add(new int[]{y, cost * tax});
                g2[y].add(new int[]{x, cost * tax});
            }
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int[] dis1 = dijkstra(g1, i, prices[i]);
            int[] dis2 = dijkstra(g2, i, prices[i]);
            int res = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (dis1[j] + dis2[j] < res - prices[j]) { // 为避免加法溢出，把 prices[j] 移到右边
                    res = prices[j] + dis1[j] + dis2[j];
                }
            }
            ans[i] = res;
        }

        return ans;
    }

    private int[] dijkstra(List<int[]>[] g, int start, int price) {
        int[] dis = new int[g.length];
        Arrays.fill(dis, price);
        // 堆中保存 (起点到节点 x 的最短路长度，节点 x)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        dis[start] = 0; // 起点到自己的距离是 0
        pq.offer(new int[]{0, start});

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int disX = top[0];
            int x = top[1];
            if (disX > dis[x]) { // x 之前出堆过
                continue;
            }
            for (int[] e : g[x]) {
                int y = e[0];
                int newDisY = disX + e[1];
                if (newDisY < dis[y]) {
                    dis[y] = newDisY; // 更新 x 的邻居的最短路
                    // 懒更新堆：只插入数据，不更新堆中数据
                    // 相同节点可能有多个不同的 newDisY，除了最小的 newDisY，其余值都会触发上面的 continue
                    pq.offer(new int[]{newDisY, y});
                }
            }
        }
        return dis;
    }
}
/*
3928. 购买苹果的最低成本 II
https://leetcode.cn/problems/minimum-cost-to-buy-apples-ii/description/

第 501 场周赛 T4。

给你一个整数 n 和一个长度为 n 的整数数组 prices，其中 prices[i] 表示商店 i 中苹果的价格。
另给定一个二维整数数组 roads，其中 roads[i] = [ui, vi, costi, taxi] 表示一条 双向 道路：
- ui 和 vi 是该道路连接的两个商店。
- costi 表示在 不携带苹果 时通过该道路的花费。
- taxi 表示在 携带苹果 时，该道路费用相对于 costi 的乘数。
对于每个商店 i，你可以选择其中之一：
- 直接在商店 i 购买苹果，花费为 prices[i]。
- 以 空手 状态，通过 任意数量 的道路前往任意一家商店 j，以 prices[j] 的价格购买苹果，然后携带苹果返回商店 i。返回途中，每条道路的费用为 cost * tax。
前往商店时（空手）和返回时（携带苹果）所经过的路径可以 不同。
返回一个长度为 n 的整数数组 ans，其中 ans[i] 表示从商店 i 出发购买到苹果所需的 最小 总花费。
提示：
1 <= n <= 1000
prices.length == n
1 <= prices[i] <= 10^9
0 <= roads.length <= min(n × (n - 1) / 2, 2000)
roads[i] = [ui, vi, costi, taxi]
0 <= ui, vi <= n - 1
ui != vi
1 <= costi <= 10^9
1 <= taxi <= 100
不存在重复边。

跑 2n 次 Dijkstra + 优化 https://leetcode.cn/problems/minimum-cost-to-buy-apples-ii/solutions/3966171/pao-2n-ci-dijkstrapythonjavacgo-by-endle-6hgd/
时间复杂度 O(n(n+mlogm))。
 */