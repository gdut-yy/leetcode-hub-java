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
使用栈进行模拟。栈都是按顺序入栈，出栈顺序类似单调栈即可。
 */