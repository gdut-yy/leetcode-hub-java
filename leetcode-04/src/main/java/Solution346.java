import java.util.ArrayDeque;
import java.util.Queue;

public class Solution346 {
    /**
     * 剑指 Offer II 041. 滑动窗口的平均值
     * https://leetcode.cn/problems/qIsx9U/
     */
    static class MovingAverage {
        private final Queue<Integer> queue;
        private final int capacity;
        private int sum = 0;

        public MovingAverage(int size) {
            this.capacity = size;
            this.queue = new ArrayDeque<>();
        }

        public double next(int val) {
            if (queue.size() == this.capacity) {
                sum -= queue.remove();
            }
            queue.add(val);
            sum += val;
            return sum / (double) queue.size();
        }
    }
}
/*
$346. 数据流中的移动平均值
https://leetcode.cn/problems/moving-average-from-data-stream/

队列
滑动窗口的平均值
 */