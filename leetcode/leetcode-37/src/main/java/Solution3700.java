public class Solution3700 {
    private static final int MOD = (int) (1e9 + 7);

    public int zigZagArrays(int n, int l, int r) {
        int len = r - l + 1;
        int dim = 2 * len;

        long[] V0 = new long[dim];
        for (int b = l; b <= r; b++) {
            int idx0 = b - l;
            int idx1 = idx0 + len;
            V0[idx0] = b - l;
            V0[idx1] = r - b;
        }

        if (n == 2) {
            long sum = 0;
            for (long x : V0) {
                sum = (sum + x) % MOD;
            }
            return (int) sum;
        }

        long[][] T = new long[dim][dim];
        for (int k = l; k <= r; k++) {
            int j0 = k - l;
            int j1 = j0 + len;

            for (int l_val = l; l_val < k; l_val++) {
                int i1 = l_val - l + len;
                T[i1][j0] = (T[i1][j0] + 1) % MOD;
            }

            for (int l_val = k + 1; l_val <= r; l_val++) {
                int i0 = l_val - l;
                T[i0][j1] = (T[i0][j1] + 1) % MOD;
            }
        }

        long[][] T_power = matQuickPow(T, n - 2);
        long[] V = matMultiply(T_power, V0);

        long ans = 0;
        for (long x : V) {
            ans = (ans + x) % MOD;
        }
        return (int) ans;
    }

    // 矩阵快速幂 res[][] = a[][]^n
    private long[][] matQuickPow(long[][] a, int n) {
        int len = a.length;
        // 对角矩阵
        long[][] res = new long[len][len];
        for (int i = 0; i < len; i++) {
            res[i][i] = 1;
        }
        while (n > 0) {
            if ((n & 1) == 1) res = matMulti(res, a);
            n >>= 1;
            a = matMulti(a, a);
        }
        return res;
    }

    // 矩阵乘 res[][] = a[][] * b[][]
    private long[][] matMulti(long[][] a, long[][] b) {
        int len = a.length;
        long[][] res = new long[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                    res[i][j] %= MOD;
                }
            }
        }
        return res;
    }

    // 矩阵乘 res[] = a[][] * b[]
    private long[] matMultiply(long[][] a, long[] b) {
        int row = a.length;
        long[] res = new long[row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                res[i] += a[i][j] * b[j] % MOD;
                res[i] %= MOD;
            }
        }
        return res;
    }
}
/*
3700. 锯齿形数组的总数 II
https://leetcode.cn/problems/number-of-zigzag-arrays-ii/description/

第 469 场周赛 T4。

给你三个整数 n、l 和 r。
长度为 n 的锯齿形数组定义如下：
- 每个元素的取值范围为 [l, r]。
- 任意 两个 相邻的元素都不相等。
- 任意 三个 连续的元素不能构成一个 严格递增 或 严格递减 的序列。
返回满足条件的锯齿形数组的总数。
由于答案可能很大，请将结果对 10^9 + 7 取余数。
序列 被称为 严格递增 需要满足：当且仅当每个元素都严格大于它的前一个元素（如果存在）。
序列 被称为 严格递减 需要满足，当且仅当每个元素都严格小于它的前一个元素（如果存在）。
提示：
3 <= n <= 10^9
1 <= l < r <= 75

矩阵快速幂优化 DP。
时间复杂度 O((r-l)^3 logn)。
https://chat.deepseek.com/a/chat/s/5fe09087-2ae4-4a67-9abd-05533a37e1d3
rating 2456 (clist.by)
 */