import java.util.Arrays;

public class Solution3434 {
    public int maxFrequency(int[] nums, int k) {
        int ans = 0;
        for (int target : Arrays.stream(nums).distinct().toArray()) {
            // f[i+1][0] 表示左，或者说 nums[i] 在被修改的子数组的左侧，此时只能统计等于 k 的元素个数。
            // f[i+1][1] 表示左+中，或者说 nums[i] 在被修改的子数组中，此时只能统计等于 target 的元素个数，这些数被修改成 k。注意不能统计子数组中的 k 的个数，因为子数组中的 k 会被修改成别的数。
            // f[i+1][2] 表示左+中+右，或者说 nums[i] 在被修改的子数组的右侧，此时只能统计等于 k 的元素个数。
            int f0 = 0, f1 = 0, f2 = 0;
            for (int x : nums) {
                f2 = Math.max(f2, f1) + (x == k ? 1 : 0);
                f1 = Math.max(f1, f0) + (x == target ? 1 : 0);
                f0 += (x == k ? 1 : 0);
            }
            ans = Math.max(ans, Math.max(f1, f2));
        }
        return ans;
    }
}
/*
3434. 子数组操作后的最大频率
https://leetcode.cn/problems/maximum-frequency-after-subarray-operation/description/

第 434 场周赛 T3。

给你一个长度为 n 的数组 nums ，同时给你一个整数 k 。
你可以对 nums 执行以下操作 一次 ：
- 选择一个子数组 nums[i..j] ，其中 0 <= i <= j <= n - 1 。
- 选择一个整数 x 并将 nums[i..j] 中 所有 元素都增加 x 。
请你返回执行以上操作以后数组中 k 出现的 最大 频率。
子数组 是一个数组中一段连续 非空 的元素序列。
提示：
1 <= n == nums.length <= 10^5
1 <= nums[i] <= 50
1 <= k <= 50

状态机 DP。
时间复杂度 O(nU)。可以优化至 O(n)。
rating 2093 (clist.by)
 */