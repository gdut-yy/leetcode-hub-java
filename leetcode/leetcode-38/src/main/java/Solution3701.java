public class Solution3701 {
    public int alternatingSum(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) ans += nums[i];
            else ans -= nums[i];
        }
        return ans;
    }
}
/*
3701. 计算交替和
https://leetcode.cn/problems/compute-alternating-sum/description/

第 470 场周赛 T1。

给你一个整数数组 nums。
交替和 定义为：将 nums 中偶数下标位置的元素 相加 ，减去 奇数下标位置的元素。即：nums[0] - nums[1] + nums[2] - nums[3]...
返回表示 nums 的交替和的整数。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 100

中国时间 2025-10-05 周日 10:30
湖南。
模拟。
时间复杂度 O(n)。
 */