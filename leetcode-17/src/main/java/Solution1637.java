import java.util.Arrays;

public class Solution1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        int len = points.length;
        int[] xAxis = new int[len];
        for (int i = 0; i < len; i++) {
            xAxis[i] = points[i][0];
        }
        Arrays.sort(xAxis);
        int max = 0;
        for (int i = 1; i < len; i++) {
            max = Math.max(max, xAxis[i] - xAxis[i - 1]);
        }
        return max;
    }
}
/*
1637. 两点之间不包含任何点的最宽垂直面积
https://leetcode-cn.com/problems/widest-vertical-area-between-two-points-containing-no-points/

给你 n 个二维平面上的点 points ，其中 points[i] = [xi, yi] ，请你返回两点之间内部不包含任何点的 最宽垂直面积 的宽度。
垂直面积 的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。 最宽垂直面积 为宽度最大的一个垂直面积。
请注意，垂直区域 边上 的点 不在 区域内。

排序后扫描线。
 */