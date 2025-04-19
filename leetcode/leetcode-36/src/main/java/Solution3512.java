import java.util.Arrays;

public class Solution3512 {
    public int minOperations(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        return sum % k;
    }
}
/*
3512. 使数组和能被 K 整除的最少操作次数
https://leetcode.cn/problems/minimum-operations-to-make-array-sum-divisible-by-k/description/

第 154 场双周赛 T1。

给你一个整数数组 nums 和一个整数 k。你可以执行以下操作任意次：
- 选择一个下标 i，并将 nums[i] 替换为 nums[i] - 1。
返回使数组元素之和能被 k 整除所需的最小操作次数。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 1000
1 <= k <= 100

数学，答案为 sum % k。
时间复杂度 O(n)。
 */