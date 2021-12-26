import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution417 {
    private int M;
    private int N;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.M = heights.length;
        this.N = heights[0].length;

        // 逆流而上 BFS
        // 太平洋 = 首行 + 首列
        Queue<int[]> queue1 = new LinkedList<>();
        boolean[][] visited1 = new boolean[M][N];
        for (int j = 0; j < N; j++) {
            queue1.add(new int[]{0, j});
            visited1[0][j] = true;
        }
        for (int i = 1; i < M; i++) {
            queue1.add(new int[]{i, 0});
            visited1[i][0] = true;
        }
        bfs(heights, queue1, visited1);

        // 太西洋 = 末行 + 末列
        Queue<int[]> queue2 = new LinkedList<>();
        boolean[][] visited2 = new boolean[M][N];
        for (int j = 0; j < N; j++) {
            queue2.add(new int[]{M - 1, j});
            visited2[M - 1][j] = true;
        }
        for (int i = 0; i < M - 1; i++) {
            queue2.add(new int[]{i, N - 1});
            visited2[i][N - 1] = true;
        }
        bfs(heights, queue2, visited2);

        List<List<Integer>> resList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited1[i][j] && visited2[i][j]) {
                    resList.add(List.of(i, j));
                }
            }
        }
        return resList;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited) {
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                int height = heights[cur[0]][cur[1]];
                for (int[] dir : direction) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    if (nextM >= 0 && nextM < M && nextN >= 0 && nextN < N && !visited[nextM][nextN]
                            && heights[nextM][nextN] >= height) {
                        visited[nextM][nextN] = true;
                        queue.add(new int[]{nextM, nextN});
                    }
                }
            }
        }
    }
}
/*
417. 太平洋大西洋水流问题
https://leetcode-cn.com/problems/pacific-atlantic-water-flow/

给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。

逆流而上 BFS
 */