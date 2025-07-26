import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1761 {
    public int minTrioDegree(int n, int[][] edges) {
        Set<Integer>[] d = new HashSet[n];
        Arrays.setAll(d, e -> new HashSet<>());
        for (int[] e : edges) {
            int u = e[0] - 1, v = e[1] - 1;
            d[u].add(v);
            d[v].add(u);
        }

        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0] - 1, v = e[1] - 1;
            if (d[u].size() < d[v].size() || (d[u].size() == d[v].size() && u < v)) {
                g[u].add(v);
            } else {
                g[v].add(u);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int u = 0; u < n; ++u) {
            for (int v : g[u]) {
                for (int w : g[v]) {
                    if (d[u].contains(w)) {
                        ans = Math.min(ans, d[u].size() + d[v].size() + d[w].size() - 6);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
/*
1761. 一个图中连通三元组的最小度数
https://leetcode.cn/problems/minimum-degree-of-a-connected-trio-in-a-graph/description/

给你一个无向图，整数 n 表示图中节点的数目，edges 数组表示图中的边，其中 edges[i] = [ui, vi] ，表示 ui 和 vi 之间有一条无向边。
一个 连通三元组 指的是 三个 节点组成的集合且这三个点之间 两两 有边。
连通三元组的度数 是所有满足此条件的边的数目：一个顶点在这个三元组内，而另一个顶点不在这个三元组内。
请你返回所有连通三元组中度数的 最小值 ，如果图中没有连通三元组，那么返回 -1 。
提示：
2 <= n <= 400
edges[i].length == 2
1 <= edges.length <= n * (n-1) / 2
1 <= ui, vi <= n
ui != vi
图中没有重复的边。

给无向图定向 https://leetcode.cn/problems/minimum-degree-of-a-connected-trio-in-a-graph/solutions/603198/gei-wu-xiang-tu-ding-xiang-by-lucifer100-c72d/
时间复杂度 O(M^{3/2})。
 */