import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Solution1263 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private char[][] grid;
    private int M, N;
    // 分别表示人、箱子的位置坐标
    private int sx, sy, bx, by;
    // 人可以到达的地方
    private boolean[][] pos;

    public int minPushBox(char[][] grid) {
        this.grid = grid;
        M = grid.length;
        N = grid[0].length;

        // step1: 找坐标
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }
        if (grid[bx][by] == 'T') {
            return 0;
        }

        // step2: 计算初始时人可以到达的地方
        pos = new boolean[M][N];
        dfs(sx, sy, bx, by);

        // step3: 计算初始时箱子可以到达的地方
        Queue<int[]> queue = new ArrayDeque<>();
        // 保存推箱子的位置和从那个方向被推过来
        boolean[][][] visited = new boolean[M][N][4];
        for (int k = 0; k < 4; k++) {
            int[] dir = DIRECTIONS[k];
            // 箱子将被推去的新位置
            int nbx = bx + dir[0];
            int nby = by + dir[1];
            // 推箱子时人的位置
            int nx = bx - dir[0];
            int ny = by - dir[1];

            if (nbx < 0 || nbx >= M || nby < 0 || nby >= N
                    || nx < 0 || nx >= M || ny < 0 || ny >= N) {
                continue;
            }
            if (!pos[nx][ny] || grid[nbx][nby] == '#' || visited[nbx][nby][k]) {
                continue;
            }
            visited[nbx][nby][k] = true;
            if (grid[nbx][nby] == 'T') {
                return 1;
            }
            // 保存的是箱子的位置，以及人推完箱子后所处的位置
            queue.add(new int[]{nbx, nby, bx, by});
        }

        // step4: 开始BFS
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tuple = queue.remove();
                // 根据上一次推完箱子的情况计算人当前可以到达的所有地方
                for (boolean[] po : pos) {
                    Arrays.fill(po, false);
                }
                dfs(tuple[2], tuple[3], tuple[0], tuple[1]);
                // 计算现在箱子可以到达的地方
                for (int k = 0; k < 4; k++) {
                    int[] dir = DIRECTIONS[k];
                    // 箱子将被推去的新位置
                    int nbx = tuple[0] + dir[0];
                    int nby = tuple[1] + dir[1];
                    // 推箱子时人的位置
                    int nx = tuple[0] - dir[0];
                    int ny = tuple[1] - dir[1];

                    if (nbx < 0 || nbx >= M || nby < 0 || nby >= N
                            || nx < 0 || nx >= M || ny < 0 || ny >= N) {
                        continue;
                    }
                    if (!pos[nx][ny] || grid[nbx][nby] == '#' || visited[nbx][nby][k]) {
                        continue;
                    }
                    visited[nbx][nby][k] = true;
                    if (grid[nbx][nby] == 'T') {
                        return step + 1;
                    }
                    queue.add(new int[]{nbx, nby, tuple[0], tuple[1]});
                }
            }
            step++;
        }
        return -1;
    }

    // 使用 DFS 计算人可以到达的所有位置
    // cx, cy：人 bx, by：箱子
    public void dfs(int cx, int cy, int bx, int by) {
        pos[cx][cy] = true;
        for (int[] dir : DIRECTIONS) {
            int nx = cx + dir[0];
            int ny = cy + dir[1];
            if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                continue;
            }
            if (grid[nx][ny] == '#' || nx == bx && ny == by || pos[nx][ny]) {
                continue;
            }
            pos[nx][ny] = true;
            dfs(nx, ny, bx, by);
        }
    }
}
/*
1263. 推箱子
https://leetcode.cn/problems/minimum-moves-to-move-a-box-to-their-target-location/

「推箱子」是一款风靡全球的益智小游戏，玩家需要将箱子推到仓库中的目标位置。
游戏地图用大小为 m x n 的网格 grid 表示，其中每个元素可以是墙、地板或者是箱子。
现在你将作为玩家参与游戏，按规则将箱子 'B' 移动到目标位置 'T' ：
- 玩家用字符 'S' 表示，只要他在地板上，就可以在网格中向上、下、左、右四个方向移动。
- 地板用字符 '.' 表示，意味着可以自由行走。
- 墙用字符 '#' 表示，意味着障碍物，不能通行。
- 箱子仅有一个，用字符 'B' 表示。相应地，网格上有一个目标位置 'T'。
- 玩家需要站在箱子旁边，然后沿着箱子的方向进行移动，此时箱子会被移动到相邻的地板单元格。记作一次「推动」。
- 玩家无法越过箱子。
返回将箱子推到目标位置的最小 推动 次数，如果无法做到，请返回 -1。
提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 20
grid 仅包含字符 '.', '#',  'S' , 'T', 以及 'B'。
grid 中 'S', 'B' 和 'T' 各只能出现一个。

BFS https://leetcode.cn/problems/minimum-moves-to-move-a-box-to-their-target-location/solution/java-jian-dan-yi-dong-bfs-by-merickbao-2-eefj/
可用 0-1 BFS？
 */