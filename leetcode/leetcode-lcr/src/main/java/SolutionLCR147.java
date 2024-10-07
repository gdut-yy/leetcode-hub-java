import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class SolutionLCR147 {
    static class MinStack {
        Deque<Integer> st1, st2;

        public MinStack() {
            st1 = new ArrayDeque<>();
            st2 = new ArrayDeque<>();
        }

        public void push(int x) {
            st1.push(x);
            if (st2.isEmpty() || st2.peek() >= x) {
                st2.push(x);
            }
        }

        public void pop() {
            int pop = st1.pop();
            if (Objects.equals(st2.peek(), pop)) {
                st2.pop();
            }
        }

        public int top() {
            return st1.peek();
        }

        public int getMin() {
            return st2.peek();
        }
    }
}
/*
LCR 147. 最小栈
https://leetcode.cn/problems/bao-han-minhan-shu-de-zhan-lcof/

请你设计一个 最小栈 。它提供 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
实现 MinStack 类:
MinStack() 初始化堆栈对象。
void push(int val) 将元素val推入堆栈。
void pop() 删除堆栈顶部的元素。
int top() 获取堆栈顶部的元素。
int getMin() 获取堆栈中的最小元素。

注意函数名差异。
同: 155. 最小栈
https://leetcode.cn/problems/min-stack/
 */