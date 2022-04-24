import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SolutionLCP56 {
    public int conveyorBelt(String[] matrix, int[] start, int[] end) {
        int M = matrix.length;
        int N = matrix[0].length();

        char[][] chars = new char[M][N];
        for (int i = 0; i < M; i++) {
            chars[i] = matrix[i].toCharArray();
        }
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
                    adjacency.add(cur, left, chars[i][j] == '<' ? 0 : 1);
                }
                if (right != -1) {
                    adjacency.add(cur, right, chars[i][j] == '>' ? 0 : 1);
                }
                if (top != -1) {
                    adjacency.add(cur, top, chars[i][j] == '^' ? 0 : 1);
                }
                if (bottom != -1) {
                    adjacency.add(cur, bottom, chars[i][j] == 'v' ? 0 : 1);
                }
            }
        }

        int[] dist = adjacency.dijkstra(start[0] * N + start[1]);
        return dist[end[0] * N + end[1]];
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
LCP 56. 信物传送
https://leetcode-cn.com/problems/6UEx57/

LCCUP 力扣杯 2022 春季编程大赛战队赛 T2。

欢迎各位勇者来到力扣城，本次试炼主题为「信物传送」。
本次试炼场地设有若干传送带，matrix[i][j] 表示第 i 行 j 列的传送带运作方向，"^","v","<",">" 这四种符号分别表示 上、下、左、右 四个方向。
信物会随传送带的方向移动。勇者每一次施法操作，可临时变更一处传送带的方向，在物品经过后传送带恢复原方向。
通关信物初始位于坐标 start处，勇者需要将其移动到坐标 end 处，请返回勇者施法操作的最少次数。
注意：
start 和 end 的格式均为 [i,j]
提示：
matrix 中仅包含 '^'、'v'、'<'、'>'
0 < matrix.length <= 100
0 < matrix[i].length <= 100
0 <= start[0],end[0] < matrix.length
0 <= start[1],end[1] < matrix[i].length

相似题目: 1368. 使网格图至少有一条有效路径的最小代价
https://leetcode-cn.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/
 */