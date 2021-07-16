public class Solution1822 {
    public int arraySign(int[] nums) {
        int len = nums.length;
        // 统计 < 0 的个数
        int cnt = 0;
        for (int num : nums) {
            // 剪枝
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                cnt++;
            }
        }
        if (cnt % 2 == 0) {
            return 1;
        }
        return -1;
    }
}
/*
1822. 数组元素积的符号
https://leetcode-cn.com/problems/sign-of-the-product-of-an-array/

周赛签到题。正数个数无须统计，因为怎么乘也是正数。
统计负数的个数，若为个数为奇数，则结果为负数
如果中途出现 0，根据 0 乘以任何数都得 0，剪枝返回
 */