import java.util.Arrays;

public class Solution3627 {
    public long maximumMedianSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long ans = 0;
        // bob 拿数量最少的三分之一
        for (int i = n / 3; i < n; i += 2) {
            ans += nums[i];
        }
        return ans;
    }
}
/*
3627. 中位数之和的最大值
https://leetcode.cn/problems/maximum-median-sum-of-subsequences-of-size-3/description/

第 460 场周赛 T1。

给你一个整数数组 nums，其长度可以被 3 整除。
你需要通过多次操作将数组清空。在每一步操作中，你可以从数组中选择任意三个元素，计算它们的 中位数 ，并将这三个元素从数组中移除。
奇数长度数组的 中位数 定义为数组按非递减顺序排序后位于中间的元素。
返回通过所有操作得到的 中位数之和的最大值 。
提示：
1 <= nums.length <= 5 * 10^5
nums.length % 3 == 0
1 <= nums[i] <= 10^9

贪心。
时间复杂度 O(nlogn)。
相似题目: 1561. 你可以获得的最大硬币数目
https://leetcode.cn/problems/maximum-number-of-coins-you-can-get/description/
 */