import java.util.Arrays;
import java.util.Comparator;

public class Solution3644 {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;
        Arrays.sort(ids, Comparator.comparingInt(o -> nums[o]));

        int and = -1;
        for (int i = 0; i < n; i++) {
            int j = ids[i];
            if (nums[i] != nums[j]) {
                int k = nums[i] & nums[j];
                and &= k;
            }
        }
        return and == -1 ? 0 : and;
    }
}
/*
3644. 排序排列
https://leetcode.cn/problems/maximum-k-to-sort-a-permutation/description/

第 462 场周赛 T2。

给你一个长度为 n 的整数数组 nums，其中 nums 是范围 [0..n - 1] 内所有数字的一个 排列 。
你可以在满足条件 nums[i] AND nums[j] == k 的情况下交换下标 i 和 j 的元素，其中 AND 表示按位与操作，k 是一个非负整数。
返回可以使数组按 非递减 顺序排序的最大值 k（允许进行任意次这样的交换）。如果 nums 已经是有序的，返回 0。
排列 是数组所有元素的一种重新排列。
提示：
1 <= n == nums.length <= 10^5
0 <= nums[i] <= n - 1
nums 是从 0 到 n - 1 的一个排列。

脑筋急转弯。猜规律。
时间复杂度 O(n)。
 */