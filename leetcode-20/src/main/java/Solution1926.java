import java.util.LinkedList;
import java.util.Queue;

public class Solution1926 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int mazeM = maze.length;
        int mazeN = maze[0].length;
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        maze[entrance[0]][entrance[1]] = '+';
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{entrance[0], entrance[1], 0});

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (cur == null) {
                    break;
                }
                for (int[] dir : direction) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    int step = cur[2] + 1;
                    // 新坐标合法且不为墙
                    if (nextM >= 0 && nextM < mazeM && nextN >= 0 && nextN < mazeN && maze[nextM][nextN] == '.') {
                        // 新坐标为出口，返回距离作为答案
                        if (nextM == 0 || nextN == 0 || nextM == mazeM - 1 || nextN == mazeN - 1) {
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
https://leetcode-cn.com/problems/nearest-exit-from-entrance-in-maze/submissions/

第 56 场双周赛 T2。
BFS
 */