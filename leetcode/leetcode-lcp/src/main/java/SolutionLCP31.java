import java.util.List;

public class SolutionLCP31 {
    // https://leetcode.cn/problems/Db3wC1/solution/java-100-120msdfs-ji-yi-hua-sou-suo-by-m-0k4g/
    private static final int[][] DIRECTIONS5 = {{0, 1}, {1, 0}, {0, 0}, {0, -1}, {-1, 0}};
    private int L;
    private int M;
    private int N;
    private char[][][] mazes;
    private boolean[][][][] dp;

    public boolean escapeMaze(List<List<String>> maze) {
        L = maze.size();
        M = maze.get(0).size();
        N = maze.get(0).get(0).length();
        mazes = new char[L][M][N];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < M; j++) {
                mazes[i][j] = maze.get(i).get(j).toCharArray();
            }
        }

        dp = new boolean[L + 1][M][N][4];
        return dfs(1, 0, 0, 3);
    }

    // t 时刻
    private boolean dfs(int t, int r, int c, int s) {
        // 记忆化搜索
        if (dp[t][r][c][s]) {
            return false;
        }
        if (r == M - 1 && c == N - 1) {
            return true;
        }
        if (t == L) {
            return false;
        }

        char[][] maze = mazes[t];
        for (int[] dir : DIRECTIONS5) {
            int dr = r + dir[0];
            int dc = c + dir[1];
            if (dr < 0 || dc < 0 || dr == M || dc == N) {
                continue;
            }

            if (maze[dr][dc] == '.') {
                if (dfs(t + 1, dr, dc, s)) {
                    return true;
                }
            } else {
                if (s == 3) {
                    if (dfs(t + 1, dr, dc, 2)) {
                        return true;
                    }
                    for (int dt = t + 1; dt < L; dt++) {
                        if (dfs(dt, dr, dc, 1)) {
                            return true;
                        }
                    }
                } else if (s == 2) {
                    for (int dt = t + 1; dt < L; dt++) {
                        if (dfs(dt, dr, dc, 0)) {
                            return true;
                        }
                    }
                } else if (s == 1) {
                    if (dfs(t + 1, dr, dc, 0)) {
                        return true;
                    }
                }
            }
        }

        dp[t][r][c][s] = true;
        return false;
    }
}
/*
LCP 31. 变换的迷宫
https://leetcode.cn/problems/Db3wC1/

某解密游戏中，有一个 N*M 的迷宫，迷宫地形会随时间变化而改变，迷宫出口一直位于 (n-1,m-1) 位置。迷宫变化规律记录于 maze 中，maze[i] 表示 i 时刻迷宫的地形状态，"." 表示可通行空地，"#" 表示陷阱。
地形图初始状态记作 maze[0]，此时小力位于起点 (0,0)。此后每一时刻可选择往上、下、左、右其一方向走一步，或者停留在原地。
小力背包有以下两个魔法卷轴（卷轴使用一次后消失）：
- 临时消除术：将指定位置在下一个时刻变为空地；
- 永久消除术：将指定位置永久变为空地。
请判断在迷宫变化结束前（含最后时刻），小力能否在不经过任意陷阱的情况下到达迷宫出口呢？
注意： 输入数据保证起点和终点在所有时刻均为空地。
提示：
1 <= maze.length <= 100
1 <= maze[i].length, maze[i][j].length <= 50
maze[i][j] 仅包含 "."、"#"
 */