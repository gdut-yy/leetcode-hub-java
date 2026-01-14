public class Solution3748 {
    public long[] countStableSubarrays(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] f = new int[n];
        f[0] = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] >= nums[i - 1]) {
                f[i] = f[i - 1];
            } else {
                f[i] = i;
            }
        }
        long[] ps = new long[n];
        ps[0] = f[0];
        for (int i = 1; i < n; i++) {
            ps[i] = ps[i - 1] + f[i];
        }

        int q = queries.length;
        long[] ans = new long[q];
        for (int idx = 0; idx < q; idx++) {
            int L = queries[idx][0];
            int R = queries[idx][1];
            long totalSubarrays = (long) (L + R + 2) * (R - L + 1) / 2;
            int low = L;
            int high = R;
            int p = R + 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (f[mid] >= L) {
                    p = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            long subtract;
            if (p > R) {
                subtract = (long) L * (R - L + 1);
            } else {
                long leftPart = (long) L * (p - L);
                long rightPart = ps[R] - (p > 0 ? ps[p - 1] : 0);
                subtract = leftPart + rightPart;
            }
            ans[idx] = totalSubarrays - subtract;
        }
        return ans;
    }
}
/*
3748. 统计稳定子数组的数目
https://leetcode.cn/problems/count-stable-subarrays/description/

第 476 场周赛 T4。

给你一个整数数组 nums。
如果 nums 的一个 子数组 中 没有逆序对 ，即不存在满足 i < j 且 nums[i] > nums[j] 的下标对，则该子数组被称为 稳定 子数组。
同时给你一个长度为 q 的 二维整数数组 queries，其中每个 queries[i] = [li, ri] 表示一个查询。对于每个查询 [li, ri]，请你计算完全包含在 nums[li..ri] 内的 稳定子数组 的数量。
返回一个长度为 q 的整数数组 ans，其中 ans[i] 是第 i 个查询的答案。
注意：
- 子数组 是数组中一个连续且 非空 的元素序列。
- 单个元素的子数组被认为是稳定的。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
1 <= queries.length <= 10^5
queries[i] = [li, ri]
0 <= li <= ri <= nums.length - 1

预处理数组：首先，我们预处理数组 nums，计算每个位置 i 的 f[i] 值，表示以 i 结尾的最长非递减子数组的起始位置。这有助于快速判断任意子数组是否为稳定的。
前缀和数组：基于 f 数组，构建前缀和数组 pref，以便快速计算任意区间内 f 值的和。
查询处理：对于每个查询 [L, R]：
计算总和：首先计算区间 [L, R] 内所有可能子数组的总数，即 (L + R + 2) * (R - L + 1) / 2。
二分查找分界点：使用二分查找找到第一个位置 p，使得 f[p] >= L。这将区间分为两部分：
第一部分：从 L 到 p-1，其中所有 f[i] < L，贡献为 L * (p - L)。
第二部分：从 p 到 R，其中所有 f[i] >= L，贡献为 pref[R] - pref[p-1]。
调整总和：从总和中减去这两部分的贡献，得到稳定子数组的数量。
https://chat.deepseek.com/a/chat/s/135f7a33-4b5a-4a6b-967b-f94c4bebef8d
rating 2234 (clist.by)
 */