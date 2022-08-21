package shopee;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Shopee001 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int[][] A = new int[N][M];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    A[j][k] = scanner.nextInt();
                }
            }
            System.out.println(solve(N, M, A));
        }
    }

    private static String solve(int N, int M, int[][] A) {
        long[][] dp = new long[N][2];
        long cnt = 0;
        for (int i = 0; i < M; i++) {
            cnt += A[0][i];
            dp[0][0] = Math.max(cnt, dp[0][0]);
        }
        // 由于刚开始在左边，所以要到右边必须穿过花园
        dp[0][1] = cnt;
        for (int i = 1; i < N; i++) {
            long l = 0, r = 0;
            for (int j = 0, k = M - 1; j < M; j++, k--) {
                l += A[i][j];
                r += A[i][k];
                // 不直接走到对面，走一点再返回来
                dp[i][0] = Math.max(dp[i][0], l);
                dp[i][1] = Math.max(dp[i][1], r);
            }
            // 上一行右边走到左边
            dp[i][0] = Math.max(dp[i][0] + dp[i - 1][0], dp[i - 1][1] + r);
            // 上一行左边走到右边
            dp[i][1] = Math.max(dp[i][1] + dp[i - 1][1], dp[i - 1][0] + l);
        }
        return String.valueOf(Math.max(dp[N - 1][0], dp[N - 1][1]));
    }
}
/*
Shopee-001. Shopee Tanam
https://leetcode.cn/problems/m8KnhV/

In Shopee, there is a game called Shopee Tanam. It’s a game developed by Shopee game developers in Indonesia. Shopee Tanam means that you can plant some plants on the game platform. One of the game developers has an idea to create a new sub game in Shopee Tanam. In the sub game, you are given a park and the park has 1 dimensional shape and it consists of M different cells. In each cell you must plant exactly 1 tree. Each day, the tree can yield a beneficial fruit / poisonous fruit / neither beneficial nor poisonous fruit. The beneficial fruit means that you will get a positive number of health.The poisonous fruit gives you a negative number of health. Otherwise, you will get 0 health.

Then you are given a character that will start at the left side of the one dimensional park. You are given N days to play the game. Each day, the number of health in each fruit produced by a tree might change. In one day the character can do one of these actions:

Not crossing the park at all (stay at the current spot).
Walk through the park going through up to M cells, gathering all the beneficial and poisonous fruits along the way, then the character turns around and goes back to the initial position before he walks through the park.
Crossing the park completely, and going to the opposite side of the park, then the character rests there.
Note: On one day, the fruit in a cell can be gotten at most once.

Help the character to get the maximum amount of health.

Input Format
There will be T (1 <= T <= 10) number of test cases. On each test case, there will be a line with 2 integers, N and M (1 <= N <= 1000, 1 <= M <= 1000). Then N lines follow up, with each line containing M integers, A[i,j] (-10^9 <= A[i,j] <= 10^9), which means the health of the fruit on day i at cell j.

Output Format
The output must consist of T number of integers, indicating the maximum amount of health that the character can get.

Sample Input
3
1 5
-9 -8 1 2 3
2 3
1 4 -5
-1 -9 100
2 3
1 4 -5
-1 -1 100

Sample Output
0
100
103

Explanation
For the first example, the character can decide to not cross the park at all, hence the total health that the character gets is 0
For the second example,
On the first day, the character goes from the left, then completely crossing the park, then he rests at the right side of the park, and the total number of health is: 1 + 4 + (-5) = 0
On the second day, the character goes from the right side of the bridge, only to the first cell from the right, then go back to the right side of the bridge, and the total number of health the character gets from the second day is 100
Hence, the total health that the character gets from 2 days is 0 + 100 = 100.
For the third example,
On the first day, the character goes from the left, but only getting the health from the first 2 cells, then the character goes back to the left side of the park, and the total number of health is: 1 + 4 = 5
On the second day, the character goes from the left side of the park, and goes completely crossing the park, gaining total health of: (-1) + (-1) + 100 = 98 for the second day
Hence, the total health that the character gets from 2 days is 5 + 98 = 103.
 */