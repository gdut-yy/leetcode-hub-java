import java.util.Arrays;

public class Solution3539 {
    private int[][] powV;
    private int[][][][] memo;

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;
        powV = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            powV[i][0] = 1;
            for (int j = 1; j <= m; j++) {
                powV[i][j] = (int) ((long) powV[i][j - 1] * nums[i] % MOD);
            }
        }

        memo = new int[n][m + 1][m / 2 + 1][k + 1];
        for (int[][][] a : memo) {
            for (int[][] b : a) {
                for (int[] c : b) {
                    Arrays.fill(c, -1);
                }
            }
        }
        return (int) (dfs(0, m, 0, k) * F[m] % MOD);
    }

    private long dfs(int i, int leftM, int x, int leftK) {
        int c1 = Integer.bitCount(x);
        if (c1 + leftM < leftK) { // 可行性剪枝
            return 0;
        }
        if (i == powV.length || leftM == 0 || leftK == 0) { // 无法继续选数字
            return leftM == 0 && c1 == leftK ? 1 : 0;
        }
        if (memo[i][leftM][x][leftK] != -1) {
            return memo[i][leftM][x][leftK];
        }
        long res = 0;
        for (int j = 0; j <= leftM; j++) { // 枚举 I 中有 j 个下标 i
            // 这 j 个下标 i 对 S 的贡献是 j * pow(2, i)
            // 由于 x = S >> i，转化成对 x 的贡献是 j
            int bit = (x + j) & 1; // 取最低位，提前从 leftK 中减去，其余进位到 x 中
            long r = dfs(i + 1, leftM - j, (x + j) >> 1, leftK - bit);
            res = (res + r * powV[i][j] % MOD * invF[j]) % MOD;
        }
        return memo[i][leftM][x][leftK] = (int) res;
    }

    static int MOD = (int) 1e9 + 7, MX = (int) 32;
    static long[] F = new long[MX + 1], invF = new long[MX + 1];

    static {
        F[0] = F[1] = invF[0] = invF[1] = 1;
        for (int i = 2; i <= MX; i++) F[i] = F[i - 1] * i % MOD;
        invF[MX] = quickPow(F[MX], MOD - 2);
        for (int i = MX - 1; i >= 2; i--) invF[i] = invF[i + 1] * (i + 1) % MOD;
    }

    static long comb(int n, int m) {
        return F[n] * invF[n - m] % MOD * invF[m] % MOD;
    }

    static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
3539. 魔法序列的数组乘积之和
https://leetcode.cn/problems/find-sum-of-array-product-of-magical-sequences/description/

第 448 场周赛 T4。

给你两个整数 M 和 K，和一个整数数组 nums。
- seq 的序列长度为 M。
- 0 <= seq[i] < nums.length
- 2^seq[0] + 2^seq[1] + ... + 2^seq[M - 1] 的 二进制形式 有 K 个 置位。
这个序列的 数组乘积 定义为 prod(seq) = (nums[seq[0]] * nums[seq[1]] * ... * nums[seq[M - 1]])。
返回所有有效 魔法 序列的 数组乘积 的 总和 。
由于答案可能很大，返回结果对 10^9 + 7 取模。
置位 是指一个数字的二进制表示中值为 1 的位。
提示:
1 <= K <= M <= 30
1 <= nums.length <= 50
1 <= nums[i] <= 10^8

状态设计 + 多重集排列数 + 可行性剪枝
https://leetcode.cn/problems/find-sum-of-array-product-of-magical-sequences/solutions/3668501/duo-wei-dp-zu-he-shu-xue-by-endlesscheng-j6y8/
时间复杂度 O(n * m^3 * k)
rating 2693 (clist.by)
 */