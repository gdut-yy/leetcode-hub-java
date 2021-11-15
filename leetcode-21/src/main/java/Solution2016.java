public class Solution2016 {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, nums[j] - nums[i]);
            }
        }
        if (max == 0) {
            return -1;
        }
        return max;
    }
}
/*
2016. 增量元素之间的最大差值
https://leetcode-cn.com/problems/maximum-difference-between-increasing-elements/

给你一个下标从 0 开始的整数数组 nums ，该数组的大小为 n ，请你计算 nums[j] - nums[i] 能求得的 最大差值 ，
其中 0 <= i < j < n 且 nums[i] < nums[j] 。
返回 最大差值 。如果不存在满足要求的 i 和 j ，返回 -1 。

模拟。
 */