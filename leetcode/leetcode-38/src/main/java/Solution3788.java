public class Solution3788 {
    public long maximumScore(int[] nums) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        for (int i = 0; i < n; i++) {
            prefixSum[i] = nums[i];
            if (i > 0) prefixSum[i] += prefixSum[i - 1];
        }
        long ans = Long.MIN_VALUE;
        long suffixMin = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            ans = Math.max(ans, prefixSum[i] - suffixMin);
            suffixMin = Math.min(suffixMin, nums[i]);
        }
        return ans;
    }
}
/*
3788. 分割的最大得分
https://leetcode.cn/problems/maximum-score-of-a-split/description/

第 482 场周赛 T1。

给你一个长度为 n 的整数数组 nums。
请你选出一个下标 i 以分割数组，该下标满足 0 <= i < n - 1。
对于选择的分割下标 i：
- 令 prefixSum(i) 表示数组前缀的和，即 nums[0] + nums[1] + ... + nums[i]。
- 令 suffixMin(i) 表示数组后缀的最小值，即 nums[i + 1], nums[i + 2], ..., nums[n - 1] 中的最小值。
在下标 i 的 分割得分 定义为：
score(i) = prefixSum(i) - suffixMin(i)
返回所有有效分割下标中 最大 的分割得分。
提示：
2 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

前后缀分解。
时间复杂度 O(n)。
 */