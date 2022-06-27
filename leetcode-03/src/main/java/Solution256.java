public class Solution256 {
    /**
     * 剑指 Offer II 091. 粉刷房子
     * https://leetcode.cn/problems/JEj789/
     */
    public int minCost(int[][] costs) {
        int len = costs.length;
        if (len == 0) {
            return 0;
        }
        // 状态压缩 只需要用到相邻的两行，即 3 * 2
        int[][] dp = new int[3][2];
        for (int i = 0; i < 3; i++) {
            dp[i][0] = costs[0][i];
        }
        // 状态转移
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < 3; j++) {
                // 刷下 2 间
                int prev1 = dp[(j + 2) % 3][(i - 1) % 2];
                // 刷下 1 间
                int prev2 = dp[(j + 1) % 3][(i - 1) % 2];
                // 取最小的
                dp[j][i % 2] = Math.min(prev1, prev2) + costs[i][j];
            }
        }
        int last = (len - 1) % 2;
        // 取三者最小
        return Math.min(dp[0][last], Math.min(dp[1][last], dp[2][last]));
    }
}
/*
$256. 粉刷房子
https://leetcode.cn/problems/paint-house/

假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
请计算出粉刷完所有房子最少的花费成本。

动态规划。
时间复杂度 O(n)
空间复杂度 O(1)
相似题目: $265. 粉刷房子 II
https://leetcode.cn/problems/paint-house-ii/
 */