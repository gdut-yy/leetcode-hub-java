import java.util.Arrays;
import java.util.TreeMap;

public class Solution34 {
    /**
     * 二分查找
     * 时间复杂度 O(logn)
     */
    public int[] searchRange(int[] nums, int target) {
        if (Arrays.binarySearch(nums, target) < 0) {
            return new int[]{-1, -1};
        }
        int leftBound = binarySearchLeftBound(nums, target);
        int rightBound = binarySearchRightBound(nums, target);
        return new int[]{leftBound, rightBound};
    }

    private int binarySearchLeftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T] checkMid(mid) == T
            if (checkMid1(nums, target, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 左边界二分
        return left;
    }

    private boolean checkMid1(int[] nums, int target, int mid) {
        return nums[mid] >= target;
    }

    private int binarySearchRightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 边界二分 F, F,..., F, [T, T,..., T] checkMid(mid) == T
            if (!checkMid2(nums, target, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // 右边界二分
        return left - 1;
    }

    private boolean checkMid2(int[] nums, int target, int mid) {
        return nums[mid] <= target;
    }
}
/*
34. 在排序数组中查找元素的第一个和最后一个位置
https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/

给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回 [-1, -1]。
进阶：
你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
提示：
0 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums 是一个非递减数组
-10^9 <= target <= 10^9

二分搜索找左/右边界
相似题目: 剑指 Offer 53 - I. 在排序数组中查找数字 I
https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */