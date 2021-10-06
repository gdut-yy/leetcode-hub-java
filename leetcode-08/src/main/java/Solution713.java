import java.math.BigInteger;

public class Solution713 {
    /**
     * 类似 "前缀和" 的 "前缀积"
     * 时间复杂度 O(n^2) 使用 BigInteger 是因为 long 会溢出
     *
     * @param nums 正整数数组
     * @param k    整数 k
     * @return 乘积小于 k 的连续的子数组的个数
     */
    public int numSubarrayProductLessThanK2(int[] nums, int k) {
        // 前缀“积”
        int len = nums.length;
        BigInteger[] preSum = new BigInteger[len + 1];
        preSum[0] = new BigInteger("1");
        for (int i = 0; i < len; i++) {
            preSum[i + 1] = preSum[i].multiply(BigInteger.valueOf(nums[i]));
        }
        // 枚举连续子数组 时间复杂度 O(n^2)
        BigInteger kBigInteger = BigInteger.valueOf(k);
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (preSum[j + 1].divide(preSum[i]).compareTo(kBigInteger) < 0) {
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 双指针
     * 时间复杂度 O(n)
     *
     * @param nums 正整数数组
     * @param k    整数 k
     * @return 乘积小于 k 的连续的子数组的个数
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // 双指针
        int left = 0;
        int right = 0;
        // 乘积
        long product = 1;
        int cnt = 0;
        while (right < nums.length) {
            // 右指针右移
            product *= nums[right];
            right++;
            // 左指针右移
            while (product >= k && left < right) {
                product /= nums[left];
                left++;
            }
            cnt += right - left;
        }
        return cnt;
    }
}
/*
713. 乘积小于K的子数组
https://leetcode-cn.com/problems/subarray-product-less-than-k/

给定一个正整数数组 nums和整数 k 。
请找出该数组内乘积小于 k 的连续的子数组的个数。

参考第 560 题 https://leetcode-cn.com/problems/subarray-sum-equals-k/
“前缀积” 时间复杂度 O(n^2)

参考第 209 题 https://leetcode-cn.com/problems/minimum-size-subarray-sum/
双指针 时间复杂度 O(n)
 */