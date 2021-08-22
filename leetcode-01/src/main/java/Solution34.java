public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int left = binarySearchLeftBound(nums, target);
        int right = binarySearchRightBound(nums, target);
        if (left >= 0 && left < nums.length) {
            left = (nums[left] == target) ? left : -1;
        }
        if (right >= 0 && right < nums.length) {
            right = (nums[right] == target) ? right : -1;
        }
        return new int[]{left, right};
    }

    /*
     * 0 1 2 2 2 2 2 2 2 3 3 4 5
     *     2 2 2 2 2 2 2 3 3 4 5
     */
    private int binarySearchLeftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    /*
     * 0 1 2 2 2 2 2 2 2 3 3 4 5
     * 0 1 2 2 2 2 2 2 2
     */
    private int binarySearchRightBound(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left - 1;
    }
}
/*
34. 在排序数组中查找元素的第一个和最后一个位置
https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/

二分搜索找左/右边界
 */