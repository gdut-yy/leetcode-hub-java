public class Solution4072 {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][][] memo = new long[n][2][2];
        for (long[][] mat : memo) {
            mat[0][0] = mat[0][1] = mat[1][0] = mat[1][1] = Long.MIN_VALUE;
        }

        long ans = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, Math.max(dfs(i, 0, 0, nums, memo), dfs(i, 1, 0, nums, memo)));
        }
        return ans;
    }

    // 只需在 1186 的基础上增加参数 rev
    private long dfs(int i, int j, int rev, int[] nums, long[][][] memo) {
        if (i == nums.length) { // 子数组至少要有一个数，不合法
            return Long.MIN_VALUE / 2; // 除 2 防止负数相加溢出
        }
        if (memo[i][j][rev] != Long.MIN_VALUE) {
            return memo[i][j][rev]; // 之前计算过
        }

        int x = rev == 0 ? nums[i] : -nums[i];
        if (j == 0) {
            return memo[i][j][rev] = Math.max(dfs(i + 1, 0, rev ^ 1, nums, memo), 0) + x;
        }
        return memo[i][j][rev] = Math.max(dfs(i + 1, 1, rev ^ 1, nums, memo) + x, dfs(i + 1, 0, rev, nums, memo));
    }
}
/*
4072. 一次删除后的最大交替子数组和
https://leetcode.cn/problems/maximum-alternating-subarray-sum-with-one-deletion/description/

第 522 场周赛 T3。

给你一个整数数组 nums。
你最多可以从 nums 中删除 一个 元素，然后在剩下数组里选一个 子数组 。
返回所选子数组的最大可能 交替和 。
子数组 是数组中连续的 非空 元素序列。
数组的 交替和 是其偶数下标处元素之和减去奇数下标处元素之和。在计算其交替和之前，所选子数组会从 0 开始重新编下标。
示例 1：
输入： nums = [5,-5,1]
输出： 11
示例 2：
输入： nums = [10,-5,-100]
输出： 110
示例 3：
输入： nums = [4,7]
输出： 7
提示：
1 <= nums.length <= 10^5
-10^5 <= nums[i] <= 10^5

状态机DP。
时间复杂度 O(n)。
相似题目: 1186. 删除一次得到子数组最大和
https://leetcode.cn/problems/maximum-subarray-sum-with-one-deletion/description/
 */