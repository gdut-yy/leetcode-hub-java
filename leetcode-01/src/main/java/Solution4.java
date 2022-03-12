public class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergeSortedArray = mergeSortedArrays(nums1, nums2);
        int len = mergeSortedArray.length;
        if (len % 2 == 1) {
            return mergeSortedArray[len / 2];
        } else {
            return (mergeSortedArray[len / 2 - 1] + mergeSortedArray[len / 2]) / (double) 2;
        }
    }

    /**
     * 合并两个有序数组
     */
    private int[] mergeSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 == 0) {
            return nums2;
        }
        if (len2 == 0) {
            return nums1;
        }
        int[] res = new int[len1 + len2];
        // 双指针
        int p1 = 0;
        int p2 = 0;
        int i = 0;
        while (p1 < len1 && p2 < len2) {
            if (nums1[p1] <= nums2[p2]) {
                res[i] = nums1[p1];
                p1++;
            } else {
                res[i] = nums2[p2];
                p2++;
            }
            i++;
        }
        while (p1 < len1) {
            res[i] = nums1[p1];
            p1++;
            i++;
        }
        while (p2 < len2) {
            res[i] = nums2[p2];
            p2++;
            i++;
        }
        return res;
    }
}
/*
4. 寻找两个正序数组的中位数
https://leetcode-cn.com/problems/median-of-two-sorted-arrays/

给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
算法的时间复杂度应该为 O(log (m+n)) 。
提示：
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-10^6 <= nums1[i], nums2[i] <= 10^6

合并两个数组后，中位的下标即为中位数。
时间复杂度 O(m+n)
空间复杂度 O(m+n)
 */