import java.util.ArrayDeque;
import java.util.Deque;

public class Solution225 {
    static class MyStack {
        private final Deque<Integer> deque;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            deque = new ArrayDeque<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            deque.push(x);
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return deque.pop();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return deque.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return deque.isEmpty();
        }
    }
}
/*
225. 用队列实现栈
https://leetcode-cn.com/problems/implement-stack-using-queues/

孪生题: 第 232 题 https://leetcode-cn.com/problems/implement-queue-using-stacks/
（实际工程中意义不大）

jdk 官方推荐使用 Deque 去实现 Stack
 */