public class Solution3550 {
    public int smallestIndex(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (digitSum(nums[i]) == i) {
                return i;
            }
        }
        return -1;
    }

    private int digitSum(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
/*
3550. 数位和等于下标的最小下标
https://leetcode.cn/problems/smallest-index-with-digit-sum-equal-to-index/description/

第 450 场周赛 T1。

给你一个整数数组 nums 。
返回满足 nums[i] 的数位和（每一位数字相加求和）等于 i 的 最小 下标 i 。
如果不存在满足要求的下标，返回 -1 。
提示：
1 <= nums.length <= 100
0 <= nums[i] <= 1000

模拟 遍历。
 */