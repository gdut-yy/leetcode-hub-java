public class Solution1477 {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        // f[i] 表示 [0, i) 之间最短的和为 target 的子数组长度
        int[] f = new int[n + 1];
        f[0] = n + 1;

        int left = 0, right = 0;
        int sum = 0;
        int min = n + 1;
        while (right < n) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left];
                left++;
            }
            if (sum == target) {
                min = Math.min(min, (right - left + 1) + f[left]);
                f[right + 1] = Math.min(f[right], right - left + 1);
            } else {
                f[right + 1] = f[right];
            }
            right++;
        }
        return (min == n + 1) ? -1 : min;
    }
}
/*
1477. 找两个和为目标值且不重叠的子数组
https://leetcode.cn/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/

给你一个整数数组 arr 和一个整数值 target 。
请你在 arr 中找 两个互不重叠的子数组 且它们的和都等于 target 。可能会有多种方案，请你返回满足要求的两个子数组长度和的 最小值 。
请返回满足要求的最小长度和，如果无法找到这样的两个子数组，请返回 -1 。
提示：
1 <= arr.length <= 10^5
1 <= arr[i] <= 1000
1 <= target <= 10^8

双指针 + 动态规划
时间复杂度 O(n)
 */