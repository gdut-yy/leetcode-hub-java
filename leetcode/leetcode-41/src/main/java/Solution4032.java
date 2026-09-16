public class Solution4032 {
    private static final int N = (int) 1e5;
    // SPF = Smallest Prime Factor，中文就是 最小质因子
    // LPF 如果指 Least Prime Factor，也是最小质因子
    private static final int[] SPF = new int[N + 1];

    static {
        for (int i = 2; i <= N; i++) {
            if (SPF[i] == 0) {
                for (int j = i; j <= N; j += i) {
                    if (SPF[j] == 0) SPF[j] = i;
                }
            }
        }
    }

    public int longestSubarray(int[] nums, int k) {
        int[] count = new int[N + 1];
        int distinct = 0;
        int left = 0, best = 0;
        for (int right = 0; right < nums.length; right++) {
            int x = nums[right];
            while (x > 1) {
                int p = SPF[x];
                if (count[p]++ == 0) distinct++;
                while (x % p == 0) x /= p;
            }
            while (distinct > k) {
                int y = nums[left];
                while (y > 1) {
                    int p = SPF[y];
                    if (--count[p] == 0) distinct--;
                    while (y % p == 0) y /= p;
                }
                left++;
            }
            best = Math.max(best, right - left + 1);
        }
        return best;
    }
}
/*
4032. 至多 K 个不同质因数集合的最长子数组
https://leetcode.cn/problems/longest-subarray-with-at-most-k-distinct-prime-factors/description/

第 516 场周赛 T3。

给你一个由正整数组成的整数数组 nums 和一个整数 k。
一个 子数组 的 质因数集合 是其所有元素的 不同质 因数的 并集。
返回 最长子数组的长度 ，其质因数集合中包含的不同质因子数量不超过 k 。如果不存在这样的子数组，则返回 0。
子数组 是数组中一段连续 非空 的元素序列。
质数 是指在大于 1 的自然数中，除了 1 和它本身以外不再有其他因数的自然数。
提示：
1 <= nums.length <= 10^5
2 <= nums[i] <= 10^5
1 <= k <= 10^4

预处理 + 滑动窗口。
时间复杂度 O(nlogU)。
 */