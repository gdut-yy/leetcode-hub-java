import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SolutionI0303 {
    static class StackOfPlates {
        int cap;
        List<Deque<Integer>> sts;

        public StackOfPlates(int cap) {
            sts = new ArrayList<>();
            this.cap = cap;
        }

        public void push(int val) {
            if (cap == 0) return;
            if (sts.isEmpty() || sts.get(sts.size() - 1).size() == cap) {
                sts.add(new ArrayDeque<>());
            }
            sts.get(sts.size() - 1).push(val);
        }

        public int pop() {
            return popAt(sts.size() - 1);
        }

        public int popAt(int index) {
            if (cap == 0) return -1;
            if (sts.isEmpty()) return -1;
            if (index > sts.size() - 1) return -1;
            int pop = sts.get(index).pop();
            if (sts.get(index).isEmpty()) sts.remove(index);
            return pop;
        }
    }
}
/*
面试题 03.03. 堆盘子
https://leetcode.cn/problems/stack-of-plates-lcci/description/

堆盘子。设想有一堆盘子，堆太高可能会倒下来。因此，在现实生活中，盘子堆到一定高度时，我们就会另外堆一堆盘子。请实现数据结构SetOfStacks，模拟这种行为。SetOfStacks应该由多个栈组成，并且在前一个栈填满时新建一个栈。此外，SetOfStacks.push()和SetOfStacks.pop()应该与普通栈的操作方法相同（也就是说，pop()返回的值，应该跟只有一个栈时的情况一样）。 进阶：实现一个popAt(int index)方法，根据指定的子栈，执行pop操作。
当某个栈为空时，应当删除该栈。当栈中没有元素或不存在该栈时，pop，popAt 应返回 -1.

数组模拟。注意 cap 为 0 的情况。
 */