import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionI0304 {
    static class MyQueue {
        private final Deque<Integer> stack1;
        private final Deque<Integer> stack2;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stack1.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            peek();
            return stack2.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            // 如果 stack2 空栈，将 stack1 的全部出栈并入栈到 stack2
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}
/*
面试题 03.04. 化栈为队
https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci/

实现一个MyQueue类，该类用两个栈来实现一个队列。

同: 232. 用栈实现队列
https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */