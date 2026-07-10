public class Solution3979 {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        int mx = 0;
        int ans = 0;
        for (int j = 0; j < n; j++) {
            if (j >= k) {
                mx = Math.max(mx, nums[j - k]);
                ans = Math.max(ans, nums[j] + mx);
            }
        }
        return ans;
    }
}
/*
3979. 最大有效数对和
https://leetcode.cn/problems/maximum-valid-pair-sum/description/

第 186 场双周赛 T2。

给你一个长度为 n 的整数数组 nums 和一个整数 k 。
如果满足以下条件，则下标对 (i, j) 被称为 有效 的：
- 0 <= i < j < n
- j - i >= k
返回所有有效对中的 nums[i] + nums[j] 的 最大 值。
提示：
2 <= n == nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= n - 1

枚举右，维护左。
时间复杂度 O(n)。
 */