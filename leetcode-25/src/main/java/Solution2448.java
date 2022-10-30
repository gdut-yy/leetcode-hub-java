import java.util.Arrays;

public class Solution2448 {
    private int[] nums;
    private int[] cost;

    public long minCost(int[] nums, int[] cost) {
        this.nums = nums;
        this.cost = cost;

        int min = Arrays.stream(nums).min().orElseThrow();
        int max = Arrays.stream(nums).max().orElseThrow();

        int left = min;
        int right = max;
        long lans = f(right);
        long rans = f(left);
        while (left < right) {
            int lmid = left + (right - left) / 3;
            int rmid = right - (right - left) / 3;
            lans = f(lmid);
            rans = f(rmid);

            if (lans <= rans) {
                right = rmid - 1;
            } else {
                left = lmid + 1;
            }
        }
        return Math.min(lans, rans);
    }

    // 使 nums 中所有元素 相等 且值为 mid 时的开销
    private long f(int mid) {
        long res = 0L;
        for (int i = 0; i < nums.length; i++) {
            res += (long) Math.abs(nums[i] - mid) * cost[i];
        }
        return res;
    }
}
/*
2448. 使数组相等的最小开销
https://leetcode.cn/problems/minimum-cost-to-make-array-equal/

第 316 场周赛 T3。

给你两个下标从 0 开始的数组 nums 和 cost ，分别包含 n 个 正 整数。
你可以执行下面操作 任意 次：
将 nums 中 任意 元素增加或者减小 1 。
对第 i 个元素执行一次操作的开销是 cost[i] 。
请你返回使 nums 中所有元素 相等 的 最少 总开销。
提示：
n == nums.length == cost.length
1 <= n <= 10^5
1 <= nums[i], cost[i] <= 10^6

凹函数，三分法取最小值。
时间复杂度 O(nlogn)
 */