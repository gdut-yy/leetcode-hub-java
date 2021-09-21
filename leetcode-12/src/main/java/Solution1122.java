public class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 计算频次
        int[] cnt = new int[1001];
        for (int num : arr1) {
            cnt[num]++;
        }
        int idx = 0;
        for (int num : arr2) {
            while (cnt[num] > 0) {
                arr1[idx] = num;
                idx++;
                cnt[num]--;
            }
        }
        // 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾
        for (int i = 0; i < cnt.length; i++) {
            while (cnt[i] > 0) {
                arr1[idx] = i;
                idx++;
                cnt[i]--;
            }
        }
        return arr1;
    }
}
/*
1122. 数组的相对排序
https://leetcode-cn.com/problems/relative-sort-array/

给你两个数组，arr1 和arr2，

arr2 中的元素各不相同
arr2 中的每个元素都出现在 arr1 中
对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾

计数排序
时间复杂度 O(m+n)
时间复杂度 O(1) 1001 为常数
 */