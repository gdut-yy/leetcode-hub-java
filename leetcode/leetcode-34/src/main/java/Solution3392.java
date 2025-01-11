public class Solution3392 {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i + 1 < n; i++) {
            if ((nums[i - 1] + nums[i + 1]) * 2 == nums[i]) {
                ans++;
            }
        }
        return ans;
    }
}
/*
3392. 统计符合条件长度为 3 的子数组数目
https://leetcode.cn/problems/count-subarrays-of-length-three-with-a-condition/description/

第 146 场双周赛 T1。

给你一个整数数组 nums ，请你返回长度为 3 的 子数组，满足第一个数和第三个数的和恰好为第二个数的一半。
子数组 指的是一个数组中连续 非空 的元素序列。
提示：
3 <= nums.length <= 100
-100 <= nums[i] <= 100

模拟。
时间复杂度 O(n)。
 */