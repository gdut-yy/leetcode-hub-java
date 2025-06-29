public class Solution3587 {
    public int minSwaps(int[] nums) {
        int[] cnt = new int[2];
        for (int v : nums) cnt[v % 2]++;

        if (Math.abs(cnt[0] - cnt[1]) > 1) return -1;
        if (cnt[0] == cnt[1]) {
            return Math.min(getAns(nums, 0), getAns(nums, 1));
        } else if (cnt[0] > cnt[1]) { // 第一个偶数
            return getAns(nums, 0);
        } else {
            return getAns(nums, 1);
        }
    }

    // st:0 偶数开头 st:1 奇数开头
    private int getAns(int[] nums, int st) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                ans += Math.abs(i - st);
                st += 2;
            }
        }
        return ans;
    }
}
/*
3587. 最小相邻交换至奇偶交替
https://leetcode.cn/problems/minimum-adjacent-swaps-to-alternate-parity/description/

第 159 场双周赛 T1。

给你一个由互不相同的整数组成的数组 nums 。
在一次操作中，你可以交换任意两个 相邻 元素。
在一个排列中，当所有相邻元素的奇偶性交替出现，我们认为该排列是 有效排列。这意味着每对相邻元素中一个是偶数，一个是奇数。
请返回将 nums 变成任意一种 有效排列 所需的最小相邻交换次数。
如果无法重排 nums 来获得有效排列，则返回 -1。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
nums 中的所有元素都是 唯一 的

统计奇数和偶数的频次，再分类讨论。
时间复杂度 O(n)。
 */