import java.util.ArrayDeque;
import java.util.Deque;

public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1
                    && heights[stack.peek()] >= heights[i]) {
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        while (stack.peek() != -1) {
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new Solution84().largestRectangleArea(new int[]{3, 2, 5, 4, 6, 1, 4, 2}));
    }
}
/*
84. 柱状图中最大的矩形
https://leetcode-cn.com/problems/largest-rectangle-in-histogram/

单调栈
heights: [3, 2, 5, 4, 6, 1, 4, 2]
index:    0  1  2  3  4  5  6  7

[-1, 3(0)]              => 3 * 1 = 3
[-1, 2(1), 5(2)]        => 5 * 1 = 5
[-1, 2(1), 4(3), 6(4)]  => 6 * 1 = 6
[-1, 2(1)]              => 4 * 3 = 12
[-1]                    => 2 * 5 = 10
[-1, 1(5)]              => 4
[-1, 1(5)]              => 4
[-1]                    => 8
 */