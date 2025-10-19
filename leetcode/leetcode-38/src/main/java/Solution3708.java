public class Solution3708 {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int ans = 2;
        int cur = 2;
        for (int i = 2; i < n; i++) {
            if (nums[i - 2] + nums[i - 1] == nums[i]) {
                cur += 1;
                if (cur > ans) {
                    ans = cur;
                }
            } else {
                cur = 2;
            }
        }
        return ans;
    }
}
/*
3708. 最长斐波那契子数组
https://leetcode.cn/problems/longest-fibonacci-subarray/description/

第 167 场双周赛 T2。

给你一个由 正 整数组成的数组 nums。
斐波那契 数组是一个连续序列，其中第三项及其后的每一项都等于这一项前面两项之和。
返回 nums 中最长 斐波那契 子数组的长度。
注意: 长度为 1 或 2 的子数组总是 斐波那契 的。
子数组 是数组中 非空 的连续元素序列。
提示:
3 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

模拟。
时间复杂度 O(n)。
 */