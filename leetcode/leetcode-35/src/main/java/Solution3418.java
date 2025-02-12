import java.util.Arrays;

public class Solution3418 {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;

        int[][][] f = new int[m][n][3];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(f[i][j], (int) -1e9);
            }
        }
        f[0][0][0] = coins[0][0]; // 感化0次
        f[0][0][1] = Math.max(0, f[0][0][0]); // 感化1次
        f[0][0][2] = Math.max(0, f[0][0][1]); // 感化2次
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k0 = 0; k0 <= 2; k0++) {
                    if (j - 1 >= 0) {
                        f[i][j][k0] = Math.max(f[i][j][k0], f[i][j - 1][k0] + coins[i][j]);
                    }
                    if (i - 1 >= 0) {
                        f[i][j][k0] = Math.max(f[i][j][k0], f[i - 1][j][k0] + coins[i][j]);
                    }
                    // 感化
                    if (coins[i][j] >= 0) continue;
                    int k1 = k0 + 1;
                    if (k1 > 2) continue;
                    if (j - 1 >= 0) {
                        f[i][j][k1] = Math.max(f[i][j][k1], f[i][j - 1][k0]);
                    }
                    if (i - 1 >= 0) {
                        f[i][j][k1] = Math.max(f[i][j][k1], f[i - 1][j][k0]);
                    }
                }
            }
        }
        return Arrays.stream(f[m - 1][n - 1]).max().orElseThrow();
    }
}
/*
3418. 机器人可以获得的最大金币数
https://leetcode.cn/problems/maximum-amount-of-money-robot-can-earn/description/

第 432 场周赛 T2。

给你一个 m x n 的网格。一个机器人从网格的左上角 (0, 0) 出发，目标是到达网格的右下角 (m - 1, n - 1)。在任意时刻，机器人只能向右或向下移动。
网格中的每个单元格包含一个值 coins[i][j]：
- 如果 coins[i][j] >= 0，机器人可以获得该单元格的金币。
- 如果 coins[i][j] < 0，机器人会遇到一个强盗，强盗会抢走该单元格数值的 绝对值 的金币。
机器人有一项特殊能力，可以在行程中 最多感化 2个单元格的强盗，从而防止这些单元格的金币被抢走。
注意：机器人的总金币数可以是负数。
返回机器人在路径上可以获得的 最大金币数 。
提示：
m == coins.length
n == coins[i].length
1 <= m, n <= 500
-1000 <= coins[i][j] <= 1000

网格图 DP。
 */