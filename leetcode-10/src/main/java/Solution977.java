public class Solution977 {
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int left = 0;
        int right = len - 1;
        int idx = len - 1;
        // 双指针 两侧向中心
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                res[idx] = nums[left] * nums[left];
                left++;
            } else {
                res[idx] = nums[right] * nums[right];
                right--;
            }
            idx--;
        }
        return res;
    }
}
/*
977. 有序数组的平方
https://leetcode.cn/problems/squares-of-a-sorted-array/

第 120 场周赛 T1。

给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
提示：
1 <= nums.length <= 10^4
-10^4 <= nums[i] <= 10^4
nums 已按 非递减顺序 排序
进阶：
请你设计时间复杂度为 O(n) 的算法解决本问题

双指针法，两侧向中心，这种方法无需处理某一指针移动至边界的情况。
时间复杂度 O(n)
空间复杂度 O(1)
 */