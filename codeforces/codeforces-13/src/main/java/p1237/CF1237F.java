package p1237;

import java.util.Scanner;

public class CF1237F {
    static int n, m, k;
    static boolean[] banR, banC;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        banR = new boolean[n];
        banC = new boolean[m];
        for (int i = 0; i < k; i++) {
            int r1 = scanner.nextInt() - 1;
            int c1 = scanner.nextInt() - 1;
            int r2 = scanner.nextInt() - 1;
            int c2 = scanner.nextInt() - 1;
            banR[r1] = true;
            banR[r2] = true;
            banC[c1] = true;
            banC[c2] = true;
        }
        System.out.println(solve());
    }

    private static final int MOD = 998244353;
    private static final int mx = 3600;

    private static String solve() {
        tuple calc = calc(banR);
        long[] f = calc.f;
        int emptyR = calc.empty;

        calc = calc(banC);
        long[] g = calc.f;
        int emptyC = calc.empty;

        long ans = 0;
        Perm perm = new Perm(mx);
        for (int i = 0; i < f.length; i++) {
            long v = f[i]; // i 个竖放
            for (int j = 0; j < g.length; j++) {
                long w = g[j]; // j 个横放
                if (j > emptyR - i * 2 || i > emptyC - j * 2) {
                    break;
                }
                ans = (ans + v * w % MOD * perm.binom(emptyC - j * 2, i) % MOD * perm.binom(emptyR - i * 2, j)) % MOD;
            }
        }
        return String.valueOf(ans);
    }

    record tuple(long[] f, int empty) {
    }

    static tuple calc(boolean[] ban) {
        int n = ban.length;
        long[][] f = new long[n + 1][n / 2 + 1];
        for (int i = 0; i < n + 1; i++) {
            f[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= (i + 1) / 2; j++) {
                f[i + 1][j] = f[i][j];
                if (!ban[i] && !ban[i - 1]) {
                    f[i + 1][j] = (f[i + 1][j] + f[i - 1][j - 1]) % MOD;
                }
            }
        }
        int empty = 0;
        for (boolean b : ban) {
            if (!b) {
                empty++;
            }
        }
        return new tuple(f[n], empty);
    }

    static class Perm {
        long[] fac, inv_fac;

        public Perm(int n) {
            fac = new long[n + 1];
            fac[0] = 1;
            for (int i = 1; i <= n; i++) fac[i] = fac[i - 1] * i % MOD;
            inv_fac = new long[n + 1];
            for (int i = 0; i <= n; i++) inv_fac[i] = quickPow(fac[i], MOD - 2);
        }

        // C(n, m) = n! / m!(n-m)!
        long binom(int n, int m) {
            if (n < m || m < 0) return 0;
            return fac[n] * inv_fac[n - m] % MOD;
        }

        // 模下的 a^b
        long quickPow(long a, long b) {
            long res = 1L;
            while (b > 0) {
                if ((b & 1) != 0) res = res * a % MOD;
                a = a * a % MOD;
                b >>= 1;
            }
            return res;
        }
    }
}
/*
F. Balanced Domino Placements
https://codeforces.com/contest/1237/problem/F

灵茶の试炼 2024-08-30
题目大意：
输入 n m(1≤n,m≤3600) 和 k(0≤k≤2400)。
有一个 n 行 m 列的棋盘，上面已经放了 k 个骨牌。
一个骨牌由两个 1x1 大小的相邻方块组成。
然后输入 k 行，每行 4 个数，表示每个骨牌的第一个方块的行号和列号，以及第二个方块的行号和列号。
行列编号从 1 开始。
定义完美平衡棋盘：对于每一行和每一列，要么没有方块，要么有一个方块，要么有两个方块且这两个方块属于同一个骨牌。
保证输入的棋盘是完美平衡棋盘。
你需要继续往棋盘上放零块或更多的骨牌，使得棋盘仍然是完美平衡的。
输出方案数，模 998244353。

rating 2600
https://www.luogu.com.cn/article/tekpxn7n
======

Input
5 7 2
3 1 3 2
4 4 4 5
Output
8

Input
5 4 2
1 2 2 2
4 3 4 4
Output
1

Input
23 42 0
Output
102848351
 */
