import java.util.ArrayList;
import java.util.List;

public class Hust10242023T5 {
    private static final int MOD = 998244353;

    /**
     * S = {1, 2, ..., n*m+k}，元素皆按 mod m 分组。
     * 前 n*m 个元素恰好构成 n 个完整剩余类循环（每个剩余类 0..m-1 各 n 次），
     * 余下 k 个元素（n*m+1 .. n*m+k）的剩余类为 1..k，各多一次。
     * 因此在群代数 Z[C_m]（即模 x^m-1）中有：
     *     P = Q^n * B,  Q = prod_{r=0}^{m-1}(1+x^r),  B = prod_{r=1}^{k}(1+x^r)
     *
     * 对 Q 做 C_m 上的离散傅里叶变换：阶为 d 的特征标处取值为
     *     (1-(-1)^d)^(m/d)
     * d 为偶数时为 0，d 为奇数时为 2^(m/d)。于是 Q^n 的系数为
     *     q_t = (1/m) * sum_{d | m, d 为奇数} 2^(n*m/d) * c_d(t)
     * 其中 c_d(t) 为 Ramanujan 和，可用 c_d(t) = sum_{e|d, e|t} e * mu(d/e) 计算。
     *
     * 最后把 B 的 k 个因子 (1+x^r) 依次作用到 q 上即可（每次 O(m)）。
     * 时间复杂度：O(m * tau(m) + k * m)；空间复杂度：O(m)。
     */
    public int[] subsetCounting(long n, int k, int m) {
        long[] q = new long[m];

        // n == 0 时 S = {1..k}，答案就是 B 的系数
        if (n == 0) {
            q[0] = 1;
            for (int r = 1; r <= k; r++) {
                q = multiplyByOnePlusXr(q, r, m);
            }
            return toIntArray(q);
        }

        // m 的所有约数
        List<Integer> divisors = new ArrayList<>();
        for (int d = 1; (long) d * d <= m; d++) {
            if (m % d == 0) {
                divisors.add(d);
                if (d != m / d) {
                    divisors.add(m / d);
                }
            }
        }

        int[] mu = new int[m + 1];
        int[] phi = new int[m + 1];
        computeMuPhi(m, mu, phi);

        long invM = modPow(m, MOD - 2);
        for (int d : divisors) {
            if ((d & 1) == 0) {
                continue;
            }
            // 2^(n * (m/d))，指数最大约 10^18，改用费马小定理约简也可，这里直接快速幂
            long exp = n * (m / d);
            long pw = modPowLong(2, exp);
            long[] cd = ramanujan(d, mu);
            for (int t = 0; t < m; t++) {
                long c = cd[t % d] % MOD;
                if (c < 0) {
                    c += MOD;
                }
                q[t] = (q[t] + pw * c) % MOD;
            }
        }
        for (int t = 0; t < m; t++) {
            q[t] = q[t] * invM % MOD;
        }

        for (int r = 1; r <= k; r++) {
            q = multiplyByOnePlusXr(q, r, m);
        }
        return toIntArray(q);
    }

    /** 在模 x^m-1 下乘以 (1 + x^r)。 */
    private long[] multiplyByOnePlusXr(long[] q, int r, int m) {
        r %= m;
        long[] res = new long[m];
        if (r == 0) {
            for (int t = 0; t < m; t++) {
                res[t] = q[t] * 2 % MOD;
            }
        } else {
            for (int t = 0; t < m; t++) {
                res[t] = (q[t] + q[(t - r + m) % m]) % MOD;
            }
        }
        return res;
    }

    /** c_d(t) = sum_{e | d, e | t} e * mu(d / e)，返回值下标为 t mod d。 */
    private long[] ramanujan(int d, int[] mu) {
        long[] c = new long[d];
        for (int e = 1; e <= d; e++) {
            if (d % e != 0) {
                continue;
            }
            long coef = (long) e * mu[d / e];
            if (coef == 0) {
                continue;
            }
            for (int r = 0; r < d; r += e) {
                c[r] += coef;
            }
        }
        return c;
    }

    private void computeMuPhi(int m, int[] mu, int[] phi) {
        if (m >= 1) {
            mu[1] = 1;
            phi[1] = 1;
        }
        boolean[] composite = new boolean[m + 1];
        int[] primes = new int[m + 1];
        int pc = 0;
        for (int i = 2; i <= m; i++) {
            if (!composite[i]) {
                primes[pc++] = i;
                mu[i] = -1;
                phi[i] = i - 1;
            }
            for (int j = 0; j < pc && (long) i * primes[j] <= m; j++) {
                int x = i * primes[j];
                composite[x] = true;
                if (i % primes[j] == 0) {
                    mu[x] = 0;
                    phi[x] = phi[i] * primes[j];
                    break;
                } else {
                    mu[x] = -mu[i];
                    phi[x] = phi[i] * (primes[j] - 1);
                }
            }
        }
    }

    private int[] toIntArray(long[] q) {
        int[] res = new int[q.length];
        for (int i = 0; i < q.length; i++) {
            res[i] = (int) q[i];
        }
        return res;
    }

    private long modPow(long base, int exp) {
        return modPowLong(base, exp);
    }

    private long modPowLong(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }
}
/*
Q5. 计算子集
https://leetcode.cn/contest/hust_1024_2023/problems/kzxnaX/

给你三个整数 n, k, m 。定义 S={i∣1≤i≤nm+k,i∈Z} 。
请返回一个下标从 0 开始、长度为 m 的数组 answer，其中 answer[i] 表示符合下列条件集合 T 的个数。
集合 T 是集合 S 的子集。
集合 T 中所有元素的和对 m 取余的值恰好为 i 。
由于答案可能很大，你只需要求出它模 998244353 的结果。
示例 1：
输入：n = 1, k = 1, m = 2 输出：[4,4]
示例 2：
输入：n = 1919, k = 8, m = 10 输出：[577613260,577613260,822345879,577613260,822345879,577613260,577613260,822345879,577613260,822345879]
提示：
0 <= n <= 10^13
0 <= k < min(m, 500)
1 <= m <= 10^5
n * m + k > 0
 */
