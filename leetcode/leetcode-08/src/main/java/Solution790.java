public class Solution790 {
    private static final int MOD = (int) (1e9 + 7);

    public int numTilings(int n) {
        long[][] f = new long[n + 1][4];
        // f[i][s] 表示平铺到第 i 列时，各个状态 s 对应的平铺方法数量。
        f[0][3] = 1;
        for (int i = 0; i < n; i++) {
            f[i + 1][0] = f[i][3];
            f[i + 1][1] = (f[i][0] + f[i][2]) % MOD;
            f[i + 1][2] = (f[i][0] + f[i][1]) % MOD;
            f[i + 1][3] = (f[i][0] + f[i][1] + f[i][2] + f[i][3]) % MOD;
        }
        return (int) f[n][3];
    }
}
/*
790. 多米诺和托米诺平铺
https://leetcode.cn/problems/domino-and-tromino-tiling/

有两种形状的瓷砖：一种是 2 x 1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。
给定整数 n ，返回可以平铺 2 x n 的面板的方法的数量。返回对 10^9 + 7 取模 的值。
平铺指的是每个正方形都必须有瓷砖覆盖。两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，使得恰好有一个平铺有一个瓷砖占据两个正方形。
提示：
1 <= n <= 1000

经典动态规划。亦可矩阵快速幂。
时间复杂度 O(n)
 */