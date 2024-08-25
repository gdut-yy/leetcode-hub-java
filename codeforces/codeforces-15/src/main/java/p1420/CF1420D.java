package p1420;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CF1420D {
    static int n, k;
    static int[][] lr;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        k = scanner.nextInt();
        lr = new int[n][2];
        for (int i = 0; i < n; i++) {
            lr[i][0] = scanner.nextInt();
            lr[i][1] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final int MOD = 998244353;
    static final int MAX_N = (int) 3e5;
    static Comb comb = new Comb(MAX_N);

    private static String solve() {
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = lr[i][0], r = lr[i][1];
            a.add(l << 1 | 1);
            a.add((r + 1) << 1);
        }
        a.sort(null);

        int s = 0, c = 0;
        long ans = 0;
        for (int i = 0; i < a.size(); i++) {
            int x = a.get(i);
            s += (x & 1) * 2 - 1;
            if ((x & 1) > 0) {
                c++;
                if ((a.get(i + 1) & 1) == 0) {
                    ans += comb.binom(s, k) - comb.binom(s - c, k);
                    c = 0;
                }
            }
        }
        ans = (ans % MOD + MOD) % MOD;
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
D. Rescue Nibel!
https://codeforces.com/contest/1420/problem/D

灵茶の试炼 2022-10-18
题目大意：
输入 n, k (1≤k≤n≤3e5) 和 n 个闭区间，区间的范围在 [1,1e9]。
你需要从 n 个区间中选择 k 个区间，且这 k 个区间的交集不为空。
输出方案数模 998244353 的结果。

rating 1800
https://codeforces.com/contest/1420/submission/176225922
https://codeforces.com/contest/1420/submission/176225199
对于每个区间的左端点 L，可能存在某些选法，是以 L 为交集的左端点的。
如果有 m 个区间包含 L，且左端点为 L 的区间有 c 个，那么以 L 为交集左端点的方案数为 C(m, k) - C(m-c, k)，即减去不以 L 为交集左端点的方案数，防止重复统计。
两种实现方案：扫描线 / 差分哈希表。
有关组合数 + 逆元，请查阅相关资料。
======

input
7 3
1 7
3 8
4 5
6 7
1 3
5 10
8 9
output
9

input
3 1
1 1
2 2
3 3
output
3

input
3 2
1 1
2 2
3 3
output
0

input
3 3
1 3
2 3
3 3
output
1

input
5 2
1 3
2 4
3 5
4 6
5 7
output
7
 */
