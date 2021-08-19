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

二分搜索。
 */
