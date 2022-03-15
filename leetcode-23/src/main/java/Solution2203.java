import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2203 {
    private static final long INF = Long.MAX_VALUE / 10;

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        int m = edges.length;
        Adjacency adj = new Adjacency(n, m);
        // 反向图
        Adjacency revert = new Adjacency(n, m);

        // 存图
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.add(u, v, w);
            revert.add(v, u, w);
        }

        long[] src1Dist = adj.dijkstra(src1);
        long[] src2Dist = adj.dijkstra(src2);
        long[] destDist = revert.dijkstra(dest);

        // 枚举中间点
        long min = INF;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, src1Dist[i] + src2Dist[i] + destDist[i]);
        }
        return min == INF ? -1 : min;
    }

    private static class Adjacency {
        private final int N;
        private final int M;
        private final int[] headArr;
        private final int[] edgeArr;
        private final int[] nextArr;
        private final int[] weightArr;
        private int idx;

        // 链式前向星
        public Adjacency(int n, int m) {
            this.N = n + 1;
            this.M = m + 1;
            this.headArr = new int[N];
            // 初始化链表头
            Arrays.fill(headArr, -1);
            this.edgeArr = new int[M];
            this.nextArr = new int[M];
            this.weightArr = new int[M];
            this.idx = 0;
        }

        public void add(int u, int v, int w) {
            edgeArr[idx] = v;
            nextArr[idx] = headArr[u];
            headArr[u] = idx;
            weightArr[idx] = w;
            idx++;
        }

        public long[] dijkstra(int k) {
            // 起始先将所有的点标记为「未更新」和「距离为正无穷」
            boolean[] visited = new boolean[N];
            // dist[x] = y 代表从「源点/起点」到 x 的最短距离为 y
            long[] dist = new long[N];
            Arrays.fill(dist, INF);

            // 只有起点最短距离为 0
            dist[k] = 0;
            // 使用「优先队列」存储所有可用于更新的点
            // 以 (点编号, 到起点的距离) 进行存储，优先弹出「最短距离」较小的点
            PriorityQueue<long[]> priorityQueue = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
            priorityQueue.add(new long[]{k, 0});

            while (!priorityQueue.isEmpty()) {
                // 每次从「优先队列」中弹出
                long[] poll = priorityQueue.poll();
                int id = (int) poll[0];
//                int step = poll[1];

                // 如果弹出的点被标记「已更新」，则跳过
                if (visited[id]) {
                    continue;
                }
                // 标记该点「已更新」，并使用该点更新其他点的「最短距离」
                visited[id] = true;
                for (int i = headArr[id]; i != -1; i = nextArr[i]) {
                    int j = edgeArr[i];
                    if (dist[j] > dist[id] + weightArr[i]) {
                        dist[j] = dist[id] + weightArr[i];
                        priorityQueue.add(new long[]{j, dist[j]});
                    }
                }
            }
            return dist;
        }
    }
}
/*
2203. 得到要求路径的最小带权子图
https://leetcode-cn.com/problems/minimum-weighted-subgraph-with-the-required-paths/

第 284 场周赛 T4。

给你一个整数 n ，它表示一个 带权有向 图的节点数，节点编号为 0 到 n - 1 。
同时给你一个二维整数数组 edges ，其中 edges[i] = [fromi, toi, weighti] ，表示从 fromi 到 toi 有一条边权为 weighti 的 有向 边。
最后，给你三个 互不相同 的整数 src1 ，src2 和 dest ，表示图中三个不同的点。
请你从图中选出一个 边权和最小 的子图，使得从 src1 和 src2 出发，在这个子图中，都 可以 到达 dest 。如果这样的子图不存在，请返回 -1 。
子图 中的点和边都应该属于原图的一部分。子图的边权和定义为它所包含的所有边的权值之和。
提示：
3 <= n <= 10^5
0 <= edges.length <= 10^5
edges[i].length == 3
0 <= fromi, toi, src1, src2, dest <= n - 1
fromi != toi
src1 ，src2 和 dest 两两不同。
1 <= weight[i] <= 10^5

dijkstra 单源最短路
时间复杂度 O(nlogm)
相似题目: 743. 网络延迟时间
https://leetcode-cn.com/problems/network-delay-time/
 */