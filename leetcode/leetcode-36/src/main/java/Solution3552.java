import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class Solution3552 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int[] dist;
    private Deque<int[]> dq;

    public int minMoves(String[] matrix) {
        int m = matrix.length;
        int n = matrix[0].length();

        List<Integer>[] trans = new ArrayList[26];
        Arrays.setAll(trans, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = matrix[i].charAt(j);
                if ('A' <= c && c <= 'Z') {
                    trans[c - 'A'].add(i * n + j);
                }
            }
        }

        // 节点编号：格子从 0 到 nm - 1，传送中心从 nm 到 nm + 25
        dist = new int[n * m + 26];
        Arrays.fill(dist, -1);
        dq = new ArrayDeque<>(); // dis, sn
        dq.add(new int[]{0, 0});

        while (!dq.isEmpty()) {
            int[] p = dq.removeFirst();
            int dis = p[0], sn = p[1];
            if (dist[sn] >= 0) continue;
            dist[sn] = dis;

            if (sn < m * n) {
                // 在格子上
                int cx = sn / n;
                int cy = sn % n;
                for (int[] d : DIRECTIONS) {
                    int nx = cx + d[0];
                    int ny = cy + d[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && matrix[nx].charAt(ny) != '#') {
                        addDeque(sn, nx * n + ny, 1);
                    }
                }
                // 如果格子上有字母，还可以走到传送中心
                char c = matrix[cx].charAt(cy);
                if ('A' <= c && c <= 'Z') {
                    addDeque(sn, n * m + (c - 'A'), 0);
                }
            } else {
                // 在传送中心里
                for (int next_sn : trans[sn - n * m]) {
                    addDeque(sn, next_sn, 0);
                }
            }
        }
        return dist[n * m - 1];
    }

    // val:增量 0/1
    private void addDeque(int sn, int next_sn, int val) {
        if (dist[next_sn] >= 0) return;
        if (val == 0) dq.addFirst(new int[]{dist[sn], next_sn});
        else dq.addLast(new int[]{dist[sn] + 1, next_sn});
    }
}
/*
3552. 网格传送门旅游
https://leetcode.cn/problems/grid-teleportation-traversal/description/

第 450 场周赛 T3。

给你一个大小为 m x n 的二维字符网格 matrix，用字符串数组表示，其中 matrix[i][j] 表示第 i 行和第 j 列处的单元格。每个单元格可以是以下几种字符之一：
- '.' 表示一个空单元格。
- '#' 表示一个障碍物。
- 一个大写字母（'A' 到 'Z'）表示一个传送门。
你从左上角单元格 (0, 0) 出发，目标是到达右下角单元格 (m - 1, n - 1)。你可以从当前位置移动到相邻的单元格（上、下、左、右），移动后的单元格必须在网格边界内且不是障碍物。
如果你踏入一个包含传送门字母的单元格，并且你之前没有使用过该传送门字母，你可以立即传送到网格中另一个具有相同字母的单元格。这次传送不计入移动次数，但每个字母对应的传送门在旅程中 最多 只能使用一次。
返回到达右下角单元格所需的 最少 移动次数。如果无法到达目的地，则返回 -1。
提示：
1 <= m == matrix.length <= 10^3
1 <= n == matrix[i].length <= 10^3
matrix[i][j] 是 '#'、'.' 或一个大写英文字母。
matrix[0][0] 不是障碍物。

0-1 BFS。
时间复杂度 O(mn)。
rating 2009 (clist.by)
 */