public class Solution4010 {
    public long maxPairStrength(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long gcd = getGCD(nums[i], nums[j]);
                long a = nums[i] / gcd;
                long b = nums[j] / gcd;
                ans = Math.max(ans, a * b);
            }
        }
        return ans;
    }

    private long getGCD(long num1, long num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
4010. 数对的最大强度
https://leetcode.cn/problems/maximize-pair-strength-using-gcd/description/

第 513 场周赛 T1。

给你一个整数数组 nums。
选择 恰好一对 不同下标 i 和 j。该数对的 强度 定义为：
(nums[i] * nums[j]) / gcd(nums[i], nums[j])2
返回所有可能数对中的 最大 强度。
gcd(a, b) 表示 a 和 b 的 最大公约数 。
提示：
2 <= nums.length <= 2000
1 <= nums[i] <= 10^5

枚举。
时间复杂度：O(n^2 * logU)。
 */