package lq231223;

import java.util.Arrays;
import java.util.Scanner;

public class LQ231223T9 {
    static long n;
    static int m;
    static Order[] pc;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextLong();
        m = scanner.nextInt();
        pc = new Order[m];
        for (int i = 0; i < m; i++) {
            long p = scanner.nextLong();
            int c = scanner.nextInt();
            pc[i] = new Order(p, c);
        }
        System.out.println(solve());
    }

    private static final int MOD = 998244353;

    private static String solve() {
        if (m == 0) {
            long ans = 72 * quickPow(71, n - 1) % MOD;
            return String.valueOf(ans);
        }

        long[][] A = {{0, 71}, {1, 70}};
        // sort(p + 1, p + 1 + m);
        Arrays.sort(pc, (o1, o2) -> {
            if (o1.p == o2.p) return Integer.compare(o1.c, o2.c);
            return Long.compare(o1.p, o2.p);
        });
        long ans = quickPow(71, pc[0].p - 1);

        for (int i = 1; i < m; i++) {
            if (pc[i].p == pc[i - 1].p + 1 && pc[i].c == pc[i - 1].c) {
                return "0";
            }

            if (pc[i].p == pc[i - 1].p + 1) continue;
            long[] cur;
            if (pc[i].c == pc[i - 1].c) {
                cur = new long[]{0, ans * 71 % MOD};
            } else {
                cur = new long[]{ans, ans * 70 % MOD};
            }

            long[][] S = mat_pow(A, pc[i].p - pc[i - 1].p - 1);
            ans = cur[0] * S[0][0] % MOD + cur[1] * S[1][0] % MOD;
            ans %= MOD;
        }

        ans = ans * quickPow(71, n - pc[m - 1].p) % MOD;
        return String.valueOf(ans);
    }

    // 模下的 a^b
    static long quickPow(long a, long b) {
        long ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return ans;
    }

    // 矩阵快速幂 res[][] = a[][]^b
    static long[][] mat_pow(long[][] a, long b) {
        int n = a.length;
        // 对角矩阵
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) res[i][i] = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = mat_mul(res, a);
            }
            a = mat_mul(a, a);
            b >>= 1;
        }
        return res;
    }

    // 矩阵乘法 res[][] = a[][] * b[][]
    static long[][] mat_mul(long[][] a, long[][] b) {
        int n = a.length;
        long[][] res = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    res[i][j] += a[i][k] * b[k][j] % MOD;
                    res[i][j] %= MOD;
                }
            }
        }
        return res;
    }

    static class Order {
        long p;
        int c;

        public Order(long p, int c) {
            this.p = p;
            this.c = c;
        }
    }
}
/*
香煎七十二餐馆【算法赛】

考察动态规划，优化，矩阵快速幂
首先构建一个简单的 DP 转移：
dp_i,j 表示处理到第 i 个人时，第 i 人选择第 j 道菜时的方案数。
转移比较简单：
dp_u,j = \sum{j' != j}_{} dp_i_1,j'
这个复杂度为 O(n 72^2)
前缀和优化一下可以优化到 O(n 72)

考虑继续优化，考虑隔板，每两个相邻的中间位置都是独立的。所以我们计算出所有的段，然后乘法原理即可。
考虑一段，那么左右两边都已经固定下来了，我们将左边的设定为食物 1，右边定位食物 2（假设左边与右边不同），其他的都定位食物 3 类。
考虑转移：
dp_i,1 = dp_i-1,2 + dp_i,3
dp_i,2 = dp_i-1,1 + dp_i,3
dp_i,3 = dp_i-1,1 * 70 + dp_i-1,2 * 70 + dp_i,3 * 69
复杂度为 O(3n)
继续优化，发现这可以看成矩阵转移：
\begin{bmatrix}
dp_{i,1} & dp_{i,2} & dp_{i,3}
\end{bmatrix}=
\begin{bmatrix}
dp_{i-1,1} & dp_{i-1,2} & dp_{i-1,3}
\end{bmatrix}
\times
\begin{bmatrix}
 0 & 1 & 70\\
 1 & 0 & 70\\
 1 & 1 & 69
\end{bmatrix}
考虑矩阵快速幂即可。
复杂度 O(m * logn * 3^3)
 */