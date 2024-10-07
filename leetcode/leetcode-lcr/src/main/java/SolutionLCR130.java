import java.util.ArrayDeque;
import java.util.Queue;

public class SolutionLCR130 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int wardrobeFinishing(int m, int n, int cnt) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        boolean[][] vis = new boolean[m][n];
        vis[0][0] = true;
        int ans = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.remove();
                for (int[] d : DIRECTIONS) {
                    int nx = cur[0] + d[0];
                    int ny = cur[1] + d[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !vis[nx][ny]
                            && digitSum(nx) + digitSum(ny) <= cnt) {
                        vis[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private int digitSum(int x) {
        int res = 0;
        while (x > 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
/*
LCR 130. 衣橱整理
https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/description/

家居整理师将待整理衣橱划分为 m x n 的二维矩阵 grid，其中 grid[i][j] 代表一个需要整理的格子。整理师自 grid[0][0] 开始 逐行逐列 地整理每个格子。
整理规则为：在整理过程中，可以选择 向右移动一格 或 向下移动一格，但不能移动到衣柜之外。同时，不需要整理 digit(i) + digit(j) > cnt 的格子，其中 digit(x) 表示数字 x 的各数位之和。
请返回整理师 总共需要整理多少个格子。
提示：
1 <= n, m <= 100
0 <= cnt <= 20

BFS
时间复杂度 O(mn)
 */