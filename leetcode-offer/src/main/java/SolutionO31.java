import java.util.ArrayDeque;
import java.util.Deque;

public class SolutionO31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int len = pushed.length;
        // 栈模拟
        Deque<Integer> stack = new ArrayDeque<>();
        int popIdx = 0;
        for (int push : pushed) {
            stack.push(push);
            while (!stack.isEmpty() && popIdx < len && stack.peek() == popped[popIdx]) {
                stack.pop();
                popIdx++;
            }
        }
        return popIdx == len;
    }
}
/*
剑指 Offer 31. 栈的压入、弹出序列
https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/

输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。

同: 946. 验证栈序列
https://leetcode-cn.com/problems/validate-stack-sequences/
 */