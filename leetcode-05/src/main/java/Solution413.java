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
- 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。
子数组 是数组中的一个连续序列。
提示：
1 <= nums.length <= 5000
-1000 <= nums[i] <= 1000

差分+计数。
时间复杂度 O(n)
空间复杂度 O(1)
 */