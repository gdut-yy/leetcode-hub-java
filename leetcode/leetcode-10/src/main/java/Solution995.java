public class Solution995 {
    public int minKBitFlips(int[] nums, int k) {
        int len = nums.length;

        // 差分数组
        int[] diff = new int[len + 1];
        int res = 0;
        int revCnt = 0;
        for (int i = 0; i < len; i++) {
            revCnt += diff[i];
            // 说明当前元素的实际值为 0
            if ((nums[i] + revCnt) % 2 == 0) {
                if (i + k > len) {
                    return -1;
                }
                res++;
                revCnt++;
                diff[i + k]--;
            }
        }
        return res;
    }
}
/*
995. K 连续位的最小翻转次数
https://leetcode.cn/problems/minimum-number-of-k-consecutive-bit-flips/

给定一个二进制数组 nums 和一个整数 k 。
k位翻转 就是从 nums 中选择一个长度为 k 的 子数组 ，同时把子数组中的每一个 0 都改成 1 ，把子数组中的每一个 1 都改成 0 。
返回数组中不存在 0 所需的最小 k位翻转 次数。如果不可能，则返回 -1 。
子数组 是数组的 连续 部分。
提示：
1 <= nums.length <= 10^5
1 <= k <= nums.length

差分数组
时间复杂度 O(n)
空间复杂度 O(n)
 */