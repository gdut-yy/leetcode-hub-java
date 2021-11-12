package template;

/**
 * 快速幂
 */
public class QuickPower {
    /**
     * 快速幂 res = a^b % mod
     */
    private int quickPow(long a, long b, int mod) {
        a %= mod;
        long res = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                res *= a;
                res %= mod;
            }
            a *= a;
            a %= mod;
            b /= 2;
        }
        return (int) res;
    }

    /**
     * 矩阵快速幂 res[][] = a[][]^n
     */
    private int[][] matQuickPow(int[][] a, int n) {
        int len = a.length;
        // 对角矩阵
        int[][] res = new int[len][len];
        for (int i = 0; i < len; i++) {
            res[i][i] = 1;
        }
        while (n > 0) {
            if ((n & 1) == 1) {
                res = matMulti(res, a);
            }
            n >>= 1;
            a = matMulti(a, a);
        }
        return res;
    }

    /**
     * 矩阵乘 res[][] = a[][] * b[][]
     */
    private int[][] matMulti(int[][] a, int[][] b) {
        int len = a.length;
        int[][] res = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    res[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return res;
    }

    /**
     * 矩阵乘 res[][] = a[][] * b[][]
     */
    private long[][] matMultiply(long[][] a, long[][] b, long mod) {
        int row = a.length;
        long[][] res = new long[row][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < row; k++) {
                    res[i][j] += (a[i][k] * b[k][j]) % mod;
                    res[i][j] %= mod;
                }
            }
        }
        return res;
    }

    /**
     * 矩阵乘 res[] = a[][] * b[]
     */
    private long[] matMultiply(long[][] a, long[] b, long mod) {
        int row = a.length;
        long[] res = new long[row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                res[i] += ((a[i][j]) * b[j]) % mod;
                res[i] %= mod;
            }
        }
        return res;
    }
}
