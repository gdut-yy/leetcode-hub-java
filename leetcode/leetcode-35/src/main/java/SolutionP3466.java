public class SolutionP3466 {
    public long maxCoins(int[] lane1, int[] lane2) {
        int n = lane1.length;
        // f[i][j] 表示在 i 英里处且换道总次数等于 j 的最大硬币数
        long[][] f = new long[n + 1][3];
        f[0][0] = 0;
        f[0][1] = Long.MIN_VALUE;
        f[0][2] = Long.MIN_VALUE;
        long ans = Long.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int coins1 = lane1[i - 1], coins2 = lane2[i - 1];
            for (int j = 0; j <= 2; j++) {
                long preCoins = Math.max(Math.max(j > 0 ? f[i - 1][j - 1] : Long.MIN_VALUE, f[i - 1][j]), 0);
                long curCoins = j % 2 == 0 ? coins1 : coins2;
                f[i][j] = preCoins + curCoins;
                ans = Math.max(ans, f[i][j]);
            }
        }
        return ans;
    }
}
/*
$3466. 最大硬币收集量
https://leetcode.cn/problems/maximum-coin-collection/description/

马里奥在双车道高速公路上行驶，每英里都有硬币。给定两个整数数组，lane1 和 lane2，其中第 i 个下标的值表示他在车道上处于第 i 英里时获得或失去的硬币数量。
- 如果马里奥在车道 1 上处于 i 英里处，并且 lane1[i] > 0，马里奥获得 lane1[i] 硬币。
- 如果马里奥在车道 1 上处于 i 英里处，并且 lane1[i] < 0，马里奥支付通行费并失去 abs(lane1[i]) 个硬币。
- 规则同样对 lane2 适用。
马里奥可以在任何地方进入高速公路，并在行驶 至少 一英里后随时退出。马里奥总是从 1 号车道进入高速公路，但 最多 可以换道 2 次。
换道 是指马里奥从车道 1 换到车道 2，反之亦然。
返回马里奥在进行 最多 2 次换道 后 最多 可以获得的硬币数。
注意：马里奥可以在进入高速公路或退出高速公路之前立即切换车道。
提示：
1 <= lane1.length == lane2.length <= 10^5
-10^9 <= lane1[i], lane2[i] <= 10^9

动态规划。
时间复杂度 O(n)。
 */