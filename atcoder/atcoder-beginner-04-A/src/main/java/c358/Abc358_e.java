package c358;

import java.io.PrintWriter;
import java.util.Scanner;

public class Abc358_e {
    static Scanner scanner;
    static PrintWriter out;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        out = new PrintWriter(System.out);
        int t = 1;
//        t = scanner.nextInt();
        while (t-- > 0) solve();
        out.flush();
    }

    static int MOD = 998244353, MX = 5000;
    static long[] F = new long[MX + 1], invF = new long[MX + 1];

    static {
        F[0] = F[1] = invF[0] = invF[1] = 1;
        for (int i = 2; i <= MX; i++) F[i] = F[i - 1] * i % MOD;
        invF[MX] = quickPow(F[MX], MOD - 2);
        for (int i = MX - 1; i >= 2; i--) invF[i] = invF[i + 1] * (i + 1) % MOD;
    }

    static long comb(int n, int m) {
        if (n < m || m < 0) return 0;
        return F[n] * invF[n - m] % MOD * invF[m] % MOD;
    }

    static long quickPow(long a, long b) {
        long res = 1L;
        while (b > 0) {
            if ((b & 1) != 0) res = res * a % MOD;
            a = a * a % MOD;
            b >>= 1;
        }
        return res;
    }

    private static void solve() {
        int mx = scanner.nextInt();
        long[] f = new long[mx + 1];
        f[0] = 1;
        for (int i = 0; i < 26; i++) {
            int c = scanner.nextInt();
            for (int j = mx; j > 0; j--) {
                for (int k = 1; k <= Math.min(j, c); k++) {
                    f[j] = (f[j] + f[j - k] * comb(j, k)) % MOD;
                }
            }
        }
        long ans = 0;
        for (int i = 1; i <= mx; i++) {
            ans += f[i];
        }
        out.println(ans % MOD);
    }
}
/*
E - Alphabet Tiles
https://atcoder.jp/contests/abc358/tasks/abc358_e

灵茶の试炼 2026-05-27
题目大意：
输入 mx(1≤mx≤1e3) 和长为 26 的数组 c(0≤c[i]≤1e3)。
输出满足如下两个条件的字符串个数，模 998244353。
1. 长度在 [1,mx] 中。
2. 只包含大写字母。第 i 种大写字母的个数至多为 c[i]。

rating
定义 f[i][j] 表示用前 i 种字母组成长度恰好为 j 的字符串的方案数。
枚举第 i 种字母用了 k 个，那么问题变成用前 i-1 种字母组成长度恰好为 j-k 的字符串的方案数 f[i-1][j-k]，乘以从 j 个位置中选择 k 个位置填第 i 种字母的方案数 C(j,k)。
f[i][j] += f[i-1][j-k] * C(j,k)。其中 k=1,2,...,min(j,c[i])。
初始值 f[0][0] = 1。
答案为 f[26][1] + f[26][2] + ... + f[26][mx]。
代码实现时，f 的第一个维度可以优化掉。
代码 https://atcoder.jp/contests/abc358/submissions/75973777
======

Input 1
2
2 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
Output 1
10

Input 2
358
1 0 1 0 1 0 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
Output 2
64

Input 3
1000
1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000 1000
Output 3
270274035
 */
