public class Solution5953 {
    public long subArrayRanges(int[] nums) {
        int len = nums.length;
        long sum = 0;
        for (int i = 0; i < len; i++) {
            int min = nums[i];
            int max = nums[i];
            for (int j = i + 1; j < len; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
                if (nums[j] < min) {
                    min = nums[j];
                }
                sum += max - min;
            }
        }
        return sum;
    }
}
/*
5953. 子数组范围和
https://leetcode-cn.com/problems/sum-of-subarray-ranges/

第 271 场周赛 T2。

给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。
返回 nums 中 所有 子数组范围的 和 。
子数组是数组中一个连续 非空 的元素序列。

范围 10^3
时间复杂度 O(n^2)
固定左端点暴力枚举最大元素和最小元素（比赛时想到全排列去了，一直想不出 O(n^2) 的方法，直到 0:58:49 才靠肌肉记忆写出此解，大脑才醒悟过来。）
 */