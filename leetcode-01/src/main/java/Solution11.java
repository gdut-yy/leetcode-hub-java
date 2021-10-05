public class Solution11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            // 木桶短板原理，取最小高度 * 宽度
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
/*
11. 盛最多水的容器
https://leetcode-cn.com/problems/container-with-most-water/

双指针。
两侧向中心移动。
 */