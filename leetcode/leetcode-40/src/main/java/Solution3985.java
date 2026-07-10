public class Solution3985 {
    public long getSum(int[] nums) {
        int n = nums.length;
        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + nums[i];
        }
        int m = 2 * n + 1;
        int[] t = new int[m];
        for (int i = 0; i < n; i++) {
            t[2 * i + 1] = nums[i];
        }
        int[] p = new int[m];
        int center = 0, right = 0;
        for (int i = 0; i < m; i++) {
            int mirror = 2 * center - i;
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }
            while (i - p[i] - 1 >= 0 && i + p[i] + 1 < m
                    && t[i - p[i] - 1] == t[i + p[i] + 1]) {
                p[i]++;
            }
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }
        long maxSum = 0;
        for (int i = 0; i < m; i++) {
            int L = i - p[i];
            int len = p[i] + (L & 1);
            if (len == 0) continue;
            int leftOrig = L / 2;
            long sum = pref[leftOrig + len] - pref[leftOrig];
            if (sum > maxSum) maxSum = sum;
        }
        return maxSum;
    }
}
/*
3985. 回文子数组求和
https://leetcode.cn/problems/palindromic-subarray-sum/description/

第 509 场周赛 T4。

给你一个整数数组 nums。
你的任务是找出 nums 中一个 回文子数组 的 最大 元素和。
返回这样的子数组的 最大 元素和。
子数组 是数组中一个连续的 非空 元素序列。
如果一个 子数组 正着读和反着读都相同，则称其为 回文 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9

Manacher 算法 + 前缀和。
时间复杂度 O(n)。
 */