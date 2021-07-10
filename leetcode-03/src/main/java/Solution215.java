import java.util.Arrays;

public class Solution215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
/*
215. 数组中的第K个最大元素
https://leetcode-cn.com/problems/kth-largest-element-in-an-array/

数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
数组排序后，返回对应下标即可。
 */