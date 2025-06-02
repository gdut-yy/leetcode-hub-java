public class Solution3560 {
    public long minCuttingCost(int n, int m, int k) {
        long ans1 = Math.max((long) (n - k) * k, 0);
        long ans2 = Math.max((long) (m - k) * k, 0);
        return Math.max(ans1, ans2);
    }
}
/*
3560. 木材运输的最小成本
https://leetcode.cn/problems/find-minimum-log-transportation-cost/description/

第 451 场周赛 T1。

给你三个整数 n、m 和 k。
有两根长度分别为 n 和 m 单位的木材，需要通过三辆卡车运输。每辆卡车最多只能装载一根长度 不超过 k 单位的木材。
你可以将木材切成更小的段，其中将长度为 x 的木材切割成长度为 len1 和 len2 的段的成本为 cost = len1 * len2，并且满足 len1 + len2 = x。
返回将木材分配到卡车上的 最小总成本 。如果木材不需要切割，总成本为 0。
提示：
2 <= k <= 10^5
1 <= n, m <= 2 * k
输入数据保证木材总存在能被运输的方案。

分类讨论。
 */