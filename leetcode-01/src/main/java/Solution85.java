import java.util.ArrayDeque;
import java.util.Deque;

public class Solution85 {
    public int maximalRectangle(String[] matrix) {
        char[][] chars = new char[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            chars[i] = matrix[i].toCharArray();
        }
        return maximalRectangle(chars);
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int matrixM = matrix.length;
        int matrixN = matrix[0].length;

        int[] heights = new int[matrixN];
        int maxArea = 0;
        for (char[] row : matrix) {
            for (int i = 0; i < matrixN; i++) {
                if (row[i] == '0') {
                    heights[i] = 0;
                } else {
                    heights[i]++;
                }
            }
            maxArea = Math.max(maxArea, solution84largestRectangleArea(heights));
        }
        return maxArea;
    }

    public int solution84largestRectangleArea(int[] heights) {
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
}
/*
85. 最大矩形
https://leetcode-cn.com/problems/maximal-rectangle/

转化成第 84 题的场景求解。
 */