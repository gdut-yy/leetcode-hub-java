package lq240406;

import java.util.Scanner;

public class LQ240406T9 {
    static int a, b, n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            n = scanner.nextInt();
            System.out.println(solve());
        }
    }

    private static String solve() {
        long[][] grid = new long[a][a];
        for (int i = 0; i < a; i++) {
            grid[i][i] += 1;
            grid[(i - 1 + a) % a][i] += 1;
        }
        long ans = matrix_pow(grid, n)[0][b];
        return String.valueOf(ans);
    }

    static final int MOD = (int) (1e9 + 7);

    static long[][] matrix_mul(long[][] a, long[][] b) {
        int n = a.length;
        int m = a[0].length;
        int p = b[0].length;
        long[][] ans = new long[n][p];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < p; k++) {
                    ans[i][k] += a[i][j] * b[j][k];
                    ans[i][k] %= MOD;
                }
            }
        }
        return ans;
    }

    static long[][] matrix_pow(long[][] x, int n) {
        if (n == 1) return x;
        if (n == 2) return matrix_mul(x, x);
        long[][] v = matrix_pow(x, n / 2);
        long[][] ans = matrix_mul(v, v);
        if (n % 2 == 0) return ans;
        return matrix_mul(ans, x);
    }
}
/*
组合数【算法赛】

观察到组合数中的 a*i+b 对 a 的余数均为 b，且 [0,n] 中所有对 a 的余数均为 b 的数均计算在内。
故原式可以理解为：有 n 个不同的小球，取出这些小球取且取出的个数是对 a 取模后为 b 的方案数。
设 f[i][j] 为考虑完前 i 个小球，当前取出小球的个数模 a 是 j 的方案数。状态转移方程为：
f[i][j] = f[i-1][j] + f[i-1][(j-1) mod a]
用矩阵快速幂加速即可。
时间复杂度为 O(50^3 T logn)。
@小羊肖恩Yawn_Sean
 */