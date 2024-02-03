package lq231227;

import java.util.Scanner;

public class LQ231227T4 {
    static int n;
    static int[] a, b, c, d;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        b = new int[n];
        c = new int[n];
        d = new int[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextInt();
        for (int i = 0; i < n; i++) b[i] = scanner.nextInt();
        for (int i = 0; i < n; i++) c[i] = scanner.nextInt();
        for (int i = 0; i < n; i++) d[i] = scanner.nextInt();
        System.out.println(solve());
    }

    static final int MOD = 998244353;

    private static String solve() {
        long s1 = 0, s2 = 0;
        for (int i = 0; i < n; i++) {
            s1 = (s1 + a[i] * quickPow(b[i], MOD - 2) % MOD) % MOD;
            s2 = (s2 + c[i] * quickPow(d[i], MOD - 2) % MOD) % MOD;
        }
        long A = (s1 * (n - s2) % MOD + MOD) % MOD;
        long B = (s2 * (n - s1) % MOD + MOD) % MOD;
        return String.valueOf((A + B) % MOD);
    }

    // 模下的 a^b
    private static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % MOD;
            }
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }
}
/*
开关【算法赛】

概率 DP。
https://www.latexlive.com/
$\sum_{i=1}^{n} \sum_{j=1}^{n} p_i \times (1-q_j) + (1-p_i) \times q_j$
即
$\sum_{i=1}^{n}p_i \times \sum_{j=1}^{n}(1-q_j) + \sum_{i=1}^{n}(1-p_i) \times \sum_{j=1}^{n}q_j$
记录
$S_1={\textstyle \sum_{i=1}^{n}}p_i,S_2={\textstyle \sum_{j=1}^{n}}q_j$
那么最终答案即为
$S_1\times (n-S_2)+S_2\times (n-S_1)$
 */