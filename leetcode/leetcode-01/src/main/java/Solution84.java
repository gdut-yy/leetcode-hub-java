import java.util.ArrayDeque;
import java.util.Deque;

public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!st.isEmpty() && st.peek() != -1 && heights[st.peek()] >= heights[i]) {
                int height = heights[st.pop()];
                int width = i - st.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }
        while (!st.isEmpty() && st.peek() != -1) {
            int height = heights[st.pop()];
            int width = heights.length - st.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }
}
/*
84. 柱状图中最大的矩形
https://leetcode.cn/problems/largest-rectangle-in-histogram/

给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
求在该柱状图中，能够勾勒出来的矩形的最大面积。
提示：
1 <= heights.length <=10^5
0 <= heights[i] <= 10^4

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