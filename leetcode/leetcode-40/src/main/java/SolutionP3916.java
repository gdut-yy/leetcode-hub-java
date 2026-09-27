import java.util.Arrays;

public class SolutionP3916 {
    private static final int MOD = (int) (1e9 + 7);

    public int zigZagArrays(int n, int l, int r) {
        long k = (long) r - l + 1;
        if (k <= n + 1) {
            return dp(n, (int) k);
        }
        // k 较大时使用拉格朗日插值（dp 是关于 k 的 n 次多项式）
        int[] xs = new int[n + 1];
        int[] ys = new int[n + 1];
        for (int x = 1; x <= n + 1; x++) {
            xs[x - 1] = x;
            ys[x - 1] = dp(n, x);
        }
        return lagrange(xs, ys, k);
    }

    private int dp(int n, int k) {
        int[] f = new int[k];
        Arrays.fill(f, 1);
        for (int i = 1; i < n; i++) {
            if (i % 2 != 0) { // 增：前缀和
                long pre = 0;
                for (int j = 0; j < k; j++) {
                    int v = f[j];
                    f[j] = (int) (pre % MOD);
                    pre += v;
                }
            } else { // 减：后缀和
                long suf = 0;
                for (int j = k - 1; j >= 0; j--) {
                    int v = f[j];
                    f[j] = (int) (suf % MOD);
                    suf += v;
                }
            }
        }
        long total = 0;
        for (int v : f) {
            total += v;
        }
        return (int) ((total * 2) % MOD);
    }

    private int lagrange(int[] xs, int[] ys, long k) {
        int n = xs.length;
        long fk = 0;
        for (int i = 0; i < n; i++) {
            long a = ys[i], b = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    a = a * floorMod(k - xs[j], MOD) % MOD; // 分子
                    b = b * floorMod(xs[i] - xs[j], MOD) % MOD; // 分母
                }
            }
            fk = (fk + a * quickPow(b, MOD - 2)) % MOD;
        }
        return (int) fk;
    }

    // 快速幂 res = a^b % mod
    private long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }


    private long floorMod(long a, long m) {
        return ((a % m) + m) % m;
    }
}
/*
$3916. 锯齿形数组的总数 III
https://leetcode.cn/problems/number-of-zigzag-arrays-iii/description/

给你三个整数 n、l 和 r。
长度为 n 的锯齿形数组定义如下：
每个元素的取值范围为 [l, r]。
任意 两个 相邻的元素都不相等。
任意 三个 连续的元素不能构成一个 严格递增 或 严格递减 的序列。
返回满足条件的锯齿形数组的总数。
由于答案可能很大，请将结果对 10^9 + 7 取余数。
示例 1：
输入：n = 3, l = 4, r = 5
输出：2
示例 2：
输入：n = 3, l = 1, r = 3
输出：10
提示：
3 <= n <= 200
1 <= l < r <= 10^9
 */