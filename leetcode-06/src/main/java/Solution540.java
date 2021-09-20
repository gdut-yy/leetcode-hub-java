public class Solution540 {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        // 左边界二分
        int left = 0;
        int right = len / 2;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int i = mid * 2;
            if (!isEquals(nums, i)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return nums[left * 2];
    }

    private boolean isEquals(int[] nums, int i) {
        return nums[i] == nums[i + 1];
    }
}
/*
540. 有序数组中的单一元素
https://leetcode-cn.com/problems/single-element-in-a-sorted-array/

给定一个只包含整数的有序数组 nums ，每个元素都会出现两次，唯有一个数只会出现一次，请找出这个唯一的数字。

输入: nums = [1,1,2,3,3,4,4,8,8]
输出: 2

数组中的数字每两个分成一组，左侧的若干组的两个数组是相同的，右侧若干组的数组是不同的。
只出现一次的数字正好是第一个两个数字不相等的分组的第一个数字。

左边界二分。
 */