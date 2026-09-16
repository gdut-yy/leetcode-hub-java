import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1514 {
    private ArrayList<edge>[] g;

    record edge(int to, double wt) {
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        int m = edges.length;
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = edges[i][0], v = edges[i][1];
            double wt = succProb[i];
            g[u].add(new edge(v, wt));
            g[v].add(new edge(u, wt));
        }
        double[] dist = dijkstra_mlogm(n, start);
        return dist[end];
    }

    private double[] dijkstra_mlogm(int n, int node) {
        PriorityQueue<edge> pq = new PriorityQueue<>(Comparator.comparingDouble(o -> -o.wt));
        boolean[] vis = new boolean[n];
        double[] dist = new double[n];
        pq.add(new edge(node, 0));
        dist[node] = 1;
        while (!pq.isEmpty()) {
            edge top = pq.remove();
            int x = top.to;
            if (vis[x]) continue;
            vis[x] = true;
            for (edge p : g[x]) {
                int y = p.to;
                double wt = p.wt;
                if (dist[y] < dist[x] * wt) {
                    dist[y] = dist[x] * wt;
                    pq.add(new edge(y, dist[y]));
                }
            }
        }
        return dist;
    }
}
/*
1514. 概率最大的路径
https://leetcode.cn/problems/path-with-maximum-probability/

给你一个由 n 个节点（下标从 0 开始）组成的无向加权图，该图由一个描述边的列表组成，
其中 edges[i] = [a, b] 表示连接节点 a 和 b 的一条无向边，且该边遍历成功的概率为 succProb[i] 。
指定两个节点分别作为起点 start 和终点 end ，请你找出从起点到终点成功概率最大的路径，并返回其成功概率。
如果不存在从 start 到 end 的路径，请 返回 0 。只要答案与标准答案的误差不超过 1e-5 ，就会被视作正确答案。
提示：
2 <= n <= 10^4
0 <= start, end < n
start != end
0 <= a, b < n
a != b
0 <= succProb.length == edges.length <= 2*10^4
0 <= succProb[i] <= 1
每两个节点之间最多有一条边

dijkstra 变种，加法变乘法，最小变最大。
 */