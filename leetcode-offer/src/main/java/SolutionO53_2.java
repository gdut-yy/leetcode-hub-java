public class SolutionO53_2 {
    public int missingNumber(int[] nums) {
        // 左边界二分
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] != mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
/*
剑指 Offer 53 - II. 0～n-1中缺失的数字
https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/

一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

左边界二分。找第一个 !=
nums[0]==0, nums[1]==1, ..., nums[i]==i, nums[i+1]!=i+1, ..., nums[n]==n
 */