package lq240127;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LQ240127T6 {
    static int n;
    static int[] k;

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        FastReader scanner = new FastReader();
        n = scanner.nextInt();
        k = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            k[i] = scanner.nextInt();
        }
        System.out.println(solve());
    }

    static final int mod = 998244353;
    static final int N = (int) 5e6;
    static long[] pw = new long[N + 5], inv_pw = new long[N + 5];
    static long[] ans_p = new long[N + 5];
    static long[] ans_rk = new long[N + 5];

    private static String solve() {
        pw[0] = 1;
        for (int i = 1; i <= N; ++i) pw[i] = pw[i - 1] * 2 % mod;
        long inv_2 = inv(2);
        inv_pw[0] = 1;
        for (int i = 1; i <= N; ++i) inv_pw[i] = inv_pw[i - 1] * inv_2 % mod;

        long mul_p = 1;
        for (int i = 1; i <= n; ++i) {
            long p = inv_pw[k[i]];
            ans_p[i] = (1 - p) * mul_p % mod;
            ans_p[i] = (ans_p[i] + mod) % mod;
            mul_p = mul_p * p % mod;
        }
        long inv_mul_p = inv((1 - mul_p + mod) % mod);
        for (int i = 1; i <= n; ++i) ans_p[i] = ans_p[i] * inv_mul_p % mod;

        int cur_rk = 0;
        for (int i = 1; i <= n; ++i) {
            if (k[i] != 0) ans_rk[i] = ++cur_rk;
        }
        for (int i = 1; i <= n; ++i) {
            if (k[i] == 0) ans_rk[i] = ++cur_rk;
        }

//        return arr_to_str(ans_p) + System.lineSeparator() + arr_to_str(ans_rk);
        return arr_to_hash(ans_p) + System.lineSeparator() + arr_to_hash(ans_rk);
    }

    static String arr_to_str(long[] a) {
        StringBuilder res = new StringBuilder();
        res.append(a[1]);
        for (int i = 2; i <= n; i++) {
            res.append(" ").append(a[i]);
        }
        return res.toString();
    }

    static String arr_to_hash(long[] a) {
        long res = 0;
        for (int i = 1; i <= n; ++i) res = (res + a[i] * i) % mod;
        return String.valueOf(res);
    }

    // 模下的 a^b
    private static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % mod;
            }
            a = a * a % mod;
            b >>= 1;
        }
        return res;
    }

    static long inv(long x) {
        return quickPow(x, mod - 2);
    }

    private static class FastReader {
        private final BufferedReader bufferedReader;
        private StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                if (stringTokenizer.hasMoreTokens()) {
                    str = stringTokenizer.nextToken("\n");
                } else {
                    str = bufferedReader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
/*
机器人【算法赛】

机器人转第一圈就停在第 j 个位置的概率：是前面位置都不停，这个位置停。有概率：
(1-p_j) \times {\textstyle \prod_{i=1}^{j-1} p_i}
机器人转第 t 圈停在第 j 个位置的概率：是前面位置都不停，这个位置停。有概率：
(1-p_j) \times {\textstyle \prod_{i=1}^{j-1} p_i} \times ( {\textstyle \prod_{i=1}^{n} p_i} )^{t-1}
因此机器人最终停在位置 j 的概率是
\sum_{t=1}^{\infty} (1-p_j) \times {\textstyle \prod_{i=1}^{j-1} p_i} \times ( {\textstyle \prod_{i=1}^{n} p_i} )^{t-1} = \frac{ (1-p_j) \times {\textstyle \prod_{i=1}^{j-1} p_i} }{ 1-{\textstyle \prod_{i=1}^{n} p_i} }
通过预处理 2 的若干次幂的积和逆元，这一部分的复杂度是 O(n+k)。
而当需要比较大小的时候，由于每个位置的概率的分母都相同，我们只需要比较分子 (1-p_j) \times {\textstyle \prod_{i=1}^{j-1} p_i} 即可。由于任意一 p 均可表示成 2^{-k} 的形式，因此：
(1-p_j) \times {\textstyle \prod_{i=1}^{j-1} p_i} = (1-2^{-k_j}) \times {\textstyle \prod_{i=1}^{j-1} 2^{-k_i}} = (2^{k_j}-1) \times 2^{ -({\textstyle \sum_{i=1}^{j} k_i}) }
将其对 2^{ -({\textstyle \sum_{i=1}^{j} k_i}) } 通分，得：
\frac{ (2^{k_j}-1) \times 2^{({\textstyle \sum_{i=j+1}^{n} k_i})} }{ 2^{({\textstyle \sum_{i=1}^{n} k_i})} }
对两个位置 x, y 进行比较大小（不妨假设 x < y），只需要判断不等式：
(2^{k_x}-1) \times 2^{({\textstyle \sum_{i=x+1}^{n} k_i})} < (2^{k_y}-1) \times 2^{({\textstyle \sum_{i=y+1}^{n} k_i})}
若 k_x = 0，则不等式左边等于 0，不等式是否成立取决于 k_y 是否等于 0。
若 k_x >= 1，则该式子等价于：
2^{({\textstyle \sum_{i=x+1}^{y} k_i})} \le \frac{ 2^{k_x}-1 }{ 2^{k_y}-1 }
由于 k_x \ge 1 \to  2^{k_x}-1 \ge 1，故 \frac{ 2^{k_x}-1 }{ 2^{k_y}-1 } \le 2^{k_y}-1 < 2^{k_y} \le 2^{({\textstyle \sum_{i=x+1}^{y} k_i})} 即上式恒不成立。
因此若 k_x 和 k_y 均不等于 0 或均等于 0，则编号小的优先级高，否则不等于 0 的优先级高，因此通过两遍 for 循环即可完成，复杂度 O(n)。
 */