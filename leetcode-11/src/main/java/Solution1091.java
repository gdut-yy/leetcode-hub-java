import java.util.LinkedList;
import java.util.Queue;

public class Solution1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) {
            return -1;
        }
        int M = grid.length;
        int N = grid[0].length;
        // 8 个方向
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[M][N];
        // m n step
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            if (cur[0] == M - 1 && cur[1] == N - 1) {
                return cur[2];
            }
            for (int[] dir : direction) {
                int nextM = cur[0] + dir[0];
                int nextN = cur[1] + dir[1];
                int nextStep = cur[2] + 1;
                if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N && grid[nextM][nextN] == 0 && !visited[nextM][nextN]) {
                    visited[nextM][nextN] = true;
                    queue.add(new int[]{nextM, nextN, nextStep});
                }
            }
        }
        return -1;
    }
}
/*
1091. 二进制矩阵中的最短路径
https://leetcode-cn.com/problems/shortest-path-in-binary-matrix/

给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。

广度优先搜索。
 */