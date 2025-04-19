public class Solution3502 {
    public int[] minCosts(int[] cost) {
        int n = cost.length;
        int[] ans = new int[n];
        int mn = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            mn = Math.min(mn, cost[i]);
            ans[i] = mn;
        }
        return ans;
    }
}
/*
3502. 到达每个位置的最小费用
https://leetcode.cn/problems/minimum-cost-to-reach-every-position/description/

第 443 场周赛 T1。

给你一个长度为 n 的整数数组 cost 。当前你位于位置 n（队伍的末尾），队伍中共有 n + 1 人，编号从 0 到 n 。
你希望在队伍中向前移动，但队伍中每个人都会收取一定的费用才能与你 交换位置。与编号 i 的人交换位置的费用为 cost[i] 。
你可以按照以下规则与他人交换位置：
- 如果对方在你前面，你 必须 支付 cost[i] 费用与他们交换位置。
- 如果对方在你后面，他们可以免费与你交换位置。
返回一个大小为 n 的数组 answer，其中 answer[i] 表示到达队伍中每个位置 i 所需的 最小 总费用。
提示
1 <= n == cost.length <= 100
1 <= cost[i] <= 100

贪心。本质是前缀最小值。
时间复杂度 O(n)。
 */