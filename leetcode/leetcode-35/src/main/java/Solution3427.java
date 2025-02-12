public class Solution3427 {
    public int subarraySum(int[] nums) {
        int n = nums.length;
        int[] ps = new int[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int L = Math.max(0, i - nums[i]);
            ans += ps[i + 1] - ps[L];
        }
        return ans;
    }
}
/*
3427. 变长子数组求和
https://leetcode.cn/problems/sum-of-variable-length-subarrays/description/

第 433 场周赛 T1。

给你一个长度为 n 的整数数组 nums 。对于 每个 下标 i（0 <= i < n），定义对应的子数组 nums[start ... i]（start = max(0, i - nums[i])）。
返回为数组中每个下标定义的子数组中所有元素的总和。
子数组 是数组中的一个连续、非空 的元素序列。
提示：
1 <= n == nums.length <= 100
1 <= nums[i] <= 1000

前缀和模拟。
时间复杂度 O(n)。
 */