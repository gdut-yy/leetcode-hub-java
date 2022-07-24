import java.util.ArrayDeque;
import java.util.Deque;

public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;

        // 前 k 个
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }

        int[] res = new int[len - k + 1];
        res[0] = nums[deque.getFirst()];

        // k+1 到 len
        for (int i = k; i < len; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);

            while (deque.getFirst() <= i - k) {
                deque.removeFirst();
            }
            res[i - k + 1] = nums[deque.getFirst()];
        }
        return res;
    }
}
/*
239. 滑动窗口最大值
https://leetcode.cn/problems/sliding-window-maximum/

给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
滑动窗口每次只向右移动一位。
返回滑动窗口中的最大值。
提示：
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
1 <= k <= nums.length

单调队列。
nums [1, 3, -1, -3, 5, 3, 6, 7]
idx  [0, 1,  2,  3, 4, 5, 6, 7]
res      3   3   5  5  6  7
idx0: deque:[0] 1
idx1: deque:[1] 3
idx2: deque:[1,2] 3,-1
idx3: deque:[1,2,3] 3,-1,-3
idx4: deque:[4] 5
idx5: deque:[4,5] 5,3
idx6: deque:[6] 6
idx7: deque:[7] 7
 */