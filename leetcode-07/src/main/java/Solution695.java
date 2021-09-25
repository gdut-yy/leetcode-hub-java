import java.util.LinkedList;
import java.util.Queue;

public class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int gridM = grid.length;
        int gridN = grid[0].length;
        boolean[][] visited = new boolean[gridM][gridN];
        int maxArea = 0;
        for (int i = 0; i < gridM; i++) {
            for (int j = 0; j < gridN; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int area = getArea(grid, visited, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int getArea(int[][] grid, boolean[][] visited, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true;
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int area = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            area++;

            for (int[] dir : direction) {
                int nextM = cur[0] + dir[0];
                int nextN = cur[1] + dir[1];
                if (nextM >= 0 && nextM < grid.length && nextN >= 0 && nextN < grid[0].length
                        && grid[nextM][nextN] == 1 && !visited[nextM][nextN]) {
                    queue.add(new int[]{nextM, nextN});
                    visited[nextM][nextN] = true;
                }
            }
        }
        return area;
    }
}
/*
695. 岛屿的最大面积
https://leetcode-cn.com/problems/max-area-of-island/

广度优先搜索。
 */