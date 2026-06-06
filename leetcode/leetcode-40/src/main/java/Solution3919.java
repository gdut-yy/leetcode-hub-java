public class Solution3919 {
    public int[] minCost(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] closest = new int[n];
        closest[0] = 1;
        closest[n - 1] = n - 2;
        for (int i = 1; i < n - 1; i++) {
            long dL = (long) nums[i] - nums[i - 1];
            long dR = (long) nums[i + 1] - nums[i];
            closest[i] = (dL <= dR) ? i - 1 : i + 1;
        }

        long[] rightCost = new long[n - 1]; // i -> i+1
        long[] leftCost = new long[n - 1];  // i+1 -> i
        for (int i = 0; i < n - 1; i++) {
            long diff = (long) nums[i + 1] - nums[i];
            boolean iToRight = closest[i] == i + 1;
            boolean iplus1ToLeft = closest[i + 1] == i;

            if (iToRight && iplus1ToLeft) {
                rightCost[i] = 1;
                leftCost[i] = 1;
            } else if (iToRight) {
                rightCost[i] = 1;
                leftCost[i] = diff;
            } else if (iplus1ToLeft) {
                rightCost[i] = diff;
                leftCost[i] = 1;
            } else {
                rightCost[i] = diff;
                leftCost[i] = diff;
            }
        }

        long[] prefRight = new long[n];
        long[] prefLeft = new long[n];
        for (int i = 0; i < n - 1; i++) {
            prefRight[i + 1] = prefRight[i] + rightCost[i];
            prefLeft[i + 1] = prefLeft[i] + leftCost[i];
        }

        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            int u = queries[i][0], v = queries[i][1];
            long cost;
            if (u < v) {
                cost = prefRight[v] - prefRight[u];
            } else if (u > v) {
                cost = prefLeft[u] - prefLeft[v];
            } else {
                cost = 0;
            }
            ans[i] = (int) cost;
        }
        return ans;
    }
}
/*
3919. 在下标间移动的最小代价
https://leetcode.cn/problems/minimum-cost-to-move-between-indices/description/

第 500 场周赛 T3。

给你一个整数数组 nums，nums 是 严格递增 的。
对于每个下标 x，设 closest(x) 为使得 abs(nums[x] - nums[y]) 最小化 的 相邻 下标 y。如果两个 相邻 下标的差值相同，则选择 较小 的下标。
从任意下标 x 出发，你可以通过以下两种方式移动：
- 移动到任意下标 y，代价为 abs(nums[x] - nums[y])，或者
- 移动到 closest(x)，代价为 1。
同时给你一个二维整数数组 queries，其中每个 queries[i] = [li, ri]。
对于每个查询，计算从下标 li 移动到下标 ri 的 最小总代价。
返回一个整数数组 ans，其中 ans[i] 是第 i 个查询的答案。
两个值 x 和 y 之间的 绝对差 定义为 abs(x - y)。
提示：
2 <= nums.length <= 10^5
-10^9 <= nums[i] <= 10^9
nums 严格递增
1 <= queries.length <= 10^5
queries[i] = [li, ri]
0 <= li, ri < nums.length

贪心 + 前缀和
https://chat.deepseek.com/a/chat/s/83681c2d-1e38-44fa-86dd-0c6276eba43f
时间复杂度 O(n+q)。
 */