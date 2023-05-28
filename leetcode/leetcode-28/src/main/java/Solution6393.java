public class Solution6393 {
    public long maxStrength(int[] nums) {
        int n = nums.length;
        // 不能初始化为 0
        long max = nums[0];
        for (int mask = 1; mask < (1 << n); mask++) {
            long product = 1L;
            for (int k = 0; k < n; k++) {
                if ((mask >> k & 1) == 1) {
                    product *= nums[k];
                }
            }
            max = Math.max(max, product);
        }
        return max;
    }

    // O(n) DP 解法
    public long maxStrength2(int[] nums) {
        int n = nums.length;
        long max = nums[0], min = nums[0], ans = nums[0];
        for (int i = 1; i < n; i++) {
            long _max = max;
            max = Math.max(max, Math.max(nums[i], Math.max(max * nums[i], min * nums[i])));
            min = Math.min(min, Math.min(nums[i], Math.min(_max * nums[i], min * nums[i])));
        }
        return Math.max(ans, max);
    }
}
/*
6393. 一个小组的最大实力值
https://leetcode.cn/problems/maximum-strength-of-a-group/

第 105 场双周赛 T3。

给你一个下标从 0 开始的整数数组 nums ，它表示一个班级中所有学生在一次考试中的成绩。老师想选出一部分同学组成一个 非空 小组，且这个小组的 实力值 最大，
如果这个小组里的学生下标为 i0, i1, i2, ... , ik ，那么这个小组的实力值定义为 nums[i0] * nums[i1] * nums[i2] * ... * nums[ik] 。
请你返回老师创建的小组能得到的最大实力值为多少。
提示：
1 <= nums.length <= 13
-9 <= nums[i] <= 9

状态压缩枚举。
时间复杂度 O(2^n)
也有 O(n) DP 解法 和 O(n) 的贪心解法。
 */