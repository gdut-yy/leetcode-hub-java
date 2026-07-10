public class Solution3969 {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            int first = -1;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (first == -1) first = String.valueOf(sum).charAt(0) - '0';
                long last = sum % 10;
                if (first == last && last == x) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
/*
3969. 求和后首尾数字相同的有效子数组 I
https://leetcode.cn/problems/valid-subarrays-with-matching-sum-digits-i/

第 507 场周赛 T2。

给你一个整数数组 nums 和一个整数数字 x。
如果一个 子数组 nums[l..r] 的元素和同时满足以下两个条件，则认为该子数组是 有效子数组：
- 该和的首位数字等于 x。
- 该和的末位数字等于 x。
返回有效子数组的数量。
子数组 是数组中一个连续、非空 的元素序列。
提示：
1 <= nums.length <= 1500
1 <= nums[i] <= 10^9
1 <= x <= 9

暴力枚举。
时间复杂度 O(n^2 * logS)。
 */