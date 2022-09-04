public class Solution6169 {
    public int longestNiceSubarray(int[] nums) {
        int len = nums.length;

        // 双指针
        int left = 0;
        int right = 0;
        int max = 0;
        // 按位或
        int bitOr = 0;
        while (right < len) {
            // 处理左端点
            while ((bitOr & nums[right]) != 0) {
                bitOr ^= nums[left];
                left++;
            }
            // 右端点
            bitOr |= nums[right];
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
/*
6169. 最长优雅子数组
https://leetcode.cn/problems/longest-nice-subarray/

第 309 场周赛 T3。

给你一个由 正 整数组成的数组 nums 。
如果 nums 的子数组中位于 不同 位置的每对元素按位 与（AND）运算的结果等于 0 ，则称该子数组为 优雅 子数组。
返回 最长 的优雅子数组的长度。
子数组 是数组中的一个 连续 部分。
注意：长度为 1 的子数组始终视作优雅子数组。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

或运算 | 可以将一个状态加入到集合中
异或运算 ^ 可以将一个状态从集合中剔除
时间复杂度 O(n)
 */