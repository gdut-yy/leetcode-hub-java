import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution6081 {
    public int minimumObstacles(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        // 节点数
        int n = M * N;
        // 边数
        int m = M * N * 4;
        LinkedForwardStar adjacency = new LinkedForwardStar(n, m);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                int cur = i * N + j;

                int left = (j - 1 >= 0) ? (i * N + j - 1) : -1;
                int right = (j + 1 < N) ? (i * N + j + 1) : -1;
                int top = (i - 1 >= 0) ? (i - 1) * N + j : -1;
                int bottom = (i + 1 < M) ? (i + 1) * N + j : -1;

                if (left != -1) {
                    adjacency.add(cur, left, grid[i][j]);
                }
                if (right != -1) {
                    adjacency.add(cur, right, grid[i][j]);
                }
                if (top != -1) {
                    adjacency.add(cur, top, grid[i][j]);
                }
                if (bottom != -1) {
                    adjacency.add(cur, bottom, grid[i][j]);
                }
            }
        }

        int[] dist = adjacency.dijkstra(0);
        return dist[n - 1];
    }

    private static class LinkedForwardStar {
        // n 个点
        private final int N;
        // m 条边
        private final int M;
        // 链式前向星
        private final int[] headArr;
        private final int[] edgeArr;
        private final int[] nextArr;
        private final int[] weightArr;
        private int idx;

        // 链式前向星
        public LinkedForwardStar(int n, int m) {
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
            this.edgeArr[idx] = v;
            this.nextArr[idx] = headArr[u];
            this.headArr[u] = idx;
            this.weightArr[idx] = w;
            this.idx++;
        }

        // 从 src 点出发跑 dijkstra 返回 dist[] 数组
        public int[] dijkstra(int src) {
            boolean[] visited = new boolean[N];
            int[] dist = new int[N];
            Arrays.fill(dist, Integer.MAX_VALUE);

            // 优先队列优化
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
            priorityQueue.add(new int[]{src, 0});
            dist[src] = 0;

            while (!priorityQueue.isEmpty()) {
                int[] poll = priorityQueue.poll();
                int id = poll[0];

                if (visited[id]) {
                    continue;
                }
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
6081. 到达角落需要移除障碍物的最小数目
https://leetcode.cn/problems/minimum-obstacle-removal-to-reach-corner/

第 295 场周赛 T4。

给你一个下标从 0 开始的二维整数数组 grid ，数组大小为 m x n 。每个单元格都是两个值之一：
- 0 表示一个 空 单元格，
- 1 表示一个可以移除的 障碍物 。
你可以向上、下、左、右移动，从一个空单元格移动到另一个空单元格。
现在你需要从左上角 (0, 0) 移动到右下角 (m - 1, n - 1) ，返回需要移除的障碍物的 最小 数目。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 10^5
2 <= m * n <= 10^5
grid[i][j] 为 0 或 1
grid[0][0] == grid[m - 1][n - 1] == 0

Dijkstra 时间复杂度 O(mnlog(mn))
0-1 BFS
相似题目: 1368. 使网格图至少有一条有效路径的最小代价
https://leetcode-cn.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/
 */