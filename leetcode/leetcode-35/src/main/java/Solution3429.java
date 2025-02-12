import java.util.Arrays;

public class Solution3429 {
    private int[][] cost;
    private long[][][] memo;

    public long minCost(int n, int[][] cost) {
        this.cost = cost;
        memo = new long[n / 2][4][4];
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < 4; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(n / 2 - 1, 3, 3);
    }

    private long dfs(int i, int preJ, int preK) {
        if (i < 0) return 0;
        if (memo[i][preJ][preK] != -1) return memo[i][preJ][preK];
        long res = Long.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            if (j == preJ) continue;
            for (int k = 0; k < 3; k++) {
                if (k != preK && k != j) {
                    long res2 = dfs(i - 1, j, k) + cost[i][j] + cost[cost.length - 1 - i][k];
                    res = Math.min(res, res2);
                }
            }
        }
        return memo[i][preJ][preK] = res;
    }
}
/*
3429. 粉刷房子 IV
https://leetcode.cn/problems/paint-house-iv/description/

第 433 场周赛 T3。

给你一个 偶数 整数 n，表示沿直线排列的房屋数量，以及一个大小为 n x 3 的二维数组 cost，其中 cost[i][j] 表示将第 i 个房屋涂成颜色 j + 1 的成本。
如果房屋满足以下条件，则认为它们看起来 漂亮：
- 不存在 两个 涂成相同颜色的相邻房屋。
- 距离行两端 等距 的房屋不能涂成相同的颜色。例如，如果 n = 6，则位置 (0, 5)、(1, 4) 和 (2, 3) 的房屋被认为是等距的。
返回使房屋看起来 漂亮 的 最低 涂色成本。
提示：
2 <= n <= 10^5
n 是偶数。
cost.length == n
cost[i].length == 3
0 <= cost[i][j] <= 10^5

多维 DP。
时间复杂度 O(n * k^4)。
rating 2170 (clist.by)
 */