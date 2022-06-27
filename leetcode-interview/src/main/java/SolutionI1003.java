public class SolutionI1003 {
    public int search(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
}
/*
面试题 10.03. 搜索旋转数组
https://leetcode.cn/problems/search-rotate-array-lcci/

搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，
假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。

相似题目: 81. 搜索旋转排序数组 II
https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/
 */