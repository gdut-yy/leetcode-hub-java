public class Solution1735 {
    public int[] waysToFillArray(int[][] queries) {
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            int n = q[0];
            int k = q[1];
            long res = 1;
            while (k > 1) {
                int p = LPF[k];
                int e = 1;
                for (k /= p; k % p == 0; k /= p) {
                    e++;
                }
                res = res * comb(e + n - 1, e) % MOD;
            }
            ans[i] = (int) res;
        }
        return ans;
    }

    static int MOD = (int) 1e9 + 7, MX = (int) 1e5 + 5;
    static long[] F = new long[MX + 1], invF = new long[MX + 1];
    static int[] LPF = new int[MX]; // i 的最小质因子是 lpf[i]

    static {
        F[0] = F[1] = invF[0] = invF[1] = 1;
        for (int i = 2; i <= MX; i++) F[i] = F[i - 1] * i % MOD;
        invF[MX] = quickPow(F[MX], MOD - 2);
        for (int i = MX - 1; i >= 2; i--) invF[i] = invF[i + 1] * (i + 1) % MOD;

        for (int i = 2; i < MX; i++) {
            if (LPF[i] == 0) { // i 是质数
                for (int j = i; j < MX; j += i) {
                    if (LPF[j] == 0) {
                        LPF[j] = i; // j 的最小质因子是 i
                    }
                }
            }
        }
    }

    static long comb(int n, int m) {
        if (n < m || m < 0) return 0;
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
1735. 生成乘积数组的方案数
https://leetcode.cn/problems/count-ways-to-make-array-with-product/description/

给你一个二维整数数组 queries ，其中 queries[i] = [ni, ki] 。第 i 个查询 queries[i] 要求构造长度为 ni 、每个元素都是正整数的数组，且满足所有元素的乘积为 ki ，请你找出有多少种可行的方案。由于答案可能会很大，方案数需要对 10^9 + 7 取余 。
请你返回一个整数数组 answer，满足 answer.length == queries.length ，其中 answer[i]是第 i 个查询的结果。
提示：
1 <= queries.length <= 10^4
1 <= ni, ki <= 10^4

质因子分解+放球问题 https://leetcode.cn/problems/count-ways-to-make-array-with-product/solutions/2713481/tu-jie-zhi-yin-zi-fen-jie-fang-qiu-wen-t-fboo/
时间复杂度：预处理的时间为 O(N+KloglogK)，其中 N=10^4, K=10^4。回答单个询问的时间为 O(logk)，因为 k 有 O(logk) 个质因子。
 */