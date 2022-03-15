import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution743 {
    private static final int INF = Integer.MAX_VALUE / 2;

    public int networkDelayTime(int[][] times, int n, int k) {
        // 有 n 个网络节点，标记为 1 到 n
        // 邻接矩阵 weights[ui][vi] = wi 表示从 ui 到 vi 有权重为 wi 的边
        int[][] weights = buildAdj(times, n);
        // floyd 基本流程为三层循环：
        // 枚举中转点 - 枚举起点 - 枚举终点 - 松弛操作
        for (int p = 1; p <= n; p++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    weights[i][j] = Math.min(weights[i][j], weights[i][p] + weights[p][j]);
                }
            }
        }
        // 遍历答案
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, weights[k][i]);
        }
        return max == INF ? -1 : max;
    }

    private int[][] buildAdj(int[][] times, int n) {
        int[][] weights = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    weights[i][j] = weights[j][i] = 0;
                } else {
                    weights[i][j] = weights[j][i] = INF;
                }
            }
        }
        for (int[] time : times) {
            int ui = time[0];
            int vi = time[1];
            int wi = time[2];
            weights[ui][vi] = wi;
        }
        return weights;
    }

    public int networkDelayTime2(int[][] times, int n, int k) {
        int m = times.length;

        Adjacency adjacency = new Adjacency(n, m);
        // 存图
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjacency.add(u, v, w);
        }

        // 堆优化 Dijkstra（邻接表）
        int[] dist = adjacency.dijkstra(k);

        // 遍历答案
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i]);
        }
        return max == INF ? -1 : max;
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

        public int[] dijkstra(int k) {
            // 起始先将所有的点标记为「未更新」和「距离为正无穷」
            boolean[] visited = new boolean[N];
            // dist[x] = y 代表从「源点/起点」到 x 的最短距离为 y
            int[] dist = new int[N];
            Arrays.fill(dist, INF);

            // 只有起点最短距离为 0
            dist[k] = 0;
            // 使用「优先队列」存储所有可用于更新的点
            // 以 (点编号, 到起点的距离) 进行存储，优先弹出「最短距离」较小的点
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
            priorityQueue.add(new int[]{k, 0});

            while (!priorityQueue.isEmpty()) {
                // 每次从「优先队列」中弹出
                int[] poll = priorityQueue.poll();
                int id = poll[0];
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
                        priorityQueue.add(new int[]{j, dist[j]});
                    }
                }
            }
            return dist;
        }
    }
}
/*
743. 网络延迟时间
https://leetcode-cn.com/problems/network-delay-time/

有 n 个网络节点，标记为 1 到 n。
给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
提示：
1 <= k <= n <= 100
1 <= times.length <= 6000
times[i].length == 3
1 <= ui, vi <= n
ui != vi
0 <= wi <= 100
所有 (ui, vi) 对都 互不相同（即，不含重复边）

最短路。
Floyd 时间复杂度 O(n^3)
堆优化 dijkstra 时间复杂度 O(nlogm)
【宫水三叶】涵盖所有的「存图方式」与「最短路算法（详尽注释）」
https://leetcode-cn.com/problems/network-delay-time/solution/gong-shui-san-xie-yi-ti-wu-jie-wu-chong-oghpz/
 */