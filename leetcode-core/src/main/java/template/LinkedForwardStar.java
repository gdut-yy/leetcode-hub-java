package template;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 链式前向星及其简单应用
 * https://malash.me/200910/linked-forward-star/
 * adjacency 邻接
 * 优先队列优化的 dijkstra
 * 时间复杂度 O(mlogm)
 * Solution743 | Solution1368 | Solution1514 | Solution2203
 */
public class LinkedForwardStar {
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