package p691;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF691E {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static final int MOD = (int) (1e9 + 7);

    private static void solve() {
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextLong();
        }

        long[][] m = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (Long.bitCount(a[i] ^ a[j]) % 3 == 0) {
                    m[i][j] = 1;
                    m[j][i] = 1;
                }
            }
        }

        long[][] f0 = new long[n][1];
        for (int i = 0; i < n; i++) {
            f0[i][0] = 1;
        }

        long[][] fk = matQuickPow(m, k - 1);
        fk = matMulti(fk, f0);
        long ans = 0;
        for (long[] row : fk) {
            ans += row[0];
            ans %= MOD;
        }

        out.println(ans);
    }

    // 矩阵快速幂 res = a^n
    static long[][] matQuickPow(long[][] a, long n) {
        int m = a.length;
        long[][] c = new long[m][m];
        for (int i = 0; i < m; i++) c[i][i] = 1;
        while (n > 0) {
            if ((n & 1) == 1) c = matMulti(c, a);
            n >>= 1;
            a = matMulti(a, a);
        }
        return c;
    }

    // 矩阵快速幂 res = a * b
    static long[][] matMulti(long[][] a, long[][] b) {
        int n = a.length, p = b.length, m = b[0].length;
        long[][] c = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < p; k++) {
                for (int j = 0; j < m; j++) {
                    c[i][j] = (c[i][j] + a[i][k] * b[k][j] % MOD) % MOD;
                }
            }
        }
        return c;
    }
}
/*
E. Xor-sequences
https://codeforces.com/contest/691/problem/E

灵茶の试炼 2025-10-09
题目大意：
输入 n(1≤n≤100) k(1≤k≤1e18) 和长为 n 的数组 a(0≤a[i]≤1e18)。
构造一个长为 k 的数组 b，每个 b[i] 都等于 a 中的某个数，且对于 b 中任意相邻元素 (x,y)，都满足 x XOR y 中的 1 的个数是 3 的倍数。
输出有多少个不同的数组 b，模 1e9+7。
注意：即使元素值相同，但选自 a 的位置不同，也算不同的 b。例如 a=[1,1]，k=1，有两个不同的 b=[1]。

rating 1900
计数问题，且只有相邻元素有约束，考虑 DP。
但 k 很大，暗示我们用矩阵快速幂。
本题子序列相邻两个数需要满足一些条件，为方便转成系数矩阵，定义 f[i][j] 表示构造子序列 b 的前 i 个数（下标 1 到 i），且 b[i] = a[j] 的方案数。
枚举 b[i-1] = a[k]，如果 a[j] XOR a[k] 中的 1 的个数是 3 的倍数，那么 f[i][j] += f[i-1][k]。
对应系数矩阵的 M[j][k] = 1。
初始值 f[1][j] = 1，子序列的第一个数无约束。
答案为 sum(f[k])。
把 f[1] 迭代 k-1 次可以得到 f[k]，所以 pow 的幂次是 k-1。
代码 https://codeforces.com/contest/691/submission/341484269
代码备份（上面打不开的同学看这个）
======

Input
5 2
15 1 2 4 8
Output
13

Input
5 1
15 1 2 4 8
Output
5
 */
