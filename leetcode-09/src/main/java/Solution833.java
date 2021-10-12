import java.util.Arrays;

public class Solution833 {
    public int projectionArea(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int[] maxM = new int[M];
        int[] maxN = new int[N];
        for (int i = 0; i < M; i++) {
            maxM[i] = grid[i][0];
            for (int j = 0; j < N; j++) {
                maxM[i] = Math.max(maxM[i], grid[i][j]);
            }
        }
        for (int j = 0; j < N; j++) {
            maxN[j] = grid[0][j];
            for (int i = 0; i < M; i++) {
                maxN[j] = Math.max(maxN[j], grid[i][j]);
            }
        }
        int cnt = Arrays.stream(maxM).sum() + Arrays.stream(maxN).sum();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                cnt += (grid[i][j] > 0) ? 1 : 0;
            }
        }
        return cnt;
    }
}
/*
883. 三维形体投影面积
https://leetcode-cn.com/problems/projection-area-of-3d-shapes/

N * N
 */