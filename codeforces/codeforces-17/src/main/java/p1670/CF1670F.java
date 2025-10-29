package p1670;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF1670F {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static int n;
    static long l, r, z;

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) V2.solve();
        out.flush();
    }

    static final int MOD = (int) (1e9 + 7);

    static class V1 {
        static long[] cn, inv;
        static int m;
        static long[][][] dp;

        // TLE
        private static void solve() {
            n = scanner.nextInt();
            l = scanner.nextLong();
            r = scanner.nextLong();
            z = scanner.nextLong();

            cn = new long[n + 1];
            inv = new long[n + 1];
            cn[0] = 1;
            cn[1] = n;
            inv[1] = 1;
            for (int i = 2; i <= n; i++) {
                inv[i] = (MOD - MOD / i) * inv[MOD % i] % MOD;
                cn[i] = cn[i - 1] * (n + 1 - i) % MOD * inv[i] % MOD;
            }
            long ans = (calc(r) - calc(l - 1) + MOD) % MOD;
            out.println(ans);
        }

        static long calc(long r0) {
            if (r0 < z) {
                return 0;
            }
            m = bitsLen(r0);
            dp = new long[m][n][2];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    Arrays.fill(dp[i][j], -1);
                }
            }
            return f(0, 0, 0, r0);
        }

        static long f(int i, int s, int gr, long r0) {
            if (i == m) {
                if (s == 0 && gr == 0) {
                    return 1;
                }
                return 0;
            }
            if (dp[i][s][gr] >= 0) return dp[i][s][gr];
            long res = 0;
            for (int j = (int) (z >> i & 1); j <= n; j += 2) {
                int bit = (s + j) & 1;
                int newGr = 0;
                if (bit == (int) (r0 >> i & 1)) {
                    newGr = gr;
                } else if (bit > (r0 >> i & 1)) {
                    newGr = 1;
                }
                res = (res + f(i + 1, (s + j) >> 1, newGr, r0) * cn[j]) % MOD;
            }
            return dp[i][s][gr] = res;
        }

        // bits.Len:
        // Len returns the minimum number of bits required to represent x; the result is 0 for x == 0.
        static int bitsLen(long x) {
            return 64 - Long.numberOfLeadingZeros(x);
        }
    }

    // https://codeforces.com/contest/1670/submission/162299931
    static class V2 {
        private static void solve() {
            n = scanner.nextInt();
            l = scanner.nextLong();
            r = scanner.nextLong();
            z = scanner.nextLong();

            memo_nCr = new long[1001][1001];
            for (long[] x : memo_nCr) {
                Arrays.fill(x, -1);
            }
            long ans = (compute(r) - compute(l - 1) + MOD) % MOD;
            out.println(ans);
        }

        static long[][] memo_nCr;
        static long[][] memo_compute;

        public static long nCr(int n, int r) {
            if (r == 0) return 1;
            if (n == 0) return 0;
            if (memo_nCr[n][r] != -1) return memo_nCr[n][r];
            return memo_nCr[n][r] = (nCr(n - 1, r) + nCr(n - 1, r - 1)) % MOD;
        }

        static long compute(long val) {
            memo_compute = new long[61][2001];
            for (long[] x : memo_compute) {
                Arrays.fill(x, -1);
            }
            return dp(60, 0, val);
        }

        private static long dp(int idx, int rem, long val) {
            if (rem > 2000) rem = 2000;
            if (rem < 0) return 0;
            if (idx == -1) return 1;
            if (memo_compute[idx][rem] != -1) return memo_compute[idx][rem];
            long ans = 0;
            int currentBitXor = (z & 1L << idx) == 0 ? 0 : 1;
            for (int i = currentBitXor == 1 ? 1 : 0; i <= n; i += 2) {
                int currentBitSum = (val & 1L << idx) == 0 ? 0 : 1;
                int nextRem = 2 * (rem + currentBitSum - i);
                long toAdd = (nCr(n, i) * dp(idx - 1, nextRem, val)) % MOD;
                ans = (ans + toAdd) % MOD;
            }
            return memo_compute[idx][rem] = ans;
        }
    }
}
/*
F. Jee, You See?
https://codeforces.com/contest/1670/problem/F

灵茶の试炼 2025-06-06
题目大意：
输入 n(1≤n≤1e3) l r(1≤l≤r≤1e18) 和 z(1≤z≤1e18)。
输出有多少个长为 n 的非负整数数组 a，满足 l ≤ sum(a) ≤ r 且 xor(a) = z，即 a 中所有元素的异或和等于 z。
答案模 1e9+7。

rating 2400
计算元素和 <= r 的方案数，减去元素和 <= l-1 的方案数。
用数位 DP 解决。
对于 xor(a) = z 的要求，只要保证 a 中每一位的 1 的个数符合就行：z 这一位是 0 就是偶数个 1，是 1 就是奇数个 1。
所以关键是把元素和作为状态，这样才能判断是否合法。但是状态个数太多了，怎么办？
这里要用到 3539. 魔法序列的数组乘积之和 中的技巧，从低位往高位考虑，把元素和 >> i 的结果作为状态。这样元素和的状态个数是 O(n) 的。
我们要写一个数位 DP。但从低位往高位考虑，怎么保证元素和 <= r 呢？
具体来说，定义 dfs(i, carry, great) 表示当前考虑从低到高第 i 位，元素和 >> i 的结果为 carry，之前填的数位是否大于 r 的这些数位，这种情况下的方案数。
枚举第 i 位的 1 的个数 j（要符合 z），更新 carry 为 (carry+j)>>1，更新 newGreat 为 bit=(carry+j)&1 与 ri=r>>i&1 的大小关系：
如果 bit < ri，那么 newGreat = false。
如果 bit > ri，那么 newGreat = true。
如果 bit = ri，那么 newGreat = great。
把 dfs(i+1, (carry+j)>>1, newGreat) * comb(n, j) 累加到返回值中。
递归终点：carry=0 且 great=false。
递归入口：dfs(0,0,false)
代码 https://codeforces.com/problemset/submission/1670/322519053
代码备份（洛谷）
======

Input
3 1 5 1
Output
13

Input
4 1 3 2
Output
4

Input
2 1 100000 15629
Output
49152

Input
100 56 89 66
Output
981727503

49 43 67 1
194554847
 */
