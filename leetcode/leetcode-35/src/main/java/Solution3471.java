import java.util.Arrays;

public class Solution3471 {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[51];
        for (int v : nums) cnt[v]++;

        int ans = -1;
        if (k == n) {
            return Arrays.stream(nums).max().orElseThrow();
        } else if (k == 1) {
            for (int v : nums) {
                if (cnt[v] == 1) ans = Math.max(ans, v);
            }
            return ans;
        } else {
            if (cnt[nums[0]] == 1) ans = Math.max(ans, nums[0]);
            if (cnt[nums[n - 1]] == 1) ans = Math.max(ans, nums[n - 1]);
            return ans;
        }
    }
}
/*
3471. 找出最大的几近缺失整数
https://leetcode.cn/problems/find-the-largest-almost-missing-integer/description/

第 439 场周赛 T1。

给你一个整数数组 nums 和一个整数 k 。
如果整数 x 恰好仅出现在 nums 中的一个大小为 k 的子数组中，则认为 x 是 nums 中的几近缺失（almost missing）整数。
返回 nums 中 最大的几近缺失 整数，如果不存在这样的整数，返回 -1 。
子数组 是数组中的一个连续元素序列。
提示：
1 <= nums.length <= 50
0 <= nums[i] <= 50
1 <= k <= nums.length

分类讨论。特别容易漏掉 k == n 的情况。
时间复杂度 O(n)。
 */
