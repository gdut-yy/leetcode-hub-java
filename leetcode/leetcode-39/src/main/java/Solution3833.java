public class Solution3833 {
    public int dominantIndices(int[] nums) {
        int n = nums.length;
        int sufSum = 0;
        int ans = 0;
        for (int i = n - 2; i >= 0; i--) {
            sufSum += nums[i + 1];
            if (nums[i] * (n - 1 - i) > sufSum) {
                ans++;
            }
        }
        return ans;
    }
}
/*
3833. 统计主导元素下标数
https://leetcode.cn/problems/count-dominant-indices/description/

第 488 场周赛 T1。

给你一个长度为 n 的整数数组 nums。
当下标 i 满足以下条件时，该下标处的元素被称为 主导元素：nums[i] > average(nums[i + 1], nums[i + 2], ..., nums[n - 1])
你的任务是统计数组中 主导元素 的下标数。
平均值 是指一组数的总和除以该组数的个数得到的值。
注意：数组的 最右边元素 不算作 主导元素 。

中国时间 2026-02-08 周日 10:30
佛山。
倒着遍历。
时间复杂度 O(n)。
 */