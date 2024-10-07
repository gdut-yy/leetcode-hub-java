import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionLCR184 {
    static class Checkout {
        private final Queue<Integer> q;
        private final Deque<Integer> dq;

        public Checkout() {
            q = new LinkedList<>();
            dq = new LinkedList<>();
        }

        public int get_max() {
            if (dq.isEmpty()) {
                return -1;
            }
            return dq.peekFirst();
        }

        public void add(int value) {
            while (!dq.isEmpty() && dq.peekLast() < value) {
                dq.pollLast();
            }
            dq.offerLast(value);
            q.offer(value);
        }

        public int remove() {
            if (q.isEmpty()) {
                return -1;
            }
            int ans = q.poll();
            if (ans == dq.peekFirst()) {
                dq.pollFirst();
            }
            return ans;
        }
    }
}
/*
LCR 184. 设计自助结算系统
https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof/

请设计一个自助结账系统，该系统需要通过一个队列来模拟顾客通过购物车的结算过程，需要实现的功能有：
- get_max()：获取结算商品中的最高价格，如果队列为空，则返回 -1
- add(value)：将价格为 value 的商品加入待结算商品队列的尾部
- remove()：移除第一个待结算的商品价格，如果队列为空，则返回 -1
注意，为保证该系统运转高效性，以上函数的均摊时间复杂度均为 O(1)
提示：
1 <= get_max, add, remove 的总操作数 <= 10000
1 <= value <= 10^5
 */