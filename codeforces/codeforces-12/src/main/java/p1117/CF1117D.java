package p1117;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF1117D {
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
        long n = scanner.nextLong();
        int k = scanner.nextInt();

        long[][] m = new long[k][k];
        m[0][0] = 1;
        m[0][k - 1] = 1;
        for (int i = 0; i < k - 1; i++) {
            m[i + 1][i] = 1;
        }
        long[][] fn = matQuickPow(m, n);
        out.print(fn[0][0]);
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
D. Magic Gems
https://codeforces.com/contest/1117/problem/D

灵茶の试炼 2025-10-02
题目大意：
输入 n(1≤n≤1e18) m(2≤m≤100)。
构造一个数组 a，只包含 1 和 m，且 sum(a) = n。
输出方案数，模 1e9+7。
注意元素顺序不同，也算不同的数组，比如 [1,1,m] 和 [m,1,1] 是不同的数组。

rating 2100
考虑最后一个数，填 1，那么子问题是 n-1；填 m，那么子问题是 n-m。
和 LC70. 爬楼梯 一样，每次爬 1 个或 m 个台阶，问爬 n 个台阶的方案数。
70 那题 m=2，状态转移方程为 f[i] = f[i-1] + f[i-2]，本题是 f[i] = f[i-1] + f[i-m]。
用矩阵快速幂解决。不熟悉的同学先用矩阵快速幂把 70 那题做了，详见我的题解。
代码 https://codeforces.com/contest/1117/submission/341418355
代码备份（上面打不开的同学看这个）
======

Input
4 2
Output
5

Input
3 2
Output
3
 */
