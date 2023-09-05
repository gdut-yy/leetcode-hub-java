package c171;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Abc171_f {
    static int k;
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        k = scanner.nextInt();
        s = scanner.next();
        System.out.println(solve());
    }

    private static final int MOD = (int) (1e9 + 7);

    private static String solve() {
        int n = s.length();

        long p26 = 1;
        Comb comb = new Comb(n - 1 + k);
        long p25 = comb.quickPow(25, k);
        long inv25 = 280000002; // pow(25, mod-2)
        long ans = 0;
        for (int i = 0; i <= k; i++) {
            ans = (ans + p26 * p25 % MOD * comb.binom(n - 1 + k - i, n - 1)) % MOD;
            p26 = p26 * 26 % MOD;
            p25 = p25 * inv25 % MOD;
        }
        return String.valueOf(ans);
    }

    private static class Comb {
        private final long[] fac, invfac;

        public Comb(int n) {
            fac = new long[n + 1];
            fac[0] = 1;
            for (int i = 1; i <= n; i++) {
                fac[i] = fac[i - 1] * i % MOD;
            }
            invfac = new long[n + 1];
            for (int i = 0; i <= n; i++) {
                invfac[i] = quickPow(fac[i], MOD - 2);
            }
        }

        // C(n, m) = n! / m!(n-m)!
        private long binom(int n, int m) {
            if (n < m || m < 0) return 0;
            return fac[n] * invfac[m] % MOD * invfac[n - m] % MOD;
        }

        // 模下的 a^b
        private long quickPow(long a, long b) {
            long res = 1L;
            while (b > 0) {
                if ((b & 1) == 1) {
                    res = res * a % MOD;
                }
                a = a * a % MOD;
                b >>= 1;
            }
            return res;
        }
    }
}
/*
F - Strivore
https://atcoder.jp/contests/abc171/tasks/abc171_f

灵茶の试炼 2022-11-07
题目大意：
输入 k(≤1e6) 和一个长度不超过 1e6 的字符串 s，由小写字母组成。
你需要在 s 中插入恰好 k 个小写字母。
输出你能得到的字符串的个数，模 1e9+7。

https://atcoder.jp/contests/abc171/submissions/36296507
设 s 的长度为 n。
提示 1：如何避免重复统计？做一个规定，插入在 s[i] 左侧的字符，不能和 s[i] 相同，这不会影响答案的正确性。
提示 2：枚举最后一个字符的右侧插入了多少个字符，设为 i，这些字符没有限制，有 26^i 种方案。
提示 3：剩下 (n-1) + (k-i) 个字符，我们需要考虑其中 n-1 个字符的位置，这就是 C(n-1+k-i, n-1)。
提示 4：其余插入字符的方案数就是 25^(k-i)。
因此答案为 ∑26^i * C(n-1+k-i, n-1) * 25^(k-i), i=[0,k]
不知道组合数怎么算的，需要学一下逆元。
======

Input 1
5
oof
Output 1
575111451

Input 2
37564
whydidyoudesertme
Output 2
318008117
 */