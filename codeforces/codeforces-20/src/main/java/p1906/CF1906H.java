package p1906;

import java.util.Arrays;
import java.util.Scanner;

public class CF1906H {
    static int n, m;
    static char[] s, t;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        s = scanner.next().toCharArray();
        t = scanner.next().toCharArray();
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        int[] cntS = new int[26];
        int[] cntT = new int[26];
        for (char b : s) {
            cntS[b - 'A']++;
        }
        for (char b : t) {
            cntT[b - 'A']++;
        }
        if (cntS[25] > cntT[25]) {
            return "0";
        }
        cntT[25] -= cntS[25];

        Comb comb = new Comb((int) 2e5);
        long[] f = new long[n + 1];
        f[0] = 1;
        long[] sum = new long[n + 2];
        for (int i = 0; i < 25; i++) {
            int cs = cntS[i];
            for (int j = 0; j < f.length; j++) {
                sum[j + 1] = sum[j] + f[j];
            }
            Arrays.fill(f, 0);
            for (int j = Math.max(cs - cntT[i], 0); j <= Math.min(cs, cntT[i + 1]); j++) {
                f[j] = sum[Math.min(cntT[i] - cs + j, n) + 1] % MOD * comb.binom(cs, j) % MOD;
            }
        }

        long sumF = 0;
        for (long v : f) {
            sumF += v;
        }
        long perm = comb.fac[n];
        for (int c : cntS) {
            perm = perm * comb.inv_fac[c] % MOD;
        }
        long ans = sumF % MOD * perm % MOD;
        return String.valueOf(ans);
    }

    static class Comb {
        long[] fac, inv_fac;

        public Comb(int n) {
            fac = new long[n + 1];
            fac[0] = 1;
            for (int i = 1; i <= n; i++) fac[i] = fac[i - 1] * i % MOD;
            inv_fac = new long[n + 1];
            for (int i = 0; i <= n; i++) inv_fac[i] = quickPow(fac[i], MOD - 2);
        }

        // C(n, m) = n! / m!(n-m)!
        long binom(int n, int m) {
            if (n < m || m < 0) return 0;
            return fac[n] * inv_fac[m] % MOD * inv_fac[n - m] % MOD;
        }

        // 模下的 a^b
        long quickPow(long a, long b) {
            long res = 1L;
            while (b > 0) {
                if ((b & 1) != 0) res = res * a % MOD;
                a = a * a % MOD;
                b >>= 1;
            }
            return res;
        }
    }
}
/*
H. Twin Friends
https://codeforces.com/contest/1906/problem/H

灵茶の试炼 2024-12-13
题目大意：
输入 n m (1≤n≤m≤2e5)，长为 n 的字符串 s，长为 m 的字符串 t，只包含大写英文字母。
你可以随意重排 s 和 t 中的字母。
然后从 t 中选一个长为 n 的子序列 t'，使得对于每个 s[i]，要么 s[i]=t'[i]，要么 s[i]+1=t'[i]。
比如 s=AAB，t'=ABB 是合法的。
有多少个不同的 (s,t') 二元组？模 998244353。

rating 2200
s 的每一种排列都对应着等价的 t' 的排列，所以先算出 sort(s) 对应的 t' 的方案数，再乘上 s 的可重集排列数。
倒着思考。
比如 s 中有 3 个 y，如果选择 t 中的 1 个 z 与之配对，那么必然还要选择 t 中的 2 个 y 与之配对。即 yyy 与 yyz 配对。
那么对于 s 中的 x 来说，t 中可以配对的 y 的个数就会减少 2。比如 t 中有 5 个 y，那么 s 中的 x 可以配对的 t 中的 y 的个数就是 5-2=3。
设 s 中第 i 种字母的个数为 cntS[i]，t 中第 i 种字母的个数为 cntT[i]。
定义 f[i][j] 表示考虑 s 的前 i 种字母，其中 s 的第 i 种字母，在 t 中选择 j 个第 i+1 种字母配对的方案数。
那么 t 中还要选择 cntS[i] - j 个第 i 种字母。
枚举 s 的第 i-1 种字母，在 t 中选择 k 个第 i 种字母，即 f[i-1][k]。
必须满足 k + (cntS[i] - j) <= cntT[i]，即 k <= cntT[i] - cntS[i] + j。
枚举 k，有
f[i][j] = f[i-1][0] + f[i-1][1] + ... + f[i-1][cntT[i] - cntS[i] + j]。
用前缀和优化。
注意无需关心转移来源是否合法，不合法的状态一定是 0。
初始值 f[0][0] = 1。
答案为 sum(f[25]) 乘上 s 的可重集排列数。sum(f[25]) 表示枚举 s 中的 y 选择了多少个 t 中的 z。
代码 https://codeforces.com/problemset/submission/1906/296084221
代码备份（洛谷）
======

Input
3 4
AMA
ANAB
Output
9

Input
5 8
BINUS
BINANUSA
Output
120

Input
15 30
BINUSUNIVERSITY
BINANUSANTARAUNIVERSITYJAKARTA
Output
151362308

Input
4 4
UDIN
ASEP
Output
0
 */