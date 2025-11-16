public class Solution3738 {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;

        int[] pre = new int[n];
        pre[0] = 1;
        for (int i = 1; i <= n - 2; i++) {
            if (nums[i - 1] <= nums[i]) {
                pre[i] = pre[i - 1] + 1;
            } else {
                pre[i] = 1;
            }
        }

        int[] suf = new int[n];
        suf[n - 1] = 1;
        for (int i = n - 2; i >= 1; i--) {
            if (nums[i] <= nums[i + 1]) {
                suf[i] = suf[i + 1] + 1;
            } else {
                suf[i] = 1;
            }
        }

        int ans = 0;
        for (int i = 1; i <= n - 2; i++) {
            ans = Math.max(ans, pre[i] + 1);
            ans = Math.max(ans, suf[i] + 1);
            if (nums[i - 1] <= nums[i + 1]) {
                ans = Math.max(ans, pre[i - 1] + 1 + suf[i + 1]);
            }
        }
        return ans;
    }
}
/*
3738. 替换至多一个元素后最长非递减子数组
https://leetcode.cn/problems/longest-non-decreasing-subarray-after-replacing-at-most-one-element/description/

第 169 场双周赛 T3。

给你一个整数数组 nums。
你被允许 最多 将数组中的一个元素替换为任何其他整数值。
返回在执行至多一次替换后，可以获得的 最长非递减子数组 的长度。
子数组 是数组中的一段连续的元素序列。
如果数组中的每个元素都大于或等于其前一个元素（如果存在），则称该数组为 非递减 的。
提示:
1 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

前后缀分解。
时间复杂度 O(n)。
 */