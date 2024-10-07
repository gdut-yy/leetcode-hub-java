import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SolutionI0301 {
    static class TripleInOne {
        int stackSize;
        Deque<Integer>[] sts;

        public TripleInOne(int stackSize) {
            sts = new Deque[3];
            Arrays.setAll(sts, e -> new ArrayDeque<>());
            this.stackSize = stackSize;
        }

        public void push(int stackNum, int value) {
            if (sts[stackNum].size() == stackSize) return;
            sts[stackNum].push(value);
        }

        public int pop(int stackNum) {
            if (sts[stackNum].isEmpty()) return -1;
            return sts[stackNum].pop();
        }

        public int peek(int stackNum) {
            if (sts[stackNum].isEmpty()) return -1;
            return sts[stackNum].peek();
        }

        public boolean isEmpty(int stackNum) {
            return sts[stackNum].isEmpty();
        }
    }
}
/*
面试题 03.01. 三合一
https://leetcode.cn/problems/three-in-one-lcci/description/

三合一。描述如何只用一个数组来实现三个栈。
你应该实现push(stackNum, value)、pop(stackNum)、isEmpty(stackNum)、peek(stackNum)方法。stackNum表示栈下标，value表示压入的值。
构造函数会传入一个stackSize参数，代表每个栈的大小。
提示：
0 <= stackNum <= 2
 */