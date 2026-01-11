package p93;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF93D {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) V2.solve();
        out.flush();
    }

    static final int MOD = (int) (1e9 + 7);

    static class V1 {
        private static void solve() {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            long ans = (sol(r) - sol(l - 1) + MOD) % MOD;
            out.println(ans);
        }

        static long sol(int n) {
            int inv2 = (MOD + 1) / 2;
            return (f(n) + f((n + 1) / 2)) * inv2 % MOD;
        }

        static long f(int n) {
            if (n == 0) return 0;
            if (n == 1) return 4;

            long[][] m = new long[17][17];
            long[][] f2 = new long[17][1];
            f2[16][0] = 4; // 长度等于 1 的方案数

            // 0123 = 白黑红黄
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (j == i || i + j == 3) continue;
                    for (int k = 0; k < 4; k++) {
                        if (k != j && j + k != 3 && (j != 0 || i + k != 3)) {
                            m[i * 4 + j][j * 4 + k] = 1;
                            m[16][j * 4 + k]++; // 计算 m 矩阵 j*4+k 列之和
                        }
                    }
                    f2[i * 4 + j][0] = 1;
                    f2[16][0]++; // 长度等于 2 的方案数
                }
            }
            m[16][16] = 1;

            m = matQuickPow(m, n - 2);
            m = matMulti(m, f2);
            return m[16][0];
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

    static class V2 {
        private static void solve() {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            long ans = (sol(r) - sol(l - 1) + MOD) % MOD;
            out.println(ans);
        }

        static long f(int n) {
            if (n == 0) {
                return 0;
            }
            long[] coef = {-3, 3, 1};
            long[] a = {4, 12, 26};
            return kitamasa(coef, a, n - 1);
        }

        static long sol(int n) {
            int inv2 = (MOD + 1) / 2;
            return (f(n) + f((n + 1) / 2)) * inv2 % MOD;
        }

        static long kitamasa(long[] coef, long[] a, int n) {
            if (n < a.length) return a[n];
            int k = coef.length;
//            if (k == 0) return 0;
//            if (k == 1) return a[0] * quickPow(coef[0], n) % MOD;

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
D. Flags
https://codeforces.com/contest/93/problem/D

灵茶の试炼 2025-10-31
题目大意：
输入 L R(1≤L≤R≤1e9)。
定义 C(n) 表示给一条长为 n 的纸带（n 个格子）涂色的不同方案数。涂色方案需满足如下要求：
1. 每个格子只能使用白色、黑色、红色或黄色。
2. 相邻格子颜色必须不同。
3. 不能有相邻的白色和黄色。
4. 不能有相邻的红色和黑色。
5. 连续三个颜色不能是黑白红，或者红白黑。
如果有两种涂色方案互为逆序，那么这两种方案是相同的。例如 ABCD 和 DCBA 互为逆序。
输出 C(L) + C(L+1) + ... + C(R)，模 1e9 + 7。

rating 2500
初步分析
分别计算 [1,R] 的方案数和 [1,L-1] 的方案数，二者相减就是答案。
设 f(n) 为 [1,n] 的方案数，不考虑互为逆序。
去掉 f(n) 中的回文方案数，剩下的方案可以两两一对，互为逆序。
所以考虑互为逆序的方案数，就是
(f(n) - 回文方案数) / 2 + 回文方案数 = (f(n) + 回文方案数) / 2。
对于回文方案数，长度不能是偶数（中间两个颜色相同），此时 <= n 变成 <= n-1。
当 n 为奇数时，根据左半就能确定右半，所以只有前 ceil(n/2) 个颜色需要计算方案数。
所以 [1,n] 考虑互为逆序时的方案数为 (f(n) + f(ceil(n/2))) / 2。
方法一：带有前缀和项的矩阵快速幂优化 DP
定义 dp[i][c1][c2] 表示长为 i 的纸带，位置 i-1 的颜色是 c1，位置 i 的颜色是 c2 时的方案数（不考虑互为逆序）。
枚举位置 i-2 的颜色 c，我们可以从 dp[i-1][c][c1] 转移过来。
由此可以得到一个 16*16 的系数矩阵 M，即 [列向量 n] = M @ [列向量 n-1]，其中 @ 表示矩阵乘法。
但请注意，我们求的不是 dp[n][*][*]，而是前缀和 dp[1][*][*] + dp[2][*][*] + ... + dp[n][*][*]。
怎么处理前缀和？
在列向量的最下面添加一个前缀和项 s[i]。
递推式 s[i] = sum(dp[i][*][*]) + s[i-1] = sum(M @ [列向量 i-1]) + s[i-1]。
这个递推式对应到系数矩阵上，就是：
在最下面新增一行：M 矩阵每一列的和，以及一个 1，即 [sum(M[i][0]), sum(M[i][1]), ..., sum(M[i][15]), 1]。
在最右边新增一列：除了最下面的 1 以外，其余全为 0。
方法二：Berlekamp-Massey 算法 + Kitamasa 算法
更加无脑的做法。
暴力求出 f(n) 的前若干项，然后用 Berlekamp-Massey 算法（入门讲解）https://zhuanlan.zhihu.com/p/1966417899825665440 得到递推式：
f(n) = f(n-1) + 3f(n-2) - 3f(n-3)   （系数从高到低为 1, 3, -3）
初始值 f(1)=4, f(2)=12, f(3)=26。
特判 n=0，返回 0。
然后用矩阵快速幂或者 Kitamasa 算法（入门讲解）https://zhuanlan.zhihu.com/p/1964051212304364939 求出 f(n)。
注意 f(n) 已经是纸带长为 1~n 的总涂色方案数了。
注：也可以直接暴力求出（逆序去重后的）1~n 的总涂色方案数，然后根据 Berlekamp-Massey 算法得到递推式。
系数从高到低为 1, 3, -3, 3, -3, -9, 9。
初始值（从 n=1 开始）4, 8, 19, 31, 59, 95, 170。
方法一 https://codeforces.com/problemset/submission/93/343440584
方法一备份
方法二 https://codeforces.com/contest/93/submission/346538705
方法二备份
======

Input
3 4
Output
23

Input
5 6
Output
64
 */
