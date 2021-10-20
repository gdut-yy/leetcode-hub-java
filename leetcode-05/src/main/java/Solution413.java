public class Solution413 {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int diff = nums[0] - nums[1];
        int times = 0;
        int res = 0;
        // 最少 3 个数
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 1] - nums[i] == diff) {
                times++;
            } else {
                diff = nums[i - 1] - nums[i];
                times = 0;
            }
            res += times;
        }
        return res;
    }
}
/*
413. 等差数列划分
https://leetcode-cn.com/problems/arithmetic-slices/

如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。

差分+计数。
时间复杂度 O(n)
空间复杂度 O(1)
 */