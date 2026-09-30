public class SolutionP3972 {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        int ans = 0;

        // 枚举子数组和的十进制长度
        for (long low = x, high = x + 1; low <= sum[n]; low *= 10, high *= 10) {
            // 计算子数组和在 [low, high-1] 中，且子数组和模 10 为 x 的子数组个数
            int[] cnt = new int[10];
            int left1 = 0;
            int left2 = 0;
            for (long s : sum) {
                // 随着 s 的增大，<= s-high 的前缀和离开窗口，<= s-low 的前缀和进入窗口
                while (sum[left1] <= s - high) {
                    cnt[(int) (sum[left1] % 10)]--;
                    left1++;
                }
                while (sum[left2] <= s - low) {
                    cnt[(int) (sum[left2] % 10)]++;
                    left2++;
                }
                ans += cnt[(int) ((s - x + 10) % 10)];
            }
        }

        return ans;
    }
}
/*
$3972. 求和后首尾数字相同的有效子数组 II
https://leetcode.cn/problems/valid-subarrays-with-matching-sum-digits-ii/description/

给你一个整数数组 nums 和一个整数数字 x。
如果一个 子数组 nums[l..r] 的元素和同时满足以下两个条件，则认为该子数组是 有效子数组：
- 该和的首位数字等于 x。
- 该和的末位数字等于 x。
返回有效子数组的数量。
子数组 是数组中一个连续、非空 的元素序列。
示例 1：
输入： nums = [1,100,1], x = 1
输出： 4
示例 2：
输入： nums = [1], x = 2
输出： 0
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= x <= 9

前缀和 + 滑动窗口
相似题目: 3969. 求和后首尾数字相同的有效子数组 I
https://leetcode.cn/problems/valid-subarrays-with-matching-sum-digits-i/
 */