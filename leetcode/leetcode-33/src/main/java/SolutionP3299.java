public class SolutionP3299 {
    private static final int MOD = (int) (1e9 + 7);

    public int getSum(int[] nums) {
        int mx = 0;
        long sum = 0;
        for (int v : nums) {
            mx = Math.max(mx, v);
            sum += v;
        }
        long[] count1 = new long[mx + 2], dp1 = new long[mx + 2];
        long[] count2 = new long[mx + 2], dp2 = new long[mx + 2];

        for (int x : nums) {
            long c1 = count1[x - 1] + 1;
            dp1[x] += dp1[x - 1] + c1 * x;
            dp1[x] %= MOD;
            count1[x] += c1;

            long c2 = count2[x + 1] + 1;
            dp2[x] += dp2[x + 1] + c2 * x;
            dp2[x] %= MOD;
            count2[x] += c2;
        }

        long ans = 0;
        for (int x = 0; x <= mx; ++x) {
            ans += dp1[x] + dp2[x];
        }
        ans = ((ans - sum) % MOD + MOD) % MOD;
        return (int) ans;
    }
}
/*
$3299. 连续子序列的和
https://leetcode.cn/problems/sum-of-consecutive-subsequences/description/

如果一个长度为 n 的数组 arr 符合下面其中一个条件，可以称它 连续：
- 对于所有的 1 <= i < n，arr[i] - arr[i - 1] == 1。
- 对于所有的 1 <= i < n，arr[i] - arr[i - 1] == -1。
数组的 值 是其元素的和。
例如，[3, 4, 5] 是一个值为 12 的连续数组，并且 [9, 8] 是另一个值为 17 的连续数组。而 [3, 4, 3] 和 [8, 6] 都不连续。
给定一个整数数组 nums，返回所有 连续 非空 子序列 的 值 之和。
由于答案可能很大，返回它对 10^9 + 7 取模 的值。
注意 长度为 1 的数组也被认为是连续的。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

相似题目: $3284. 连续子数组的和
https://leetcode.cn/problems/sum-of-consecutive-subarrays/description/
 */