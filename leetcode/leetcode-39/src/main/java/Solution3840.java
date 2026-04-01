public class Solution3840 {
    public long rob(int[] nums, int[] colors) {
        int n = nums.length;
        if (n == 0) return 0;
        long robPrev = nums[0];
        long notRobPrev = 0;
        for (int i = 1; i < n; i++) {
            long notRobCurr = Math.max(notRobPrev, robPrev);
            long robCurr;
            if (colors[i] == colors[i - 1]) {
                robCurr = nums[i] + notRobPrev;
            } else {
                robCurr = nums[i] + Math.max(notRobPrev, robPrev);
            }
            notRobPrev = notRobCurr;
            robPrev = robCurr;
        }
        return Math.max(notRobPrev, robPrev);
    }
}
/*
3840. 打家劫舍 V
https://leetcode.cn/problems/house-robber-v/description/

第 176 场双周赛 T3。

你是一名专业小偷，计划偷窃沿街的房屋。每间房屋都藏有一定的现金，并由带有颜色代码的安全系统保护。
给你两个长度为 n 的整数数组 nums 和 colors，其中 nums[i] 是第 i 间房屋中的金额，而 colors[i] 是该房屋的颜色代码。
如果两间 相邻 的房屋具有 相同 的颜色代码，则你 不能同时偷窃 它们。
返回你能偷窃到的 最大 金额。
提示：
1 <= n == nums.length == colors.length <= 10^5
1 <= nums[i], colors[i] <= 10^5

动态规划。
时间复杂度 O(n)。
 */