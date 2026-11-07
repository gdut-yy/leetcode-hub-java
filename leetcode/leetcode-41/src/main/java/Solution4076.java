public class Solution4076 {
    public int resilientSubarray(int[] nums, int k) {
        int ans = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int r = nums[i] % k;
            if (i > 0 && r == nums[i - 1] % k) {
                cnt++;
            } else { // 新的模 k 同余段
                cnt = 1;
            }
            // 去掉一个数后，剩余元素之和是 k 的倍数
            if (r * (cnt - 1) % k == 0) {
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}
/*
4076. 最长有韧性的子数组 II
https://leetcode.cn/problems/longest-resilient-subarray-ii/description/

第 193 场双周赛 T3。

给你一个整数数组 nums 和一个整数 k。
如果对一个子数组中的 每一个 元素，删除 该元素后，剩余 元素的 和能被 k 整除 ，那么称它是 有韧性的 。
对于长度为 1 的子数组，剩余元素的和为 0，可以被 k 整除。
返回 最长有韧性子数组 的长度。
子数组 是数组中连续的 非空 元素序列。
示例 1：
输入： nums = [2,4,6,3], k = 2
输出： 3
示例 2：
输入： nums = [1,4,7,1], k = 3
输出： 4
示例 3：
输入： nums = [5,5,4,8], k = 4
输出： 2
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^5
1 <= k <= 10^5

一次遍历。
时间复杂度 O(n)。
 */