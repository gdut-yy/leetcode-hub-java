package p1831;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class CF1831E {
    static int n, k;
    static int[][] lr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
        int t = scanner.nextInt();
        while (t-- > 0) {
            n = scanner.nextInt();
            k = scanner.nextInt();
            lr = new int[k][2];
            for (int i = 0; i < k; i++) {
                lr[i][0] = scanner.nextInt();
                lr[i][1] = scanner.nextInt();
            }
            System.out.println(solve());
        }
    }

    private static final int MOD = 998244353;

    // https://codeforces.com/contest/1830/submission/207598385
    private static String solve() {
        Random random = new Random();
        long[] d = new long[n];
        for (int i = 0; i < k; i++) {
            int l = lr[i][0] - 1, r = lr[i][1];
            long x = random.nextLong();
            d[l] ^= x;
            if (r < n) {
                d[r] ^= x;
            }
        }
        for (int i = 1; i < n; i++) {
            d[i] ^= d[i - 1];
        }

        Map<Long, Integer> cntMap = new HashMap<>();
        for (long x : d) {
            cntMap.put(x, cntMap.getOrDefault(x, 0) + 1);
        }

        long ans = 1;
        Comb comb = new Comb(n);
        for (Integer x : cntMap.values()) {
            if (x % 2 == 1) {
                ans = 0;
            } else {
                x /= 2;
                ans *= comb.binom(2 * x, x) - comb.binom(2 * x, x + 1);
                ans %= MOD;
            }
        }
        ans = (ans + MOD) % MOD;
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
E. Hyperregular Bracket Strings
https://codeforces.com/contest/1831/problem/E

灵茶の试炼 2024-01-19
题目大意：
给定 n 和 k 个整数区间。第 i 个区间为[li,ri]，其中 1≤li≤ri≤n。
我们称长度为 n 的正则括号序列†，‡为超正则序列，如果对于每一个 i 满足 1≤i≤k，子串 slisli+1…sri 也是正则括号序列。
你的任务是计算超正则括号序列的个数。由于这个数字可能非常大，所以只需要对 998244353 取模即可。
括号序列是只包含字符"("和")"的字符串。
如果可以通过添加字符+和 1 将括号序列转换为有效的数学表达式，则称为正则括号序列。例如,序列 (())(), (), (()(())) 空字符串是常规,而 )(, ((), (()))(并不是。

xor hashing + 卡特兰数
======

input
7
6 0
5 0
8 1
1 3
10 2
3 4
6 9
1000 3
100 701
200 801
300 901
28 5
1 12
3 20
11 14
4 9
18 19
4 3
1 4
1 4
1 4
output
5
0
0
4
839415253
140
2
 */
