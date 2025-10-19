public class Solution3712 {
    public int sumDivisibleByK(int[] nums, int k) {
        int[] cnt = new int[101];
        for (int v : nums) {
            cnt[v]++;
        }
        int ans = 0;
        for (int i = 1; i <= 100; i++) {
            if (cnt[i] % k == 0) {
                ans += i * cnt[i];
            }
        }
        return ans;
    }
}
/*
3712. 出现次数能被 K 整除的元素总和
https://leetcode.cn/problems/sum-of-elements-with-frequency-divisible-by-k/description/

第 471 场周赛 T1。

给你一个整数数组 nums 和一个整数 k。
请返回一个整数，表示 nums 中所有其 出现次数 能被 k 整除的元素的总和；如果没有这样的元素，则返回 0 。
注意： 若某个元素在数组中的总出现次数能被 k 整除，则它在求和中会被计算 恰好 与其出现次数相同的次数。
元素 x 的 出现次数 指它在数组中出现的次数。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100
1 <= k <= 100

模拟。
时间复杂度 O(n)。
 */