public class Solution2183 {
    public long coutPairs(int[] nums, int k) {
        int len = nums.length;

        long cnt = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] % k == 0) {
                cnt += len - 1 - i;
            } else {
                for (int j = i + 1; j < len; j++) {
                    if ((long) nums[i] * nums[j] % k == 0) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
/*
2183. 统计可以被 K 整除的下标对数目
https://leetcode-cn.com/problems/count-array-pairs-divisible-by-k/

第 281 场周赛 T4。

给你一个下标从 0 开始、长度为 n 的整数数组 nums 和一个整数 k ，返回满足下述条件的下标对 (i, j) 的数目：
- 0 <= i < j <= n - 1 且
- nums[i] * nums[j] 能被 k 整除。
提示：
1 <= nums.length <= 10^5
1 <= nums[i], k <= 10^5

这个乍一看很像前一晚双周赛的 T1。暴力解法时间复杂度 O(n^2) 数量级 10^5 无法 AC。
 */