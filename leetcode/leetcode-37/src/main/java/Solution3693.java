import java.util.Arrays;

public class Solution3693 {
    private int n;
    private int[] cost;
    private int[] memo;

    public int climbStairs(int n, int[] costs) {
        this.n = n;
        this.cost = costs;
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dfs(0);
    }

    private int dfs(int i) {
        if (i == n) return 0;
        if (memo[i] != -1) return memo[i];
        int res = Integer.MAX_VALUE;
        for (int j = 1; j <= 3; j++) {
            if (i + j <= n) res = Math.min(res, dfs(i + j) + cost[i + j - 1] + j * j);
        }
        return memo[i] = res;
    }
}
/*
3693. 爬楼梯 II
https://leetcode.cn/problems/climbing-stairs-ii/description/

第 166 场双周赛 T2。

你正在爬一个有 n + 1 级台阶的楼梯，台阶编号从 0 到 n。
你还得到了一个长度为 n 的 下标从 1 开始 的整数数组 costs，其中 costs[i] 是第 i 级台阶的成本。
从第 i 级台阶，你 只能 跳到第 i + 1、i + 2 或 i + 3 级台阶。从第 i 级台阶跳到第 j 级台阶的成本定义为： costs[j] + (j - i)2
你从第 0 级台阶开始，初始 cost = 0。
返回到达第 n 级台阶所需的 最小 总成本。
提示:
1 <= n == costs.length <= 10^5
1 <= costs[i] <= 10^4

记忆化搜索。
时间复杂度 O(n)。
 */