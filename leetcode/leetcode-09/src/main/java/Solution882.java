import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution882 {
    private List<int[]>[] g;
    private int n;

    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        this.n = n;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int u = e[0], v = e[1], cnt = e[2];
            g[u].add(new int[]{v, cnt + 1});
            g[v].add(new int[]{u, cnt + 1}); // 建图
        }
        int[] dist = dijkstra_mlogm(0); // 从 0 出发的最短路

        int ans = 0;
        for (int d : dist) {
            if (d <= maxMoves) { // 这个点可以在 maxMoves 步内到达
                ans++;
            }
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1], cnt = e[2];
            int a = Math.max(maxMoves - dist[u], 0);
            int b = Math.max(maxMoves - dist[v], 0);
            ans += Math.min(a + b, cnt); // 这条边上可以到达的节点数
        }
        return ans;
    }

    private int[] dijkstra_mlogm(int node) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        boolean[] vis = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE); // 不能为 1e9
        pq.add(new int[]{node, 0});
        dist[node] = 0;
        while (!pq.isEmpty()) {
            int[] top = pq.remove();
            int x = top[0];
            if (vis[x]) continue;
            vis[x] = true;
            for (int[] p : g[x]) {
                int y = p[0], wt = p[1];
                if (dist[y] > dist[x] + wt) {
                    dist[y] = dist[x] + wt;
                    pq.add(new int[]{y, dist[y]});
                }
            }
        }
        return dist;
    }
}
/*
882. 细分图中的可到达节点
https://leetcode.cn/problems/reachable-nodes-in-subdivided-graph/description/

给你一个无向图（原始图），图中有 n 个节点，编号从 0 到 n - 1 。你决定将图中的每条边 细分 为一条节点链，每条边之间的新节点数各不相同。
图用由边组成的二维数组 edges 表示，其中 edges[i] = [ui, vi, cnti] 表示原始图中节点 ui 和 vi 之间存在一条边，cnti 是将边 细分 后的新节点总数。注意，cnti == 0 表示边不可细分。
要 细分 边 [ui, vi] ，需要将其替换为 (cnti + 1) 条新边，和 cnti 个新节点。新节点为 x1, x2, ..., xcnti ，新边为 [ui, x1], [x1, x2], [x2, x3], ..., [xcnti-1, xcnti], [xcnti, vi] 。
现在得到一个 新的细分图 ，请你计算从节点 0 出发，可以到达多少个节点？如果节点间距离是 maxMoves 或更少，则视为 可以到达 。
给你原始图和 maxMoves ，返回 新的细分图中从节点 0 出发 可到达的节点数 。
提示：
0 <= edges.length <= min(n * (n - 1) / 2, 10^4)
edges[i].length == 3
0 <= ui < vi < n
图中 不存在平行边
0 <= cnti <= 10^4
0 <= maxMoves <= 10^9
1 <= n <= 3000

转换成单源最短路问题 https://leetcode.cn/problems/reachable-nodes-in-subdivided-graph/solutions/1991509/tu-jie-zhuan-huan-cheng-dan-yuan-zui-dua-6l8o/
时间复杂度 O(n+mlogm)。
 */