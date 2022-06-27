import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionO59_2 {
    static class MaxQueue {
        private final Queue<Integer> queue;
        private final Deque<Integer> deque;

        public MaxQueue() {
            queue = new LinkedList<>();
            deque = new LinkedList<>();
        }

        public int max_value() {
            if (deque.isEmpty()) {
                return -1;
            }
            return deque.peekFirst();
        }

        public void push_back(int value) {
            while (!deque.isEmpty() && deque.peekLast() < value) {
                deque.pollLast();
            }
            deque.offerLast(value);
            queue.offer(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int ans = queue.poll();
            if (ans == deque.peekFirst()) {
                deque.pollFirst();
            }
            return ans;
        }
    }
}
/*
剑指 Offer 59 - II. 队列的最大值
https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/

请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
若队列为空，pop_front 和 max_value 需要返回 -1
 */