import java.util.ArrayDeque;
import java.util.Deque;

public class Solution946 {
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
946. 验证栈序列
https://leetcode-cn.com/problems/validate-stack-sequences/

第 112 场周赛 T2。

给定 pushed 和 popped 两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false 。

使用栈进行模拟。栈都是按顺序入栈，出栈顺序类似单调栈即可。
 */