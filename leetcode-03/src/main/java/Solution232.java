import java.util.ArrayDeque;
import java.util.Deque;

public class Solution232 {
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
232. 用栈实现队列
https://leetcode-cn.com/problems/implement-queue-using-stacks/

孪生题: 第 225 题 https://leetcode-cn.com/problems/implement-stack-using-queues/
（实际工程中意义不大）

栈为先进后出，两个栈即可做到负负得正，先进先出

栈只有
push 压栈
pop 出栈
peek 查看栈顶
empty 判空
 */