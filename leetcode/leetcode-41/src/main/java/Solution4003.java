import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution4003 {
    // 奇数下标 1,3 对应向右或向下
    // 偶数下标 0,2 对应向左或向上
    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // 左右上下

    private record Node(long d, int i, int j, int k) {
    }

    public long minCost(int m, int n, int[][] penalty) {
        long[][][] dis = new long[m][n][2];
        for (long[][] mat : dis) {
            for (long[] row : mat) {
                Arrays.fill(row, Long.MAX_VALUE);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.d));

        // 支付 1 的入口代价
        dis[0][0][1] = 1;
        pq.offer(new Node(1, 0, 0, 1));

        while (true) {
            Node top = pq.poll();
            long d = top.d;
            int i = top.i;
            int j = top.j;
            int k = top.k;
            if (i == m - 1 && j == n - 1) {
                return d;
            }
            if (d > dis[i][j][k]) {
                continue;
            }
            int p = penalty[i][j];

            // 原地不动
            long newDis = d + p;
            if (newDis < dis[i][j][k ^ 1]) {
                dis[i][j][k ^ 1] = newDis;
                pq.offer(new Node(newDis, i, j, k ^ 1)); // k^1 切换行动编号的奇偶性
            }

            // 移动一步
            for (int idx = 0; idx < 4; idx++) {
                int x = i + DIRS[idx][0];
                int y = j + DIRS[idx][1];
                if (0 <= x && x < m && 0 <= y && y < n) {
                    // 如果 k 和 idx 的奇偶性不同，那么违反了奇偶性规则，需要额外支付 p 的代价
                    newDis = d + (long) (x + 1) * (y + 1) + (long) (idx % 2 ^ k) * p;
                    if (newDis < dis[x][y][k ^ 1]) {
                        dis[x][y][k ^ 1] = newDis;
                        pq.offer(new Node(newDis, x, y, k ^ 1)); // k^1 切换行动编号的奇偶性
                    }
                }
            }
        }
    }
}
/*
4003. 交替方向的最小路径代价 III
https://leetcode.cn/problems/minimum-cost-path-with-alternating-directions-iii/description/

第 512 场周赛 T4。

给你两个整数 m 和 n，表示一个网格的行数和列数。你的目标是到达单元格 (m - 1, n - 1)。同时给你一个二维整数数组 penalty。
进入单元格 (i, j) 的代价为 (i + 1) * (j + 1)。
你从单元格 (0, 0) 开始，最初需要支付其入口代价。进入 (0, 0) 后执行的行动从 1 开始编号。
在每次行动中，你可以移动到一个 相邻 的单元格，或者在当前单元格等待。如果满足以下条件，则移动遵循奇偶性规则：
- 在 奇数编号 的行动中，你向 右 或向 下 移动。
- 在 偶数编号 的行动中，你向 左 或向 上 移动。
行动的代价由以下方式决定：
- 如果你遵循奇偶性规则移动，只需支付目标单元格的入口代价。
- 如果你在 违反 奇偶性规则的方向上移动，支付目标单元格的入口代价加上 penalty[i][j]，其中 (i, j) 是你移动前所在的单元格。
- 如果你在单元格 (i, j) 中等待，支付 penalty[i][j]。
在每次移动或等待之后，行动编号增加 1。因此，无论是否支付了惩罚代价，所需遵循的奇偶性规则在每次行动后都会交替改变。
返回到达 (m - 1, n - 1) 所需的 最小 总代价。
提示：
1 <= m, n <= 10^5
2 <= m * n <= 10^5
penalty.length == m
penalty[i].length == n
0 <= penalty[i][j] <= 10^5

Dijkstra 最短路。
https://leetcode.cn/problems/minimum-cost-path-with-alternating-directions-iii/solutions/4001978/dijkstra-zui-duan-lu-pythonjavacgo-by-en-x6f4/
 */