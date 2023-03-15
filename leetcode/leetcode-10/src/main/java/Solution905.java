public class Solution905 {
    public int[] sortArrayByParity(int[] nums) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            if (nums[left] % 2 == 1 && nums[right] % 2 == 0) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            } else if (nums[left] % 2 == 0) {
                left++;
            } else if (nums[right] % 2 == 1) {
                right--;
            }
        }
        return nums;
    }
}
/*
905. 按奇偶排序数组
https://leetcode.cn/problems/sort-array-by-parity/

给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
返回满足此条件的 任一数组 作为答案。
提示：
1 <= nums.length <= 5000
0 <= nums[i] <= 5000
 */