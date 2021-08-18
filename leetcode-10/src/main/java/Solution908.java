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

加上一个任意数字 x （-k <= x <= k）
因此相差 2k 以内的可以看成被 “抹平”
 */