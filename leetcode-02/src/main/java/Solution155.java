import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Solution155 {
    static class MinStack {
        Deque<Integer> stack1;
        Deque<Integer> stack2;

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
            return stack1.peek();
        }

        public int getMin() {
            return stack2.peek();
        }
    }
}
/*
155. 最小栈
https://leetcode-cn.com/problems/min-stack/

设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。

双栈实现最小栈。
相似题目: 剑指 Offer 30. 包含min函数的栈
https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
面试题 03.02. 栈的最小值
https://leetcode-cn.com/problems/min-stack-lcci/
 */
