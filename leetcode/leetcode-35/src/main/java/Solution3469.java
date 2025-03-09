import java.util.Arrays;

public class Solution3469 {
    private int n;
    private int[] nums;
    private int[][] memo;

    public int minCost(int[] nums) {
        n = nums.length;
        this.nums = nums;
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(1, 0);
    }

    private int dfs(int i, int j) {
        if (i == n) return nums[j];
        if (i == n - 1) return Math.max(nums[j], nums[i]);
        if (memo[i][j] != -1) return memo[i][j];
        int a = nums[j], b = nums[i], c = nums[i + 1];
        // 移除 a,b
        int res = dfs(i + 2, i + 1) + Math.max(a, b);
        // 移除 a,c
        res = Math.min(res, dfs(i + 2, i) + Math.max(a, c));
        // 移除 b,c
        res = Math.min(res, dfs(i + 2, j) + Math.max(b, c));
        return memo[i][j] = res;
    }
}
/*
3469. 移除所有数组元素的最小代价
https://leetcode.cn/problems/find-minimum-cost-to-remove-array-elements/description/

第 151 场双周赛 T3。

给你一个整数数组 nums。你的任务是在每一步中执行以下操作之一，直到 nums 为空，从而移除 所有元素 ：
- 从 nums 的前三个元素中选择任意两个元素并移除它们。此操作的成本为移除的两个元素中的 最大值 。
- 如果 nums 中剩下的元素少于三个，则一次性移除所有剩余元素。此操作的成本为剩余元素中的 最大值 。
返回移除所有元素所需的最小成本。
提示：
1 <= nums.length <= 1000
1 <= nums[i] <= 10^6

记忆化搜索，边界挺难写的。
时间复杂度 O(n^2)。
rating 2115 (clist.by)
 */