import java.util.Stack;

public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        // 单调栈
        Stack<Integer> stack = new Stack<>();
        for (int i = len * 2 - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i % len]) {
                stack.pop();
            }
            if (!stack.empty()) {
                res[i % len] = stack.peek();
            } else {
                res[i % len] = -1;
            }
            stack.push(nums[i % len]);
        }
        return res;
    }
}
/*
503. 下一个更大元素 II
https://leetcode-cn.com/problems/next-greater-element-ii/

单调栈。
第 496 题升级版。循环数组可用 i % len 下标进行处理
 */