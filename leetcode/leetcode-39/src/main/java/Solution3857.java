public class Solution3857 {
    public int minCost(int n) {
        return n * (n - 1) / 2;
    }
}
/*
3857. 拆分到 1 的最小总代价
https://leetcode.cn/problems/minimum-cost-to-split-into-ones/description/

第 491 场周赛 T2。

给你一个整数 n。
在一次操作中，你可以将整数 x 拆分为两个正整数 a 和 b，使得 a + b = x。
此操作的代价是 a * b。
返回将整数 n 拆分为 n 个 1 所需的最小总代价。
提示：
1 <= n <= 500

对于任意划分（拆分）方案，得到的答案都是 n * (n - 1) / 2
时间复杂度 O(1)。
 */