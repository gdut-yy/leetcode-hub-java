public class Solution3984 {
    static final int MOD = (int) (1e9 + 7);

    public int divisibleGame(int[] nums) {
        int n = nums.length;
        int minVal = nums[0];
        int maxVal = nums[0];
        boolean allOne = true;
        for (int x : nums) {
            if (x < minVal) minVal = x;
            if (x > maxVal) maxVal = x;
            if (x != 1) allOne = false;
        }
        if (allOne) {
            long v = -minVal;
            v = (v % MOD + MOD) % MOD;
            v = v * 2 % MOD;
            return (int) v;
        }
        boolean[] valid = new boolean[maxVal + 1];
        for (int x : nums) {
            int limit = (int) Math.sqrt(x);
            for (int d = 1; d <= limit; d++) {
                if (x % d == 0) {
                    if (d > 1) valid[d] = true;
                    int e = x / d;
                    if (e > 1) valid[e] = true;
                }
            }
        }

        long bestDiff = Long.MIN_VALUE;
        int bestK = -1;
        for (int k = 2; k <= maxVal; k++) {
            if (!valid[k]) continue;
            long cur = 0;
            long maxSum = Long.MIN_VALUE;
            for (int v : nums) {
                long val = (v % k == 0) ? v : -v;
                cur = Math.max(val, cur + val);
                if (cur > maxSum) maxSum = cur;
            }
            if (maxSum > bestDiff) {
                bestDiff = maxSum;
                bestK = k;
            }
        }
        long ans = (bestDiff % MOD + MOD) % MOD;
        ans = ans * (bestK % MOD) % MOD;
        return (int) ans;
    }
}
/*
3984. 可整除游戏
https://leetcode.cn/problems/divisible-game/description/

第 509 场周赛 T3。

给你一个长度为 n 的整数数组 nums。
Alice 和 Bob 正在玩一个游戏。Alice 会选择：
- 一个整数 k，满足 k > 1。
- 两个整数 l 和 r，满足 0 <= l <= r < n。
初始时，Alice 和 Bob 的分数都为 0。
对于区间 [l, r]（包含两端）中的每个下标 i：
- 如果 nums[i] 能被 k 整除，则 Alice 的分数 增加 nums[i]。
- 否则，Bob 的分数 增加 nums[i]。
分数差 定义为 Alice 的分数 减去 Bob 的分数。
Alice 希望 最大化 分数差。如果有多个 k 可以达到 最大 分数差，她会选择其中 最小 的 k。
返回 最大 分数差与所选 k 的 乘积 。由于结果可能很大，请返回其对 109 + 7 取余数后的结果。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 10^6

枚举质因子 + 最大子数组和。
 */