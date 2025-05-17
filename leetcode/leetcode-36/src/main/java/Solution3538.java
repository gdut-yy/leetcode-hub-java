public class Solution3538 {
    private int[] position;
    private int[] s;
    private int[][][] memo;

    public int minTravelTime(int l, int n, int k, int[] position, int[] time) {
        this.position = position;
        s = new int[n];
        for (int i = 0; i < n - 1; i++) { // time[n-1] 用不到
            s[i + 1] = s[i] + time[i]; // 计算 time 的前缀和
        }

        memo = new int[n - 1][n - 1][k + 1];
        return dfs(0, 0, k); // 第一个子数组是 [0, 0]
    }

    private int dfs(int i, int j, int leftK) {
        int n = position.length;
        if (j == n - 1) { // 到达终点
            return leftK > 0 ? Integer.MAX_VALUE / 2 : 0; // 除以 2，避免下面计算 r 的地方加法溢出
        }
        if (memo[i][j][leftK] > 0) { // 之前计算过
            return memo[i][j][leftK];
        }
        int res = Integer.MAX_VALUE;
        int t = s[j + 1] - s[i]; // 合并到 time[j] 的时间
        // 枚举下一个子数组 [j+1, k]
        for (int k = j + 1; k < Math.min(n, j + 2 + leftK); k++) {
            int r = dfs(j + 1, k, leftK - (k - j - 1)) + (position[k] - position[j]) * t;
            res = Math.min(res, r);
        }
        return memo[i][j][leftK] = res; // 记忆化
    }
}
/*
3538. 合并得到最小旅行时间
https://leetcode.cn/problems/merge-operations-for-minimum-travel-time/description/

第 448 场周赛 T3。

给你一个长度为 l 公里的直路，一个整数 n，一个整数 k 和 两个 长度为 n 的整数数组 position 和 time 。
数组 position 列出了路标的位置（单位：公里），并且是 严格 升序排列的（其中 position[0] = 0 且 position[n - 1] = l）。
每个 time[i] 表示从 position[i] 到 position[i + 1] 之间行驶 1 公里所需的时间（单位：分钟）。
你 必须 执行 恰好 k 次合并操作。在一次合并中，你可以选择两个相邻的路标，下标为 i 和 i + 1（其中 i > 0 且 i + 1 < n），并且：
- 更新索引为 i + 1 的路标，使其时间变为 time[i] + time[i + 1]。
- 删除索引为 i 的路标。
返回经过 恰好 k 次合并后从 0 到 l 的 最小总旅行时间（单位：分钟）。
提示:
1 <= l <= 10^5
2 <= n <= min(l + 1, 50)
0 <= k <= min(n - 2, 10)
position.length == n
position[0] = 0 和 position[n - 1] = l
position 是严格升序排列的。
time.length == n
1 <= time[i] <= 100
1 <= sum(time) <= 100

相邻相关划分型 DP
https://leetcode.cn/problems/merge-operations-for-minimum-travel-time/solutions/3668454/hua-fen-xing-dpcong-ji-yi-hua-sou-suo-da-cref/
时间复杂度 O(n * k^3)
rating 2453 (clist.by)
 */