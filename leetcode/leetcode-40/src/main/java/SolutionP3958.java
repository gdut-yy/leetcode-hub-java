public class SolutionP3958 {
    public long minCost(int n) {
        return (long) n * (n - 1) / 2;
    }
}
/*
$3958. 拆分到 1 的最小总代价 II
https://leetcode.cn/problems/minimum-cost-to-split-into-ones-ii/description/

给你一个整数 n。
在一次操作中，你可以将整数 x 拆分为两个正整数 a 和 b，使得 a + b = x。
此操作的代价是 a * b。
返回将整数 n 拆分为 n 个 1 所需的 最小总代价。
示例 1：
输入： n = 3
输出： 3
示例 2：
输入： n = 4
输出： 6
提示：
1 <= n <= 5 * 10^7

相似题目: 3857. 拆分到 1 的最小总代价
https://leetcode.cn/problems/minimum-cost-to-split-into-ones/description/
 */