import java.util.Arrays;
import java.util.TreeMap;

public class Solution34 {
    /**
     * 二分查找
     * 时间复杂度 O(logn)
     *
     * @param nums   升序排列的整数数组 nums
     * @param target 目标值 target
     * @return 给定目标值在数组中的开始位置和结束位置
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
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return left;
    }

    private static int binarySearchRightBound(int[] nums, int target) {
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

    /**
     * TreeMap
     * 时间复杂度 O(nlogn)
     *
     * @param nums   升序排列的整数数组 nums
     * @param target 目标值 target
     * @return 给定目标值在数组中的开始位置和结束位置
     */
    public int[] searchRange2(int[] nums, int target) {
        TreeMap<Integer, int[]> treeMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            int[] startEnd = treeMap.getOrDefault(nums[i], new int[]{i, i});
            startEnd[1] = i;
            treeMap.put(nums[i], startEnd);
        }
        return treeMap.getOrDefault(target, new int[]{-1, -1});
    }
}
/*
34. 在排序数组中查找元素的第一个和最后一个位置
https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/

二分搜索找左/右边界
 */