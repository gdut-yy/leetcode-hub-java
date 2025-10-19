public class Solution3702 {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor = 0;
        boolean allZero = true;
        for (int v : nums) {
            if (v != 0) allZero = false;
            xor ^= v;
        }
        if (allZero) return 0;
        return xor == 0 ? n - 1 : n;
    }
}
/*
3702. 按位异或非零的最长子序列
https://leetcode.cn/problems/longest-subsequence-with-non-zero-bitwise-xor/description/

第 470 场周赛 T2。

给你一个整数数组 nums。
返回 nums 中 按位异或（XOR）计算结果 非零 的 最长子序列 的长度。如果不存在这样的 子序列 ，返回 0 。
子序列 是一个 非空 数组，可以通过从原数组中删除一些或不删除任何元素（不改变剩余元素的顺序）派生而来。
提示：
1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9

脑筋急转弯。
如果 nums 所有元素的异或和不为 0，那么全选即可满足条件，返回 n。
否则不能全选。如果 nums 中有非零元素，那么去掉这个非零元素，就可以使异或和不为零，返回 n−1。
否则 nums 全为 0，无解，返回 0。
时间复杂度 O(n)。
 */
