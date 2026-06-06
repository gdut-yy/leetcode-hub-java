public class Solution3914 {
    public long minOperations(int[] nums) {
        long ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                ans += nums[i - 1] - nums[i];
            }
        }
        return ans;
    }
}
/*
3914. 使数组非递减需要的最小累计值
https://leetcode.cn/problems/minimum-operations-to-make-array-non-decreasing/description/

第 499 场周赛 T3。

给你一个长度为 n 的整数数组 nums。
一次操作中，你可以选择任意一个 子数组 nums[l..r]，并将该 子数组 中的每个元素都增加 x，其中 x 可以是任意正整数。
返回使数组变为 非递减 所需的所有操作中，所选 x 的值之和可能达到的 最小值。
如果对于所有 0 <= i < n - 1，都有 nums[i] <= nums[i + 1]，则称数组是 非递减 的。
子数组 是数组中一个连续、 非空 的元素序列。
提示：
1 <= n == nums.length <= 10^5
1 <= nums[i] <= 10^9

差分思想。
https://chat.deepseek.com/a/chat/s/846c9f29-3582-4d7c-b488-87e08ef1177c
时间复杂度 O(n)。
 */