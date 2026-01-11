package p498;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF498E {
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
        int w;
        long[][] f = {{1}};
        for (int h = 1; h <= 7; h++) {
            int size = 1 << h;
            long[][] m = new long[size][size];

            for (int r = 0; r < size; r++) {
                for (int l = 0; l < size; l++) {
                    long f0 = 0, f1 = 1;
                    for (int i = 0; i < h; i++) {
                        long s = f0 + f1;
                        if (((l & r) >> i & 1) > 0) {
                            f1 = f0;
                        } else {
                            f1 = s;
                        }
                        f0 = s;
                    }
                    m[r][l] = f1;
                }
            }

            w = scanner.nextInt();
            // f = append(newMat(len(f), 1), f...)
            int lenF = f.length;
            long[][] newF = new long[lenF + lenF][1];
            System.arraycopy(f, 0, newF, lenF, lenF);
            f = newF;

            m = matQuickPow(m, w);
            f = matMulti(m, f);
        }
        out.println(f[(1 << 7) - 1][0]);
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
E. Stairs and Lines
https://codeforces.com/contest/498/problem/E

灵茶の试炼 2025-11-14
题目大意：
输入一个长为 7 的数组 w(0≤w[i]≤1e5)，保证至少有一个 w[i]>0。
对于 i=1,2,...,7，从左到右依次拼接高为 i，底边长为 w[i] 的矩形（底边对齐），我们可以得到一个阶梯图形。
图形的边缘已经涂色。
你需要把图形内部格子的部分边界涂色，要求每个格子的四条边不能都被涂色。
输出涂色方案数，模 1e9+7。

rating 2700
和昨天的题目一样，分段矩阵快速幂。
考虑其中一个矩形的涂色方案数。
定义 f[i][mask] 表示对这个矩形的前 i 列涂色，且第 i 列右边界是 mask 的涂色方案数。其中 mask 是个二进制数，从低到高对应着从下往上的边是否涂色。0 表示不涂色，1 表示涂色。
考虑转移来源，枚举第 i-1 列的右边界二进制为 left，注意这同时也是第 i 列的左边界。
知道了第 i 列的左右边界怎么涂色，那么第 i 列内部的水平线段有多少种涂色方案？
这可以写一个 O(i) 的状态机 DP，从下往上计算。
定义 g[j][0/1] 表示涂前 j 条水平线段，且第 j 条不涂色/涂色的方案数。
枚举第 j-1 条是否涂色，结合 left>>j&1 和 mask>>j&1，就能知道从下往上第 j 个格子的四边涂色情况了。如果涂色格子个数 < 4 则可以转移。
初始值 g[0][0] = 0, g[0][1] = 1，因为底边一定染色。
这个状态机 DP 的结果为最上面的水平线段染色的 g 值，也就是 g[i][1]。
把状态机 DP 的计算结果，作为转移方程
f[i][mask] += 系数 * f[i-1][left]
中的系数。
初始值：
如果是第一个矩形（高为 1），那么初始化 f[0][1] = 1，因为第一个矩形的左边界一定涂色。
假设我们算出第一个矩形最右边不涂色有 6 种方案，最右边涂色有 7 种方案，
那么对于第二个矩形（高为 2），初始化 f[0][2]=6，f[0][3]=7。这是因为第二个矩形的不在内部的左边界一定被涂色。且 mask 的定义是二进制从低到高对应矩形的从下往上。
对应到代码上，可以在第一个矩形的矩阵快速幂计算完毕后（我们得到了一个长为 2 的列向量），在这个列向量的下面添加两个 0，就得到了第二个矩形的初始值。添加的两个 0 分别对应 f[0][0] = 0 和 f[0][1] = 0。
一般地，在我们计算高为 h 的矩形之前，往上一个矩形的计算结果（列向量）的下面添加 2^(h-1) 个 0。
最终答案为高为 7 的矩形的计算结果（列向量）的 2^7 - 1 项，因为最右边矩形的右边界全被涂色。
代码 https://codeforces.com/contest/498/submission/347948036
代码备份（上面打不开的同学看这个）
======

Input
0 1 0 0 0 0 0
Output
1

Input
0 2 0 0 0 0 0
Output
7

Input
1 1 1 0 0 0 0
Output
9

Input
5 1 0 3 0 0 1
Output
411199181
 */
