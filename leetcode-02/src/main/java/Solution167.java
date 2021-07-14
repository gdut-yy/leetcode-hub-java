import java.util.Arrays;

public class Solution167 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int cur = numbers[i];
            int want = target - cur;
            // 有可能不是严格递增，但因为 i 是从左到右的，如果 right 等于 i，那么 right = i + 1 即可；如果 right 不等于 i，无需处理
            int right = Arrays.binarySearch(numbers, want);
            if (right >= 0) {
                if (right == i) {
                    right = i + 1;
                }
                return new int[]{i + 1, right + 1};
            }
        }
        return new int[]{-1, -1};
    }
}
/*
167. 两数之和 II - 输入有序数组
https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/

第 1 题两数之和的简化版。没错，确实是简化版，区别在于第 1 题数组无序，这题数组有序。
利用二分搜索，时间复杂度可以从 O(n) 下降至 O(logn)
 */