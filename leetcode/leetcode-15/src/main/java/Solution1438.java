import java.util.ArrayDeque;
import java.util.Deque;

public class Solution1438 {
    public int longestSubarray(int[] nums, int limit) {
        int len = nums.length;

        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();

        int max = 0;
        // 双指针
        int left = 0;
        int right = 0;
        while (right < len) {
            // 滑动窗口最大值
            while (!deque1.isEmpty() && nums[right] > deque1.getLast()) {
                deque1.removeLast();
            }
            deque1.addLast(nums[right]);
            // 滑动窗口最小值
            while (!deque2.isEmpty() && nums[right] < deque2.getLast()) {
                deque2.removeLast();
            }
            deque2.addLast(nums[right]);

            // 左指针右移
            while (!deque1.isEmpty() && !deque2.isEmpty()
                    && deque1.getFirst() - deque2.getFirst() > limit) {
                if (nums[left] == deque1.getFirst()) {
                    deque1.removeFirst();
                }
                if (nums[left] == deque2.getFirst()) {
                    deque2.removeFirst();
                }
                left++;
            }

            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}
/*
1438. 绝对差不超过限制的最长连续子数组
https://leetcode.cn/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

给你一个整数数组 nums ，和一个表示限制的整数 limit，请你返回最长连续子数组的长度，该子数组中的任意两个元素之间的绝对差必须小于或者等于 limit 。
如果不存在满足条件的子数组，则返回 0 。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
0 <= limit <= 10^9

单调队列
时间复杂度 O(n)
相似题目: 239. 滑动窗口最大值
https://leetcode.cn/problems/sliding-window-maximum/
 */