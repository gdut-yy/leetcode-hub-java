public class Solution3866 {
    public int firstUniqueEven(int[] nums) {
        int[] cnt = new int[101];
        for (int v : nums) {
            cnt[v]++;
        }
        for (int v : nums) {
            if (v % 2 == 0 && cnt[v] == 1) return v;
        }
        return -1;
    }
}
/*
3866. 找到第一个唯一偶数
https://leetcode.cn/problems/first-unique-even-element/description/

第 178 场双周赛 T1。

给你一个整数数组 nums。
请你返回一个整数，表示 nums 中出现 恰好 一次的第一个 偶数（以数组下标最早为准）。如果不存在这样的整数，返回 -1。
如果一个整数 x 能被 2 整除，那么它就被认为是 偶数。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100

模拟。统计频次。
时间复杂度 O(n)。
 */