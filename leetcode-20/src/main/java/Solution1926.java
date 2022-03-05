import java.util.LinkedList;
import java.util.Queue;

public class Solution1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int M = maze.length;
        int N = maze[0].length;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        // BFS
        maze[entrance[0]][entrance[1]] = '+';
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{entrance[0], entrance[1], 0});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();

                for (int[] dir : directions) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    int step = cur[2] + 1;
                    // 新坐标合法且不为墙
                    if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N && maze[nextM][nextN] == '.') {
                        // 新坐标为出口，返回距离作为答案
                        if (nextM == 0 || nextN == 0 || nextM == M - 1 || nextN == N - 1) {
                            return step;
                        }
                        // 新坐标为空格子且不为出口，修改为墙并加入队列
                        maze[nextM][nextN] = '+';
                        queue.add(new int[]{nextM, nextN, step});
                    }
                }
            }
        }
        // 不存在到出口的路径，返回 -1
        return -1;
    }
}
/*
1926. 迷宫中离入口最近的出口
https://leetcode-cn.com/problems/nearest-exit-from-entrance-in-maze/

第 56 场双周赛 T2。

给你一个 m x n 的迷宫矩阵 maze （下标从 0 开始），矩阵中有空格子（用 '.' 表示）和墙（用 '+' 表示）。
同时给你迷宫的入口 entrance ，用 entrance = [entrancerow, entrancecol] 表示你一开始所在格子的行和列。
每一步操作，你可以往 上，下，左 或者 右 移动一个格子。你不能进入墙所在的格子，你也不能离开迷宫。你的目标是找到离 entrance 最近 的出口。
出口 的含义是 maze 边界 上的 空格子。entrance 格子 不算 出口。
请你返回从 entrance 到最近出口的最短路径的 步数 ，如果不存在这样的路径，请你返回 -1 。
提示：
maze.length == m
maze[i].length == n
1 <= m, n <= 100
maze[i][j] 要么是 '.' ，要么是 '+' 。
entrance.length == 2
0 <= entrancerow < m
0 <= entrancecol < n
entrance 一定是空格子。

BFS。
 */