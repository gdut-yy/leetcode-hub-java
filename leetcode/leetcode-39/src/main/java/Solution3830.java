public class Solution3830 {
    public int longestAlternating(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] left_up = new int[n];
        int[] left_down = new int[n];
        int[] right_up = new int[n];
        int[] right_down = new int[n];
        left_up[0] = 1;
        left_down[0] = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] < nums[i]) {
                left_up[i] = left_down[i - 1] + 1;
            } else {
                left_up[i] = 1;
            }
            if (nums[i - 1] > nums[i]) {
                left_down[i] = left_up[i - 1] + 1;
            } else {
                left_down[i] = 1;
            }
        }
        right_up[n - 1] = 1;
        right_down[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                right_up[i] = right_down[i + 1] + 1;
            } else {
                right_up[i] = 1;
            }
            if (nums[i] > nums[i + 1]) {
                right_down[i] = right_up[i + 1] + 1;
            } else {
                right_down[i] = 1;
            }
        }
        int ans = 1;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, Math.max(left_up[i], left_down[i]));
        }
        for (int k = 0; k < n; k++) {
            if (k - 1 >= 0 && k + 1 < n) {
                if (nums[k - 1] > nums[k + 1]) {
                    ans = Math.max(ans, left_up[k - 1] + right_up[k + 1]);
                } else if (nums[k - 1] < nums[k + 1]) {
                    ans = Math.max(ans, left_down[k - 1] + right_down[k + 1]);
                }
            }
        }
        return ans;
    }
}
/*
3830. 移除至多一个元素后的最长交替子数组
https://leetcode.cn/problems/longest-alternating-subarray-after-removing-at-most-one-element/description/

第 487 场周赛 T4。

给你一个整数数组nums。
如果一个子数组nums[l..r]满足以下条件之一，则称其为 交替子数组：
- nums[l] < nums[l + 1] > nums[l + 2] < nums[l + 3] > ...
- nums[l] > nums[l + 1] < nums[l + 2] > nums[l + 3] < ...
换句话说，如果我们比较子数组中的相邻元素，这些比较在严格大于和严格小于之间交替进行，则该子数组是交替的。
你可以从数组nums中最多移除一个元素。然后，你需要从nums中选择一个交替子数组。
返回一个整数，表示你可以选择的最长交替子数组的长度。
子数组 是数组中连续的一段元素。
长度为 1 的子数组被认为是交替的。
提示：
2 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

前后缀分解
https://chat.deepseek.com/a/chat/s/766c36d8-f9fd-4c3a-9878-1400f09ec698
时间复杂度 O(n)。
rating 2186 (clist.by)
 */