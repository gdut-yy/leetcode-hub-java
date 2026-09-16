public class Solution4041 {
    public int minOperations(int[] nums, int sum) {
        final int INF = Integer.MAX_VALUE / 4;
        int[] dp = new int[sum + 1];
        java.util.Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int x : nums) {
            int[] ndp = dp.clone();
            int a = 0;
            long d = x;
            while (d >= 1) {
                long v = d;
                int b = 0;
                while (v <= sum) {
                    int cost = a + b;
                    int vv = (int) v;
                    for (int s = sum - vv; s >= 0; s--) {
                        if (dp[s] + cost < ndp[s + vv]) {
                            ndp[s + vv] = dp[s] + cost;
                        }
                    }
                    v <<= 1;
                    b++;
                }
                d >>= 1;
                a++;
            }
            dp = ndp;
        }
        return dp[sum] >= INF ? -1 : dp[sum];
    }
}
/*
4041. 构造子集和的最少操作次数 II
https://leetcode.cn/problems/minimum-operations-to-form-subset-sum-ii/description/

第 517 场周赛 T4。

给你一个整数数组 nums 和一个整数 sum。
一次 操作 中，选择一个当前值为 x 的元素，并将其替换为 2 * x 或 floor(x / 2)。
对于每个元素，乘法 操作和 除法 操作可以按照任意顺序执行。
返回所需的 最少 操作次数，使得操作后的数组中存在一个 子集，其元素之和 恰好 等于 sum。如果无法做到，则返回 -1。
数组的子集是从数组中选择若干个元素得到的集合，也可以不选择任何元素。
floor() 函数返回除法结果的整数部分。
提示：
1 <= nums.length <= 100
1 <= nums[i] <= 500
1 <= sum <= 5000

分组背包。
与 I 的区别在于：乘法 操作和 除法 操作可以按照任意顺序执行。
 */