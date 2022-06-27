public class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int leftSum = 0;
        int rightSum = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            rightSum += 1 - nums[right];
            while (leftSum < rightSum - k) {
                leftSum += 1 - nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
/*
1004. 最大连续1的个数 III
https://leetcode.cn/problems/max-consecutive-ones-iii/

第 126 场周赛 T3。

给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
返回仅包含 1 的最长（连续）子数组的长度。
输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
输出：6

滑动窗口。
时间复杂度 O(n)
空间复杂度 O(1)
 */