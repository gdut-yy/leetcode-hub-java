import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class SolutionO30 {
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
            int pop = stack1.pop();
            if (Objects.equals(stack2.peek(), pop)) {
                stack2.pop();
            }
        }

        public int top() {
            return stack1.peek();
        }

        public int min() {
            return stack2.peek();
        }
    }
}
/*
剑指 Offer 30. 包含min函数的栈
https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/

定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

同: 155. 最小栈
https://leetcode.cn/problems/min-stack/
注意函数名差异。
 */