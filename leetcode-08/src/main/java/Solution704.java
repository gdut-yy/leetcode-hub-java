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

二分搜索。一般而言，如果题目是精确二分，直接用 jdk Arrays#binarySearch(int[] a, int key) 即可
 */
