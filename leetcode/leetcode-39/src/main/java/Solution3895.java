public class Solution3895 {
    public int countDigitOccurrences(int[] nums, int digit) {
        int ans = 0;
        for (int v : nums) {
            while (v > 0) {
                int d = v % 10;
                if (d == digit) ans++;
                v /= 10;
            }
        }
        return ans;
    }
}
/*
3895. 统计数字出现总次数
https://leetcode.cn/problems/count-digit-appearances/description/

第 180 场双周赛 T2。

给你一个整数数组 nums 和一个整数 digit。
返回在 nums 所有元素的十进制表示中 digit 出现的总次数。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 10^6
0 <= digit <= 9

模拟。
时间复杂度 O(logn)。
 */