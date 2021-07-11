import java.util.Arrays;

public class Solution27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0, right = 0;
        while (right < nums.length) {
            if (val != nums[right]) {
                // left 先赋值再加，因为 left 本身有可能是需要移除的元素。
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        nums = Arrays.copyOfRange(nums, 0, left);
        return nums.length;
    }
}
/*
27. 移除元素
https://leetcode-cn.com/problems/remove-element/

双指针。快慢指针。与 26 题相近。
 */