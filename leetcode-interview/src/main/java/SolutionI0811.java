public class SolutionI0811 {
    public int waysToChange(int n) {
        int[] coins = {25, 10, 5, 1};
        // 完全背包
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int wi : coins) {
            for (int i = wi; i <= n; i++) {
                f[i] += f[i - wi];
                f[i] %= 1000000007;
            }
        }
        return f[n];
    }
}
/*
面试题 08.11. 硬币
https://leetcode.cn/problems/coin-lcci/

硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
说明：
注意:
你可以假设：
0 <= n (总金额) <= 1000000

动态规划。完全背包。
时间复杂度 O(n)
空间复杂度 O(n)
 */