public class Solution908 {
    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        if (max - min > k * 2) {
            return max - min - k * 2;
        }
        return 0;
    }
}
/*
908. 最小差值 I
https://leetcode-cn.com/problems/smallest-range-i/

第 103 场周赛 T1。

给你一个整数数组 nums，请你给数组中的每个元素 nums[i] 都加上一个任意数字 x （-k <= x <= k），从而得到一个新数组 result 。
返回数组 result 的最大值和最小值之间可能存在的最小差值。

加上一个任意数字 x （-k <= x <= k）
因此相差 2k 以内的可以看成被 “抹平”
 */