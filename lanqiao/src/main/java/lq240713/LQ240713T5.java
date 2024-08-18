package lq240713;

import java.util.Arrays;
import java.util.Scanner;

public class LQ240713T5 {
    static int[] c;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        c = new int[10];
        for (int i = 1; i <= 9; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        int sum = Arrays.stream(c).sum();
        Comb comb = new Comb(sum);

        long cnt = 0, mul = 0;
        for (int i = 1; i <= sum; i++) {
            mul = (mul * 10 + 1) % MOD;
        }
        for (int i = 1; i <= 9; i++) {
            if (c[i] > 0) {
                long ti = comb.binom(sum - 1, c[i] - 1);
                int res = sum - c[i];
                for (int j = 1; j <= 9; j++) {
                    if (j != i) {
                        ti = ti * comb.binom(res, c[j]) % MOD;
                        res -= c[j];
                    }
                }
                cnt = (cnt + ti * i) % MOD;
            }
        }
        long ans = cnt * mul % MOD;
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
9 面数字墙【算法赛】

一共有 \sum ci 个数位，每一个位置都可以放这个数字，数字与数字之间是相互独立的，他们放置的次数也是相互独立的。
---
以 [1 1 0 1 0 0 0 0 0] 为例子，一共有 3! 种组合，分别为 [124],[142],[214],[241],[412],[421]。
可以看到，每一个数字在每一位均出现了 2 次，这 6 个数的和是 1554。
我们可以将其转换成 4*111 + 2*111 + 111 = 777，777*2 = 1554。可以发现每一个数均乘上了 111，然后总和乘上 (n-1)!
---
以 [2 1 0 0 0 0 0 0 0] 为例，一共有 3! 种组合，分别为 [121],[112],[211],[211],[112],[121]。
但有 3 个数重复了，因此我们需要舍去。这三个数的和为 444。
---
对于上述步骤，我们可以直接看所有符合的数个位的和，然后将其乘上 111..111。
 */
