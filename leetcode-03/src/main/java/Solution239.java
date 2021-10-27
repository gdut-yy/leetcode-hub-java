import java.util.Deque;
import java.util.LinkedList;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) {
            return nums;
        }
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[len - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < len; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
/*
239. 滑动窗口最大值
https://leetcode-cn.com/problems/sliding-window-maximum/

给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。
 */