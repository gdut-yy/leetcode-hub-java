import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SolutionLCP75 {
    private static final int INF = (int) 1e9;
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private char[][] grid;
    private int n;
    private int[][] dist;

    public int challengeOfTheKeeper(String[] maze) {
        this.n = maze.length;
        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = maze[i].toCharArray();
        }

        int sx = 0, sy = 0, tx = 0, ty = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char ch = grid[i][j];
                if (ch == 'S') {
                    sx = i;
                    sy = j;
                } else if (ch == 'T') {
                    tx = i;
                    ty = j;
                }
            }
        }

        // BFS 求终点到其余点的最短路
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{tx, ty, 0});
        boolean[][] visited = new boolean[n][n];
        visited[tx][ty] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] tuple = queue.remove();
                int cx = tuple[0], cy = tuple[1], cstep = tuple[2];
                dist[cx][cy] = cstep;

                for (int[] dir : DIRECTIONS) {
                    int nx = cx + dir[0];
                    int ny = cy + dir[1];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && grid[nx][ny] != '#') {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, cstep + 1});
                    }
                }
            }
        }

        // 无法从 S 到 T
        if (dist[sx][sy] == INF) {
            return -1;
        }

        // 二分答案
        // 走到一个位置（陷阱），传送之后还需要走 > mid 步
        // 如果在不走 # 不走陷阱的情况下，可以到达终点 => 答案 <= mid
        // 如果无法到达终点 => 答案 > mid
        int left = 0;
        int right = n * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T]
            // ----------------------^
            if (checkMid(sx, sy, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left == n * n ? -1 : left;
    }

    private boolean checkMid(int sx, int sy, int mid) {
        boolean[][] vis = new boolean[n][n];
        return dfs(vis, sx, sy, mid);
    }

    private boolean dfs(boolean[][] vis, int i, int j, int mid) {
        if (i >= 0 && i < n && j >= 0 && j < n && !vis[i][j] && grid[i][j] != '#') {
            if (grid[i][j] == 'T') {
                return true;
            }
            vis[i][j] = true;
            if (grid[i][j] == '.') {
                if (grid[i][n - 1 - j] != '#' && dist[i][n - 1 - j] > mid) {
                    return false;
                }
                if (grid[n - 1 - i][j] != '#' && dist[n - 1 - i][j] > mid) {
                    return false;
                }
            }
            for (int[] dir : DIRECTIONS) {
                int nx = i + dir[0];
                int ny = j + dir[1];
                if (dfs(vis, nx, ny, mid)) {
                    return true;
                }
            }
        }
        return false;
    }
}
/*
LCP 75. 传送卷轴
https://leetcode.cn/problems/rdmXM7/

LCCUP'23 春季个人赛 T4。

随着不断的深入，小扣来到了守护者之森寻找的魔法水晶。首先，他必须先通过守护者的考验。
考验的区域是一个正方形的迷宫，maze[i][j] 表示在迷宫 i 行 j 列的地形：
- 若为 . ，表示可以到达的空地；
- 若为 # ，表示不可到达的墙壁；
- 若为 S ，表示小扣的初始位置；
- 若为 T ，表示魔法水晶的位置。
小扣每次可以向 上、下、左、右 相邻的位置移动一格。而守护者拥有一份「传送魔法卷轴」，使用规则如下：
- 魔法需要在小扣位于 空地 时才能释放，发动后卷轴消失；；
- 发动后，小扣会被传送到水平或者竖直的镜像位置，且目标位置不得为墙壁(如下图所示)；
在使用卷轴后，小扣将被「附加负面效果」，因此小扣需要尽可能缩短传送后到达魔法水晶的距离。而守护者的目标是阻止小扣到达魔法水晶的位置；如果无法阻止，则尽可能 增加 小扣传送后到达魔法水晶的距离。
假设小扣和守护者都按最优策略行事，返回小扣需要在 「附加负面效果」的情况下 最少 移动多少次才能到达魔法水晶。如果无法到达，返回 -1。
注意：
- 守护者可以不使用卷轴；
- 传送后的镜像位置可能与原位置相同。
提示：
4 <= maze.length == maze[i].length <= 200
maze[i][j] 仅包含 "."、"#"、"S"、"T"

BFS。
也可用 瓶颈路 解决？
https://leetcode.cn/problems/rdmXM7/solution/bfs-ping-jing-lu-by-tsreaper-d220/
相似题目: 1631. 最小体力消耗路径
https://leetcode.cn/problems/path-with-minimum-effort/
 */
