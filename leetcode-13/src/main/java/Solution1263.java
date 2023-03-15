import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1263 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int M;
    private int N;

    // 人可以到达的地方
    boolean[][] pos;

    public int minPushBox(char[][] grid) {
        M = grid.length;
        N = grid[0].length;
        pos = new boolean[M][N];

        // 分别表示人、目标、箱子的位置坐标
        int[] player = {-1, -1};
        int[] target = {-1, -1};
        int[] box = {-1, -1};

        // step1 : 找上面的坐标
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 'S') {
                    player = new int[]{i, j};
                } else if (grid[i][j] == 'B') {
                    box = new int[]{i, j};
                } else if (grid[i][j] == 'T') {
                    target = new int[]{i, j};
                }
            }
        }
        if (Arrays.equals(box, target)) {
            return 0;
        }

        // step2 : 计算初始时人可以到达的地方
        dfs(grid, player, box);

        // step3 : 计算初始时箱子可以到达的地方
        Queue<int[]> queue = new LinkedList<>();
        boolean[][][] seen = new boolean[M][N][4]; // 保存推箱子的位置和从那个方向被推过来
        for (int i = 0; i < 4; i++) {
            int[] dir = DIRECTIONS[i];
            // 箱子将被推去的新位置
            int x = box[0] + dir[0];
            int y = box[1] + dir[1];
            // 推箱子时人的位置
            int px = box[0] - dir[0];
            int py = box[1] - dir[1];

            if (x < 0 || x >= M || y < 0 || y >= N || px < 0 || px >= M || py < 0 || py >= N) {
                continue;
            }
            if (!pos[px][py] || grid[x][y] == '#' || seen[x][y][i]) {
                continue;
            }
            seen[x][y][i] = true;
            if (grid[x][y] == 'T') {
                return 1;
            }
            queue.offer(new int[]{x, y, box[0], box[1]}); // 保存的是箱子的位置，以及人推完箱子后所处的位置

        }

        // step4 : 开始BFS
        int cnt = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int sz = 0; sz < size; sz++) {
                int[] now = queue.poll();
                // 根据上一次推完箱子的情况计算人当前可以到达的所有地方
                for (boolean[] po : pos) {
                    Arrays.fill(po, false);
                }
                dfs(grid, new int[]{now[2], now[3]}, new int[]{now[0], now[1]});
                // 计算现在箱子可以到达的地方
                for (int i = 0; i < 4; i++) {
                    int[] dir = DIRECTIONS[i];
                    int x = now[0] + dir[0];
                    int y = now[1] + dir[1];
                    int px = now[0] - dir[0];
                    int py = now[1] - dir[1];

                    if (x < 0 || x >= M || y < 0 || y >= N || px < 0 || px >= M || py < 0 || py >= N) {
                        continue;
                    }
                    if (!pos[px][py] || grid[x][y] == '#' || seen[x][y][i]) {
                        continue;
                    }
                    seen[x][y][i] = true;
                    if (grid[x][y] == 'T') {
                        return cnt + 1;
                    }
                    queue.offer(new int[]{x, y, now[0], now[1]});
                }
            }
            cnt++;
        }
        return -1;
    }

    // 使用DFS计算人可以到达的所有位置
    public void dfs(char[][] grid, int[] player, int[] box) {
        pos[player[0]][player[1]] = true;
        for (int i = 0; i < 4; i++) {
            int[] dir = DIRECTIONS[i];
            int tx = player[0] + dir[0];
            int ty = player[1] + dir[1];
            if (tx < 0 || tx >= M || ty < 0 || ty >= N) {
                continue;
            }
            if (grid[tx][ty] == '#' || tx == box[0] && ty == box[1] || pos[tx][ty]) {
                continue;
            }
            pos[tx][ty] = true;
            dfs(grid, new int[]{tx, ty}, box);
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
 */