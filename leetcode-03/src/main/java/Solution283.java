import java.util.Arrays;

public class Solution283 {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        Arrays.fill(nums, left, right, 0);
    }
}
/*
283. 移动零
https://leetcode-cn.com/problems/move-zeroes/submissions/

双指针。相当于 27 题需要移除的元素为 0，然后剩余的数组部分再补充上 0。
 */