public class Solution3987 {
    private static final int MOD = (int) (1e9 + 7);

    public int minimumCost(int[] nums, int k) {
        long sum = 0;
        for (int x : nums) {
            sum += x;
        }
        long t = (sum - 1) / k % MOD;
        int inv2 = (MOD + 1) / 2;
        return Math.toIntExact(t * (1 + t) % MOD * inv2 % MOD);
    }
}
/*
3987. 处理所有元素的成本
https://leetcode.cn/problems/minimum-total-cost-to-process-all-elements/description/

第 510 场周赛 T2。

给你一个整数数组 nums 和一个整数 k。
初始时，你拥有 k 单位的资源。
你必须从左到右依次处理 nums 中的元素。处理第 i 个元素需要消耗 nums[i] 单位的资源。
如果当前可用资源少于 nums[i]，你可以执行一次操作，使可用资源增加 k。k 的值固定不变。第一次执行该操作的成本为 1，第二次的成本为 2，依此类推。
处理完第 i 个元素后，可用资源会减少 nums[i]。
返回处理完所有元素所需的 最小总成本。由于答案可能很大，请返回其对 10^9 + 7 取模后的结果。
提示：
1 <= nums.length <= 10^5
1 <= nums[i] <= 10^9
1 <= k <= 10^9

脑筋急转弯。
时间复杂度 O(n)。
 */