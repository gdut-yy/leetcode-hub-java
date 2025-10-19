public class Solution3698 {
    public long splitArray(int[] nums) {
        int n = nums.length;
        long[] ps = new long[n + 1];
        for (int i = 0; i < n; i++) {
            ps[i + 1] = ps[i] + nums[i];
        }

        boolean[] L = new boolean[n];
        L[0] = true;
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] && (nums[i] > nums[i - 1]);
        }
        boolean[] R = new boolean[n + 1];
        R[n] = true;
        R[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] && (nums[i] > nums[i + 1]);
        }

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long lsum = ps[i + 1];
            long rsum = ps[n] - ps[i + 1];
            if (L[i] && R[i + 1]) {
                ans = Math.min(ans, Math.abs(lsum - rsum));
            }
        }
        return ans == Long.MAX_VALUE ? -1 : ans;
    }
}
/*
3698. 分割数组得到最小绝对差
https://leetcode.cn/problems/split-array-with-minimum-difference/description/

第 469 场周赛 T2。

给你一个整数数组 nums。
将数组 恰好 分成两个子数组 left 和 right ，使得 left 严格递增 ，right 严格递减 。
返回 left 与 right 的元素和之间 绝对差值的最小可能值 。如果不存在有效的分割方案，则返回 -1 。
子数组 是数组中连续的非空元素序列。
当数组中每个元素都严格大于其前一个元素（如果存在）时，称该数组为严格递增。
当数组中每个元素都严格小于其前一个元素（如果存在）时，称该数组为严格递减。
提示：
2 <= nums.length <= 10^5
1 <= nums[i] <= 10^5

前后缀分解。
时间复杂度 O(n)。
 */