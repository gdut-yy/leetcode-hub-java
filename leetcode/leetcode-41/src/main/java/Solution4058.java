public class Solution4058 {
    public long maxValue(int[] nums) {
        int n = nums.length;
        long pulse = 0;
        long pre = 0;
        long minEvenSum = Long.MAX_VALUE;
        long maxPreEven = 0;
        long maxPreOdd = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            long b = ((i & 1) == 0) ? nums[i] : -(long) nums[i];
            pulse += b;
            pre += b;
            int end = i + 1;
            if ((end & 1) == 0) {
                minEvenSum = Math.min(minEvenSum, pre - maxPreEven);
                maxPreEven = Math.max(maxPreEven, pre);
            } else {
                if (maxPreOdd != Long.MIN_VALUE) {
                    minEvenSum = Math.min(minEvenSum, pre - maxPreOdd);
                }
                maxPreOdd = Math.max(maxPreOdd, pre);
            }
        }
        if (minEvenSum != Long.MAX_VALUE) {
            long gain = -2 * minEvenSum;
            if (gain > 0) {
                pulse += gain;
            }
        }
        return pulse;
    }
}
/*
4058. 一个子数组循环移动后的最大脉冲值
https://leetcode.cn/problems/maximum-pulse-value-after-one-subarray-rotation/description/

第 520 场周赛 T3。

给你一个长度为 n 的整数数组 nums。
定义整数数组 arr 的 脉冲值 为从下标 0 开始的 交替和 ：pulse(arr) = arr[0] - arr[1] + arr[2] - arr[3] + ...
你可以对 nums 执行 至多一次 操作：
- 选择两个下标 l 和 r，满足 0 <= l < r <= n - 1。
- 将子数组 nums[l..r] 循环左移恰好 一个位置。例如，[a, b, c, d] 变为 [b, c, d, a]。
返回执行 至多一次 该操作后可以获得的 最大脉冲值。
子数组 是数组中连续且 非空 的元素序列。
示例 1：
输入：nums = [1,5,2]
输出：6
示例 2：
输入：nums = [6,4,3]
输出：7
示例 3：
输入：nums = [9,7]
输出：2
提示：
1 <= n == nums.length <= 10^5
-10^9 <= nums[i] <= 10^9

最大子数组和。
时间复杂度 O(n)。
 */