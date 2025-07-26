public class Solution3618 {
    public long splitArray(int[] nums) {
        int n = nums.length;
        long sumA = 0, sumB = 0;
        for (int i = 0; i < n; i++) {
            if (isPrime(i)) sumA += nums[i];
            else sumB += nums[i];
        }
        return Math.abs(sumA - sumB);
    }

    private boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        for (long i = 2; i * i <= num; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
/*
3618. 根据质数下标分割数组
https://leetcode.cn/problems/split-array-by-prime-indices/description/

第 161 场双周赛 T1。

给你一个整数数组 nums。
根据以下规则将 nums 分割成两个数组 A 和 B：
- nums 中位于 质数 下标的元素必须放入数组 A。
- 所有其他元素必须放入数组 B。
返回两个数组和的 绝对 差值：|sum(A) - sum(B)|。
质数 是一个大于 1 的自然数，它只有两个因子，1和它本身。
注意：空数组的和为 0。
提示:
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

中国时间 2025-07-19 周六 22:30
上海。
模拟。判断素数。
 */