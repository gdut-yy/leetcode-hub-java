import java.util.ArrayDeque;
import java.util.Queue;

public class SolutionO13 {
    private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int movingCount(int m, int n, int k) {
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
                            && digitSum(nx) + digitSum(ny) <= k) {
                        vis[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    private static int digitSum(int x) {
        int res = 0;
        while (x > 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
/*
剑指 Offer 13. 机器人的运动范围
https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/description/

地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
请问该机器人能够到达多少个格子？

广度优先搜索 或 深度优先搜索
时间复杂度 O(mn)
空间复杂度 O(mn)
 */