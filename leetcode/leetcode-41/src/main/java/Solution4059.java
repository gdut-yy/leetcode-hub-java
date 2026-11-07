public class Solution4059 {
    public int[] largestPower(int[] nums) {
        final int BITS = 15;
        final int SIZE = 1 << BITS;
        int n = nums.length;
        int[] sup = new int[SIZE];
        for (int x : nums) {
            sup[x]++;
        }
        for (int bit = 0; bit < BITS; bit++) {
            int b = 1 << bit;
            for (int m = 0; m < SIZE; m++) {
                if ((m & b) == 0) {
                    sup[m] += sup[m | b];
                }
            }
        }
        int[] req = new int[n];
        int[] ans = new int[BITS];
        for (int i = 0; i < BITS; i++) {
            int bit = BITS - 1 - i;
            int bitVal = 1 << bit;
            int best = n;
            int p = 0;
            while (p < n) {
                int v = req[p];
                int q = p;
                while (q < n && req[q] == v) {
                    q++;
                }
                int t = q;
                int needed = v | bitVal;
                int available = sup[needed];
                if (t > available && available < best) {
                    best = available;
                }
                p = q;
            }
            ans[i] = best;
            for (int j = 0; j < best; j++) {
                req[j] |= bitVal;
            }
        }
        return ans;
    }
}
/*
4059. 字典序最大的答案数组
https://leetcode.cn/problems/lexicographically-largest-power-array/description/

第 520 场周赛 T4。

给你一个长度为 n 的整数数组 nums。你可以重新排列其中的元素以形成任意 排列 perm。
定义一个长度为 15 的数组 power。对于每个 0 <= i < 15，考查 perm 的前 j 个元素的第 (14 - i) 位，power[i] 是满足这些位全为 1 的最大整数 j（其中 0 <= j <= n）。
二进制位的位置从右向左编号，从第 0 位开始。
返回可能得到的 字典序最大 的 power 数组。
排列 是数组中所有元素的一种重新排列。
置位 指的是数字在二进制表示中对应位的值为 1。
对于两个长度相同的数组，如果在它们不同的第一个下标处，数组 a 包含的元素大于数组 b 中的元素，则称数组 a 的 字典序大于 数组 b。
示例 1：
输入：nums = [7,5]
输出：[0,0,0,0,0,0,0,0,0,0,0,0,2,1,2]
示例 2：
输入：nums = [3,1,7]
输出：[0,0,0,0,0,0,0,0,0,0,0,0,1,2,3]
提示：
1 <= nums.length <= 5 * 10^4
0 <= nums[i] < 2^15

贪心。
时间复杂度 O(nlogU)。
 */