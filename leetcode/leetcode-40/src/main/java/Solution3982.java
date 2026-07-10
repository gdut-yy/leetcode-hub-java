public class Solution3982 {
    public int maxDigitRange(int[] nums) {
        int maxD = 0;
        int ans = 0;
        for (int x : nums) {
            int y = x;
            int mx = -1, mn = 10;
            while (x > 0) {
                int d = x % 10;
                mx = Math.max(mx, d);
                mn = Math.min(mn, d);
                x /= 10;
            }
            int curD = mx - mn;
            if (curD > maxD) {
                maxD = curD;
                ans = y;
            } else if (curD == maxD) {
                ans += y;
            }
        }
        return ans;
    }
}
/*
3982. 最大数字范围的整数之和
https://leetcode.cn/problems/sum-of-integers-with-maximum-digit-range/description/

第 509 场周赛 T1。

给你一个整数数组 nums。
一个整数的 数字范围 定义为其 最大 数字与 最小 数字之间的差。
例如，5724 的数字范围为 7 - 2 = 5。
返回 nums 中所有 数字范围 等于数组中 最大数字范围 的整数之和。
提示：
1 <= nums.length <= 100
10 <= nums[i] <= 10^5

模拟。
时间复杂度 O(nlogU)，其中 n 是 nums 的长度，U=max(nums)。
 */