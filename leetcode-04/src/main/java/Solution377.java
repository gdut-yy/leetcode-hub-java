public class Solution377 {
    public int combinationSum4(int[] nums, int target) {
        // 完全背包
        // f[j] 表示和为 i 的排列的数目
        int[] f = new int[target + 1];
        f[0] = 1;
        for (int j = 1; j <= target; j++) {
            for (int wi : nums) {
                if (j >= wi) {
                    f[j] += f[j - wi];
                }
            }
        }
        return f[target];
    }
}
/*
377. 组合总和 Ⅳ
https://leetcode.cn/problems/combination-sum-iv/

给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
题目数据保证答案符合 32 位整数范围。
提示：
1 <= nums.length <= 200
1 <= nums[i] <= 1000
nums 中的所有元素 互不相同
1 <= target <= 1000

动态规划。完全背包。
参考第 322 题 https://leetcode.cn/problems/coin-change/
f(i) 表示和为 i 的排列的数目
当 nums[j] <= i 时，f(i) = ∑f(i-nums[j])
 */