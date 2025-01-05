public class Solution1664 {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        // 滚动数组 实现
        int odd1 = 0, even1 = 0;
        int odd2 = 0, even2 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) odd2 += nums[i];
            else even2 += nums[i];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 != 0) odd2 -= nums[i];
            else even2 -= nums[i];
            if (odd1 + even2 == odd2 + even1) ans++;
            if (i % 2 != 0) odd1 += nums[i];
            else even1 += nums[i];
        }
        return ans;
    }
}
/*
1664. 生成平衡数组的方案数
https://leetcode.cn/problems/ways-to-make-a-fair-array/description/

给你一个整数数组 nums 。你需要选择 恰好 一个下标（下标从 0 开始）并删除对应的元素。请注意剩下元素的下标可能会因为删除操作而发生改变。
比方说，如果 nums = [6,1,7,4,1] ，那么：
- 选择删除下标 1 ，剩下的数组为 nums = [6,7,4,1] 。
- 选择删除下标 2 ，剩下的数组为 nums = [6,1,4,1] 。
- 选择删除下标 4 ，剩下的数组为 nums = [6,1,7,4] 。
如果一个数组满足奇数下标元素的和与偶数下标元素的和相等，该数组就是一个 平衡数组 。
请你返回删除操作后，剩下的数组 nums 是 平衡数组 的 方案数 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^4

动态规划。
时间复杂度 O(n)。
空间复杂度 O(1)。
 */