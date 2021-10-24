import java.util.LinkedList;
import java.util.Queue;

public class SolutionO13 {
    public int movingCount(int m, int n, int k) {
        int[][] direction = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int cnt = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.remove();
                for (int[] dir : direction) {
                    int nextM = cur[0] + dir[0];
                    int nextN = cur[1] + dir[1];
                    if (nextM >= 0 && nextM < m && nextN >= 0 && nextN < n && !visited[nextM][nextN]
                            && numSum(nextM) + numSum(nextN) <= k) {
                        visited[nextM][nextN] = true;
                        queue.add(new int[]{nextM, nextN});
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    private static int numSum(int num) {
        int cnt = 0;
        while (num > 0) {
            cnt += num % 10;
            num /= 10;
        }
        return cnt;
    }
}
/*
剑指 Offer 13. 机器人的运动范围
https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/

地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
请问该机器人能够到达多少个格子？

广度优先搜索 或 深度优先搜索
时间复杂度 O(mn)
空间复杂度 O(mn)
 */