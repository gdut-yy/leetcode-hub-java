import java.util.Arrays;

public class Solution3795 {
    public int minLength(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0, minLen = n + 1;
        int mx = Arrays.stream(nums).max().orElseThrow();
        int[] cnt = new int[mx + 1];
        long sum = 0;
        while (r < n) {
            // 入
            cnt[nums[r]]++;
            if (cnt[nums[r]] == 1) sum += nums[r];
            while (sum >= k) {
                // 更新答案
                minLen = Math.min(minLen, r - l + 1);
                // 出
                cnt[nums[l]]--;
                if (cnt[nums[l]] == 0) sum -= nums[l];
                l++;
            }
            r++;
        }
        return minLen == n + 1 ? -1 : minLen;
    }
}
/*
3795. 不同元素和至少为 K 的最短子数组长度
https://leetcode.cn/problems/minimum-subarray-length-with-distinct-sum-at-least-k/description/

第 173 场双周赛 T2。

给你一个整数数组 nums 和一个整数 k。
返回一个 子数组 的 最小 长度，使得该子数组中出现的 不同 值之和（每个值只计算一次）至少 为 k。如果不存在这样的子数组，则返回 -1。
子数组 是数组中一个连续的 非空 元素序列。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
1 <= k <= 10^9

滑动窗口。
时间复杂度 O(n)。
 */