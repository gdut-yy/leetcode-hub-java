public class Solution3473 {
    public int maxSum(int[] nums, int k, int m) {
        int n = nums.length;
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }

        long[][] f = new long[k + 1][n + 1];
        for (int i = 1; i <= k; i++) {
            long mx = Long.MIN_VALUE / 2;
            // 3077 version
//            long w = (i % 2 > 0 ? 1 : -1) * (k - i + 1);
//            f[i][i - 1] = mx;
//            for (int j = i; j <= n - (k - i); j++) {
//                mx = Math.max(mx, f[i - 1][j - 1] - ps[j - 1] * w);
//                f[i][j] = Math.max(f[i][j - 1], ps[j] * w + mx);
//            }
            for (int j = i * m - m; j < i * m; j++) {
                f[i][j] = mx;
            }
            for (int j = i * m; j <= n - (k - i) * m; j++) {
                mx = Math.max(mx, f[i - 1][j - m] - ps[j - m]);
                f[i][j] = Math.max(f[i][j - 1], ps[j] + mx);
            }
        }
        return (int) f[k][n];
    }
}
/*
3473. 长度至少为 M 的 K 个子数组之和
https://leetcode.cn/problems/sum-of-k-subarrays-with-length-at-least-m/description/

第 439 场周赛 T3。

给你一个整数数组 nums 和两个整数 k 和 m。
返回数组 nums 中 k 个不重叠子数组的 最大 和，其中每个子数组的长度 至少 为 m。
子数组 是数组中的一个连续序列。
提示:
1 <= nums.length <= 2000
-10^4 <= nums[i] <= 10^4
1 <= k <= floor(nums.length / m)
1 <= m <= 3

划分型 DP + 前缀和优化。
和 3077 题 几乎是一样的题目，一年前的 T4 hard，时过境迁，今年竟然放 T3 medium 了，
（作为 T4 时候 clist rating 分是 2586，今天 T3 rating 分是 2460）
时间复杂度 O(nk)。
相似题目: 3077. K 个不相交子数组的最大能量值
https://leetcode.cn/problems/maximum-strength-of-k-disjoint-subarrays/description/
 */