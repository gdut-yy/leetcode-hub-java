public class Solution3584 {
    private static final long INF = (long) 1e18;

    public long maximumProduct(int[] nums, int m) {
        int n = nums.length;
        if (m == 1) {
            long ans = 0;
            for (int x : nums) ans = Math.max(ans, (long) x * x);
            return ans;
        }
        int k = m - 1;

        int[] max_suffix = new int[n];
        int[] min_suffix = new int[n];
        max_suffix[n - 1] = nums[n - 1];
        min_suffix[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            max_suffix[i] = Math.max(nums[i], max_suffix[i + 1]);
            min_suffix[i] = Math.min(nums[i], min_suffix[i + 1]);
        }

        long candidate;
        long max_prod = -INF;
        for (int i = 0; i + k < n; i++) {
            int start = i + k;
            if (nums[i] >= 0) {
                candidate = (long) nums[i] * max_suffix[start];
            } else {
                candidate = (long) nums[i] * min_suffix[start];
            }
            max_prod = Math.max(max_prod, candidate);
        }

        return max_prod;
    }
}
/*
3584. 子序列首尾元素的最大乘积
https://leetcode.cn/problems/maximum-product-of-first-and-last-elements-of-a-subsequence/description/

第 454 场周赛 T3。

给你一个整数数组 nums 和一个整数 m。
返回任意大小为 m 的 子序列 中首尾元素乘积的最大值。
子序列 是可以通过删除原数组中的一些元素（或不删除任何元素），且不改变剩余元素顺序而得到的数组。
提示:
1 <= nums.length <= 10^5
-10^5 <= nums[i] <= 10^5
1 <= m <= nums.length

预处理后缀 + 贪心。
时间复杂度 O(n)。
 */