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
meituan-015. 十字路口
https://leetcode.cn/problems/KLwc3e/

在小美和小团生活的城市中，有 n 行 m 列共计 n * m 个十字路口，第 i 行 j 列的十字路口有两个属性 a[i][j]，b[i][j] 。当行人处在 i 行 j 列的路口，对于任意非负整数 k :
当时间处在 [k * a[i][j] + k * b[i][j], (k+1) * a[i][j] + k * b[i][j])时，行人可以选择走到 i±1 行 j 列的路口。
当时间处在 [(k+1) * a[i][j] + k * b[i][j], (k+1) * a[i][j] + (k+1) * b[i][j])时，行人可以选择走到 i 行 j±1 列的路口。
每次移动花费的时间为 1 ，且要保证将要去的十字路口存在，即属于 n * m 个路口当中。可以选择原地静止不动。
在第 0 时刻，小美处在 xs 行 ys 列的十字路口处，要去 xt 行 yt 列的十字路口找小团。小团原地不动等小美，请问小美所花费的时间最少是多少?
格式：
输入：
- 第一行六个正整数 n,m,xs,ys,xt,yt ，含义如上文所示。以样例第一行【5、5、2、4、4、3】 共计 6 个数字为例：
  - 前两位数字代表有 5*5 的二维数组
  - 三、四位数字代表小美处在 2 行 4 列的十字路口处
  - 五、六位数字代表要去 4 行 3 列的十字路口找小团。
- 接下来 n 行每行 m 个正整数，在样例中为第一个 5*5 的二维数组，第 i 行第 j 个数代表 i 行 j 列十字路口的属性 a[i][j] 。
- 接下来 n 行每行 m 个正整数，在样例中为第二个 5*5 的二维数组，第 i 行第 j 个数代表 i 行 j 列十字路口的属性 b[i][j]。
输出：
- 输出 1 行 1 个整数代表答案。
示例：
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
提示：
对于100%的数据，1 ≤ n, m, xs, ys, xt, yt, a[i][j], b[i][j] ≤ 100
 */