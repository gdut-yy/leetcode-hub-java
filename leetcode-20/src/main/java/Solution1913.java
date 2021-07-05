import java.util.Arrays;

public class Solution1913 {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        return nums[len - 1] * nums[len - 2] - nums[0] * nums[1];
    }
}
/*
1913. 两个数对之间的最大乘积差
https://leetcode-cn.com/problems/maximum-product-difference-between-two-pairs/

周赛签到题。数组排序后，最大两个数乘积减去最小两个数乘积即可。
 */
