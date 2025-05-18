package c183;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Arc183_c {
    static int n, m;

    record pair(int l, int x) {
    }

    static List<pair>[] ban;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        ban = new ArrayList[n + 1];
        Arrays.setAll(ban, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int x = scanner.nextInt();
            ban[r].add(new pair(l, x));
        }
        System.out.println(solve());
    }

    private static String solve() {
        long[][] f = new long[n + 2][n + 2];
        f[n + 1][n] = 1;
        for (int l = n; l > 0; l--) {
            boolean[] b = new boolean[n + 1];
            f[l][l - 1] = 1;
            for (int r = l; r <= n; r++) {
                for (pair p : ban[r]) {
                    if (p.l >= l) {
                        b[p.x] = true;
                    }
                }
                for (int x = l; x <= r; x++) {
                    if (!b[x]) {
                        f[l][r] = (f[l][r] + comb(r - l, x - l) * f[l][x - 1] % MOD * f[x + 1][r]) % MOD;
                    }
                }
            }
        }
        return String.valueOf(f[1][n]);
    }

    static int MOD = (int) 998244353, MX = (int) 500;
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
}
/*
C - Not Argmax
https://atcoder.jp/contests/arc183/tasks/arc183_c

灵茶の试炼 2025-01-17
题目大意：
输入 n(1≤n≤500) m(1≤m≤1e5)。
你需要构造一个 1~n 的排列 P。
然后输入 m 个约束，每个约束输入 L R X (1≤L≤X≤R≤n)，表示 P[L],P[L+1],...,P[R] 中的最大值不能是 P[X]。
输出有多少个符合要求的排列 P，模 998244353。

如果 x 可以是区间 [L,R] 中的最大值的下标，那么把最大值放置在下标 x 上，问题变成：
1. 从 R-L 个非最大值中，选 x-L 个数分到区间 [L,x-1] 中的方案数（其余数分到区间 [x+1,R] 中）。
2. 区间 [L,x-1] 的排列数。
3. 区间 [x+1,R] 的排列数。
三者互相独立，根据乘法原理相乘。
这样就有子问题了，于是定义 f[L][R] 表示区间 [L,R] 的排列数。
枚举可以是区间 [L,R] 的最大值的下标 x，我们有
f[L][R] = sum(C(R-L,x-L) * f[L][x-1] * f[x+1][R] for x in valid[L,R])。
怎么计算哪些 x 可以是最大值的下标？
把输入按照右端点分组。
在枚举 R 的过程中，把左端点 >= L 的 x 标记为「不能是最大值」。
为什么可以这样做？如果 x 不能是 [l,r] 中的最大值的下标，那么对于任意包含 [l,r] 的更大的区间 [L,R]，x 也不能是 [L,R] 中的最大值的下标。
初始值 f[i][i-1] = 1。
答案为 f[1][n]。
代码 https://atcoder.jp/contests/arc183/submissions/61526190
======

Input 1
3 2
1 3 2
1 2 1
Output 1
1

Input 2
5 1
1 1 1
Output 2
0

Input 3
10 5
3 8 4
3 10 4
1 7 2
1 8 3
3 8 7
Output 3
1598400

Input 4
15 17
2 11 9
2 15 13
1 14 2
5 11 5
3 15 11
1 6 2
4 15 12
3 11 6
9 13 10
2 14 6
10 15 11
1 8 6
6 14 8
2 10 2
6 12 6
3 14 12
2 6 2
Output 4
921467228
 */
