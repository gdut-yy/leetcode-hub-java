public class Solution4067 {
    private static final int MX = 500;

    public int maxSubarray(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[MX + 1];
        int r = 0;
        int ans = 0;

        for (int l = 0; l < n; l++) {
            while (r < n && canAdd(cnt, nums[r])) {
                cnt[nums[r]]++;
                r++;
            }
            ans = Math.max(ans, r - l);
            cnt[nums[l]]--;
        }
        return ans;
    }

    private boolean canAdd(int[] count, int v) {
        for (int a = 1; a <= v / 2; a++) {
            int b = v - a;
            if (a == b) {
                if (count[a] >= 2) {
                    return false;
                }
            } else if (count[a] > 0 && count[b] > 0) {
                return false;
            }
        }
        for (int a = 1; v + a <= MX; a++) {
            if (count[a] > 0 && count[v + a] > 0) {
                return false;
            }
        }
        return true;
    }
}
/*
4067. 数对和受限的最长子数组
https://leetcode.cn/problems/longest-subarray-with-restricted-pair-sums/description/

第 521 场周赛 T3。

给你一个整数数组 nums。
如果不存在三个 互不相同 的下标 i、j 和 k，满足 l <= i, j, k <= r 且：
- nums[i] + nums[j] == nums[k]
则 子数组 nums[l..r] 是 有效 子数组。
返回 nums 中有效子数组的 最大 长度。
子数组 是数组中一个连续 非空 元素序列。
示例 1：
输入： nums = [2,3,5,3,2,1]
输出： 3
示例 2：
输入： nums = [3,4,5,6]
输出： 4
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 500

滑动窗口。
时间复杂度：O(n^2+U)。
 */