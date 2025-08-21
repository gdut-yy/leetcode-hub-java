public class Solution3638 {
    public int maxBalancedShipments(int[] weight) {
        int n = weight.length;
        int ans = 0;
        int mn = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (mn > weight[i]) {
                mn = weight[i];
            } else if (mn < weight[i]) {
                ans++;
                mn = Integer.MAX_VALUE;
            }
        }
        return ans;
    }
}
/*
3638. 平衡装运的最大数量
https://leetcode.cn/problems/maximum-balanced-shipments/description/

第 461 场周赛 T2。

给你一个长度为 n 的整数数组 weight，表示按直线排列的 n 个包裹的重量。装运 定义为包裹的一个连续子数组。如果一个装运满足以下条件，则称其为 平衡装运：最后一个包裹的重量 严格小于 该装运中所有包裹中 最大重量 。
选择若干个 不重叠 的连续平衡装运，并满足 每个包裹最多出现在一次装运中（部分包裹可以不被装运）。
返回 可以形成的平衡装运的最大数量 。
提示:
2 <= n <= 10^5
1 <= weight[i] <= 10^9

贪心。
后往前遍历。维护最小值，遇到比最小值大的数 答案就加一。
时间复杂度 O(n)。
 */