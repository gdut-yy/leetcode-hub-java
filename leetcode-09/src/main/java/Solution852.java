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
}
/*
852. 山脉数组的峰顶索引
https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/

第 89 场周赛 T1。
题目数据保证 arr 是一个山脉数组。
845 题简化版。差分数组时间复杂度 O(n)
二分搜索，时间复杂度 O(logn)
 */