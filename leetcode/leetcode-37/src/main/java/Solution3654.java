import java.util.Arrays;

public class Solution3654 {
    public long minArraySum(int[] nums, int k) {
        int n = nums.length;
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        long[] pre = new long[n + 1];
        pre[0] = 0;
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + nums[i - 1];
        }
        long[] dp = new long[n + 1];
        dp[0] = 0;
        long[] maxVal = new long[k];
        Arrays.fill(maxVal, Long.MIN_VALUE);
        maxVal[0] = 0;
        for (int i = 1; i <= n; i++) {
            long mod = pre[i] % k;
            if (mod < 0) {
                mod += k;
            }
            int r = (int) mod;
            long candidate = Long.MIN_VALUE;
            if (maxVal[r] != Long.MIN_VALUE) {
                candidate = maxVal[r] + pre[i];
            }
            dp[i] = Math.max(candidate, dp[i - 1]);
            long current = dp[i] - pre[i];
            if (current > maxVal[r]) {
                maxVal[r] = current;
            }
        }
        return total - dp[n];
    }
}
/*
3654. 删除可整除和后的最小数组和
https://leetcode.cn/problems/minimum-sum-after-divisible-sum-deletions/description/

第 463 场周赛 T3。

给你一个整数数组 nums 和一个整数 k。
你可以 多次 选择 连续 子数组 nums，其元素和可以被 k 整除，并将其删除；每次删除后，剩余元素会填补空缺。
返回在执行任意次数此类删除操作后，nums 的最小可能 和。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^6
1 <= k <= 10^5

动态规划 + 前缀和
https://yuanbao.tencent.com/chat/naQivTmsDa/d4964cd6-d3d6-4ab2-936f-81f8f42fc512
时间复杂度 O(n)。
 */