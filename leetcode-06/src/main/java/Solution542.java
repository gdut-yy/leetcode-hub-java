import java.util.LinkedList;
import java.util.Queue;

public class Solution542 {
    public int[][] updateMatrix(int[][] mat) {
        int matM = mat.length;
        int matN = mat[0].length;
        int[][] dists = new int[matM][matN];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matM; i++) {
            for (int j = 0; j < matN; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    dists[i][j] = 0;
                } else {
                    dists[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.remove();
            int dist = dists[cur[0]][cur[1]];
            for (int[] dir : direction) {
                int nextM = cur[0] + dir[0];
                int nextN = cur[1] + dir[1];
                if (nextM >= 0 && nextM < matM && nextN >= 0 && nextN < matN) {
                    if (dists[nextM][nextN] > dist + 1) {
                        dists[nextM][nextN] = dist + 1;
                        queue.add(new int[]{nextM, nextN});
                    }
                }
            }
        }
        return dists;
    }
}
/*
542. 01 矩阵
https://leetcode-cn.com/problems/01-matrix/

给定一个由 0 和 1 组成的矩阵 mat，请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
两个相邻元素间的距离为 1 。

广度优先搜索。
 */