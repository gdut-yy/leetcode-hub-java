public class Solution42 {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        // 双指针
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                res += leftMax - height[left];
                left++;
            } else {
                res += rightMax - height[right];
                right--;
            }
        }
        return res;
    }
}
/*
42. 接雨水
https://leetcode-cn.com/problems/trapping-rain-water/

给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

双指针
时间复杂度 O(n)
空间复杂度 O(1)
 */