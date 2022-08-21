package meituan;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Meituan015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        // 开始点坐标
        int startX = sc.nextInt() - 1;
        int startY = sc.nextInt() - 1;
        // 目标点坐标
        int endX = sc.nextInt() - 1;
        int endY = sc.nextInt() - 1;

        // 左右绿灯
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        // 上下绿灯
        int[][] b = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        System.out.println(getMin(a, b, startX, startY, endX, endY));
    }


    public static int getMin(int[][] a, int[][] b, int startX, int startY, int endX, int endY) {
        int m = a.length;
        int n = a[0].length;
        // dp[i][j]：到达点(i,j)所用时长
        int[][] dp = new int[m][n];
        // maxT 没有到达过
        int maxT = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], maxT);
        }
        // 起始点坐标
        dp[startX][startY] = 0;
        Queue<int[]> pq = new LinkedList<>();
        // 入队
        pq.offer(new int[]{startX, startY, 0});
        while (!pq.isEmpty()) {
            int size = pq.size();
            for (int i = 0; i < size; i++) {
                int[] pos = pq.poll();
                if (pos == null) {
                    break;
                }
                int x = pos[0];
                int y = pos[1];
                int t = pos[2];
                // 已经到目标点了，不走了
                if (x == endX && y == endY) continue;
                int val = t % (a[x][y] + b[x][y]);
                // 判断当前时刻是左右绿灯通行还是上下绿灯通行
                // 下面是左右绿灯通行
                if (val < a[x][y]) {
                    // 不越界且此次到达时间小于上次到达时间
                    if (x - 1 >= 0 && dp[x - 1][y] > t + 1) {
                        dp[x - 1][y] = t + 1;
                        pq.offer(new int[]{x - 1, y, dp[x - 1][y]});
                    }
                    if (x + 1 < m && dp[x + 1][y] > t + 1) {
                        dp[x + 1][y] = t + 1;
                        pq.offer(new int[]{x + 1, y, dp[x + 1][y]});
                    }
                    // 等红灯的时间也要算上去
                    if (y - 1 >= 0 && dp[x][y - 1] > t + a[x][y] - val + 1) {
                        dp[x][y - 1] = t + a[x][y] - val + 1;
                        pq.offer(new int[]{x, y - 1, dp[x][y - 1]});
                    }
                    if (y + 1 < n && dp[x][y + 1] > t + a[x][y] - val + 1) {
                        dp[x][y + 1] = t + a[x][y] - val + 1;
                        pq.offer(new int[]{x, y + 1, dp[x][y + 1]});
                    }
                } else { // 类似上面，此时为上下绿灯通行
                    if (x - 1 >= 0 && dp[x - 1][y] > t + (a[x][y] + b[x][y]) - val + 1) {
                        dp[x - 1][y] = t + (a[x][y] + b[x][y]) - val + 1;
                        pq.offer(new int[]{x - 1, y, dp[x - 1][y]});
                    }
                    if (x + 1 < m && dp[x + 1][y] > t + (a[x][y] + b[x][y]) - val + 1) {
                        dp[x + 1][y] = t + (a[x][y] + b[x][y]) - val + 1;
                        pq.offer(new int[]{x + 1, y, dp[x + 1][y]});
                    }
                    if (y - 1 >= 0 && dp[x][y - 1] > t + 1) {
                        dp[x][y - 1] = t + 1;
                        pq.offer(new int[]{x, y - 1, dp[x][y - 1]});
                    }
                    if (y + 1 < n && (dp[x][y + 1] == -1 || dp[x][y + 1] > t + 1)) {
                        dp[x][y + 1] = t + 1;
                        pq.offer(new int[]{x, y + 1, dp[x][y + 1]});
                    }
                }
            }
        }
        return dp[endX][endY];
    }
}
/*
输入：
5 5 2 4 4 3
2 1 1 3 1
1 4 2 3 1
4 4 4 2 1
3 1 1 2 4
5 1 5 5 1
5 3 4 1 3
1 1 2 2 2
2 1 4 4 5
1 1 5 3 3
3 2 1 3 3
输出：3

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/KLwc3e
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */