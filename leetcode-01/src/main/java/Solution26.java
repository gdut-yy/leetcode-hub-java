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

双指针。
 */