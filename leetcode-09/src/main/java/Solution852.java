public class Solution852 {
    public int peakIndexInMountainArray(int[] arr) {
        int len = arr.length;
        // 差分数组
        int[] diff = new int[len];
        diff[0] = arr[0];
        for (int i = 1; i < len; i++) {
            diff[i] = arr[i] - arr[i - 1];
        }
        for (int top = 1; top <= len - 1; top++) {
            boolean isTop = diff[top] > 0 && diff[top + 1] < 0;
            if (isTop) {
                return top;
            }
        }
        return -1;
    }

    /**
     * 二分查找
     * 时间复杂度 O(logn)
     */
    public int peakIndexInMountainArray2(int[] arr) {
        int len = arr.length;
        int left = 1;
        int right = len - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1]) {
                return mid;
            } else if (arr[mid] > arr[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
/*
852. 山脉数组的峰顶索引
https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/

第 89 场周赛 T1。

符合下列属性的数组 arr 称为 山脉数组 ：
- arr.length >= 3
- 存在 i（0 < i < arr.length - 1）使得：
  - arr[0] < arr[1] < ... arr[i-1] < arr[i]
  - arr[i] > arr[i+1] > ... > arr[arr.length - 1]
给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 。

题目数据保证 arr 是一个山脉数组。
差分数组时间复杂度 O(n)
二分查找，时间复杂度 O(logn)

相似题目: 845. 数组中的最长山脉
https://leetcode-cn.com/problems/longest-mountain-in-array/
 */