import java.util.Deque;
import java.util.LinkedList;

public class SolutionO59_1 {
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
剑指 Offer 59 - I. 滑动窗口的最大值
https://leetcode.cn/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/

给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
示例:
输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7]

同: 239. 滑动窗口最大值
https://leetcode.cn/problems/sliding-window-maximum/
 */