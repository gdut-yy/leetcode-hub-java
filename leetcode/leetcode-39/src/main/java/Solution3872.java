public class Solution3872 {
    public int longestArithmetic(int[] nums) {
        int n = nums.length;
        int[] leftLen = new int[n];
        int[] leftDiff = new int[n];
        leftLen[0] = 1;
        for (int i = 1; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if (leftLen[i - 1] == 1) {
                leftLen[i] = 2;
                leftDiff[i] = diff;
            } else {
                if (diff == leftDiff[i - 1]) {
                    leftLen[i] = leftLen[i - 1] + 1;
                    leftDiff[i] = diff;
                } else {
                    leftLen[i] = 2;
                    leftDiff[i] = diff;
                }
            }
        }
        int[] rightLen = new int[n];
        int[] rightDiff = new int[n];
        rightLen[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            int diff = nums[i + 1] - nums[i];
            if (rightLen[i + 1] == 1) {
                rightLen[i] = 2;
                rightDiff[i] = diff;
            } else {
                if (diff == rightDiff[i + 1]) {
                    rightLen[i] = rightLen[i + 1] + 1;
                    rightDiff[i] = diff;
                } else {
                    rightLen[i] = 2;
                    rightDiff[i] = diff;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, leftLen[i]);
        }
        if (n >= 2) {
            ans = Math.max(ans, 1 + rightLen[1]);
            ans = Math.max(ans, leftLen[n - 2] + 1);
        }
        for (int i = 1; i <= n - 2; i++) {
            int L = leftLen[i - 1];
            int R = rightLen[i + 1];
            int diffLR = nums[i + 1] - nums[i - 1];
            ans = Math.max(ans, L + 1);
            ans = Math.max(ans, 1 + R);
            if (L >= 2 && R >= 2 && leftDiff[i - 1] == rightDiff[i + 1] && diffLR == 2L * leftDiff[i - 1]) {
                ans = Math.max(ans, L + 1 + R);
            }
            if (L >= 2 && diffLR == 2L * leftDiff[i - 1]) {
                ans = Math.max(ans, L + 2);
            }
            if (R >= 2 && diffLR == 2L * rightDiff[i + 1]) {
                ans = Math.max(ans, R + 2);
            }
            if (diffLR % 2 == 0) {
                ans = Math.max(ans, 3);
            }
        }
        return ans;
    }
}
/*
3872. 替换最多一个元素后的最长等差子数组
https://leetcode.cn/problems/longest-arithmetic-sequence-after-changing-at-most-one-element/description/

第 493 场周赛 T3。

给你一个整数数组 nums。
如果子数组中相邻元素的差值是一个常数，那么这个子数组被称为 等差子数组。
你可以将 nums 中的 最多 一个元素替换为任意一个 整数。然后，从 nums 中选择一个等差子数组。
返回一个整数，该整数表示你可以选择的 最长 等差子数组的长度。
子数组 是数组中一段连续的元素序列。

前后缀分解。
https://chat.deepseek.com/a/chat/s/dee18f63-0ea1-488f-ab0b-af831e1c4178
时间复杂度 O(n)。
 */