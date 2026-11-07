public class Solution4088 {
    public int peakValleyDifference(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) ans += nums[i];
            if (nums[i] < nums[i - 1] && nums[i] < nums[i + 1]) ans -= nums[i];
        }
        return ans;
    }
}
/*
4088. 峰值与谷值的差
https://leetcode.cn/problems/difference-between-peaks-and-valleys/description/

第 194 场双周赛 T1。

给你一个长度为 n 的整数数组 nums。
如果满足以下 所有 条件，则下标 i 被称为 峰值 ：
- 0 < i < n - 1
- nums[i] > nums[i - 1]
- nums[i] > nums[i + 1]
如果满足以下 所有 条件，则下标 i 被称为 谷值 ：
- 0 < i < n - 1
- nums[i] < nums[i - 1]
- nums[i] < nums[i + 1]
返回一个整数，表示所有峰值之和与所有谷值之和的 差值 。
示例 1：
输入： nums = [1,5,2,4,1,3,0]
输出： 9
示例 2：
输入： nums = [-5,-6,-1,-2,5,3,2]
输出： 12
示例 3：
输入： nums = [6,5,2,5,5,3,6]
输出： -5
提示：
3 <= n == nums.length <= 100
-100 <= nums[i] <= 100

模拟。
时间复杂度 O(n)。
 */