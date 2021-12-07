import java.util.LinkedList;
import java.util.Queue;

public class Solution1034 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int M = grid.length;
        int N = grid[0].length;

        int originColor = grid[row][col];
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        // BFS
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[M][N];
        queue.add(new int[]{row, col});
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                // 连通分量的边界
                if (grid[cur[0]][cur[1]] == originColor
                        && (cur[0] == 0 || cur[1] == 0 || cur[0] == M - 1 || cur[1] == N - 1)) {
                    grid[cur[0]][cur[1]] = color;
                }

                for (int[] dir : direction) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N && !visited[nextM][nextN]) {
                        // 连通分量的边界
                        if (grid[nextM][nextN] != originColor) {
                            grid[cur[0]][cur[1]] = color;
                        }
                        if (grid[nextM][nextN] == originColor) {
                            visited[nextM][nextN] = true;
                            queue.add(new int[]{nextM, nextN});
                        }
                    }
                }
            }
        }
        return grid;
    }

}
/*
1034. 边界着色
https://leetcode-cn.com/problems/coloring-a-border/

给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数  row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。
两个网格块属于同一 连通分量 需满足下述全部条件：
两个网格块颜色相同
在上、下、左、右任意一个方向上相邻
连通分量的边界 是指连通分量中满足下述条件之一的所有网格块：
在上、下、左、右四个方向上与不属于同一连通分量的网格块相邻
在网格的边界上（第一行/列或最后一行/列）
请你使用指定颜色  color 为所有包含网格块  grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格  grid 。

按要求BFS。
 */