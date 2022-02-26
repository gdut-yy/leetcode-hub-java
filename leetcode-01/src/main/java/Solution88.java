public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p0 = nums1.length - 1;
        // 双指针
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] >= nums2[p2]) {
                nums1[p0] = nums1[p1];
                p1--;
            } else {
                nums1[p0] = nums2[p2];
                p2--;
            }
            p0--;
        }
        // 余下的继续补充完整
        while (p1 >= 0) {
            nums1[p0] = nums1[p1];
            p1--;
            p0--;
        }
        while (p2 >= 0) {
            nums1[p0] = nums2[p2];
            p2--;
            p0--;
        }
    }
}
/*
88. 合并两个有序数组
https://leetcode-cn.com/problems/merge-sorted-array/

给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。

双指针。
 */