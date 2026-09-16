public class Solution4044 {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        long sum1 = 0;
        long sum2 = 0;
        int ans = 0;
        for (int i = n / 2; i < n * 2 - 1; i++) {
            // 1. 入
            sum1 += nums[(i - n / 2) % n];
            sum2 += nums[i % n];
            int left = i - n + 1;
            if (left < 0) { // 尚未形成第一个窗口
                continue;
            }
            // 2. 更新答案
            if (sum1 > sum2) {
                ans++;
            }
            // 3. 出
            sum1 -= nums[left];
            sum2 -= nums[(left + n / 2) % n];
        }
        return ans;
    }
}
/*
4044. 统计好循环移位的数量
https://leetcode.cn/problems/count-good-cyclic-rotations/description/

第 518 场周赛 T2。

给你一个长度为偶数 n 的整数数组 nums。
nums 的一次 循环移位 可以通过以下方式得到：选择 nums 的一个长度在 0 到 n - 1（包含两端）之间的 前缀 ，并将其移动到数组末尾，同时保持所有元素的相对顺序不变。
如果一次循环移位后的数组中，前 n / 2 个元素之和 严格大于 后 n / 2 个元素之和，则称该循环移位是 好循环移位 。
返回 nums 中好循环移位的数量。
数组的 前缀 是指从数组开头开始，并延伸到数组中某个位置的子数组。
子数组 是数组中一段连续的元素序列，可以为空。
提示：
2 <= n == nums.length <= 10^5
1 <= nums[i] <= 10^9
n 为偶数。

滑动窗口。
时间复杂度 O(n)。
 */