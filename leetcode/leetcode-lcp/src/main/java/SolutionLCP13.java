import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionLCP13 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int M;
    private int N;
    private char[][] chars;
    private int[] start;
    private int[] target;

    public int minimalSteps(String[] maze) {
        M = maze.length;
        N = maze[0].length();
        chars = new char[M][N];
        for (int i = 0; i < M; i++) {
            chars[i] = maze[i].toCharArray();
        }

        // 机关点 'M'
        List<int[]> mList = new ArrayList<>();
        // 石头 'O'
        List<int[]> oList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                char ch = chars[i][j];
                if (ch == 'S') {
                    start = new int[]{i, j};
                } else if (ch == 'T') {
                    target = new int[]{i, j};
                } else if (ch == 'M') {
                    mList.add(new int[]{i, j});
                } else if (ch == 'O') {
                    oList.add(new int[]{i, j});
                }
            }
        }

        // 起点到其他点距离，-1 表示无法抵达
        int[][] startDist = bfs(start);
        // 特判：没有机关 S->T
        if (mList.isEmpty()) {
            return startDist[target[0]][target[1]];
        }

        // 机关数量
        int mSize = mList.size();

        // dist[i][j] 第 i 个机关到第 j 个机关最小距离 (M-O-M')
        // dist[i][mSize] 第 i 个机关到起点距离 (S-O-M)
        // dist[i][mSize+1] 第 i 个机关到终点距离 (M-T)
        int[][] dist = new int[mSize][mSize + 2];
        for (int i = 0; i < mSize; i++) {
            Arrays.fill(dist[i], -1);
        }

        // dd[i] 第 i 个机关到其他点距离
        int[][][] dd = new int[mSize][][];
        for (int i = 0; i < mSize; i++) {
            // 第 i 个机关
            int[] mi = mList.get(i);
            int[][] miDist = bfs(mi);
            dd[i] = miDist;
            // (S-O-M)
            dist[i][mSize + 1] = miDist[target[0]][target[1]];
        }
        for (int i = 0; i < mSize; i++) {
            int som = -1;
            for (int[] oi : oList) {
                if (dd[i][oi[0]][oi[1]] != -1 && startDist[oi[0]][oi[1]] != -1) {
                    if (som == -1 || som > dd[i][oi[0]][oi[1]] + startDist[oi[0]][oi[1]]) {
                        som = dd[i][oi[0]][oi[1]] + startDist[oi[0]][oi[1]];
                    }
                }
            }
            // (M-T)
            dist[i][mSize] = som;
            for (int j = i + 1; j < mSize; j++) {
                int mom = -1;
                for (int[] oi : oList) {
                    if (dd[i][oi[0]][oi[1]] != -1 && dd[j][oi[0]][oi[1]] != -1) {
                        if (mom == -1 || mom > dd[i][oi[0]][oi[1]] + dd[j][oi[0]][oi[1]]) {
                            mom = dd[i][oi[0]][oi[1]] + dd[j][oi[0]][oi[1]];
                        }
                    }
                }
                dist[i][j] = mom;
                dist[j][i] = mom;
            }
        }

        // 特判：无解
        for (int i = 0; i < mSize; i++) {
            if (dist[i][mSize] == -1 || dist[i][mSize + 1] == -1) {
                return -1;
            }
        }

        return bitmaskDP(mSize, dist);
    }

    // 状态压缩动态规划
    private static int bitmaskDP(int mSize, int[][] dist) {
        int[][] dp = new int[1 << mSize][mSize];
        for (int i = 0; i < (1 << mSize); i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < mSize; i++) {
            dp[1 << i][i] = dist[i][mSize];
        }

        for (int state = 1; state < (1 << mSize); state++) {
            for (int i = 0; i < mSize; i++) {
                if (((state >> i) & 1) == 1) {
                    for (int j = 0; j < mSize; j++) {
                        // j 不在 state
                        if ((state & (1 << j)) == 0) {
                            int next = state | (1 << j);
                            if (dp[next][j] == -1 || dp[next][j] > dp[state][i] + dist[i][j]) {
                                dp[next][j] = dp[state][i] + dist[i][j];
                            }
                        }
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;
        int finalState = (1 << mSize) - 1;
        for (int i = 0; i < mSize; i++) {
            if (res > dp[finalState][i] + dist[i][mSize + 1]) {
                res = dp[finalState][i] + dist[i][mSize + 1];
            }
        }
        return res;
    }

    // 从某个点到其他可通行点的步数
    private int[][] bfs(int[] point) {
        int[][] dist = new int[M][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{point[0], point[1]});
        boolean[][] visited = new boolean[M][N];
        visited[point[0]][point[1]] = true;

        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                dist[cur[0]][cur[1]] = step;

                for (int[] dir : DIRECTIONS) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N && chars[nextM][nextN] != '#' && !visited[nextM][nextN]) {
                        visited[nextM][nextN] = true;
                        queue.add(new int[]{nextM, nextN});
                    }
                }
            }
            step++;
        }
        return dist;
    }
}
/*
LCP 13. 寻宝
https://leetcode.cn/problems/xun-bao/

我们得到了一副藏宝图，藏宝图显示，在一个迷宫中存在着未被世人发现的宝藏。
迷宫是一个二维矩阵，用一个字符串数组表示。它标识了唯一的入口（用 'S' 表示），和唯一的宝藏地点（用 'T' 表示）。
但是，宝藏被一些隐蔽的机关保护了起来。在地图上有若干个机关点（用 'M' 表示），只有所有机关均被触发，才可以拿到宝藏。
要保持机关的触发，需要把一个重石放在上面。迷宫中有若干个石堆（用 'O' 表示），每个石堆都有无限个足够触发机关的重石。但是由于石头太重，我们一次只能搬一个石头到指定地点。
迷宫中同样有一些墙壁（用 '#' 表示），我们不能走入墙壁。剩余的都是可随意通行的点（用 '.' 表示）。石堆、机关、起点和终点（无论是否能拿到宝藏）也是可以通行的。
我们每步可以选择向上/向下/向左/向右移动一格，并且不能移出迷宫。搬起石头和放下石头不算步数。那么，从起点开始，我们最少需要多少步才能最后拿到宝藏呢？如果无法拿到宝藏，返回 -1 。
限制：
1 <= maze.length <= 100
1 <= maze[i].length <= 100
maze[i].length == maze[j].length
S 和 T 有且只有一个
0 <= M的数量 <= 16
0 <= O的数量 <= 40，题目保证当迷宫中存在 M 时，一定存在至少一个 O 。

没有技巧，全靠暴力，边界条件还多
 */