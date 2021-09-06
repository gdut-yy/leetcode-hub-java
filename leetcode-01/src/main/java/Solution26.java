import java.util.Arrays;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                // left 先加再赋值，因为 left 本身是需要返回的
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        nums = Arrays.copyOfRange(nums, 0, left + 1);
        return nums.length;
    }
}
/*
26. 删除有序数组中的重复项
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
双指针。
 */