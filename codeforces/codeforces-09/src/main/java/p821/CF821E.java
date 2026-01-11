package p821;

import java.io.PrintWriter;
import java.util.Scanner;

public class CF821E {
    static Scanner scanner = new Scanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    private static void solve() {
        int n = scanner.nextInt();
        long k = scanner.nextLong();

        long[][] f = new long[16][1];
        f[0][0] = 1;
        for (int p = 0; p < n; p++) {
            long l = scanner.nextLong();
            long r = scanner.nextLong();
            int c = scanner.nextInt();

            long[][] m = new long[16][16];
            for (int i = 0; i <= c; i++) {
                for (int j = Math.max(i - 1, 0); j <= Math.min(i + 1, c); j++) {
                    m[i][j] = 1;
                }
            }

            if (p == n - 1) {
                r = k;
            }
            long[][] fn = matQuickPow(m, r - l);
            f = matMulti(fn, f);
        }

        out.println(f[0][0]);
    }

    private static final int MOD = (int) (1e9 + 7);

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
E. Okabe and El Psy Kongroo
https://codeforces.com/contest/821/problem/E

灵茶の试炼 2025-11-13
题目大意：
输入 n(1≤n≤100) 和 k(1≤k≤1e18)。
然后输入 n 条水平线段，每条线段输入 L R(0≤L<R≤1e18) Y(0≤Y≤15)，表示线段左右端点的横坐标，以及线段的纵坐标。
保证 L[1] = 0，R[i] = L[i+1]，L[n]≤k≤R[n]。
这些水平线段组成了上边界。下边界为 x 轴。
你从平面直角坐标系的原点 (0,0) 出发，目标是 (k,0)。
每一步，你可以从 (x,y) 移动到 (x+1,y-1)、(x+1,y) 或者 (x+1,y+1)。
对于第 i 条线段，你的纵坐标必须满足 0≤y≤Y[i]。
特别地，当一条线段结束、另一条线段开始时，需要同时满足两条线段的 Y 限制。
输出从 (0,0) 移动到 (k,0) 的合法方案数，模 1e9+7。

rating 2100
网格图路径计数，考虑 DP。
定义 f[i][j] 表示移动到 (i,j) 的方案数。
考虑转移来源，可以是 (i-1,j-1), (i-1,j), (i-1,j+1)，但不能越界。
即 f[i][j] += f[i-1][k]，其中 k 在 [max(j-1,0), min(j+1,Y)] 中，Y 是线段的纵坐标。
初始值是本题的关键。
如果是第一条线段，那么初始值 f[0][0] = 1（起点），其余 f[0][j] = 0。
否则，初始值是上一条线段的 f[R][j]。其中 R 是上一条线段的右端点横坐标，也是当前这条线段的左端点横坐标。
注意不需要修剪 f[R] 中的越界状态，转移方程限制了我们不会从越界的位置转移过来。
答案为最后一条线段的 f[k][0]（终点）。
对于每一条线段，计算一次矩阵快速幂（分段矩阵快速幂）。
把矩阵快速幂的结果（列向量），作为下一条线段的矩阵快速幂的列向量。
注意最后一条线段的右端点视作 k。
代码 https://codeforces.com/contest/821/submission/347485134
代码备份（上面打不开的同学看这个）
======

Input
1 3
0 3 3
Output
4

Input
2 6
0 3 0
3 10 2
Output
4
 */
