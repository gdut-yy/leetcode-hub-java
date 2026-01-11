package p1895;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class CF1895F {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
        t = scanner.nextInt();
        while (t-- > 0) V2.solve();
        out.flush();
    }

    // 写法一
    static class V1 {
        private static final int MOD = (int) (1e9 + 7);

        private static void solve() {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int k = scanner.nextInt();

            long ans = (long) (x + k) * quickPow(k * 2L + 1, n - 1) % MOD;

            if (x > 0) {
                long[][] m = new long[x][x];
                for (int j = 0; j < x; j++) {
                    for (int v = Math.max(j - k, 0); v <= Math.min(j + k, x - 1); v++) {
                        m[j][v] = 1;
                    }
                }

                // 创建初始向量 f1 (x x 1)
                long[][] f1 = new long[x][1];
                for (int j = 0; j < x; j++) {
                    f1[j][0] = 1;
                }

                long[][] fn = matQuickPow(m, n - 1);
                fn = matMulti(fn, f1);
                for (long[] row : fn) {
                    ans -= row[0];
                }
            }

            ans = (ans % MOD + MOD) % MOD;
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
    }

    // 写法二
    static class V2 {
        private static final int MOD = (int) (1e9 + 7);

        private static void solve() {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int k = scanner.nextInt();

            if (n == 1) {
                out.println(k);
                return;
            }

            long ans = (long) (x + k) * quickPow(k * 2L + 1, n - 1) % MOD;
            if (x == 0) {
                out.println((ans % MOD + MOD) % MOD);
                return;
            }

            long[] f = new long[x];
            Arrays.fill(f, 1);
            long[] sum = new long[x + 1];

            long[] a = new long[x * 2];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < f.length; j++) {
                    sum[j + 1] = (sum[j] + f[j]) % MOD;
                }
                for (int j = 0; j < f.length; j++) {
                    f[j] = (sum[Math.min(j + k + 1, x)] - sum[Math.max(j - k, 0)]) % MOD;
                    a[i] += f[j];
                }
                a[i] %= MOD;
            }

            long[] coef = berlekampMassey(a);
            reverse(coef);
            ans -= kitamasa(coef, a, n - 2);
            out.println((ans % MOD + MOD) % MOD);
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
F. Fancy Arrays
https://codeforces.com/contest/1895/problem/F

灵茶の试炼 2025-11-07
题目大意：
输入 T(≤50) 表示 T 组数据。
每组数据输入 n(1≤n≤1e9) x(0≤x≤40) k(1≤k≤1e9)。
有多少个数组 a，满足如下条件？
1. 长为 n。
2. 元素值均为非负整数。
3. 至少有一个 a[i] 在 [x,x+k-1] 中。
4. a 中所有相邻元素 (x,y)，均满足 |x-y|≤k。
输出符合要求的 a 的个数，模 1e9+7。

rating 2600
看到「至少」，你可能想到了正难则反（容斥）。
也就是用总方案数减去不合法方案数。
但这就是本题的难点，什么是总方案？什么是不合法方案？
对于总方案，无视 [x,x+k-1] 的限制？
但题目要求 a[i] 不能是负数，不好处理。而且题目也没有限定 a[i] 的上界。
所以计算总方案不能无视 [x,x+k-1]。
考虑 min(a) <= x+k-1 的数组，作为总方案。
由于不合法数组不能同时包含 [0,x-1] 和 [x+k,∞) 中的数，所以总方案中的不合法方案就是 max(a) <= x-1 的数组个数。
总方案：
考虑 a 的长为 n-1 的差分数组 d，确定了 d，就确定了 a 的折线图（横轴为下标，纵轴为 a[i]）。
这条折线图可以上下平移。确定 min(a)，就固定了折线图的位置。
min(a) 可以在 [0,x+k-1] 中，有 x+k 个不同的值。
每个 d[i] 可以在 [-k,k] 中，有 2k+1 个不同的值。n-1 个 d[i] 就是 (2k+1)^(n-1)。
所以总方案数为 (x+k) * (2k+1)^(n-1)。
不合法方案：
定义 f[i][j] 表示长为 i 的数组，元素范围 [0,x-1]，相邻元素绝对差 <= k，最后一个数是 j 的方案数。
转移：枚举 i-1 位置上的值 v，从 f[i-1][v] 转移过来。其中 abs(v-j) <= k。
初始值：f[1][j] = 1。
答案：sum(f[n])。
写法一：用矩阵快速幂优化。
写法二：算出连续 2x 个 sum(f[i])，用 Berlekamp-Massey 算法 找规律（线性递推式），然后用 Kitamasa 算法 计算第 n 项。
写法一 https://codeforces.com/problemset/submission/1895/347180735
写法二 https://codeforces.com/problemset/submission/1895/347181072
代码备份（上面打不开的同学看这个）
======

Input
4
3 0 1
1 4 25
4 7 2
1000000000 40 1000000000
Output
9
25
582
514035484

50
325 9 1
431 39 5
132 7 2
590 15 5
536 10 7
250 6 2
533 33 10
253 35 8
299 32 9
753 4 2
683 21 5
685 10 2
366 21 9
12 17 1
263 11 9
860 15 5
743 28 4
709 16 9
953 35 3
824 5 4
655 20 2
595 36 2
133 5 6
617 7 1
348 6 3
939 0 1
244 5 1
554 2 1
309 19 2
557 16 7
598 29 1
816 14 2
15 30 1
618 17 5
285 20 3
710 28 2
804 40 3
110 27 9
524 2 1
917 36 4
783 36 8
828 33 1
610 28 1
176 1 10
968 14 5
155 15 2
503 20 5
271 15 7
951 4 2
901 14 2

630274093
951403609
264337334
160069934
476489487
124304385
916835939
789613132
155998051
594676970
583302452
78503365
190443521
786985
172252866
711225377
513917627
747418600
995138720
951220842
126270751
827586805
794353278
661721628
231541321
614127676
94044246
225876065
879319015
822586576
770864289
333395476
23832931
745380707
682613192
593454929
464588473
303129521
469124524
594096792
808268846
346379197
917346633
566880638
916888831
382826685
977545075
131195600
928084880
403537459

1
325 9 1
 */
