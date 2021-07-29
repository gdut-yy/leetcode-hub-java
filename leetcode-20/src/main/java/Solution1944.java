import java.util.Stack;

public class Solution1944 {
    public int[] canSeePersonsCount(int[] heights) {
        int len = heights.length;
        int[] res = new int[len];
        // 单调栈
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= heights[i]) {
                // 单调栈中比自己低的都能看到
                res[i]++;
                stack.pop();
            }
            if (!stack.empty()) {
                // 能看到一个比自己高的
                res[i]++;
            }
            stack.push(heights[i]);
        }
        return res;
    }
}
/*
1944. 队列中可以看到的人数
https://leetcode-cn.com/problems/number-of-visible-people-in-a-queue/

第 57 场双周赛 T4。
单调栈。
 */