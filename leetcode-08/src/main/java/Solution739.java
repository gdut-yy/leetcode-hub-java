import java.util.Stack;

public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] res = new int[len];
        // 单调栈 存放数组元素下标而非数组元素
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.empty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            if (!stack.empty()) {
                res[i] = stack.peek() - i;
            } else {
                res[i] = 0;
            }
            stack.push(i);
        }
        return res;
    }
}
/*
739. 每日温度
https://leetcode-cn.com/problems/daily-temperatures/

单调栈。
解法同第 496、503 题，本题存放数组元素下标而非数组元素
 */