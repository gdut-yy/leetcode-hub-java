public class Solution3688 {
    public int evenNumberBitwiseORs(int[] nums) {
        int ans = 0;
        for (int v : nums) {
            if (v % 2 == 0) {
                ans |= v;
            }
        }
        return ans;
    }
}
/*
3688. 偶数的按位或运算
https://leetcode.cn/problems/bitwise-or-of-even-numbers-in-an-array/description/

第 468 场周赛 T1。

给你一个整数数组 nums。
返回数组中所有 偶数 的按位 或 运算结果。
如果 nums 中没有偶数，返回 0。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100

中国时间 2025-09-21 周日 10:30
佛山。
模拟。
 */