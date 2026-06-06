public class Solution3891 {
    public long minIncrease(int[] nums) {
        int n = nums.length;
        long[] suf = new long[n + 1];
        for (int i = n - 2; i > 0; i -= 2) {
            suf[i] = suf[i + 2] + Math.max(Math.max(nums[i - 1], nums[i + 1]) - nums[i] + 1, 0);
        }
        if (n % 2 > 0) {
            // 要修改的下标是唯一的，即所有奇数下标
            return suf[1];
        }

        long ans = suf[2]; // 修改 [2,n-2] 中的所有偶数下标
        long pre = 0;
        // 枚举修改 [1,i] 中的奇数下标，以及 [i+3,n-2] 中的偶数下标
        for (int i = 1; i < n - 1; i += 2) {
            pre += Math.max(Math.max(nums[i - 1], nums[i + 1]) - nums[i] + 1, 0);
            ans = Math.min(ans, pre + suf[i + 3]); // 中间可以间隔两个
        }
        return ans;
    }
}
/*
3891. 最大化特殊下标数目的最少增加次数
https://leetcode.cn/problems/minimum-increase-to-maximize-special-indices/description/

第 496 场周赛 T3。

给你一个长度为 n 的整数数组 nums。
如果 nums[i] > nums[i - 1] 且 nums[i] > nums[i + 1]，则下标 i (0 < i < n - 1) 是 特殊的 。
你可以执行操作，选择 任意 下标 i 并将 nums[i] 增加 1。
你的目标是：
- 最大化 特殊 下标的数量。
- 最小化 达到该 最大值 所需的总 操作 数。
返回所需的 最小 总操作数。
提示：
3 <= n <= 10^5
1 <= nums[i] <= 10^9

前后缀分解 + 分类讨论。
如果 n 是奇数，那么要修改所有奇数下标。
如果 n 是偶数，那么枚举修改 [1,i] 中的奇数下标，以及 [i+3,n−2] 中的偶数下标。
时间复杂度 O(n)。
 */