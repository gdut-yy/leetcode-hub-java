import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Solution155 {
    static class MinStack {
        private final Deque<Integer> stack1;
        private final Deque<Integer> stack2;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack1 = new ArrayDeque<>();
            stack2 = new ArrayDeque<>();
        }

        public void push(int val) {
            stack1.push(val);
            if (stack2.isEmpty() || stack2.peek() >= val) {
                stack2.push(val);
            }
        }

        public void pop() {
            int pop = stack1.pop();
            if (Objects.equals(stack2.peek(), pop)) {
                stack2.pop();
            }
        }

        public int top() {
            if (!stack1.isEmpty()) {
                return stack1.peek();
            }
            return -1;
        }

        public int getMin() {
            if (!stack2.isEmpty()) {
                return stack2.peek();
            }
            return -1;
        }
    }
}
/*
155. 最小栈
https://leetcode.cn/problems/min-stack/

设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
实现 MinStack 类:
- MinStack() 初始化堆栈对象。
- void push(int val) 将元素val推入堆栈。
- void pop() 删除堆栈顶部的元素。
- int top() 获取堆栈顶部的元素。
- int getMin() 获取堆栈中的最小元素。
提示：
-2^31 <= val <= 2^31 - 1
pop、top 和 getMin 操作总是在 非空栈 上调用
push, pop, top, and getMin最多被调用 3 * 10^4 次

双栈实现最小栈。
相似题目: 剑指 Offer 30. 包含min函数的栈
https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/
面试题 03.02. 栈的最小值
https://leetcode.cn/problems/min-stack-lcci/
 */
