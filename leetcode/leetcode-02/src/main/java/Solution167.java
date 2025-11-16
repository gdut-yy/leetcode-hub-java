public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target) {
                return new int[]{l + 1, r + 1};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{-1, -1};
    }
}
/*
167. 两数之和 II - 输入有序数组
https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/

给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。
如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
你所设计的解决方案必须只使用常量级的额外空间。
提示：
2 <= numbers.length <= 3 * 10^4
-1000 <= numbers[i] <= 1000
numbers 按 非递减顺序 排列
-1000 <= target <= 1000
仅存在一个有效答案

双指针。
第 1 题两数之和的简化版。区别在于第 1 题数组无序，这题数组有序。
HashMap 解法: 时间复杂度 O(n)
二分搜索解法: 时间复杂度 O(nlogn), 本题二分搜索并不是优选方法
时间复杂度 O(n)
 */