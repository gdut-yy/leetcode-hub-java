public class Solution3513 {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        return 1 << bitsLen(n);
    }

    // bits.Len:
    // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
    private int bitsLen(long x) {
        return 64 - Long.numberOfLeadingZeros(x);
    }
}
/*
3513. 不同 XOR 三元组的数目 I
https://leetcode.cn/problems/number-of-unique-xor-triplets-i/description/

第 154 场双周赛 T2。

给你一个长度为 n 的整数数组 nums，其中 nums 是范围 [1, n] 内所有数的 排列 。
XOR 三元组 定义为三个元素的异或值 nums[i] XOR nums[j] XOR nums[k]，其中 i <= j <= k。
返回所有可能三元组 (i, j, k) 中 不同 的 XOR 值的数量。
排列 是一个集合中所有元素的重新排列。
提示：
1 <= n == nums.length <= 10^5
1 <= nums[i] <= n
nums 是从 1 到 n 的整数的一个排列。

构造题。
时间复杂度 O(1)。
 */