public class Solution4 {
    // 时间复杂度 O(m+n)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergeSortedArray = mergeSortedArrays(nums1, nums2);
        int len = mergeSortedArray.length;
        if (len % 2 == 1) {
            return mergeSortedArray[len / 2];
        } else {
            return (mergeSortedArray[len / 2 - 1] + mergeSortedArray[len / 2]) / 2.0;
        }
    }

    // 合并两个有序数组
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

    private int len1;
    private int len2;

    // 时间复杂度 O(log(m+n))
    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        len1 = nums1.length;
        len2 = nums2.length;
        int totalLen = len1 + len2;
        if (totalLen % 2 == 1) {
            return getKthElement(nums1, nums2, totalLen / 2 + 1);
        } else {
            return (getKthElement(nums1, nums2, totalLen / 2) + getKthElement(nums1, nums2, totalLen / 2 + 1)) / 2.0;
        }
    }

    // 主要思路：要找到第 k (k>1) 小的元素，那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
    // 这里的 "/" 表示整除
    // nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
    // nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
    // 取 pivot = min(pivot1, pivot2)，两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
    // 这样 pivot 本身最大也只能是第 k-1 小的元素
    // 如果 pivot = pivot1，那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums1 数组
    // 如果 pivot = pivot2，那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除"，剩下的作为新的 nums2 数组
    private int getKthElement(int[] nums1, int[] nums2, int k) {
        int idx1 = 0;
        int idx2 = 0;

        while (true) {
            // 边界情况
            if (idx1 == len1) {
                return nums2[idx2 + k - 1];
            }
            if (idx2 == len2) {
                return nums1[idx1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[idx1], nums2[idx2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(idx1 + half, len1) - 1;
            int newIndex2 = Math.min(idx2 + half, len2) - 1;
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            if (pivot1 <= pivot2) {
                k -= (newIndex1 - idx1 + 1);
                idx1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - idx2 + 1);
                idx2 = newIndex2 + 1;
            }
        }
    }
}
/*
4. 寻找两个正序数组的中位数
https://leetcode.cn/problems/median-of-two-sorted-arrays/

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