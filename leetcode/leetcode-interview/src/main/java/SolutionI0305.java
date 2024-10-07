import java.util.PriorityQueue;

public class SolutionI0305 {
    static class SortedStack {
        PriorityQueue<Integer> pq;

        public SortedStack() {
            pq = new PriorityQueue<>();
        }

        public void push(int val) {
            pq.add(val);
        }

        public void pop() {
            if (pq.isEmpty()) return;
            pq.remove();
        }

        public int peek() {
            if (pq.isEmpty()) return -1;
            return pq.peek();
        }

        public boolean isEmpty() {
            return pq.isEmpty();
        }
    }
}
/*
面试题 03.05. 栈排序
https://leetcode.cn/problems/sort-of-stacks-lcci/description/

栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。
说明:
栈中的元素数目在[0, 5000]范围内。

优先队列 模拟。
 */