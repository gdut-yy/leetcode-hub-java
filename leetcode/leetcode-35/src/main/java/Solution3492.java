public class Solution3492 {
    public int maxContainers(int n, int w, int maxWeight) {
        return Math.min(maxWeight / w, n * n);
    }
}
/*
3492. 船上可以装载的最大集装箱数量
https://leetcode.cn/problems/maximum-containers-on-a-ship/description/

第 442 场周赛 T1。

给你一个正整数 n，表示船上的一个 n x n 的货物甲板。甲板上的每个单元格可以装载一个重量 恰好 为 w 的集装箱。
然而，如果将所有集装箱装载到甲板上，其总重量不能超过船的最大承载重量 maxWeight。
请返回可以装载到船上的 最大 集装箱数量。
提示：
1 <= n <= 1000
1 <= w <= 1000
1 <= maxWeight <= 10^9

数学。
时间复杂度 O(1)。
 */