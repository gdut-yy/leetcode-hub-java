package p514;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF514E {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) V2.solve();
        out.flush();
    }

    // 矩阵快速幂
    static class V1 {
        private static void solve() {
            int n = scanner.nextInt();
            int x = scanner.nextInt();

            long[] cnt = new long[MX + 1];
            for (int i = 0; i < n; i++) {
                int v = scanner.nextInt();
                cnt[v]++;
            }

            long[][] m = new long[MX + 1][MX + 1];
            System.arraycopy(cnt, 1, m[0], 0, MX);
            m[0][MX] = 1;
            for (int j = 1; j < MX; j++) {
                m[j][j - 1] = 1;
            }
            m[MX][MX] = 1;

            long[][] f0 = new long[MX + 1][1];
            f0[0][0] = 1;
            f0[MX][0] = 1;

            long[][] fn = matQuickPow(m, x);
            fn = matMulti(fn, f0);
            out.println(fn[0][0]);
        }

        private static final int MOD = (int) (1e9 + 7);
        static final int MX = 100;

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

    static class V2 {
        private static final int MOD = (int) (1e9 + 7);

        static void solve() {
            int n = scanner.nextInt();
            int x = scanner.nextInt();

            final int MX = 100;
            int[] cnt = new int[MX + 1];
            for (int i = 0; i < n; i++) {
                int v = scanner.nextInt();
                cnt[v]++;
            }

            long[] a = new long[MX * 2 + 2];
            a[0] = 1;
            for (int i = 1; i < a.length; i++) {
                a[i] = 1;
                for (int j = 1; j <= Math.min(i, MX); j++) {
                    a[i] += cnt[j] * a[i - 1 - (j - 1)] % MOD;
                }
                a[i] %= MOD;
            }
            long[] coef = berlekampMassey(a);
            reverse(coef);
            out.println(kitamasa(coef, a, x));
        }

        static void reverse(long[] a) {
            for (int l = 0, r = a.length - 1; l < r; l++, r--) {
                long tmp = a[l];
                a[l] = a[r];
                a[r] = tmp;
            }
        }

        // 快速幂 res = a^b % mod
        static long quickPow(long a, long b) {
            long res = 1L;
            while (b > 0) {
                if ((b & 1) != 0) res = res * a % MOD;
                a = a * a % MOD;
                b >>= 1;
            }
            return res;
        }

        static long[] berlekampMassey(long[] a) {
            long[] preC = new long[0];
            int preI = -1;
            long preD = 0;
            long[] coef = new long[0];
            for (int i = 0; i < a.length; i++) {
                long d = a[i];
                for (int j = 0; j < coef.length; j++) {
                    d = (d - coef[j] * a[i - 1 - j]) % MOD;
                }
                if (d == 0) continue;
                if (preI < 0) {
                    coef = new long[i + 1];
                    preI = i;
                    preD = d;
                    continue;
                }
                int bias = i - preI;
                int oldLen = coef.length;
                int newLen = bias + preC.length;
                long[] tmp = null;
                if (newLen > oldLen) {
                    tmp = coef.clone();
                    coef = new long[newLen];
                    System.arraycopy(tmp, 0, coef, 0, oldLen);
                }
                long delta = d * quickPow(preD, MOD - 2) % MOD;
                coef[bias - 1] = (coef[bias - 1] + delta) % MOD;
                for (int j = 0; j < preC.length; j++) {
                    coef[bias + j] = (coef[bias + j] - delta * preC[j]) % MOD;
                }
                if (newLen > oldLen) {
                    preC = tmp;
                    preI = i;
                    preD = d;
                }
            }
            return coef;
        }

        static long kitamasa(long[] coef, long[] a, int n) {
            if (n < a.length) return a[n];
            int k = coef.length;
            if (k == 0) return 0;
            if (k == 1) return a[0] * quickPow(coef[0], n) % MOD;

            long[] resC = new long[k];
            resC[0] = 1;
            long[] c = new long[k];
            c[1] = 1;
            for (; n > 0; n /= 2) {
                if (n % 2 > 0) {
                    resC = compose(coef, c, resC);
                }
                c = compose(coef, c, c.clone());
            }
            long ans = 0;
            for (int i = 0; i < k; i++) {
                ans = (ans + resC[i] * a[i]) % MOD;
            }
            ans = (ans % MOD + MOD) % MOD;
            return ans;
        }

        static long[] compose(long[] coef, long[] a, long[] b) {
            int k = coef.length;
            long[] c = new long[k];
            for (long v : a) {
                for (int j = 0; j < b.length; j++) {
                    c[j] = (c[j] + v * b[j]) % MOD;
                }
                long bk1 = b[k - 1];
                for (int j = k - 1; j > 0; j--) {
                    b[j] = (b[j - 1] + bk1 * coef[j]) % MOD;
                }
                b[0] = bk1 * coef[0] % MOD;
            }
            return c;
        }
    }
}
/*
E. Darth Vader and Tree
https://codeforces.com/contest/514/problem/E

灵茶の试炼 2025-11-06
题目大意：
输入 n(1≤n≤1e5) x(0≤x≤1e9) 和长为 n 的数组 d(1≤d[i]≤100)。
有一棵无限大的 n 叉树，每个节点都有 n 个儿子。
对于每个节点，到其第 i 个儿子的距离为 d[i]。
输出距离根节点不超过 x 的节点个数，模 1e9+7。
注意根节点一定满足要求，也算在内。

rating 2200
这棵树是自相似的，每个节点都和整棵树相似。
定义 f[i] 表示到当前节点距离 <= i 的节点个数。
考察当前节点的第 j 个儿子 v，问题变成到 v 距离 <= i - d[j] 的节点个数，即 f[i] += f[i-d[j]]。
枚举 j=1..n，得 f[i] = 1 + sum_{j=1..n} f[i-d[j]]，其中 1 是把当前节点也算进来。
初始值 f[0]=1，答案为 f[x]。
注意 d[j] 的范围很小，设 cnt[k] 是 d[j]=k 的 d[j] 的个数，转移方程优化成
f[i] = 1 + sum_{k=1..100} cnt[k] * f[i-k]
这样就可以用矩阵快速幂优化了。
注意 f 包含常数项，可以在列向量末尾添加一个 1，系数矩阵下面和右边添加一行，右下角是 1 其余为 0。
初始值：一个长为 101 的列向量，第一个数表示 f[0] = 1，最后一个数表示常数项 1，其余的相当于 f[-1]=f[-2]=...=0。
另一种写法是，直接用递推式求出 f 的前 202 项（系数矩阵的阶为 101，乘以 2）。
然后用 Berlekamp-Massey 算法 https://zhuanlan.zhihu.com/p/1966417899825665440 找规律，得到不含常数项的线性递推式（可以证明这样的递推式一定存在）。
最后用 Kitamasa 算法 https://zhuanlan.zhihu.com/p/1964051212304364939 求出 f[x]。
矩阵快速幂 https://codeforces.com/contest/514/submission/347485206
Berlekamp-Massey + Kitamasa https://codeforces.com/contest/514/submission/347485689
代码备份（上面打不开的同学看这个）
======

Input
3 3
1 2 3
Output
8

10 100000
1 1 2 2 3 3 4 4 5 5

475936186
 */
