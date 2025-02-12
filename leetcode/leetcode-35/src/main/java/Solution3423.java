public class Solution3423 {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int ans = Math.abs(nums[0] - nums[n - 1]);
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans, Math.abs(nums[i] - nums[i - 1]));
        }
        return ans;
    }
}
/*
3423. 循环数组中相邻元素的最大差值
https://leetcode.cn/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/description/

第 148 场双周赛 T1。

给你一个 循环 数组 nums ，请你找出相邻元素之间的 最大 绝对差值。
注意：一个循环数组中，第一个元素和最后一个元素是相邻的。
提示：
2 <= nums.length <= 100
-100 <= nums[i] <= 100

模拟。
 */