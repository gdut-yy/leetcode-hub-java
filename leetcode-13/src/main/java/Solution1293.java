import java.util.LinkedList;
import java.util.Queue;

public class Solution1293 {
    public int shortestPath(int[][] grid, int k) {
        int gridM = grid.length;
        int gridN = grid[0].length;
        // FIX [[0]]
        if (gridM == 1 && gridN == 1) {
            return 0;
        }
        // BFS
        int[][] direction = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        int step = 0;
        // int[0..1..2]
        Queue<int[]> queue = new LinkedList<>();
        // 起点
        queue.offer(new int[]{0, 0, 0});
        // 二维标记位置 三维标记到此节点的路径处理障碍总个数
        int[][][] visited = new int[gridM][gridN][k + 1];
        visited[0][0][0] = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curMN = queue.poll();
                if (curMN == null) {
                    break;
                }
                // 同一个节点被访问的时候 已经使用消除障碍物的次数
                int curM = curMN[0];
                int curN = curMN[1];
                int curCnt = curMN[2];
                for (int[] dir : direction) {
                    int nextM = curM + dir[0];
                    int nextN = curN + dir[1];
                    if (nextM < 0 || nextN < 0 || nextM >= gridM || nextN >= gridN) {
                        continue;
                    }
                    if (nextM == gridM - 1 && nextN == gridN - 1) {
                        return step + 1;
                    }
                    // 穿越障碍次数已满
                    if (grid[nextM][nextN] == 1 && curCnt >= k) {
                        continue;
                    }
                    int nextCnt = grid[nextM][nextN] == 1 ? curCnt + 1 : curCnt;
                    if (visited[nextM][nextN][nextCnt] == 0) {
                        queue.offer(new int[]{nextM, nextN, nextCnt});
                        visited[nextM][nextN][nextCnt] = 1;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
/*
1293. 网格中的最短路径
https://leetcode-cn.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/

第 167 场周赛 T4。

给你一个 m * n 的网格，其中每个单元格不是 0（空）就是 1（障碍物）。每一步，您都可以在空白单元格中上、下、左、右移动。
如果您 最多 可以消除 k 个障碍物，请找出从左上角 (0, 0) 到右下角 (m-1, n-1) 的最短路径，并返回通过该路径所需的步数。如果找不到这样的路径，则返回 -1。

BFS
 */