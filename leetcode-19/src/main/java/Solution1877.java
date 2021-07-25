import java.util.Arrays;

public class Solution1877 {
    public int minPairSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < len / 2; i++) {
            max = Math.max(max, nums[i] + nums[len - 1 - i]);
        }
        return max;
    }
}
/*
1877. 数组中最大数对和的最小值
https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/

第 53 双周赛 T2。
有签到题的感觉？
题目要求最小的最大数对和 即 从有序数组的首尾两端求和中取最值
 */