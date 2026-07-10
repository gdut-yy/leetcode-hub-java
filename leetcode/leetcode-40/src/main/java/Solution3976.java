public class Solution3976 {
    public long maxSubarraySum(int[] nums, int k) {
        return Math.max(solve(nums, k, true), solve(nums, k, false));
    }

    private long solve(int[] nums, int k, boolean multiply) {
        long dp0 = 0, dp1 = 0, dp2 = 0;
        long ans = Long.MIN_VALUE;

        for (long x : nums) {
            long mod = multiply ? x * k : x / k;

            long ndp0 = Math.max(x, dp0 + x);
            long ndp1 = Math.max(mod, Math.max(dp0, dp1) + mod);
            long ndp2 = Math.max(x, Math.max(dp1, dp2) + x);

            dp0 = ndp0;
            dp1 = ndp1;
            dp2 = ndp2;

            ans = Math.max(ans, Math.max(dp0, Math.max(dp1, dp2)));
        }
        return ans;
    }
}
/*
3976. 乘以系数后最大子数组和
https://leetcode.cn/problems/maximum-subarray-sum-after-multiplier/description/

第 508 场周赛 T3。

给你一个整数数组 nums 和一个正整数 k。
你必须选择 nums 的一个 子数组 并执行以下操作之一：
1.将所选子数组中的每个数字乘以 k。
2.将所选子数组中的每个数字除以 k。
  - 当正数除以 k 时，除法结果 向下取整。
  - 当负数除以 k 时，除法结果 向上取整。
返回结果数组中 非空 子数组的 最大 可能和。
注意，用于执行操作的 子数组 与用于求和的 子数组 可以是 不同 的。
子数组 是数组中一段连续的 非空 元素序列。
提示：
1 <= nums.length <= 10^5
-10^5 <= nums[i] <= 10^5
1 <= k <= 10^5

状态机 DP。
时间复杂度 O(n)。
 */