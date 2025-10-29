public class Solution3725 {
    private static final int MOD = (int) (1e9 + 7);

    public int countCoprime(int[][] mat) {
        long[] f = new long[151];
        f[0] = 1;
        for (int[] row : mat) {
            long[] nf = new long[151];
            for (int g = 0; g < 151; g++) {
                if (f[g] == 0) continue;
                for (int x : row) {
                    int newG = getGCD(g, x);
                    nf[newG] = (nf[newG] + f[g]) % MOD;
                }
            }
            f = nf;
        }
        return (int) (f[1] % MOD);
    }

    private int getGCD(int num1, int num2) {
        return num1 == 0 ? num2 : getGCD(num2 % num1, num1);
    }
}
/*
3725. 统计每一行选择互质整数的方案数
https://leetcode.cn/problems/count-ways-to-choose-coprime-integers-from-rows/description/

第 168 场双周赛 T4。

给你一个由正整数组成的 m x n 矩阵 mat。
返回一个整数，表示从 mat 的每一行中 恰好 选择一个整数，使得所有被选整数的 最大公约数 为 1 的选择方案数量。
由于答案可能非常大，请将其 模 10^9 + 7 后返回。
提示:
1 <= m == mat.length <= 150
1 <= n == mat[i].length <= 150
1 <= mat[i][j] <= 150

动态规划。
https://chat.deepseek.com/a/chat/s/2f0c8f16-176b-4c5c-a379-8c62362a0ea0
时间复杂度 O(n^3)。
 */