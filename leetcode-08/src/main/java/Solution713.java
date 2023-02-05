public class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        long product = 1L;
        int res = 0;
        while (right < n) {
            product *= nums[right];
            while (product >= k && left <= right) {
                product /= nums[left];
                left++;
            }
            res += right - left + 1;
            right++;
        }
        return res;
    }
}
/*
713. 乘积小于K的子数组
https://leetcode.cn/problems/subarray-product-less-than-k/

给定一个正整数数组 nums和整数 k 。
请找出该数组内乘积小于 k 的连续的子数组的个数。
提示:
1 <= nums.length <= 3 * 10^4
1 <= nums[i] <= 1000
0 <= k <= 10^6

双指针
时间复杂度 O(n)
相似题目: 209. 长度最小的子数组
https://leetcode.cn/problems/minimum-size-subarray-sum/
 */