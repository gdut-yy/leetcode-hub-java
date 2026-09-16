import java.util.Arrays;

public class Solution4040 {
    public int minOperations(int[] nums, int sum) {
        final int INF = Integer.MAX_VALUE / 2;
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int x : nums) {
            for (int s = sum; s >= 1; s--) {
                int val = x, cost = 0;
                while (val > 0) {
                    if (val <= s) {
                        int cand = dp[s - val] + cost;
                        if (cand < dp[s]) dp[s] = cand;
                    }
                    val /= 2;
                    cost++;
                }
                val = x * 2;
                cost = 1;
                while (val <= s) {
                    int cand = dp[s - val] + cost;
                    if (cand < dp[s]) dp[s] = cand;
                    val *= 2;
                    cost++;
                }
            }
        }
        return dp[sum] == INF ? -1 : dp[sum];
    }
}
/*
4040. 构造子集和的最少操作次数 I
https://leetcode.cn/problems/minimum-operations-to-form-subset-sum-i/description/

第 517 场周赛 T3。

给你一个整数数组 nums 和一个整数 sum。
一次 操作 中，选择一个当前值为 x 的元素，并将其替换为 2 * x 或 floor(x / 2)。
对于每个元素，对其执行的所有 乘法 操作都必须发生在任何 除法 操作之前。
返回所需的 最少 操作次数，使得操作后的数组中存在一个 子集，其元素之和 恰好 等于 sum。如果无法做到，则返回 -1。
数组的 子集 是从数组中选择若干个元素得到的集合，也可以不选择任何元素。
floor() 函数返回除法结果的整数部分。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 500
1 <= sum <= 5000

分组背包。
 */