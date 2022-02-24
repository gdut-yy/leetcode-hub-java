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

请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
实现 MyQueue 类：
- void push(int x) 将元素 x 推到队列的末尾
- int pop() 从队列的开头移除并返回元素
- int peek() 返回队列开头的元素
- boolean empty() 如果队列为空，返回 true ；否则，返回 false
说明：
- 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
- 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。

（实际工程中意义不大）
栈为先进后出，两个栈即可做到负负得正，先进先出
jdk 官方推荐使用 Deque 去实现 Stack：
push 压栈
pop 出栈
peek 查看栈顶
empty 判空
相似题目: 225. 用队列实现栈
https://leetcode-cn.com/problems/implement-stack-using-queues/
 */