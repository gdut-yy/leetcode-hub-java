public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        // 前缀和
        int len = nums.length;
        int[] preSum = new int[len + 1];
        preSum[0] = 0;
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        // 枚举连续子数组 时间复杂度 O(n^2)
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if ((preSum[j + 1] - preSum[i]) == k) {
                    res++;
                }
            }
        }
        return res;
    }
}
/*
560. 和为K的子数组
https://leetcode-cn.com/problems/subarray-sum-equals-k/

第 974 题相同题形: https://leetcode-cn.com/problems/subarray-sums-divisible-by-k/
前缀和 + 枚举连续子数组。时间复杂度 O(n^2)
 */
