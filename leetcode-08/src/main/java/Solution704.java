import java.util.Arrays;

public class Solution704 {
    public int search(int[] nums, int target) {
        int res = Arrays.binarySearch(nums, target);
        return res >= 0 ? res : -1;
    }
}
/*
704. 二分查找
https://leetcode-cn.com/problems/binary-search/

给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

二分搜索。一般而言，如果题目是精确二分，直接用 jdk Arrays#binarySearch(int[] a, int key) 即可
 */
