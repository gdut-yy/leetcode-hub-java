import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution3905 {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] grid = new int[n][m];
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], -1);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        for (int[] s : sources) {
            int r = s[0], c = s[1], color = s[2];
            grid[r][c] = color;
            dist[r][c] = 0;
            queue.offer(new int[]{r, c});
        }
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];
            int d = dist[r][c];
            int color = grid[r][c];
            for (int k = 0; k < 4; k++) {
                int nr = r + dx[k];
                int nc = c + dy[k];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (dist[nr][nc] == -1) {
                        dist[nr][nc] = d + 1;
                        grid[nr][nc] = color;
                        queue.offer(new int[]{nr, nc});
                    } else if (dist[nr][nc] == d + 1) {
                        if (color > grid[nr][nc]) {
                            grid[nr][nc] = color;
                        }
                    }
                }
            }
        }
        return grid;
    }
}
/*
3905. 多源图像渲染
https://leetcode.cn/problems/multi-source-flood-fill/description/

第 498 场周赛 T3。

给你两个整数 n 和 m，分别表示一个网格的行数和列数。
同时给你一个二维整数数组 sources，其中 sources[i] = [ri, ci, colori] 表示单元格 (ri, ci) 初始被涂上颜色 colori。所有其他单元格初始均未着色，用 0 表示。
在每一单位时间中，所有当前已着色的单元格都会将其颜色向上下左右四个方向扩散到所有相邻的 未着色 单元格。所有扩散同时发生。
如果 多个 颜色在同一时间步到达同一个未着色单元格，该单元格将采用具有 最大 值的颜色。
这个过程持续进行，直到没有更多的单元格可以被着色。
返回一个二维整数数组，表示网格的最终状态，其中每个单元格包含其最终的颜色。
提示：
1 <= n, m <= 10^5
1 <= n * m <= 10^5
1 <= sources.length <= n * m
sources[i] = [ri, ci, colori]
0 <= ri <= n - 1
0 <= ci <= m - 1
1 <= colori <= 10^6
sources 中的所有 (ri, ci) 互不相同。

多源 BFS。
https://chat.deepseek.com/a/chat/s/d4d03b52-ee32-4779-8aa4-89f20bf9393c
时间复杂度 O(k+nm)，其中 k 是 sources 的长度。
 */