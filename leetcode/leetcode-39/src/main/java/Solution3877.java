import java.util.Arrays;

public class Solution3877 {
    private static final int INF = (int) 1e9;

    public int minRemovals(int[] nums, int target) {
        int mx = Arrays.stream(nums).max().orElseThrow();
        int m = 1 << bitsLen(mx);
        // 无解
        if (m <= target) return -1;

        int n = nums.length;
        int[] f = new int[m];
        Arrays.fill(f, -INF);
        f[0] = 0;
        for (int num : nums) {
            int[] nf = f.clone();
            for (int j = 0; j < m; j++) {
                nf[j] = Math.max(nf[j], f[j ^ num] + 1);
                if (nf[j] < 0) {
                    nf[j] = -INF;
                }
            }
            f = nf;
        }
        return f[target] == -INF ? -1 : n - f[target];
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    private int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }
}
/*
3877. 达到目标异或值的最少删除次数
https://leetcode.cn/problems/minimum-removals-to-achieve-target-xor/description/

第 494 场周赛 T3。

给你一个整数数组 nums 和一个整数 target。
你可以从 nums 中移除 任意 数量的元素（可能为零）。
返回使剩余元素的 按位异或和 等于 target 所需的 最小 移除次数。如果无法达到 target，则返回 -1。
空数组的按位异或和为 0。
提示：
1 <= nums.length <= 40
0 <= nums[i] <= 10^4
0 <= target <= 10^4

0-1 背包问题。
相似题目: 2915. 和为目标值的最长子序列的长度
https://leetcode.cn/problems/length-of-the-longest-subsequence-that-sums-to-target/
 */