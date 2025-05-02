public class Solution3524 {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] ans = new long[k];
        // 定义 f[i+1][x] 表示右端点为 i 的、元素积模 k 等于 x 的子数组的个数。+1 是为了方便用 f[0] 表示初始值。
        int[][] f = new int[n + 1][k];
        for (int i = 0; i < n; i++) {
            int v = nums[i] % k;
            f[i + 1][v] = 1;
            for (int y = 0; y < k; y++) {
                f[i + 1][y * v % k] += f[i][y]; // 刷表法
            }
            for (int x = 0; x < k; x++) {
                ans[x] += f[i + 1][x];
            }
        }
        return ans;
    }
}
/*
3524. 求出数组的 X 值 I
https://leetcode.cn/problems/find-x-value-of-array-i/description/

第 446 场周赛 T3。

给你一个由 正 整数组成的数组 nums，以及一个 正 整数 k。
你可以对 nums 执行 一次 操作，该操作中可以移除任意 不重叠 的前缀和后缀，使得 nums 仍然 非空 。
你需要找出 nums 的 x 值，即在执行操作后，剩余元素的 乘积 除以 k 后的 余数 为 x 的操作数量。
返回一个大小为 k 的数组 result，其中 result[x] 表示对于 0 <= x <= k - 1，nums 的 x 值。
数组的 前缀 指从数组起始位置开始到数组中任意位置的一段连续子数组。
数组的 后缀 是指从数组中任意位置开始到数组末尾的一段连续子数组。
子数组 是数组中一段连续的元素序列。
注意，在操作中选择的前缀和后缀可以是 空的 。
提示：
1 <= nums[i] <= 10^9
1 <= nums.length <= 10^5
1 <= k <= 5

子数组 DP + 刷表法。
https://leetcode.cn/problems/find-x-value-of-array-i/solutions/3656580/zi-shu-zu-dp-shua-biao-fa-pythonjavacgo-8lonk/
题意：对于 x=0,1,2,...,k−1，计算有多少个非空连续子数组的元素积模 k 等于 x。
时间复杂度 O(nk)。
 */