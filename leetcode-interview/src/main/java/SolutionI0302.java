import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class SolutionI0302 {
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

        public void push(int x) {
            stack1.push(x);
            if (stack2.isEmpty() || stack2.peek() >= x) {
                stack2.push(x);
            }
        }

        public void pop() {
            if (Objects.equals(stack1.pop(), stack2.peek())) {
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
面试题 03.02. 栈的最小值
https://leetcode-cn.com/problems/min-stack-lcci/

请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。
执行push、pop和min操作的时间复杂度必须为O(1)。

同: 155. 最小栈
https://leetcode-cn.com/problems/min-stack/
 */