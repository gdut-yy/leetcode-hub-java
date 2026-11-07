public class Solution4089 {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        long length = 0;
        for (int num : nums) {
            if (num >= minK && num <= maxK) {
                length++;
                ans += length;
            } else {
                length = 0;
            }
        }
        return ans;
    }
}
/*
4089. 统计宽界子数组的数目
https://leetcode.cn/problems/count-subarrays-with-loose-bounds/description/

第 194 场双周赛 T2。

给你一个整数数组 nums 和两个整数 minK 与 maxK。
一个宽界子数组 是指满足以下条件的 子数组 ：子数组中的每个元素都 大于或等于 minK 且 小于或等于 maxK。
返回 nums 中宽界子数组的 数量 。
子数组 是数组中连续的 非空 元素序列。
示例 1：
输入： nums = [1,4,7,3], minK = 1, maxK = 5
输出： 4
示例 2：
输入： nums = [1,1], minK = 1, maxK = 1
输出： 3
提示：
2 <= nums.length <= 10^5
1 <= nums[i], minK, maxK <= 10^6

枚举。
时间复杂度 O(n)。
 */