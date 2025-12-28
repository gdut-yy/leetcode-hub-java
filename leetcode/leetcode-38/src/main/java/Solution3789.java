public class Solution3789 {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long c1 = cost1, c2 = cost2, cb = costBoth;
        long n1 = need1, n2 = need2;
        long ans = Long.MAX_VALUE;
        ans = Math.min(ans, c1 * n1 + c2 * n2);
        ans = Math.min(ans, cb * n1 + c2 * Math.max(0, n2 - n1));
        ans = Math.min(ans, cb * n2 + c1 * Math.max(0, n1 - n2));
        return ans;
    }
}
/*
3789. 采购的最小花费
https://leetcode.cn/problems/minimum-cost-to-acquire-required-items/description/

第 482 场周赛 T2。

给你五个整数 cost1, cost2, costBoth, need1 和 need2。
有三种类型的物品可以购买：
- 类型 1 的物品花费 cost1，并仅满足类型 1 的需求 1 个单位。
- 类型 2 的物品花费 cost2，并仅满足类型 2 的需求 1 个单位。
- 类型 3 的物品花费 costBoth，同时满足类型 1 和类型 2 的需求各 1 个单位。
你需要购买足够的物品，使得：
- 满足类型 1 的总需求 至少 为 need1。
- 满足类型 2 的总需求 至少 为 need2。
返回满足这些需求的 最小 可能总花费。

分类讨论。
时间复杂度 O(1)。
 */