import java.util.Arrays;

public class Solution27 {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
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

给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

双指针。
相似题目: 26. 删除有序数组中的重复项
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */